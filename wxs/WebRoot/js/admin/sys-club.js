/**
 * Created by chenyi on 2016/05/16.
 */

var SysClub={
  checkName:function(_this){
      var url=getRootPath()+"/club/checkname",
          data="name="+$(_this).val()+"&nocahe=" + new Date().getTime();
      ajax1(url,data,SysClub.checkname_result);
  },
  checkName_result:function(data){
      if (data == "1") {
          $('#feedback-name').addClass('glyphicon-ok');
          $('#feedback-name').parent().removeClass('has-error');
      //    return ;
      } else {
          $('#feedback-name').addClass('glyphicon-remove');
          $('#feedback-name').parent().addClass('has-error');
          $('#error_text').html("<small>该名称已经被使用，请输入新的名称</small>");

      }
  },
  checkAccount:function(_this){
      var url=getRootPath()+"/club/checkaccount",
          data="name="+$(_this).val()+"&nocahe=" + new Date().getTime();
      ajax1(url,data,SysClub.checkAccount_reslut);
  },
  checkAccount_reslut:function(data){
      if (data == "1") {
          $('#feedback-account').addClass('glyphicon-ok');
          $('#feedback-account').parent().removeClass('has-error');
          //    return ;
      } else {
          $('#feedback-account').addClass('glyphicon-remove');
          $('#feedback-account').parent().addClass('has-error');
          $('#error_text').html("<small>该名称已经被使用，请输入新的名称</small>");

      }
  },
  clubCreate:function(){
      var url=$('#clubCreateForm').attr('action'),
          data=$('#clubCreateForm').serialize(),
          pwd1=$('#password').val(),
          pwd2=$('#password1').val();
      if(pwd1==''||pwd2==''){
          $('#error_text').html("<small>密码不能为空</small>");
          return false;
      }else if(pwd1!=pwd2){
          $('#error_text').html("<small>两次密码不相同！</small>");
          return false;
      }else if(pwd1.length>48||pwd1.length<8){
          $('#error_text').html("<small>密码长度不能小于8且不能超过48</small>");
          return false;
      }

  }
};