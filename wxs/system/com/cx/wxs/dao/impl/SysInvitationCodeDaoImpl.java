package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysInvitationCodeDao;
import com.cx.wxs.dto.SysInvitationCodeDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysInvitationCode;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SysInvitationCodeDao")
public class SysInvitationCodeDaoImpl extends BaseDaoImpl<SysInvitationCode, Integer> implements SysInvitationCodeDao{

    private BeanToDto<SysInvitationCode, SysInvitationCodeDto> beanToDto=new BeanToDto<SysInvitationCode, SysInvitationCodeDto>();

    public BeanToDto<SysInvitationCode, SysInvitationCodeDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SysInvitationCode, SysInvitationCodeDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SysInvitationCodeDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SysInvitationCodeDto getSysInvitationCodeByID(SysInvitationCodeDto sysInvitationCodeDto){
        // TODO Auto-generated method stub
        if(sysInvitationCodeDto!=null&&sysInvitationCodeDto.getCodeId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysInvitationCode.class.getName()+"  a where a.codeId=:id");
           params.put("id",sysInvitationCodeDto.getCodeId());
           List<SysInvitationCode> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysInvitationCode t1= list.get(0);
            SysInvitationCodeDto    dto=new    SysInvitationCodeDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysInvitationCodeDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SysInvitationCodeDto> getSysInvitationCodeList(SysInvitationCodeDto sysInvitationCodeDto){
        return null;
    }

    /**
    * 添加一个新的SysInvitationCode到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto){
         // TODO Auto-generated method stub
        if(sysInvitationCodeDto!=null){
           SysInvitationCode sysInvitationCode= new SysInvitationCode();
           sysInvitationCode=beanToDto.D1ToT1(sysInvitationCode, sysInvitationCodeDto);
           return this.save(sysInvitationCode);
        }
        return 0;
    }

    /**
    * 更新SysInvitationCode
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto){
        // TODO Auto-generated method stub
        if(sysInvitationCodeDto!=null&&sysInvitationCodeDto.getCodeId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysInvitationCodeDto.createSetPropertiesVal(sysInvitationCodeDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysInvitationCode.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.codeId=:uid");
           params.put("uid",sysInvitationCodeDto.getCodeId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysInvitationCode
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSysInvitationCode(SysInvitationCodeDto sysInvitationCodeDto){
         // TODO Auto-generated method stub
        if(sysInvitationCodeDto!=null&&sysInvitationCodeDto.getCodeId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysInvitationCode.class.getName()+" a");
           stringBuffer.append(" where a.codeId=:uid ");
           params.put("uid",sysInvitationCodeDto.getCodeId());
           SysInvitationCode sysInvitationCode= new SysInvitationCode();
           BeanUtils.copyProperties(sysInvitationCodeDto, sysInvitationCode);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}