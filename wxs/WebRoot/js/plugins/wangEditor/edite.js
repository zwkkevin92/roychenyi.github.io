/**
 * Created by chenyi on 2016/04/07.
 */
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
        'alignright',
        'img'
    ];


    editor.create();
        //设置是否投稿
    var contribute_value=$("input[name='contribute']").val();
    if(contribute_value=="1"){
        $("input[name='contribute']").attr("checked",true);
    }else{
        $("input[name='contribute']").attr("checked",false);
    }
    $("input[name='contribute']").change(function(){
        if(this.checked){
            $(this).val("1");
        }else{
            $(this).val("0");
        }
    });
    //提交日志
   $("#article_add_form").submit(function(){
       var url=$(this).attr("action"),
           arr=$(this).serializeArray();
       var data_str= $.param(arr);
       var content=editor.$txt.html();
       var txt=editor.$txt.text();
       var txt1=editor.$txt.text();
       txt1 = txt1.replace(/\s/g,"");

       var diarySize=txt1.length;
       var title=$(this).find("input[name='title']").val();

       if(title.length==0){
           layer.msg("标题不能为空",{icon:2,time:1000});
           return false;
       }
       if(txt.length==0||txt==""){
           layer.msg("内容不能为空",{icon:2,time:1000});
           return false;
       }
       if(diarySize>10000){
           layer.msg("内容不能超过一万字",{icon:2,time:1000});
           return false;
       }
        var article_url1=$(this).data("url");
       data_str+="&content="+content+"&txt="+txt+"&diarySize="+diarySize;
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
                   layer.msg("文章发布失败，请重新再试!",{icon:2,time:1000});
               }else if(data["statusFlag"]==1){
                   layer.msg("发布成功！",{icon:1,time:1000});
                   var article_url=$(this).data("url");
                   var dirayId=data["diaryId"];
                   window.location.href=article_url1+"/"+dirayId;
               }
           },

           error: function (XMLHttpRequest, textStatus, errorThrown) {
               submitFail(textStatus || errorThrown);

           },

           complete: function () {
               submitEnd();
           }
       });

       return false;
   });
});