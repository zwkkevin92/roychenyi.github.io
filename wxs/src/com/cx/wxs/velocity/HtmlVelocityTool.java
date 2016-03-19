package com.cx.wxs.velocity;

/**
 * @author 陈义
 * @date   2016-1-8 下午8:43:30
 */
public class HtmlVelocityTool extends VelocityTool{


	/***
	 * 获取图片的路径
	 * @param img_name
	 * @return
	 * @author 陈义
	 * @date   2016-1-8下午8:44:04
	 */
	public String image_src(String img_name){
		StringBuffer img = new StringBuffer();
		img.append(super.root());
		img.append("/images/");
		img.append(img_name);
		return img.toString();
	}

	/***
	 * 在页面中间设置<img>标签
	 * @param img_name  图片
	 * @return
	 * @author 陈义
	 * @date   2016-1-8下午8:46:36
	 */
	public String img(String img_name){
		StringBuffer prefix = new StringBuffer("<img src=\"");
		prefix.append(super.root());
		prefix.append("/images/");
		prefix.append(img_name);
		prefix.append("\" border=\"0\" alt=\"\"/>");
		return prefix.toString();
	}

	/***
	 * 在页面中间设置<img>标签+alt
	 * @param img_name
	 * @param alt
	 * @return
	 * @author 陈义
	 * @date   2016-1-8下午8:47:23
	 */
	public String img(String img_name, String alt){
		StringBuffer prefix = new StringBuffer("<img src=\"");
		prefix.append(super.root());
		prefix.append("/images/");
		prefix.append(img_name);
		prefix.append("\"");
		
		prefix.append(" alt=\"");
		prefix.append((alt==null)?"":alt);
		prefix.append("\"");

		prefix.append(" border=\"0\"");
		
		prefix.append("/>");
		return prefix.toString();
	}
	/***
	 * 设置<img>
	 * @param img_name
	 * @param title
	 * @param alt
	 * @param align
	 * @param border 边框
	 * @return
	 * @author 陈义
	 * @date   2016-1-8下午8:47:55
	 */
	public String img(String img_name, String title, String alt, String align, int border){
		StringBuffer prefix = new StringBuffer("<img src=\"");
		prefix.append(super.root());
		prefix.append("/images/");
		prefix.append(img_name);
		prefix.append("\"");
		
		if(title!=null){
			prefix.append(" title=\"");
			prefix.append(title);
			prefix.append("\"");
		}

		prefix.append(" alt=\"");
		prefix.append((alt==null)?"":alt);
		prefix.append("\"");

		if(align!=null){
			prefix.append(" align=\"");
			prefix.append(align);
			prefix.append("\"");
		}
		
		prefix.append(" border=\"");
		prefix.append(border);
		prefix.append("\"");
		
		prefix.append("/>");
		return prefix.toString();
	}
	

}
