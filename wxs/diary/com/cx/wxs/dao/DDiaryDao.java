package com.cx.wxs.dao;

import java.util.List;

import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.po.DDiary;
import com.cx.wxs.base.dao.IBaseDao;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */
public interface DDiaryDao extends IBaseDao<DDiary,Integer>{
    /**
    * 通过id获取DDiaryDto
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DDiaryDto getDDiaryByID(DDiaryDto dDiaryDto);

    /**
    * 通过相关数据获取DDiaryDtoList
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public List<DDiaryDto> getDDiaryList(DDiaryDto dDiaryDto);

    /**
    * 添加一个新的DDiary到数据库
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer addDDiary(DDiaryDto dDiaryDto);

    /**
    * 更新DDiary
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer updateDDiary(DDiaryDto dDiaryDto);

    /**
    * 删除DDiary
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public Integer deleteDDiary(DDiaryDto dDiaryDto);
    /**
     * 移动日志的目录
     * @param diaryDto
     * @param catalogDto
     * @return
     * @author 陈义
     * @date   2016-4-12下午4:22:37
     */
    public Integer diaryMove(DDiaryDto diaryDto,DCatalogDto catalogDto);

    /***
     * 获取当前的日志及前后两篇日志
     * @param diaryDto
     * @return
     * @author 陈义
     * @date   2016-4-12下午4:23:58
     */
    public List<DDiaryDto> getCurrentDiarys(DDiaryDto diaryDto);
    /**
     * 获取文章计数
     * @param dDiaryDto
     * @return
     * @author 陈义
     * @date   2016-5-6上午9:09:01
     */
    public Integer getDiaryCount(DDiaryDto dDiaryDto);
    /**
     * @param 
     * @return
     * @author 
     * @date   2016-5-6上午9:09:01
     */
    public List<DDiaryDto> getDiaryByLikeTitleOrContent(DDiaryDto dDiaryDto);
    /**
     * 
     */
    public Integer getLikeCount(DDiaryDto dDiaryDto);
}