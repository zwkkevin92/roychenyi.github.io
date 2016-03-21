/**
 * Created by chenyi on 2016/03/08.
 */

function usercheck(user){
    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    if(!reg.test(user.value)){
//           layer.tips('tips的样式并非是固定的，您可自定义外观。', '#username', {
//                style: ['background-color:#78BA32; color:#fff', '#78BA32'],
//                maxWidth:185,
//                time: 3,
//                closeBtn:[0, true]
//            });

        layer.tips('亲，用户名为您的邮箱', '#username',{
            title:'标题',
            icon:1,
            closeBtn:1,
            shade:0.8,
            time:1000,
            maxWidth:200,
            tips: [2, '#78BA32']//还可配置颜色

        });
    }

}



function check_VerifyCode(E){

    
    $.ajax({
    url: "checkVerifyCode?VerifyCode=" + E.value + "&nocahe=" + new Date().getTime(),
    type:"POST",
    dataType:"json",
    success:function(data) {
        if (data == "1") {
            layer.tips('验证码正确', '#verifyCode', {
                title: '标题',
                icon: 1,
                closeBtn: 1,
                shade: 0.8,
                time: 3000,
                maxWidth: 200,
                tips: [2, '#78BA32']//还可配置颜色

            });
            $('#error_text').html("");
            E.style.borderColor='';
        } else {
            layer.tips('验证码错误，请重新输入', '#verifyCode', {
                title: '标题',
                icon: 1,
                closeBtn: 1,
                shade: 0.8,
                time: 3000,
                maxWidth: 200,
                tips: [2, '#FF0000']//还可配置颜色
            });
            $('#error_text').html("<small>验证码错误！</small>");
            E.style.borderColor='#ff0000';
        }
    },
    error:function(){alert("执行失败！");}
     }
    );
}

$(document).ready(function () {
var hash = {
    'qq.com': 'http://mail.qq.com',
    'gmail.com': 'http://mail.google.com',
    'sina.com': 'http://mail.sina.com.cn',
    '163.com': 'http://mail.163.com',
    '126.com': 'http://mail.126.com',
    'yeah.net': 'http://www.yeah.net/',
    'sohu.com': 'http://mail.sohu.com/',
    'tom.com': 'http://mail.tom.com/',
    'sogou.com': 'http://mail.sogou.com/',
    '139.com': 'http://mail.10086.cn/',
    'hotmail.com': 'http://www.hotmail.com',
    'live.com': 'http://login.live.com/',
    'live.cn': 'http://login.live.cn/',
    'live.com.cn': 'http://login.live.com.cn',
    '189.com': 'http://webmail16.189.cn/webmail/',
    'yahoo.com.cn': 'http://mail.cn.yahoo.com/',
    'yahoo.cn': 'http://mail.cn.yahoo.com/',
    'eyou.com': 'http://www.eyou.com/',
    '21cn.com': 'http://mail.21cn.com/',
    '188.com': 'http://www.188.com/',
    'foxmail.com': 'http://www.foxmail.com',
    'outlook.com': 'http://www.outlook.com'
}
   //验证码验证，失去焦点时验证
    $('#verifyCode').blur(
        function(){
        	if(this.value.length>0){
                check_VerifyCode(this);
        	}
        }
    );
//验证码验证，当输入验证码长度达到4位数时验证
    $('#verifyCode').change(function(){
            if(this.value.length==4&&this.value.length>0) {
                check_VerifyCode(this);
            }
    });
//验证码输入框，聚焦时确定
    $('#verifyCode').focus(function(){
        this.value="";        
        this.style.backgroundColor='#ffffff';
    });
//登陆按钮确认事件
    $('#login').click(function() {
        var str_data = $("#loginform input").map(function () {
            return ($(this).attr("name") + '=' + $(this).val());
        }).get().join("&");

        $.ajax({
            url: "login1",
            type: "POST",
            data: str_data,
            dataType:"json",
            success: function (data) {
                if(data["loginFlag"]==-1){

                    $('#error_text').html("<small>登陆失败:账号或密码错误，请检查后登陆</small>");
                }else if(data["loginFlag"]==0){
                    $('#error_text').html("<small>验证码错误！</small>");
                }else{
                    window.location=data['url'];
                }
            }

        });
    });
 //忘记密码时，验证按钮点击事件   
    $('#check').click(function(){
    	
     var str_data = $("#forgotform input").map(function () {
            return ($(this).attr("name") + '=' + $(this).val());
        }).get().join("&");
        $.ajax({
        	url:"forgot/result",
        	dataType:"json",
        	type:"POST",
        	data:str_data,
        	success:function(data){
        		if(data==null||data==""){
        		$('#error_text').html("<small>该邮箱没有注册，请点击注册或者重新输入邮箱！</small>");
        		}else{
        		var _mail = $("#username").val().split('@')[1];    //获取邮箱域
               for (var j in hash){
               if(j == _mail){
                 //$(".js_login_mail").show().attr("href", hash[_mail]);    //替换登陆链接
                 layer.confirm("点击确认，可进入邮箱进行验证",{title:"提示"},function(){
                 window.location=hash[_mail];
                 });
                }
             }
             
             
        		}
        	},
        	error: function(data){
        	    $('#error_text').html("<small>该邮箱没有注册，请点击注册或者重新输入邮箱！</small>");
        	}
        });
         
    });
//忘记密码时,修改密码    
$('#newpwd').click(function(){
        var pwd1=$('#password').val();
        var pwd2=$('#password1').val();
        if(pwd1!=pwd2){
            $('#error_text').html("<small>两次输入密码不相同，请重新输入</small>");
            return null
        }else{
            var str_data = $("#changeform input").map(function () {
                return ($(this).attr("name") + '=' + $(this).val());
            }).get().join("&");
            $.ajax({
                url: "change",
                dataType:"json",
        	    type:"POST",
        	    data:str_data,
                success: function(data){
                    if(data["loginFlag"]==-1){

                        $('#error_text').html("<small>修改密码失败！</small>");
                    }else{
                    window.location=data['url'];
                }
                }

            });
        }

    });
    //更换新的密码，修改密码    
$('#changepwd').click(function(){
	    var pwd=$('#oldPassword').val();
        var pwd1=$('#password').val();
        var pwd2=$('#password1').val();
        if(pwd==pwd1){
        $('#error_text').html("<small>新密码不能和旧密码相同</small>");
        return null;
        }
        if(pwd1!=pwd2){
            $('#error_text').html("<small>两次输入密码不相同，请重新输入</small>");
            return null;
        }else{
            var str_data = $("#changeform input").map(function () {
                return ($(this).attr("name") + '=' + $(this).val());
            }).get().join("&");
            $.ajax({
                url: "new",
                dataType:"json",
        	    type:"POST",
        	    data:str_data,
                success: function(data){
                    if(data["loginFlag"]==-1){

                        $('#error_text').html("<small>输入旧密码错误，请重新输入！</small>");
                    }else if(data["loginFlag"]==0){
                    $('#error_text').html("<small>修改密码失败，请重新再试！</small>");
                }else{
                   window.location=data["url"];
                }
                }

            });
        }

    });
});