package com.cx.wxs.action.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 陈义
 * @date   2016-5-9 下午3:55:17
 */
@Controller
@RequestMapping("/hanger")
public class HangerAction {

	@RequestMapping("/wearth")
	@ResponseBody
	public JSONObject wearthModule(HttpServletRequest request,
			HttpServletResponse response){
		return null;
	}
}
