package com.cx.wxs.velocity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.util.ParserException;

import com.cx.wxs.utils.StringUtils;



/**
 * 获取网页内容
 * @author 陈义
 * @date   2016-1-8 上午11:41:06
 */
public class VelocityTextTool {


	/**
	 * HTML输出内容格式转换
	 * @param content
	 * @return
	 */
	public String html(Object content){
		return StringUtils.formatContent((String)content);
	}
	
	private static List<String> tokens_keep;
	private static List<String> tokens_remove;
	static{
		tokens_keep = new ArrayList<String>();
		tokens_keep.add("&nbsp;");
		tokens_keep.add("<br/>");
		tokens_keep.add("<br />");
		tokens_remove = new ArrayList<String>();
		tokens_remove.add("<p>");
		tokens_remove.add("</p>");
	}
	
	/**
	 * 显示友好的格式化文本信息
	 * @param content
	 * @return
	 */
	public static String friendly_text(String content){
        if(content==null)
            return "";
        String html = content;
        for(int i=0;i<tokens_remove.size();i++){
        	html = StringUtils.remove(html, (String)tokens_remove.get(i));
        }
        List<String> randoms = new ArrayList<String>();
        for(int i=0;i<tokens_keep.size();i++){
    		String randomStr = String.valueOf(System.currentTimeMillis())+'_'+i;
    		html = StringUtils.replaceIgnoreCase(html, (String)tokens_keep.get(i), randomStr);
    		randoms.add(randomStr);
        }
		html = StringUtils.replace(html, "&hellip;", "…");
		html = StringUtils.replace(html, "&ldquo;", "“");
		html = StringUtils.replace(html, "&rdquo;", "”");
		html = StringUtils.replace(html, "&mdash;", "—");
		html = StringUtils.replace(html, "&quot;", "\"");
		html = StringUtils.replace(html, "&", "&amp;");
		html = StringUtils.replace(html, "'", "&apos;");
		html = StringUtils.replace(html, "\"", "&quot;");
		html = StringUtils.replace(html, "\t", "&nbsp;&nbsp;");// 替换跳格
		//html = StringUtils.replace(html, " ", "&nbsp;");// 替换空格
		html = StringUtils.replace(html, "<", "&lt;");
		html = StringUtils.replace(html, ">", "&gt;");
		for(int i=0;i<tokens_keep.size();i++){
			String randomStr = (String)randoms.get(i);
			html = StringUtils.replaceIgnoreCase(html, randomStr, (String)tokens_keep.get(i));
		}
		return html;
	}

    /**
     * 转换HTML成纯文本，用于显示最新评论或者是日记在首页的预览信息
     * @param html
     * @return
     * @throws UnsupportedEncodingException
     * @throws ParserException 
     */
	public static String plain_text(String html) throws Exception{
		return StringUtils.extractText(html);
	}

	/**
	 * 字符串智能截断
	 * @param str
	 * @param maxWidth
	 * @return
	 */
	public String abbreviate(String str, int maxWidth){
		if(str==null) return null;
		return StringUtils.abbreviate(str,maxWidth);
	}

	/**
	 * 文本替换(login.vm)
	 * 
	 * @param src
	 * @param srcText
	 * @param desText
	 * @return
	 */
	public String replace(String src, String srcText, String desText) {
		return StringUtils.replace(src, srcText, desText);
	}

	/**
	 * 判断是否是一个合法的邮件地址
	 * 
	 * @param email
	 * @return
	 */
	public boolean is_email(String email) {
		return StringUtils.isEmail(email);
	}
	
	public boolean is_empty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public boolean not_empty(String str) {
		return !is_empty(str);
	}

	public static void main(String[] args){
		String html = "hello my name is <form> <bR/>";
		System.out.println(friendly_text(html));
	}
	
}
