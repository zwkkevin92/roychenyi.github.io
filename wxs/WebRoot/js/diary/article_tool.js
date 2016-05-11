/**
 * Created by chenyi on 2016/04/25.
 */

$(document).ready(function () {

     $("#d_delete a").click(function(){
        var url=$(this).data("url");
        layer.confirm("该文章将移动到回收站，您确定吗？",{title:"删除提示",btn: ['确定','取消'] //按钮
        },function(){
            $.ajax({
                url:url,
                type:"POST",
                data:"",
                dataType:"json",
                async: false,
                beforeSend: function () {
                    submitStart();
                },
                success: function (data) {
                   
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    submitFail(textStatus || errorThrown);

                },

                complete: function () {
                    submitEnd();
                }
            });
        });
    }); 
    
    $('#d_upvote a').click(function(){
        var url=$(this).data("url"),
            _this=this;
        ajax1(url,"",d_upvote_result);

    });
    
    $('#d_favorite a').click(function () {
        var url=$(this).data("url"),
            _this=this;
        ajax1(url,"",d_favorite_result);
    });

});
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
}