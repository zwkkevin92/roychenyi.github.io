package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.dto.DUpvoteDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface DUpvoteService {
    /**
    * 通过用户id获取DUpvoteDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DUpvoteDto getDUpvoteByID(DUpvoteDto dUpvoteDto);
    /**
     * 通过相信关系获取upvote 信息
     * @param dUpvoteDto
     * @return
     * @author 陈义
     * @date   2016-4-17上午10:56:42
     */
    public DUpvoteDto getDUpvote(DUpvoteDto dUpvoteDto);

    /**
    * 通过相关信息获取DUpvoteDtoList信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DUpvoteDto> getDUpvoteList(DUpvoteDto dUpvoteDto);
    

    /**
    * 添加一个新的DUpvote到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDUpvote(DUpvoteDto dUpvoteDto);

    /**
    * 更新DUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDUpvote(DUpvoteDto dUpvoteDto);

    /**
    * 删除DUpvote
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDUpvote(DUpvoteDto dUpvoteDto);
    /***
     * 获取文章点赞数量
     * @param dUpvoteDto
     * @return
     * @author 陈义
     * @date   2016-5-11下午7:47:24
     */
    public Integer getDUpvoteCount(DUpvoteDto dUpvoteDto);
    
    public List<DDiaryDto> getdDiarysByUpvote(DUpvoteDto dUpvoteDto); 

}