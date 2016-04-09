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
    
    public Integer diaryMove(DDiaryDto diaryDto,DCatalogDto catalogDto);

}