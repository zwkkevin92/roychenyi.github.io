/**
 * Created by chenyi on 2016/04/25.
 */

$(document).ready(function () {

    $("#d_delete a").click(function(){
        var url=$(this).data("url");
        layer.confirm('该文章将被移动到回收站，您确定吗？',{title:"删除提示",btn: ['确定','取消'] //按钮
        },function(){
            ajax1(url,'',Ariticle_Tool.d_delete_result);
        });
    });

    $('#d_upvote a').click(function(){
        var url=$(this).data("url"),
            _this=this;
        ajax1(url,'',Ariticle_Tool.d_upvote_result);

    });

    $('#d_favorite a').click(function () {
        var url=$(this).data("url"),
            _this=this;
        ajax1(url,'',Ariticle_Tool.d_favorite_result);
    });

    Ariticle_Tool.addPagination(Number($('#page').val()),Number($('#pageCount').val()));
    Ariticle_Tool.updateUpvoteCount(window.location.href+"/upvoteCount");
    Ariticle_Tool.updateFavoriteCount(window.location.href+"/favoriteCount");
    Ariticle_Tool.updateCommentCount(window.location.href+"/commentCount")

});
var Ariticle_Tool={
    //文章删除
    d_delete:function(_this){
        var url=$(_this).data("url");
        layer.confirm('该文章将被移动到回收站，您确定吗？',{title:"删除提示",btn: ['确定','取消'] //按钮
        },function(){
            ajax1(url,'',Ariticle_Tool.d_delete_result);
        });
    },
    //文章删除结果
    d_delete_result:function(data){
        if(data["statusFlag"]==-2){
            layer.msg("您没有权限删除!",{icon:5,time:1000});
        }else if(data["statusFlag"]==-1){
            layer.msg("删除失败，请重新再试!",{icon:2,time:1000});
        }else if(data["statusFlag"]==1){

            window.location.href=data["url"];
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
                $('#d_upvote>a>i').removeClass("fa-thumbs-up");
                layer.msg("点赞-1!",{icon:5,time:1000});break;
            case 1: $('#d_upvote>a>span').html("("+data["upvoteCount"]+")");
                $('#d_upvote>a>i').removeClass("fa-thumbs-o-up");
                $('#d_upvote>a>i').addClass("fa-thumbs-up");
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
                $('#d_favorite>a>i').removeClass("fa-star");
                layer.msg("点赞-1!",{icon:5,time:1000});break;
            case 1:$('#d_favorite>a>span').html("("+data["favoriteCount"]+")");
                $('#d_favorite>a>i').removeClass("fa-star-o");
                $('#d_favorite>a>i').addClass("fa-star");
                layer.msg("点赞+1!",{icon:6,time:1000});break;
            default:break;

        }
    },
    updateUpvoteCount:function(url){
        ajax(url,'',Ariticle_Tool.updateUpvoteCount_result);
    },
    updateUpvoteCount_result:function(data){
        $('#d_upvote>a>span').html("("+data.upvoteCount+")");
    },
    updateFavoriteCount:function(url){
        ajax(url,'',Ariticle_Tool.updateFavoriteCoun)
    },
    updateFavoriteCount_result:function(data){
        $('#d_favorite>a>span').html("("+data.favoriteCount+")");
    },
    updateCommentCount:function(url){
        ajax(url,'',Ariticle_Tool.updateCommentCount_result);
    },
    updateCommentCount_result:function(data){
        $('#d_comment>a>span').html("("+data.replyCount+")");
    },
    //文章列表更新
    list_info:function(data){
        data=FastJson.format(data);
        console.log(data);
        if(data.length>0&&data[0].rows>0) {
            $('#diary_list').html("<input id='page' type='hidden' value='" + data[0].page + "'>"
                + "<input id='pageCount' type='hidden' value='" + data[0].pageCount + "'>");
            var html = "<ul class='list-group'>";
            var rootUrl=getRootPath()+"/";
            var user_url=rootUrl+data[0].uUserDto.nickname;
            for(var i=0;i<data.length;i++){
                html+="<li class='list-group-item'><a href='"+user_url+"/article/details/"+data[i].diaryId+"'>"+data[i].title+"</a>"
                    +"<span class='pull-right dropdown' onmouseover='dropdown_open(this)' onmouseout='dropdown_close(this)'>&nbsp;"
                    +"  <a class='dropdown-toggle active' href='"+user_url+"/article/article_edite/"+data[i].diaryId+"' data-toggle='data-toggle'>编辑<span class='caret'></span></a>"
                    +"<ul class='dropdown-menu'>"
                    +"<li id='d_modify'><a href='"+user_url+"/article/article_edite/"+data[i].diaryId+"'>编辑</a></li>"
                    +   "<li id='d_delete'><a data-url='"+user_url+"/article/article_delete/"+data[i].diaryId+"' href='javascript:;' onclick='Ariticle_Tool.d_delete(this)'>删除</a></li>"
                    +"<li><a>转为私密文章</a></li>"
                    +"</ul></span>"
                    +"<div class='pull-right'>"+new Date(data[i].writeTime).format("yyyy/MM/dd")+"&nbsp;("+data[i].replyCount+"/"+data[i].viewCount+")</div>"
                    +"</li>" ;
            }
            html+="</ul>";
            $('#diary_list').append(html);
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



/*
 //文章删除结果
 function d_delete_result(data){

 if(data["statusFlag"]==-1){
 layer.msg("删除失败，请重新再试!",{icon:2,time:1000});
 }else if(data["statusFlag"]==1){

 window.location.href=data["url"];
 }
 }
 //点赞处理
 function d_upvote_result(data){
 if(data["statusFlag"]==-1){
 layer.msg("点赞失败，请重新再试!",{icon:2,time:1000});
 }else if(data["statusFlag"]==1){
 $('#d_upvote>a>span').html("("+data["upvoteCount"]+")");
 $('#d_upvote>a>i').removeClass("fa-thumbs-o-up");
 $('#d_upvote>a>i').addClass("fa-thumbs-up");
 layer.msg("点赞+1!",{icon:6,time:1000});
 }else if(data["statusFlag"]==0){
 $('#d_upvote>a>span').html("("+data["upvoteCount"]+")");
 $('#d_upvote>a>i').addClass("fa-thumbs-o-up");
 $('#d_upvote>a>i').removeClass("fa-thumbs-up");
 layer.msg("点赞-1!",{icon:5,time:1000});
 }else if(data["statusFlag"]==-2){
 layer.msg("您尚未登陆，请登陆后再试!",{icon:5,time:1000});
 }
 }
 //收藏处理
 function d_favorite_result(data){
 var flag=Number(data["statusFlag"]);
 switch(flag){
 case -2:layer.msg("您尚未登陆，请登陆后再试!",{icon:5,time:1000});break;
 case -1:layer.msg("点赞失败，请重新再试!",{icon:2,time:1000});break;
 case 0:$('#d_favorite>a>span').html("("+data["favoriteCount"]+")");
 $('#d_favorite>a>i').addClass("fa-star-o");
 $('#d_favorite>a>i').removeClass("fa-star");
 layer.msg("点赞-1!",{icon:5,time:1000});break;
 case 1:$('#d_favorite>a>span').html("("+data["favoriteCount"]+")");
 $('#d_favorite>a>i').removeClass("fa-star-o");
 $('#d_favorite>a>i').addClass("fa-star");
 layer.msg("点赞+1!",{icon:6,time:1000});break;
 default:break;

 }
 }*/
