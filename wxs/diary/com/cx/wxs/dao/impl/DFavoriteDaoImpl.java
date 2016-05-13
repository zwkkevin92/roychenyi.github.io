package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DFavoriteDao;
import com.cx.wxs.dto.DFavoriteDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DFavorite;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-16 09:22:44
 */
@Repository("DFavoriteDao")
public class DFavoriteDaoImpl extends BaseDaoImpl<DFavorite, Integer> implements DFavoriteDao{

    private BeanToDto<DFavorite, DFavoriteDto> beanToDto=new BeanToDto<DFavorite, DFavoriteDto>();

    public BeanToDto<DFavorite, DFavoriteDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<DFavorite, DFavoriteDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    /**
    * 通过id获取DFavoriteDto
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public DFavoriteDto getDFavoriteByID(DFavoriteDto dFavoriteDto){
        // TODO Auto-generated method stub
        if(dFavoriteDto!=null&&dFavoriteDto.getDfavoriteId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DFavorite.class.getName()+"  a where a.dfavoriteId=:id");
           params.put("id",dFavoriteDto.getDfavoriteId());
           List<DFavorite> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DFavorite t1= list.get(0);
            DFavoriteDto    dto=new    DFavoriteDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }
    /**
     * @author 陈义
     * @date 2016-04-19 19:02:44
     */
    @Override
    public DFavoriteDto getDFavorite(DFavoriteDto dFavoriteDto){
    	if(dFavoriteDto!=null){
    		StringBuffer stringBuffer=new StringBuffer();
            Map<String,Object> params=new HashMap<String, Object>();
            stringBuffer.append("from  "+DFavorite.class.getName()+"  a where a.status=1");
            stringBuffer.append(" and a.DDiary.diaryId=:diaryId and a.UUser.userId=:userId");
            params.put("diaryId",dFavoriteDto.getDDiaryDto().getDiaryId());
            params.put("userId",dFavoriteDto.getUUserDto().getUserId());
            List<DFavorite> list=this.find(stringBuffer.toString(), params);
            if(list!=null&&list.size()>0){
            	DFavorite dFavorite=list.get(0);
            	dFavoriteDto=beanToDto.T1ToD1(dFavorite, new DFavoriteDto());
                return dFavoriteDto;
            }
           
    	}
    	return null;
    }

    /**
    * 通过相关数据获取DFavoriteDtoList
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public List<DFavoriteDto> getDFavoriteList(DFavoriteDto dFavoriteDto){
        if(dFavoriteDto!=null&&dFavoriteDto.getUUserDto()!=null){
        	StringBuffer stringBuffer=new StringBuffer();
            Map<String,Object> params=new HashMap<String, Object>();
            stringBuffer.append("from  "+DFavorite.class.getName()+"  a where 1=1");
            stringBuffer.append(" and  a.UUser.userId=:userId");
            params.put("userId", dFavoriteDto.getUUserDto().getUserId());
            if(dFavoriteDto.getStatus()!=null){
            	stringBuffer.append(" and a.status=:status");
            	params.put("status",dFavoriteDto.getStatus());
            }else{
            	stringBuffer.append(" and a.status=1");
            }
            List<DFavorite> list=new ArrayList<DFavorite>();
            List<DFavoriteDto> list1=new ArrayList<DFavoriteDto>();
            if(dFavoriteDto.getPage()!=null){
            	this.find(stringBuffer.toString(), params, dFavoriteDto.getPage(), dFavoriteDto.getRows());
            }else{
            	this.find(stringBuffer.toString(), params,1,10);
            }          		
            if(list!=null&&list.size()>0){
            	for(int i=0;i<list.size();i++){
            	DFavorite dFavorite=list.get(i);
            	DFavoriteDto dto=beanToDto.T1ToD1(dFavorite, new DFavoriteDto());
            	if(dFavoriteDto.getPage()!=null){
            		dto.setPage(dFavoriteDto.getPage());
            		dto.setRow((dFavoriteDto.getPage()-1)*dFavoriteDto.getRow()+i+1);
            	}else{
            		dto.setPage(1);
            		dto.setRow(i+1);
            	}
            	list1.add(dto);            
            	}
             return list1;   
            }
            
        }
    	return null;
    }

    /**
    * 添加一个新的DFavorite到数据库
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer addDFavorite(DFavoriteDto dFavoriteDto){
         // TODO Auto-generated method stub
        if(dFavoriteDto!=null){
           DFavorite dFavorite= new DFavorite();
           dFavorite=beanToDto.D1ToT1(dFavorite, dFavoriteDto);
           return this.save(dFavorite);
        }
        return 0;
    }

    /**
    * 更新DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer updateDFavorite(DFavoriteDto dFavoriteDto){
        // TODO Auto-generated method stub
        if(dFavoriteDto!=null&&dFavoriteDto.getDfavoriteId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dFavoriteDto.createSetPropertiesVal(dFavoriteDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+DFavorite.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.dfavoriteId=:uid");
           params.put("uid",dFavoriteDto.getDfavoriteId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DFavorite
    * @author 陈义
    * @date 2016-04-16 09:22:44
    */
    @Override
    public Integer deleteDFavorite(DFavoriteDto dFavoriteDto){
         // TODO Auto-generated method stub
        if(dFavoriteDto!=null&&dFavoriteDto.getUid()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+DFavorite.class.getName()+" a");
           stringBuffer.append(" where a.dfavoriteId=:uid ");
           params.put("uid",dFavoriteDto.getDfavoriteId());
           DFavorite dFavorite= new DFavorite();
           BeanUtils.copyProperties(dFavoriteDto, dFavorite);
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }
    @Override
    public Integer getDFavoriteCount(DFavoriteDto dFavoriteDto){
    	if(dFavoriteDto!=null&&dFavoriteDto.getDDiaryDto()!=null){
    		StringBuffer stringBuffer=new StringBuffer(DbType.SELECT+" count(*) ");
			Map<String,Object> params=new HashMap<String, Object>();
			stringBuffer.append(" from "+DFavorite.class.getName()+" a where 1=1");
			stringBuffer.append(" and a.DDiary.diaryId=:diaryId");
			params.put("diaryId", dFavoriteDto.getDDiaryDto().getDiaryId());
			if(dFavoriteDto.getStatus()!=null){
				stringBuffer.append(" and a.status=:status");
				params.put("status",dFavoriteDto.getStatus());
			}else{
				stringBuffer.append(" and a.status=1");
			}
			return this.count(stringBuffer.toString(), params);
    	}
    	return 0;
    }

}