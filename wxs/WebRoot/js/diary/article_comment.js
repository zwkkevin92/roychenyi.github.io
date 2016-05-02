/**
 * Created by chenyi on 2016/04/29.
 */
var DComment = new Object();
$(document).ready(function () {



    var editor = new wangEditor('textarea1');

    // 自定义菜单
    editor.config.menus = [
//        'source',
//        '|',     // '|' 是菜单组的分割线
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'forecolor',
        'bgcolor',
        'alignleft',
        'aligncenter',
        'alignright'
//        ,'img'
    ];


    editor.create();
    //添加新评论
    $('#comment_form').submit(function(){
        var url=$(this).attr("action"),
        _this=this,
            arr=$(this).serializeArray();
        var bool=get_comment_info(url,arr);
        if(bool==1){
            ajax1(url,arr,comment_save);
        }
        return false;
    });

    function get_comment_info(url,arr){
        var content=editor.$txt.html();
        content=encodeURI(content,"UTF-8");
        var txt=editor.$txt.text();
        var txt1=editor.$txt.text();
        txt1 = txt1.replace(/\s/g,"");

        var diarySize=txt1.length;
        if(txt1.length==0||txt1==""){
            layer.msg("评论内容不能为空",{icon:2,time:1000});
            return 0;
        }
        if(diarySize>1000){
            layer.msg("内容不能超过一千字",{icon:2,time:1000});
            return 0;
        }
        //       var article_url1=$('#article_add_form').data("url");
        //      data_str+="&content="+content+"&txt="+txt+"&diarySize="+diarySize+"&role=1";
        arr.push({name:"content",value:content});
        arr.push({name:"diarySize",value:diarySize});
        //    arr.push({name:"role",value:"1"});
        return 1;
    }
    
    

});
//评论结果
function comment_save(data){
    if(data["statusFlag"]==-2){
        layer.msg("请登陆后再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==-1){
        layer.msg("文章发布失败，请重新再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==1){
        layer.msg("发布成功！",{icon:1,time:1000});

    }
}
//显示评论回复编辑器
DComment.showCommentEditor=function(commentId){
    var commentDivId='#commentDiv'+commentId;
    $('div.chat-message-form').addClass("hidden");
    $(commentDivId).find("div.message div.chat-message-form").removeClass("hidden");
    
        comment_dreply=new wangEditor('dreply'+commentId)
    // 自定义菜单
    comment_dreply.config.menus = [
//        'source',
//        '|',     // '|' 是菜单组的分割线
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'forecolor',
        'bgcolor',
        'alignleft',
        'aligncenter',
        'alignright'
//        ,'img'
    ];
    comment_dreply.create();
}
//添加评论回复
DComment.addCommentReply=function(commentId){
    var formId="replyForm"+commentId;
    var url=$("#"+formId).attr("action"),
        arr=$("#"+formId).serializeArray();;
    var content=comment_dreply.$txt.html();
    content=encodeURI(content,"UTF-8");
    var txt1=comment_dreply.$txt.text();
    txt1 = txt1.replace(/\s/g,"");

    var diarySize=txt1.length;
     if(txt1.length==0||txt1==""){
            layer.msg("评论内容不能为空",{icon:2,time:1000});
            return 0;
        }
    if(diarySize>1000){
        layer.msg("内容不能超过一千字",{icon:2,time:1000});
        return false;
    }

    arr.push({name:"content",value:content});
    ajax1(url,arr,dreply_save);
}
//回复结果
function dreply_save(data){
    if(data["statusFlag"]==-2){
        layer.msg("请登陆后再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==-1){
        layer.msg("回复失败，请重新再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==1){
        layer.msg("回复成功！",{icon:1,time:1000});

    }
}