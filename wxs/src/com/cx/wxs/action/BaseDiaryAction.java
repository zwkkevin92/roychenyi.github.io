package com.cx.wxs.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.BConfigService;
import com.cx.wxs.service.DCatalogService;
import com.cx.wxs.service.SysTypeService;

/**
 * @author 陈义
 * @date   2016-4-16 下午4:42:27
 */
@Controller
public class BaseDiaryAction extends BaseAction{
	
	@Resource
	private BConfigService configService;
	@Resource
	private DCatalogService catalogService;
	@Resource
	private SysTypeService sysTypeService;
    
	
	public void getDiarySetting(UUserDto userDto,ModelAndView mv){
		//是否可以上传日志
		BConfigDto configDto=new BConfigDto();
		configDto.setBSiteDto(userDto.getBSiteDto());
		configDto.setConfigKey("allow_pull");
		configDto=configService.getBConfig(configDto);
		mv.addObject("contribute", configDto);
		//用户分类列表
		DCatalogDto catalogDto=new DCatalogDto();
		catalogDto.setUUserDto(userDto);
		List<DCatalogDto> catalogList=catalogService.getDCatalogList(catalogDto);
		mv.addObject("catalogList", catalogList);
		//获取系统分类
		SysTypeDto sysTypeDto=new SysTypeDto();
		sysTypeDto.setParentId(0);
		List<SysTypeDto> sysTypeList=sysTypeService.getSysTypeList(sysTypeDto);
		mv.addObject("sysTypeList", sysTypeList);
	}
	
	public void getDcatolog(DCatalogDto catalogDto,ModelAndView mv){
		List<DCatalogDto> catalogDtos=catalogService.getDCatalogList(catalogDto);
		mv.addObject("catalogs", catalogDtos);
	}

}
