/**
 * Created by chenyi on 2016/04/02.
 */
$(document).ready(function () {


//设置性别的转换
    var sex_value= $('#sex').val();
    if(sex_value==1){
        $('#boy').attr("checked","checked");
    }else if(sex_value==0){
        $('#girl').attr("checked","checked");
    }

    $("input[name=sex_rodio]").click(function(){
        switch($("input[name=sex_rodio]:checked").attr("id")){
            case "boy":
                $('#sex').val('1');
                break;
            case "girl":
                $('#sex').val('0');
                break;
            default:
                break;
        }
    });

//设置生日的转换和获取


    var date=new Date();
    var year=date.getFullYear();
    for(var i=year;i>=1900;i--){
        $("#birthday_y").append("<option value="+i+" label="+i+">"+i+"</option>");
    }




    $('#birthday_y').change(function(){
        var birth_year=$('#birthday_y').val();
        if(birth_year!=""){
            var birth_month=$('#birthday_m').val();
            if(birth_month!=""){
                if(birth_month=="2"){
                    if((birth_year%4==0 && birth_year%100!=0) || (birth_year%400==0)){
                        $("#birthday_d").append("<option value=" + 29 + " label=" + 29 + ">" + 29 + "</option>");
                    }else{
                        $("#birthday_d option[value='29']").remove();
                    }
                }
            }else {
                for (var i = 1; i <= 12; i++) {
                    $("#birthday_m").append("<option value=" + i + " label=" + i + ">" + i + "</option>");
                }
            }
        }else{
            $("#birthday_m").html("<option value=''></option>");
            $("#birthday_d").html("<option value=''></option>");
        }
        checkBirthday();
    });
    $('#birthday_m').change(function(){
        var birth_year=$('#birthday_y').val();
        var birth_month=this.value;
        var birth_day=$('#birthday_d').val();
        if(birth_month!=""){
            switch (birth_month){
                case "1":case "3":case "5":case "7":case "8":case "10":case "12":
                if(birth_day=="") {
                    $("#birthday_d").empty();
                    $("#birthday_d").append("<option value='' ></option>");
                    for (var i = 1; i <= 31; i++) {
                        $("#birthday_d").append("<option value=" + i + " label=" + i + ">" + i + "</option>");
                    }
                }else {
                    switch ($("#birthday_d option:last").attr("value")){
                        case "28":$("#birthday_d").append("<option value=" + 29 + " >" + 29 + "</option>");
                        case "29":$("#birthday_d").append("<option value=" + 30 + " >" + 30 + "</option>");
                            $("#birthday_d").append("<option value=" + 31 + " >" + 31 + "</option>");break;
                        case "30":$("#birthday_d").append("<option value=" + 31 + " >" + 31 + "</option>");
                            break;
                        default :break;

                    }
                }
                break;
                case "4":case "6":case "9": case "11":
                if(birth_day=="") {
                    $("#birthday_d").empty();
                    $("#birthday_d").append("<option value='' ></option>");
                    for (var i = 1; i <= 30; i++) {
                        $("#birthday_d").append("<option value=" + i + " label=" + i + ">" + i + "</option>");
                    }
                }else{
                    switch ($("#birthday_d option:last").attr("value")){
                        case "28":$("#birthday_d").append("<option value=" + 29 + " >" + 29 + "</option>");
                        case "29":$("#birthday_d").append("<option value=" + 30 + " >" + 30 + "</option>");
                        case "31":$("#birthday_d option[value='31']").remove();
                            break;
                        default :break;

                    }
                }
                break;
                case "2":
                    if(birth_day==""){
                        if((birth_year%4==0 && birth_year%100!=0) || (birth_year%400==0)){
                            for(var i=1;i<=29;i++){
                                $("#birthday_d").append("<option value="+i+" label="+i+">"+i+"</option>");
                            }
                        }else{
                            for(var i=1;i<=28;i++){
                                $("#birthday_d").append("<option value="+i+" label="+i+">"+i+"</option>");
                            }
                        }}else{
                        $("#birthday_d option[value='31']").remove();
                        $("#birthday_d option[value='30']").remove();
                        if((birth_year%4==0 && birth_year%100!=0) || (birth_year%400==0)){

                        }else{
                            $("#birthday_d option[value='29']").remove();
                        }
                    }
                    break;
                default :break;
            }


        }
        checkBirthday();
    });

    $('#birthday_d').change(function() {
            checkBirthday();
        }
    );
    $('#birthday_d').focus(
        function(){
            if($('#birthday_m').val()==""){
                $("#birthday_d").empty();
                $("#birthday_d").append("<option value='' ></option>");
            }
        }
    );

    //根据后台提供的数据，填充用户的值
    var birth_value=$('#birth').val();
    if(birth_value!="") {
        var date1 = new Date(birth_value);
        var b_year=date1.getFullYear();
        var b_month=date1.getMonth()+1;
        var b_day=date1.getDate();
        $("#birthday_y").find("option[value='"+b_year+"']").attr("selected","selected");
        if($('#birthday_y').val()!="") {
            for (var i = 1; i <= 12; i++) {
                $("#birthday_m").append("<option value=" + i + " label=" + i + ">" + i + "</option>");
            }
        }
        $("#birthday_m").find("option[value='"+b_month+"']").attr("selected","selected");
        switch (b_month){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
            for (var i = 1; i <= 31; i++) {
                $("#birthday_d").append("<option value=" + i + " label=" + i + ">" + i + "</option>");
            }
            break;
            case 4:case 6:case 9: case 11:

            $("#birthday_d").append("<option value='' ></option>");
            for (var i = 1; i <= 30; i++) {
                $("#birthday_d").append("<option value=" + i + " label=" + i + ">" + i + "</option>");
            }
            break;
            case 2:
                if((b_year%4==0 && b_year%100!=0) || (b_year%400==0)){
                    for(var i=1;i<=29;i++){
                        $("#birthday_d").append("<option value="+i+" label="+i+">"+i+"</option>");
                    }
                }else{
                    for(var i=1;i<=28;i++){
                        $("#birthday_d").append("<option value="+i+" label="+i+">"+i+"</option>");
                    }
                }
                break;
            default :break;
        }
        $("#birthday_d").find("option[value='"+b_day+"']").attr("selected","selected");
    }

//验证生日是否输入完整
    function checkBirthday(){
        var b_year= $('#birthday_y').val();
        var b_month=$('#birthday_m').val();
        var b_day=$('#birthday_d').val();
        if(b_year!=""&&b_month!=""&&b_day!=""){
            $('#birth').val(b_year+"-"+b_month+"-"+b_day);
            $('#birth_error_info').addClass("hidden");
        }else{
            $('#birth').val("");
            $('#birth_error_info').removeClass("hidden");
        }
    }

    //血型
    var blood_value=$('#blood').val();
    if(blood_value!=""){
        $("#blood_select").find("option[value='"+blood_value+"']").attr("selected","selected");
    }
    $("#blood_select").change(function(){
        $('#blood').val(this.value);
    });

    //签名单|个人介绍
    $('#sign').val("");
    $('#sign').change(function(){

        if(this.value.length>36){
            $('#sign_error_info').removeClass("hidden");
        }else{
            $('#sign_error_info').addClass("hidden");
        }
    });

    $('#info').on('show.bs.collapse', function () {
        $('#info').prev().children(".panel-title").find("a").find("code").html("收起");

    });
    $('#info').on('hide.bs.collapse', function () {
        $('#info').prev().children(".panel-title").find("a").find("code").html("编辑");
        //	 $('#collapseexample').prev().children(".panel-title").find("a").append("<code class='pull-right'>编辑</code>");
        //   alert('嘿，当您展开时会提示本警告');
    });
    $('#tag').on('show.bs.collapse', function () {
        $('#tag').prev().children(".panel-title").find("a").find("code").html("收起");

    });
    $('#tag').on('hide.bs.collapse', function () {
        $('#tag').prev().children(".panel-title").find("a").find("code").html("编辑");
        //	 $('#collapseexample').prev().children(".panel-title").find("a").append("<code class='pull-right'>编辑</code>");
        //   alert('嘿，当您展开时会提示本警告');
    });
    $("#defaultInfo").click(function(){
        this.$default_info_form=$('#default_info_form');
        var url = this.$default_info_form.attr('action'),

            _this = this;
        var arr = this.$default_info_form.serializeArray();

        var data_str = $.param(arr);

        $.ajax({
            url:url,
            type:"POST",
            data:data_str,
            dataType:"json",
            contentType:"application/x-www-form-urlencoded",
            processData: false,


            beforeSend: function () {
                submitStart();
            },

            success: function (data) {
                if(data["loginFlag"]==-1){
                    layer.alert("信息更新失败！");
                }else if(data["loginFlag"]==1){
                    layer.tips("信息更新成功","#defaultInfo",{
                        tips:[1],
                        time:3000
                    });
                }
            },

            error: function (XMLHttpRequest, textStatus, errorThrown) {
                submitFail(textStatus || errorThrown);
            },

            complete: function () {
                submitEnd();
            }

        } );
    });

    function submitStart() {
        layer.load();
    }
    function submitEnd(){
        layer.closeAll('loading')
    }
    function submitFail(msg){
        layer.alert(msg);
    }


});
