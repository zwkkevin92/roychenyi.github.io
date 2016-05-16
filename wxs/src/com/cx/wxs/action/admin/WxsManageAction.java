package com.cx.wxs.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.WWxsDto;
import com.cx.wxs.service.WWxsService;

/**
 * @author 陈义
 * @date   2016-5-16 下午4:34:01
 * 文学社管理，添加、修改、配置
 */
@Controller
@RequestMapping("/system/club")
public class WxsManageAction {

	@Resource
	WWxsService wxsService;
	
	@RequestMapping(value="/create")
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("admin/club/main");
		return mv;
	}
	@RequestMapping(value="/checkacount")
	@ResponseBody
	public String checkAcount(HttpServletRequest request,HttpServletResponse response,WWxsDto wWxsDto){

		String flag = "0";//默认为0，失败

		if(wWxsDto!=null&&wWxsDto.getAccount()!=null){
			List<WWxsDto> list = wxsService.getWWxsList(wWxsDto);
			if(list!=null&&list.size()>0){
				
			}
		}
		return flag;
		
	}
	@RequestMapping(value="/checkname")
	@ResponseBody
	public String checkName(HttpServletRequest request,HttpServletResponse response,WWxsDto wWxsDto){
		String flag = "0";//默认为0，失败（数据库中已经存在）
		if(wWxsDto!=null&&!wWxsDto.getName().trim().equals("")){
			List<WWxsDto> list = wxsService.getWWxsList(wWxsDto);
			if(list!=null&&list.size()==0){
				flag = "1";//修改flag,，成功（数据库中不存在）
			}
		}
		return flag;
		
	}
	
	@RequestMapping(value="/createCheck")
	@ResponseBody 
	public WWxsDto createWxs(HttpServletRequest request,HttpServletResponse response,WWxsDto wxsDto){
		if(wxsDto!=null){}
		return wxsDto;
	}
	/**
	 * club列表
	 * @param page
	 * @param request
	 * @param response
	 * @param wxsDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-16下午4:49:51
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public List<WWxsDto> getWxsList(@PathVariable("page") Integer page,HttpServletRequest request,HttpServletResponse response,WWxsDto wxsDto){
		List<WWxsDto> wxsList=new ArrayList<WWxsDto>();
		wxsList=wxsService.getWWxsList(wxsDto);
		return wxsList;
	}
	/**
	 * 更新wxs
	 * @param request
	 * @param response
	 * @param wxsDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-16下午4:49:33
	 */
	@RequestMapping(value="/update")
	public WWxsDto  updateWxs(HttpServletRequest request,HttpServletResponse response,WWxsDto wxsDto){
		return wxsDto;
	}
}
