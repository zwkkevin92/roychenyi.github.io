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
    function testText(){
        alert(editor.$txt.html());
        alert(editor.$txt.text());
        alert(editor.$txt.formatText);
    }
});