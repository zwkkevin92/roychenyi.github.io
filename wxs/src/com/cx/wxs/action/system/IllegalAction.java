package com.cx.wxs.action.system;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.SysIllegalDto;
import com.cx.wxs.service.SysIllegalService;

/**
 * @author 陈义
 * @date   2016-5-16 下午8:53:06
 */
@Controller
@RequestMapping("/system/illegal")
public class IllegalAction {

	@Resource
	private SysIllegalService sysIllegalService;
	@RequestMapping(value="")
	public ModelAndView illegalManage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("system/common/illegal");
		return mv;
	}
	/**
	 * 创建一个敏感词
	 * @param request
	 * @param response
	 * @param sysIllegalDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-16下午9:07:26
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public SysIllegalDto addIllegal(HttpServletRequest request,HttpServletResponse response,SysIllegalDto sysIllegalDto){
		Date date=new Date();
		sysIllegalDto.setNullify((short)1);
		sysIllegalDto.setCreateTime(new Timestamp(date.getTime()));
		int illegalId=sysIllegalService.addSysIllegal(sysIllegalDto);
		if(illegalId>0){
			sysIllegalDto.setStatusFlag("-1");
		}else{
			sysIllegalDto.setStatusFlag("1");
		}
		return sysIllegalDto;
	}
	/**
	 * 获取列表
	 * @param page
	 * @param request
	 * @param response
	 * @param sysIllegalDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-17上午10:59:24
	 */
	@RequestMapping(value="list")
	@ResponseBody
	public List<SysIllegalDto> getIllegalList(Integer page,HttpServletRequest request,HttpServletResponse response,SysIllegalDto sysIllegalDto){
		List<SysIllegalDto> sysIllegalDtos=new ArrayList<SysIllegalDto>();
		sysIllegalDtos=sysIllegalService.getSysIllegalList(sysIllegalDto);
		return sysIllegalDtos;
	}
	/**
	 * 更新一个敏感词
	 * @param request
	 * @param response
	 * @param sysIllegalDto
	 * @return
	 * @author 陈义
	 * @date   2016-5-17上午10:59:37
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public SysIllegalDto updateIllegal(HttpServletRequest request,HttpServletResponse response,SysIllegalDto sysIllegalDto){
		sysIllegalService.updateSysIllegal(sysIllegalDto);
		sysIllegalDto=sysIllegalService.getSysIllegalByID(sysIllegalDto);
		return sysIllegalDto;
	}
}
