package com.cx.wxs.action.club;

import java.text.MessageFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.WWxsDto;
import com.cx.wxs.enums.EmailType;
import com.cx.wxs.service.EmailService;
import com.cx.wxs.service.WWxsService;
import com.cx.wxs.utils.MD5Tool;
import com.cx.wxs.utils.StringUtils;
import com.cx.wxs.utils.TemplateUtils;
@Controller
@RequestMapping("/club")
public class WxsAction {
	@Resource
	private  WWxsService wxsService;
	@Resource
	private EmailService emailService;
	
	@RequestMapping(value="/create")
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv =new ModelAndView("wxs/create");
		return mv;
	}
	@RequestMapping(value="checkAccount")
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
	

}
