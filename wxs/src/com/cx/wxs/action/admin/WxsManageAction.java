package com.cx.wxs.action.admin;

import java.text.MessageFormat;
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
import com.cx.wxs.enums.EmailType;
import com.cx.wxs.service.EmailService;
import com.cx.wxs.service.WWxsService;
import com.cx.wxs.utils.StringUtils;
import com.cx.wxs.utils.TemplateUtils;

/**
 * @author 陈义
 * @date   2016-5-16 下午4:34:01
 * 文学社管理，添加、修改、配置
 */
@Controller
@RequestMapping("/system/club")
public class WxsManageAction {

	@Resource
    private WWxsService wxsService;
	@Resource
	private EmailService emailService;
	
	public void setWxsService(WWxsService wxsService) {
		this.wxsService = wxsService;
	}
	@RequestMapping(value="")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("system/club/main");
		return mv;
	}
	@RequestMapping(value="/create")
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("system/club/main");
		return mv;
	}
	@RequestMapping(value="/checkacount")
	@ResponseBody
	public String checkAcount(HttpServletRequest request,HttpServletResponse response,WWxsDto wWxsDto){
		String flag = "0";//默认为0，失败（数据库中已经存在）
		if(wWxsDto!=null&&StringUtils.isNotEmpty(wWxsDto.getAccount())){
			wWxsDto = wxsService.getWWxsDto(wWxsDto);
			if(wWxsDto==null){
				flag = "1";//修改flag,，成功（数据库中不存在）
			}
		}
		return flag;
		
	}
	@RequestMapping(value="/checkname")
	@ResponseBody
	public String checkName(HttpServletRequest request,HttpServletResponse response,WWxsDto wWxsDto){
		String flag = "0";//默认为0，失败（数据库中已经存在）
		if(wWxsDto!=null&&StringUtils.isNotEmpty(wWxsDto.getName())){
			wWxsDto = wxsService.getWWxsDto(wWxsDto);
			if(wWxsDto==null){
				flag = "1";//修改flag,，成功（数据库中不存在）
			}
		}
		return flag;
		
	}
	
	@RequestMapping(value="/createCheck")
	@ResponseBody 
	public WWxsDto createWxs(HttpServletRequest request,HttpServletResponse response,WWxsDto wxsDto){
		if(wxsDto!=null){
			if(StringUtils.isNotEmpty(wxsDto.getAccount())&&StringUtils.isNotEmpty(wxsDto.getName())){
				wxsDto.setPassword(StringUtils.md5("123456"));//设置默认密码
				Integer result = wxsService.addWWxs(wxsDto);
				if(result>0){
					wxsDto.setStatusFlag("1");//注册成功
					String template=TemplateUtils.getTemplate("vm/conf/admin_check.html");
					String notify_content = MessageFormat.format(template,wxsDto.getName(),wxsDto.getAccount(),"123456");
					String title = "文学社平台注册激活";
					String[] receivers=new String[]{wxsDto.getMail()};
					emailService.sendEmail(title, receivers, notify_content, EmailType.VALIDATE);
				}else{
					wxsDto.setStatusFlag("-1");//注册不成功
				}
			}
		}
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
	public List<WWxsDto> getWxsList(Integer page,HttpServletRequest request,HttpServletResponse response,WWxsDto wxsDto){
		
		wxsDto.setRows(10);
		if(page==null){
			page = 1;
		}
		wxsDto.setPage(page);
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
