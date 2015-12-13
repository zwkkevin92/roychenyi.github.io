package com.cx.wxs.service;

import java.util.List;

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

}