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
                data:data_str,
                dataType:"json",
                async: false,
                beforeSend: function () {
                    submitStart();
                },
                success: function (data) {
                    if(data["statusFlag"]==-1){
                        layer.msg("删除失败，请重新再试!",{icon:2,time:1000});
                    }else if(data["statusFlag"]==1){
                        window.location.href="" ;
                    }
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
        ajax1(url,"",d_upvote);

    });

    $('#d_favorite a').click(function () {
        var url=$(this).data("url"),
            _this=this;
        ajax1(url,"",d_favorite);
    });

});

function d_upvote(data){
    if(data["statusFlag"]==-1){
        layer.msg("删除失败，请重新再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==1){
        $('#d_delete a span').html(data["upvoteCount"]);
        $('#d_delete a i').removeClass("fa-thumbs-o-up");
        $('#d_delete a i').addClass("fa-thumbs-up");
        layer.msg("点赞+1!",{icon:1,time:1000});
    }else if(data["statusFlag"]==0){
        $('#d_delete a span').html(data["upvoteCount"]);
        $('#d_delete a i').addClass("fa-thumbs-o-up");
        $('#d_delete a i').removeClass("fa-thumbs-up");
        layer.msg("点赞-1!",{icon:1,time:1000});
    }
}

function d_favorite(data){
    if(data["statusFlag"]==-1){
        layer.msg("删除失败，请重新再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==1){
        $('#d_delete a span').html(data["upvoteCount"]);
        $('#d_delete a i').removeClass("fa-thumbs-o-up");
        $('#d_delete a i').addClass("fa-thumbs-up");
        layer.msg("点赞+1!",{icon:1,time:1000});
    }else if(data["statusFlag"]==0){
        $('#d_delete a span').html(data["upvoteCount"]);
        $('#d_delete a i').addClass("fa-thumbs-o-up");
        $('#d_delete a i').removeClass("fa-thumbs-up");
        layer.msg("点赞-1!",{icon:1,time:1000});
    }
}