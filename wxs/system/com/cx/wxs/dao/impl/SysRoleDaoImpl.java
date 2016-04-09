package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.SysRoleDao;
import com.cx.wxs.dto.SysRoleDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.SysRole;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("SysRoleDao")
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole, Integer> implements SysRoleDao{

    private BeanToDto<SysRole, SysRoleDto> beanToDto=new BeanToDto<SysRole, SysRoleDto>();

    public BeanToDto<SysRole, SysRoleDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<SysRole, SysRoleDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取SysRoleDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public SysRoleDto getSysRoleByID(SysRoleDto sysRoleDto){
        // TODO Auto-generated method stub
        if(sysRoleDto!=null&&sysRoleDto.getRoleId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+SysRole.class.getName()+"  a where a.roleId=:id");
           params.put("id",sysRoleDto.getRoleId());
           List<SysRole> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            SysRole t1= list.get(0);
            SysRoleDto    dto=new    SysRoleDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取SysRoleDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<SysRoleDto> getSysRoleList(SysRoleDto sysRoleDto){
        return null;
    }

    /**
    * 添加一个新的SysRole到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addSysRole(SysRoleDto sysRoleDto){
         // TODO Auto-generated method stub
        if(sysRoleDto!=null){
           SysRole sysRole= new SysRole();
           sysRole=beanToDto.D1ToT1(sysRole, sysRoleDto);
           return this.save(sysRole);
        }
        return 0;
    }

    /**
    * 更新SysRole
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateSysRole(SysRoleDto sysRoleDto){
        // TODO Auto-generated method stub
        if(sysRoleDto!=null&&sysRoleDto.getRoleId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = sysRoleDto.createSetPropertiesVal(sysRoleDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+SysRole.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.roleId=:uid");
           params.put("uid",sysRoleDto.getRoleId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除SysRole
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteSysRole(SysRoleDto sysRoleDto){
         // TODO Auto-generated method stub
        if(sysRoleDto!=null&&sysRoleDto.getRoleId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+SysRole.class.getName()+" a");
           stringBuffer.append(" where a.roleId=:uid ");
           params.put("uid",sysRoleDto.getRoleId());
           SysRole sysRole= new SysRole();
           BeanUtils.copyProperties(sysRoleDto, sysRole);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}