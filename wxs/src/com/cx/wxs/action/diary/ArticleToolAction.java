package com.cx.wxs.action.diary;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.wxs.action.BaseDiaryAction;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.dto.DReply1Dto;
import com.cx.wxs.dto.DUpvoteDto;
import com.cx.wxs.dto.UUserDto;
import com.cx.wxs.po.DReply1;
import com.cx.wxs.service.DDiaryService;
import com.cx.wxs.service.DFavoriteService;
import com.cx.wxs.service.DReply1Service;
import com.cx.wxs.service.DUpvoteService;
import com.cx.wxs.service.UUserService;
import com.cx.wxs.utils.RequestUtils;

/**
 * @author 陈义
 * @date   2016-4-28 下午3:44:01
 */
@Controller
@RequestMapping("/{vip}/article")
public class ArticleToolAction extends BaseDiaryAction{
	@Resource
	private DUpvoteService upvoteService;
	@Resource
	private DFavoriteService favoriteService;
	@Resource
	private DReply1Service reply1Service;
	@Resource
	private UUserService userService;
	@Resource
	private DDiaryService diaryService;

	/**
	 * 文章点赞
	 * @param vip
	 * @param diaryId
	 * @param request
	 * @param reqResponse
	 * @param diaryDto
	 * @return
	 * @author 陈义
	 * @date   2016-4-16下午4:18:21
	 */
	@RequestMapping(value="/toupvote/{diaryId}")
	@ResponseBody
	public DDiaryDto articleUpvote(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto,DUpvoteDto upvoteDto){
		//访问用户
		UUserDto userDto1=(UUserDto) request.getSession().getAttribute("user");
		if(userDto1==null){
			diaryDto.setStatusFlag("-2");   //未登录
		}else{
			//作者信息
			//UUserDto userDto2=getUserDtoByNickname(vip);
			Date date=new Date();
			diaryDto.setDiaryId(diaryId);		
			diaryDto=diaryService.getDDiaryByID(diaryDto);		
			DUpvoteDto upvoteDto2=this.getDUpvoteDto(diaryDto, userDto1);
			if(upvoteDto2!=null){
				upvoteDto2.setStatus((short)0);
				upvoteDto2.setUpdateTime(new Timestamp(date.getTime()));
				if(upvoteService.updateDUpvote(upvoteDto2)>0){
			//	upvoteDto=upvoteDto2;
				diaryDto.setStatusFlag("0");
				//取消赞
				diaryDto.setUpvoteCount(diaryDto.getUpvoteCount()-1);  //点赞数量减一
				diaryService.updateDDiary(diaryDto);
				}else{
					diaryDto.setStatusFlag("-1");
				}
			}else{
				upvoteDto.setStatus((short)1);
				upvoteDto.setTime(new Timestamp(date.getTime())); //添加时间
				upvoteDto.setDDiaryDto(diaryDto);
				upvoteDto.setUUserDto(userDto1);
				int upvoteId=upvoteService.addDUpvote(upvoteDto);
				
				if(upvoteId>0){
					diaryDto.setStatusFlag("1");
					//点赞数更新
					if(diaryDto.getUpvoteCount()==null){
						diaryDto.setUpvoteCount(1);
					}else{
						diaryDto.setUpvoteCount(diaryDto.getUpvoteCount()+1);
					}
					diaryService.updateDDiary(diaryDto);
				}else{
					diaryDto.setStatusFlag("-1");
				}
			}
		}
		return diaryDto;
	}
	/**
	 * 文章收藏
	 * @param vip
	 * @param diaryId
	 * @param request
	 * @param reqResponse
	 * @param diaryDto
	 * @return
	 * @author 陈义
	 * @date   2016-4-16下午4:18:42
	 */
	@RequestMapping(value="/tofavorite/{diaryId}")
	@ResponseBody
	public DDiaryDto articleFavorite(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto,DFavoriteDto favoriteDto){
		
		UUserDto userDto1=(UUserDto) request.getSession().getAttribute("user");
		if(userDto1==null){
			diaryDto.setStatusFlag("-2");			
		}else{
			Date date=new Date();
			diaryDto.setDiaryId(diaryId);
			diaryDto=diaryService.getDDiaryByID(diaryDto);
			DFavoriteDto favoriteDto2=this.getDFavoriteDto(diaryDto, userDto1);
			if(favoriteDto2!=null){
				//取消收藏
				favoriteDto2.setStatus((short)0);
				favoriteDto2.setUpdateTime(new Timestamp(date.getTime()));
				if(favoriteService.updateDFavorite(favoriteDto2)>0){
			//		favoriteDto=favoriteDto2;
					diaryDto.setStatusFlag("0");
					diaryDto.setFavoriteCount(diaryDto.getFavoriteCount()-1);
					diaryService.updateDDiary(diaryDto);
				}else{
					diaryDto.setStatusFlag("-1");
				}
			}else{
				favoriteDto.setDDiaryDto(diaryDto);
				favoriteDto.setUUserDto(userDto1);
				favoriteDto.setTime(new Timestamp(date.getTime()));
				favoriteDto.setStatus((short)1);
				int favoriteId= favoriteService.addDFavorite(favoriteDto);
				if(favoriteId>0){
					//确认收藏
					if(diaryDto.getFavoriteCount()==null){
						diaryDto.setFavoriteCount(1);
					}else{
						diaryDto.setFavoriteCount(diaryDto.getFavoriteCount()+1);
					}
					diaryService.updateDDiary(diaryDto);
					diaryDto.setStatusFlag("1");
			//		favoriteDto.setDfavoriteId(favoriteId);
				}else{
					diaryDto.setStatusFlag("-1");
				}
			}
		}
		return diaryDto;
	}
	@RequestMapping(value="/totrash/{diaryId}")
	@ResponseBody
	public DDiaryDto articleToTrash(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto ){
		
		diaryDto.setDiaryId(diaryId);
//		diaryDto.setUUserDto(userDto);
        diaryDto=this.updateDiaryRole(diaryDto, (short)-1, request);
        
		return diaryDto;
	}
	/***
	 * 彻底删除日志（把role改为-2）
	 * @param vip
	 * @param diaryId
	 * @param request
	 * @param reqResponse
	 * @param diaryDto
	 * @return
	 * @author 陈义
	 * @date   2016-4-16下午4:17:28
	 */
	@RequestMapping(value="/todelete/{diaryId}")
	@ResponseBody
	public DDiaryDto  articleDelete(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto ){
	
		diaryDto.setDiaryId(diaryId);
		diaryDto=this.updateDiaryRole(diaryDto, (short)-2, request);
		//返回回收站
		diaryDto.setUrl(diaryDto.getUrl()+"&role=-1");
		return diaryDto;
	}
	@RequestMapping(value="/toprivate/{diaryId}")
	@ResponseBody
	public DDiaryDto articleToPrivate(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto ){
	/*	UUserDto userDto=(UUserDto) request.getSession().getAttribute("user");
		if(userDto==null||!userDto.getNickname().equals(vip)){
			diaryDto.setStatusFlag("-2");
			return diaryDto;
		}*/
		diaryDto.setDiaryId(diaryId);
		diaryDto=this.updateDiaryRole(diaryDto, (short)0, request);
		//返回私密日志列表
		diaryDto.setUrl(diaryDto.getUrl()+"&role=0");
		return diaryDto;
	}
	@RequestMapping(value="/tocommen/{diaryId}")
	@ResponseBody
	public DDiaryDto artivleToCommen(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse,DDiaryDto diaryDto){
		diaryDto.setDiaryId(diaryId);
		diaryDto=this.updateDiaryRole(diaryDto, (short)1, request);
		//返回私密日志列表
		diaryDto.setUrl(diaryDto.getUrl()+"&role=1");
		return diaryDto;
	}
	/***
	 * 获取文章的相关计数
	 * @param vip
	 * @param diaryId
	 * @param request
	 * @param reqResponse
	 * @return
	 * @author 陈义
	 * @date   2016-5-12下午7:06:10
	 */
	@RequestMapping(value="/details/{diaryId}/infoCount")
	@ResponseBody
	public DDiaryDto updateInfoCount(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse){
		DDiaryDto dDiaryDto=new DDiaryDto(diaryId);
		//获取最新点赞计数
		DUpvoteDto upvoteDto=new DUpvoteDto();
		upvoteDto.setDDiaryDto(dDiaryDto);
	    Integer upvoteCount=upvoteService.getDUpvoteCount(upvoteDto);
		dDiaryDto.setUpvoteCount(upvoteCount);
		//获取最新收藏计数
		DFavoriteDto favoriteDto=new DFavoriteDto();
		favoriteDto.setDDiaryDto(dDiaryDto);
		Integer favoriteCount=favoriteService.getDFavoriteCount(favoriteDto);
		dDiaryDto.setFavoriteCount(favoriteCount);
		//获取最新评论极速
		DReply1Dto dReply1Dto=new DReply1Dto();
		dReply1Dto.setDDiaryDto(dDiaryDto);
		int commentCount=reply1Service.getDReply1Count(dReply1Dto);
		dDiaryDto.setReplyCount(commentCount);	
		//更新计数
		diaryService.updateDDiary(dDiaryDto);
		return dDiaryDto;
	}
	/**
	 * 获取文章点赞数量
	 * @param vip  用户昵称
	 * @param diaryId 文章id
	 * @param request
	 * @param reqResponse
	 * @return
	 * @author 陈义
	 * @date   2016-5-11下午7:56:21
	 */
	@RequestMapping(value="/details/{diaryId}/upvoteCount")
	@ResponseBody
	public DDiaryDto updateUpvoteCount(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse){
		DDiaryDto dDiaryDto=new DDiaryDto(diaryId);
		DUpvoteDto upvoteDto=new DUpvoteDto();
		upvoteDto.setDDiaryDto(dDiaryDto);
	    int count=upvoteService.getDUpvoteCount(upvoteDto);
		dDiaryDto.setUpvoteCount(count);
		diaryService.updateDDiary(dDiaryDto);
		return dDiaryDto;
	}
	@RequestMapping(value="/details/{diaryId}/favoriteCount")
	@ResponseBody
	public DDiaryDto updateFavoriteCount(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse){
		DDiaryDto dDiaryDto=new DDiaryDto(diaryId);
		DFavoriteDto favoriteDto=new DFavoriteDto();
		favoriteDto.setDDiaryDto(dDiaryDto);
		int count=favoriteService.getDFavoriteCount(favoriteDto);
		dDiaryDto.setFavoriteCount(count);
		diaryService.updateDDiary(dDiaryDto);
		return dDiaryDto;
	}
	@RequestMapping(value="/details/{diaryId}/commentCount")
	@ResponseBody	
	public DDiaryDto updateCommentCount(@PathVariable("vip") String vip,@PathVariable("diaryId") Integer diaryId,
			HttpServletRequest request,HttpServletResponse reqResponse){
		DDiaryDto dDiaryDto=new DDiaryDto(diaryId);
		DReply1Dto dReply1Dto=new DReply1Dto();
		dReply1Dto.setDDiaryDto(dDiaryDto);
		int count=reply1Service.getDReply1Count(dReply1Dto);
		dDiaryDto.setReplyCount(count);
		diaryService.updateDDiary(dDiaryDto);
		return dDiaryDto;
	}
}
