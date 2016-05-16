package com.cx.wxs.action.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.WWxsDto;
import com.cx.wxs.service.WWxsService;
@Controller
@RequestMapping("/club")
public class WxsAction {
	@Autowired
	WWxsService wxsService;
	
	@RequestMapping(value="/create")
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("wxs/create");
		return mv;
	}
	@RequestMapping(value="checkAcount")
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
	@RequestMapping(value="checkName")
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
	

}
