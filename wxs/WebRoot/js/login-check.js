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

function testjson(){
    $.ajax({
        url:"json",
        type:"POST",
        dataType: "json",  
        success:function(data){
            alert(data);
        },
        error:function(){
            alert("失败！");
        }
    });
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
        } else {
            layer.tips('验证码错误，请重新输入', '#verifyCode', {
                title: '标题',
                icon: 1,
                closeBtn: 1,
                shade: 0.8,
                time: 3000,
                maxWidth: 200,
                tips: [2, '#78BA32']//还可配置颜色

            });
            E.style.backgroundColor='#ff0000';
        }
    },
    error:function(){alert("执行失败！");}
     }
    );
}

$(document).ready(function () {
    $('#verifyCode').blur(
        function(){
                check_VerifyCode(this);
        }
    );

    $('#verifyCode').change(function(){
            if(this.value.length==4) {
                check_VerifyCode(this);
            }
    });

    $('#verifyCode').focus(function(){
        this.value="";
        this.style.backgroundColor='#ffffff';
    });

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
            	
            	alert(data["loginFlag"]);
                if(data["loginFlag"]==-1){

                    $('#error_text').append("<small>登陆失败:账号或密码错误，请检查后登陆</small>");
                }else if(data["loginFlag"]==0){
                    $('#error_text').append("<small>验证码错误！</small>");
                }else{
                    window.location=data['url'];
                }
            }

        });
    });
});