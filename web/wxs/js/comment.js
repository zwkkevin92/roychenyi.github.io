/**
 * Created by chenyi on 2016/04/29.
 */
var DComment = new Object();
$(document).ready(function () {

//alert(getRootPath());

    var editor = new wangEditor('textarea1');

    // 自定义菜单
    editor.config.menus = [
//        'source',
//        '|',     // '|' 是菜单组的分割线
        'source',
        'location',
        '|',
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
        console.log();
        $('#comment_form').before("<div class='chat-message'><a href='http://localhost:8080/admin'><img class='message-avatar' src='http://localhost:8080/upload/image/1/2016/5/1//1462075603718_s_50.jpg' alt='admin'></a><div class='message'><a class='message-author' href='http://localhost:8080/admin'> admin</a><span class='message-date'> 2016/05/03 16:35:32  </span><button  onclick='DComment.showCommentEditor(1)'>回复</button><span class='message-content'><p>那好</p></span></div></div>");
        return false;
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
var  comment_dreply;
DComment.a=a_host();
    function a_host(){
    return window.location.host;
}
DComment.showCommentEditor=function(commentId){
    var commentDivId='#commentDiv'+commentId;
    $('div.chat-message-form').addClass("hidden");
    $('div.chat-message-form').prev().remove("hidden");
    $(commentDivId).find("div.message div.chat-message-form").removeClass("hidden");
    $(commentDivId).find("div.message div.chat-message-form").prev().addClass("hidden");
   if(comment_dreply!=null) {
    //    comment_dreply.destroy();
    //    comment_dreply.$txt.html("");
       $(commentDivId).find("div.message div.chat-message-form div.wangEditor-container").remove();
       if(!$("#reply"+commentId)) {
           $(commentDivId).find("div.message div.chat-message-form").prepend("<div id='reply" + commentId + "' class='form-group' style='height:150px;max-height:200px;'>");
       }
   }
        comment_dreply = new wangEditor('reply' + commentId);
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

   // comment_dreply.undestroy();
}

DComment.addCommentReply=function(commentId){
    var formId="replyForm"+commentId;
    var url=$(formId).action,
        arr=$(formId).serializeArray();
    var content=comment_dreply.$txt.html();
    content=encodeURI(content,"UTF-8");
    var txt1=comment_dreply.$txt.text();
    txt1 = txt1.replace(/\s/g,"");

    var diarySize=txt1.length;

    if(diarySize>1000){
        layer.msg("内容不能超过一千字",{icon:2,time:1000});
        return false;
    }

    arr.push({name:"content",value:content});
    ajax1(url,arr,dreply_save);
}

function dreply_save(data){
    if(data["statusFlag"]==-2){
        layer.msg("请登陆后再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==-1){
        layer.msg("回复失败，请重新再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==1){
        layer.msg("回复成功！",{icon:1,time:1000});

    }
}

function comment_save(data){
    if(data["statusFlag"]==-2){
        layer.msg("请登陆后再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==-1){
        layer.msg("评论发布失败，请重新再试!",{icon:2,time:1000});
    }else if(data["statusFlag"]==1){
        console.log(data);
        var rootUrl=getRootPath();
        var user_url=rootUrl+"/"+data.uUserByUserIdDto.nickname;
        $('#d_comment>a>span').html("("+data["row"]+")");
        $('#comment_form').parent().append("<div class='chat-message' id='commentDiv"+data["row"]+"' data-replyid='"+data["dreplyId"]+"'><a href='"+user_url+"'><img class='message-avatar' src='"+rootUrl+data["uUserDto"]["portrait"]+"' alt='"+data["uUserDto"]["nickname"]+"'> </a>"
           +" <span><b>"+data["row"]+"楼</b></span><span class='pull-right'><small>"+new Date(data["writeTime"]).format("yyyy-MM-dd hh:mm:ss")+"</small><a href='javascript:;' onclick='DComment.showCommentEditor("+data["row"]+")'>回复</a>"
           +" <span class='dropdown pull-right' onmouseover='dropdown_open(this)' onmouseout='dropdown_close(this)'><a class='dropdown-toggle' data-toggle='data-toggle'><i class='fa fa-sort-desc ' style='padding:0 5px; '></i></a>"
           +"   <ul class='dropdown-menu text-right'>"
           +"<li><a>删除</a></li>"
           +"<li><a>举报</a></li>                </ul></span></span>"
           +"<div class='message'><a class='message-author' href='"+user_url+"'> "+data.dReply2Dtos[0].uUserByUserIdDto.nickname+":</a>"
           +"<span class='message-date'> "+new Date(data["writeTime"]).formatDate("yyyy-MM-dd hh:mm:ss")+"  </span>"
           +"<span class='message-content'> "+data.dReply2Dtos[0].content+"</span>"
           +"<div class='form-group' >            <input type='text' class='form-control' placeholder='我也来评论一句' onclick='DComment.showCommentEditor("+data.row+")'> </div>"
           +"<div class='chat-message-form hidden'><form id='replyForm"+data.row+"' action='"+user_url+"/article/"+data.dDiaryDto.diaryId+"/reply2_add'>"
           +"<input type='hidden' name='DReply1Dto.dreplyId' value='"+data.dDiaryDto.diaryId+"'>"
           +"<div id='dreply"+data.row+"' class='form-group' style='height:150px;max-height:200px;'></div>"
           +"<input class='btn btn-info' type='button' value='确认' onclick='DComment.addCommentReply("+data.row+")'></form>"
           +"</div></div></div>");
        layer.msg("发布成功！",{icon:1,time:1000});

    }
}


/*
 <div class="chat-message" id="commentDiv7" data-replyid="7">
 <a href="http://localhost:8080/admin"><img class="message-avatar" src="http://localhost:8080/upload/image/1/2016/5/1//1462075603718_s_50.jpg" alt="admin"> </a>
 <span><b>7楼</b></span>
 <span class="pull-right">
 <small>2016/04/30 09:01:56 </small>
 <a href="javascript:;" onclick="DComment.showCommentEditor('7')">回复</a>
 <span class="dropdown pull-right">
 <a class="dropdown-toggle" data-toggle="data-toggle"><i class="fa fa-sort-desc " style="padding:0 5px; "></i></a>
 <ul class="dropdown-menu text-right">
 <li><a>删除</a></li>
 <li><a>举报</a></li>
 </ul></span>
 </span>


 <div class="message">
 <a class="message-author" href="http://localhost:8080/admin"> admin:</a>
 <span class="message-date"> 2016/04/30 09:01:56  </span>
 <span class="message-content">


 <p>毛泽东</p>
 </span>
 <div class="form-group" >
 <input type="text" class="form-control" placeholder="我也来评论一句" onclick="DComment.showCommentEditor(7)">
 </div>

 <div class="chat-message-form hidden">
 <form id="replyForm7" action="http://localhost:8080/admin/article/27/reply2_add">
 <input type="hidden" name="DReply1Dto.dreplyId" value="7">
 <div id="dreply7" class="form-group" style="height:150px;max-height:200px;">


 </div>
 <input class="btn btn-info" type="button" value="确认" onclick="DComment.addCommentReply(7)">
 </form>
 </div>
 </div>
 </div>
*/
