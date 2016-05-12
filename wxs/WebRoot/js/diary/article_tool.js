/**
 * Created by chenyi on 2016/04/25.
 */

$(document).ready(function () {

    $("#d_toTrash a").click(function(){    Ariticle_Tool.d_totrash(this) });
    $("#d_delete a").click(function(){    Ariticle_Tool.d_delete(this) });
    $('#d_private a').click(function(){Ariticle_Tool.d_toPrivate(this)});

    $('#d_upvote a').click(function(){ Ariticle_Tool.d_upvote(this);    });
    $('#d_favorite a').click(function () {   Ariticle_Tool.d_favorite(this);});

    
    Ariticle_Tool.addPagination(Number($('#page').val()),Number($('#pageCount').val()));
    Ariticle_Tool.updateCount(window.location.href+"/infoCount");
     if($('#role').val()!=''&&$('#role').val()!=null){
        var role=Number($('#role').val().trim())
        switch (role){
            case -1:$('#d_toTrash').addClass("hidden");break;
            case 0:$('#d_private').addClass("hidden");break;
            case 1:;break;
            case 2:$('#d_toTrash').addClass("hidden");break;
            default :;
        }
    }
});
var Ariticle_Tool={
     userId:Number($('#U_userId').val().trim()),
     authorId:Number($('#author_id').val().trim()),
    //文章删除
    d_totrash:function(_this){
        var url=$(_this).data("url");
        layer.confirm('您确定将该文章移到回收站吗？',{title:"删除提示",btn: ['确定','取消'] //按钮
        },function(){
            ajax1(url,'',Ariticle_Tool.d_totrash_result);
        });
    },
    //文章删除结果
    d_totrash_result:function(data){
        if(data["statusFlag"]==-2){
            layer.msg("您没有权限删除!",{icon:5,time:1000});
        }else if(data["statusFlag"]==-1){
            layer.msg("删除失败，请重新再试，或给管理员提意见!",{icon:2,time:1000});
        }else if(data["statusFlag"]==1){

            window.location.href=data["url"];
        }
    },
    d_delete:function(_this){
        var url=$(_this).data("url");
        layer.confirm('您确定彻底删除该文章吗？',{title:"删除提示",btn: ['确定','取消'] //按钮
        },function(){
            ajax1(url,'',Ariticle_Tool.d_delete_result);
        });
    },
    d_delete_result:function(data){
        var flag=Number(data["statusFlag"]);
        switch (flag){
            case -2:layer.msg("您没有权限删除!",{icon:5,time:1000});break;
            case -1:layer.msg("转私密失败，请重新再试，或给管理员提意见!",{icon:2,time:1000});
            case 1:window.location.href=data["url"];break;
            default :break;
        }
    },
    //文章点赞
    d_upvote:function(_this){
        var url=$(_this).data("url");
        ajax1(url,'',Ariticle_Tool.d_upvote_result);
    },
    //文章点赞结果
    d_upvote_result:function(data){
        var flag=Number(data["statusFlag"]);
        switch(flag){
            case -2: layer.msg("您尚未登陆，请登陆后再试!",{icon:5,time:1000});break;
            case -1:layer.msg("点赞失败，请重新再试!",{icon:2,time:1000});break;
            case 0:$('#d_upvote>a>span').html("("+data["upvoteCount"]+")");
                $('#d_upvote>a>i').addClass("fa-thumbs-o-up");
                $('#d_upvote>a>i').removeClass("fa-thumbs-up text-warning");
                layer.msg("点赞-1!",{icon:5,time:1000});break;
            case 1: $('#d_upvote>a>span').html("("+data["upvoteCount"]+")");
                $('#d_upvote>a>i').removeClass("fa-thumbs-o-up");
                $('#d_upvote>a>i').addClass("fa-thumbs-up text-warning");
                layer.msg("点赞+1!",{icon:6,time:1000});break;
            default :;
        }

    },
    d_favorite:function(_this){
        var url=$(_this).data("url");
        ajax1(url,'',Ariticle_Tool.d_favorite_result);
    },
    //文章收藏结果
    d_favorite_result:function(data){
        var flag=Number(data["statusFlag"]);
        switch(flag){
            case -2:layer.msg("您尚未登陆，请登陆后再试!",{icon:5,time:1000});break;
            case -1:layer.msg("点赞失败，请重新再试!",{icon:2,time:1000});break;
            case 0:$('#d_favorite>a>span').html("("+data["favoriteCount"]+")");
                $('#d_favorite>a>i').addClass("fa-star-o");
                $('#d_favorite>a>i').removeClass("fa-star text-warning");
                layer.msg("点赞-1!",{icon:5,time:1000});break;
            case 1:$('#d_favorite>a>span').html("("+data["favoriteCount"]+")");
                $('#d_favorite>a>i').removeClass("fa-star-o ");
                $('#d_favorite>a>i').addClass("fa-star text-warning");
                layer.msg("点赞+1!",{icon:6,time:1000});break;
            default:break;

        }
    },
    d_toPrivate:function(_this){
        var url=$(_this).data("url");
        ajax1(url,'',Ariticle_Tool.d_toPrivate_result);
    },
    d_toPrivate_result:function(data){
        var flag=Number(data["statusFlag"]);
        switch (flag){
            case -2:layer.msg("您没有权限进行操作!",{icon:5,time:1000});break;
            case -1:layer.msg("转私密失败，请重新再试，或给管理员提意见!",{icon:2,time:1000});
            case 1:window.location.href=data["url"];break;
            default :break;
        }
    },
    //更新文章计数
    updateCount:function(url){
        ajax(url,'',Ariticle_Tool.updateCount_result);
    },
    //更新文章计数结果
    updateCount_result:function(data){
        $('#d_upvote>a>span').html("("+data.upvoteCount+")");
        $('#d_comment>a>span').html("("+data.replyCount+")");
        $('#d_favorite>a>span').html("("+data.favoriteCount+")");
    },

    //文章列表更新
    list_info:function(data){
        data=FastJson.format(data);
        console.log(data);
        if(data.length>0&&data[0].rows>0) {
            var role=Number(data[0].role);
            $('#diary_list').html("<input id='page' type='hidden' value='" + data[0].page + "'>"
                + "<input id='pageCount' type='hidden' value='" + data[0].pageCount + "'>"
                +"<input id='role' type='hidden' value='" + role+ "'>");
            var html = "<ul class='list-group'>";
            var rootUrl=getRootPath()+"/";
            var user_url=rootUrl+data[0].uUserDto.nickname;
            for(var i=0;i<data.length;i++){
                html+="<li class='list-group-item'><a href='"+user_url+"/article/details/"+data[i].diaryId+"'>"+data[i].title+"</a>"
                    +"<span id='toolMenu' class='pull-right dropdown' onmouseover='dropdown_open(this)' onmouseout='dropdown_close(this)'>&nbsp;"
                    +"  <a class='dropdown-toggle active' href='"+user_url+"/article/article_edite/"+data[i].diaryId+"' data-toggle='data-toggle'>编辑<span class='caret'></span></a>"
                    +"<ul class='dropdown-menu'>"
                    +"<li id='d_modify'><a href='"+user_url+"/article/article_edite/"+data[i].diaryId+"'>编辑</a></li>"
                    +"<li id='d_toTrash'><a data-url='"+user_url+"/article/totrash/"+data[i].diaryId+"' href='javascript:;' >删除</a></li>"
                    +"<li id='d_delete'><a data-url='"+user_url+"/article/todelete/"+data[i].diaryId+"' href='javascript:;'>彻底删除</a></li>"
                    +"<li id='d_private'><a data-url='"+user_url+"/article/toprivate/"+data[i].diaryId+"' href='javascript:;'>转为私密文章</a></li>"
                    +"</ul></span>"
                    +"<div class='pull-right'>"+new Date(data[i].writeTime).format("yyyy/MM/dd")+"&nbsp;("+data[i].replyCount+"/"+data[i].viewCount+")</div>"
                    +"</li>" ;
            }
            html+="</ul>";
            $('#diary_list').append(html);
            if(Ariticle_Tool.userId!=Ariticle_Tool.authorId){
                $('#toolMenu').addClass("hidden");
            }else {
                switch (role){
                    case -1:$('#d_toTrash').addClass("hidden");break;
                    case 0:$('#d_private').addClass("hidden");break;
                    case 1:;break;
                    case 2:$('#d_toTrash').addClass("hidden");break;
                    default :;
                }
                $("#d_toTrash a").click(function(){    Ariticle_Tool.d_totrash(this) });
                $("#d_delete a").click(function(){    Ariticle_Tool.d_delete(this) });
                $('#d_private a').click(function(){Ariticle_Tool.d_toPrivate(this)});
            }
        }
    },
    //添加分页
    addPagination:function(page,pageCount){
        if(pageCount>1){
            var html=createPagination(page,pageCount,'Ariticle_Tool');
            $('#diary_pagination').html(html);
            if(page===1){
                $('#page_prev').addClass("disabled");
            }else if(page===pageCount){
                $('#page_next').addClass("disabled");
            }
            $('#page'+page).addClass("active");
        }
    },
    goPage:function(page){
        var d_page=Number($('#page').val()),
            pageCount=Number($('#pageCount').val());
        page+=d_page;
        if(page<1||page>pageCount){
            layer.msg("已经到底了",{icon:5,time:1000});
        }else {
            this.goDirectPage(page);
        }
    },
    goDirectPage:function(page){
        var url=$('#diary_pagination').data('url'),
            data="page="+page;
        ajax1(url,data,this.goPage_result);
    },
    goPage_result:function(data){
        Ariticle_Tool.list_info(data);
        Ariticle_Tool.addPagination(Number($('#page').val()),Number($('#pageCount').val()));
    }

};



