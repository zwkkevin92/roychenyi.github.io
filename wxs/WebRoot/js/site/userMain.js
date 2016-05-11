/**
 * Created by chenyi on 2016/05/11.
 */
$(document).ready(function(){
    $(document).scroll(function(){
        var  scrollTop =  $(document).scrollTop(),
             top1=$('#leftMenu').offset().top;
        if(scrollTop>top1){
            var navbarH=$('#navbar').height();
            var width=$('#leftMenu').width();
            var footerH=$('footer').height();
            var height=$(document).height();
            $('#leftMenu>div').css({position: 'fixed',top:navbarH,bottom:footerH,width:width});
            if(footerH>(height-scrollTop)){
                $('#leftMenu>div').removeAttr('style');
            }
        }else{
            $('#leftMenu>div').removeAttr('style');
        }
    });
});