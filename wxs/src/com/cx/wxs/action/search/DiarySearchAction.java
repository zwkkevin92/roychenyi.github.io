package com.cx.wxs.action.search;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cx.wxs.action.BaseAction;
import com.cx.wxs.dao.DDiaryDao;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.service.DDiaryService;
@Controller
public class DiarySearchAction extends BaseAction {
	
	@Resource
	private DDiaryService diaryService;
	

	public DDiaryService getDiaryService() {
		return diaryService;
	}


	public void setDiaryService(DDiaryService diaryService) {
		this.diaryService = diaryService;
	}


	@RequestMapping(value="/getDiaryByLikeTitleOrContent")
	ModelAndView getDiaryByLikeTitleOrContent(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("search/main");
		DDiaryDto diaryDto = new DDiaryDto();
		diaryDto.setContent(request.getParameter("content"));
		diaryDto.setTitle(request.getParameter("title"));
		String pageStr = request.getParameter("page");
		Integer pageNum = 1;
		if(pageStr!=null){
			pageNum = Integer.parseInt(pageStr);
		}
		diaryDto.setPage(pageNum);
		diaryDto.setRows(10);//默认10条记录/每页
		List<DDiaryDto>  listDiaryDto = diaryService.getDiaryByLikeTitleOrContent(diaryDto);
		mv.addObject("diaryList", listDiaryDto);
		return mv;		
	}

}
