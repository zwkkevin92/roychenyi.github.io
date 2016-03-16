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

        layer.tips('tips的样式并非是固定的，您可自定义外观', '#username',{
            title:'标题',
            icon:1,
            closeBtn:1,
            shade:0.8,
            time:1000,
            maxWidth:200,
            tips: [3, '#78BA32']//还可配置颜色



        });
    }

}
