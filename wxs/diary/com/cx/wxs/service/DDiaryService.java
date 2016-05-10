package com.cx.wxs.service;

import java.util.List;

import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;

/**
 * @author 陈义
 * @date 2015-12-13 19:01:59
 */

public interface DDiaryService {
    /**
    * 通过用户id获取DDiaryDto信息
    * @author 陈义
    * @date 2015-12-13 19:01:59
    */
    public DDiaryDto getDDiaryByID(DDiaryDto dDiaryDto);

    /**
    * 通过相关信息获取DDiaryDtoList信息
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
    /***
     * 把日志移动到个人日记中
     * @return
     * @author 陈义
     * @date   2016-4-9下午9:36:06
     */
    public Integer diaryMove(DDiaryDto diaryDto,DCatalogDto catalogDto);
    /***
     * 获取当前的日志和前后两篇日志
     * @param diaryDto
     * @return
     * @author 陈义
     * @date   2016-4-12下午4:53:25
     */
    public List<DDiaryDto> getCurrentDiarys(DDiaryDto diaryDto);
    /**
     * 获取分页信息
     * @param diaryDto
     * @return
     * @author 陈义
     * @date   2016-4-25下午4:54:01
     */
    public DDiaryDto getPageInfo(DDiaryDto diaryDto);
    /***
     * 获取日志预览列表
     * @param diaryDto
     * @return
     */    
    public List<DDiaryDto> getDDiaryPreList(DDiaryDto diaryDto);
    /**
     * 根据标题或者内容查找文章
     * @param diaryDto
     * @return
     */
    public List<DDiaryDto>  getDiaryByLikeTitleOrContent(DDiaryDto diaryDto);
    /**
     * 获取页数
     * @param diaryDto
     * @return
     */
    public Integer getPageByLike(DDiaryDto diaryDto);
}