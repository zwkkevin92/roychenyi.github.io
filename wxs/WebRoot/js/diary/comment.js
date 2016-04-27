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
        'alignright'
//        ,'img'
    ];


    editor.create();
    //添加新评论
      $('#comment_form').submit(function(){
  	
     return false;
    });
    });