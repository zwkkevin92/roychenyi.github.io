package com.cx.wxs.utils;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.TableTag;
import org.htmlparser.tags.TitleTag;

/**
 * @author 陈义
 * @date   2016-3-20 下午3:45:37
 */
public class HtmlNodeFilters {

	/**
	 * 用于提取页面的图像
	 * @author Winter Lau
	 */
	public final static NodeFilter imageFilter = new NodeFilter() {
		public boolean accept(Node node) {
			return (node instanceof ImageTag);
		}		
	};
	/**
	 * 用于提取页面的表格
	 * @author Winter Lau
	 */
	public final static NodeFilter tableFilter = new NodeFilter() {
		public boolean accept(Node node) {
			return (node instanceof TableTag);
		}		
	};
	/**
	 * 用于提取页面的标题
	 * @author Winter Lau
	 */
	public final static NodeFilter titleFilter = new NodeFilter() {
		public boolean accept(Node node) {
			return (node instanceof TitleTag);
		}		
	};

}
