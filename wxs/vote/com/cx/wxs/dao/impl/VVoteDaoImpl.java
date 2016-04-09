package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.VVoteDao;
import com.cx.wxs.dto.VVoteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.VVote;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("VVoteDao")
public class VVoteDaoImpl extends BaseDaoImpl<VVote, Integer> implements VVoteDao{

    private BeanToDto<VVote, VVoteDto> beanToDto=new BeanToDto<VVote, VVoteDto>();

    public BeanToDto<VVote, VVoteDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<VVote, VVoteDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取VVoteDto
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public VVoteDto getVVoteByID(VVoteDto vVoteDto){
        // TODO Auto-generated method stub
        if(vVoteDto!=null&&vVoteDto.getVoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+VVote.class.getName()+"  a where a.voteId=:id");
           params.put("id",vVoteDto.getVoteId());
           List<VVote> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            VVote t1= list.get(0);
            VVoteDto    dto=new    VVoteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取VVoteDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public List<VVoteDto> getVVoteList(VVoteDto vVoteDto){
        return null;
    }

    /**
    * 添加一个新的VVote到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer addVVote(VVoteDto vVoteDto){
         // TODO Auto-generated method stub
        if(vVoteDto!=null){
           VVote vVote= new VVote();
           vVote=beanToDto.D1ToT1(vVote, vVoteDto);
           return this.save(vVote);
        }
        return 0;
    }

    /**
    * 更新VVote
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer updateVVote(VVoteDto vVoteDto){
        // TODO Auto-generated method stub
        if(vVoteDto!=null&&vVoteDto.getVoteId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = vVoteDto.createSetPropertiesVal(vVoteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" form "+VVote.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.voteId=:uid");
           params.put("uid",vVoteDto.getVoteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除VVote
    * @author 陈义
    * @date 2016-04-09 16:11:19
    */
    @Override
    public Integer deleteVVote(VVoteDto vVoteDto){
         // TODO Auto-generated method stub
        if(vVoteDto!=null&&vVoteDto.getVoteId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+VVote.class.getName()+" a");
           stringBuffer.append(" where a.voteId=:uid ");
           params.put("uid",vVoteDto.getVoteId());
           VVote vVote= new VVote();
           BeanUtils.copyProperties(vVoteDto, vVote);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

}