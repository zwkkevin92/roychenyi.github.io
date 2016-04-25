package com.cx.wxs.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.dto.BConfigDto;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.SysTypeDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.service.BConfigService;
import com.cx.wxs.service.DCatalogService;
import com.cx.wxs.service.SysTypeService;
import com.cx.wxs.utils.RequestUtils;
import com.cx.wxs.utils.StringUtils;

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
	/**
	 * 获取分页信息
	 * @param catalogDto
	 * @param mv
	 * @author 陈义
	 * @date   2016-4-25下午7:45:48
	 */
	public void getDcatolog(DCatalogDto catalogDto,ModelAndView mv){
		List<DCatalogDto> catalogDtos=catalogService.getDCatalogList(catalogDto);
		mv.addObject("catalogs", catalogDtos);
	}
	/**
	 * 将日志的分页信息存入cookie和session
	 * @param diaryDto
	 * @author 陈义
	 * @date   2016-4-25下午7:46:57
	 */
	public void setCookie_page(DDiaryDto diaryDto,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		Integer pageCount=diaryDto.getPageCount();
		Integer page=diaryDto.getPage();
		RequestUtils.setCookie(request, response, "page", page.toString(),12*3600);
		RequestUtils.setCookie(request, response, "pageCount", pageCount.toString(),12*3600);
		session.setAttribute("page", page);
		session.setAttribute("pageCount", pageCount);
	}

}
