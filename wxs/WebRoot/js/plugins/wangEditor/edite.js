/**
 * Created by chenyi on 2016/04/07.
 */
$(document).ready(function () {
	
	 $("#edit_dropdown").mouseover(function() {
        $(this).addClass('open');
    }).mouseout(function() {
        $(this).removeClass('open');
    });
	
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
           _this=this,
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
       data_str+="&content="+content+"&txt="+txt+"&diarySize="+diarySize+"&role=1";
       var dairyId=$(this).find("input[name='diaryId']").val();
       var diaryId1=$(this).find("input[name='diaryId1']").val();
       var draft_box=$(this).find("input[name='draft_box']").val();
       if(draft_box=="1"){
       layer.confirm("您正要发布的文章列表里有对应的文章存在，你现在要",{
          btn: ['发表为新文章','覆盖该原文章'] //按钮
          },function(){
          diary_save(url,data_str,_this)
          },function(){
          data_str+="&coverFlag=1";
          diary_save(url,data_str,_this)
          });
          return false;
       }else{
       diary_save(url,data_str,this)
       }
      return false;
   });
   
   function diary_save(url,data_str,e){
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
                   var article_url=$(e).data("url");
                   var dirayId=data["diaryId"];
                   window.location.href=article_url+"/"+dirayId;
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
   }

   
   $("#draft_save").click(function(){
   	   var form=$("#article_add_form"),
   	       _this=this;
       var url=$(this).data("url"),
           arr=$(form).serializeArray();
       var data_str= $.param(arr);
       var content=editor.$txt.html();
       var txt=editor.$txt.text();
       var txt1=editor.$txt.text();
       txt1 = txt1.replace(/\s/g,"");

       var diarySize=txt1.length;
       var title=$(form).find("input[name='title']").val();

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
       data_str+="&content="+content+"&txt="+txt+"&diarySize="+diarySize+"&role=2";
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
                   layer.msg("文章存草稿失败，请重新再试!",{icon:2,time:1000});
               }else if(data["statusFlag"]==1){
                   layer.msg("存草稿成功！",{icon:1,time:1000});
                   if(!$(form).find("input[name='diaryId1']").length>0){
                      $(form).append("<input type='hidden' name='diaryId1' value='"+data["diaryId"]+"'/>");                      
                   }
                   if(!$(form).find("input[name='diaryId']").length>0){
                      $(form).append("<input type='hidden' name='diaryId' value='"+data["diaryId"]+"'/>");                      
                   }
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
   
});

