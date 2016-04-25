package com.cx.wxs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.dao.DDiaryDao;
import com.cx.wxs.dto.DCatalogDto;
import com.cx.wxs.dto.DDiaryDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.DDiary;
import com.cx.wxs.utils.StringUtils;

import com.cx.wxs.utils.BeanToDto;

/**
 * @author 陈义
 * @date 2016-04-09 16:11:18
 */
@Repository("DDiaryDao")
public class DDiaryDaoImpl extends BaseDaoImpl<DDiary, Integer> implements DDiaryDao{

    private BeanToDto<DDiary, DDiaryDto> beanToDto=new BeanToDto<DDiary, DDiaryDto>();

    public BeanToDto<DDiary, DDiaryDto> getBeanToDto(){
        return beanToDto;
    }

    public void setBeanToDto(BeanToDto<DDiary, DDiaryDto> beanToDto) {
        this.beanToDto = beanToDto;
    }
    
    public void setDefault(DDiary diary){
    	diary.setReplyCount(0);
    	diary.setViewCount(0);
    	diary.setUpvoteCount(0);
    	diary.setFavoriteCount(0);
    }
    /**
    * 通过id获取DDiaryDto
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public DDiaryDto getDDiaryByID(DDiaryDto dDiaryDto){
        // TODO Auto-generated method stub
        if(dDiaryDto!=null&&dDiaryDto.getDiaryId()!=null){
           StringBuffer stringBuffer=new StringBuffer();
           Map<String,Object> params=new HashMap<String, Object>();
           stringBuffer.append("from  "+DDiary.class.getName()+"  a where a.diaryId=:id and a.role<>-2");
           params.put("id",dDiaryDto.getDiaryId());
           List<DDiary> list=this.find(stringBuffer.toString(), params);
           if(list!=null&&list.size()>0){
            DDiary t1= list.get(0);
            DDiaryDto    dto=new    DDiaryDto();
            dto=beanToDto.T1ToD1(t1,dto);
            return dto;
            }
        }
        return null;
    }

    /**
    * 通过相关数据获取DDiaryDtoList
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public List<DDiaryDto> getDDiaryList(DDiaryDto dDiaryDto){
    	if(dDiaryDto!=null&&dDiaryDto.getUUserDto()!=null){
    		StringBuffer stringBuffer=new StringBuffer();
            Map<String,Object> params=new HashMap<String, Object>();
            stringBuffer.append("from  "+DDiary.class.getName()+" a ");
            stringBuffer.append(" where a.UUser.userId=:userId");
            params.put("userId",dDiaryDto.getUUserDto().getUserId());
            if(dDiaryDto.getRole()!=null){
            	stringBuffer.append(" and a.role =:role");
            	params.put("role",dDiaryDto.getRole());
            }else{
            	stringBuffer.append(" and a.role=1");
            }
            //逆向排序
            stringBuffer.append(" order by a.diaryId desc ");
            List<DDiary> list=new ArrayList<DDiary>();
            List<DDiaryDto> list1=new ArrayList<DDiaryDto>();
            if(dDiaryDto.getRows()!=null&&dDiaryDto.getPage()!=null){
            	list=this.find(stringBuffer.toString(), params, dDiaryDto.getPage(), dDiaryDto.getRows());
            }else{
            	list=this.find(stringBuffer.toString(), params);
            }
            if(list!=null&&list.size()>0){
            	for(DDiary diary:list){
            		DDiaryDto dto=beanToDto.T1ToD1(diary, new DDiaryDto());
            		list1.add(dto);
            	}
            	return list1;
            }
    	}
        return null;
    }

    /**
    * 添加一个新的DDiary到数据库
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer addDDiary(DDiaryDto dDiaryDto){
         // TODO Auto-generated method stub
        if(dDiaryDto!=null){
           DDiary dDiary= new DDiary();
           dDiary=beanToDto.D1ToT1(dDiary, dDiaryDto);
           this.setDefault(dDiary);
           return this.save(dDiary);
        }
        return 0;
    }

    /**
    * 更新DDiary
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer updateDDiary(DDiaryDto dDiaryDto){
        // TODO Auto-generated method stub
        if(dDiaryDto!=null&&dDiaryDto.getDiaryId()!=null){
           StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
           String[] fl = new String[]{"uid"};//过滤掉的字段
           Map<String, Object> map = dDiaryDto.createSetPropertiesVal(dDiaryDto, "a", fl);
           Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);
           stringBuffer.append(" from "+DDiary.class.getName()+" a");
           stringBuffer.append(map.get(StringUtils.SET_HQL));
           stringBuffer.append(" where a.diaryId=:uid");
           params.put("uid",dDiaryDto.getDiaryId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

    /**
    * 删除DDiary
    * @author 陈义
    * @date 2016-04-09 16:11:18
    */
    @Override
    public Integer deleteDDiary(DDiaryDto dDiaryDto){
         // TODO Auto-generated method stub
        if(dDiaryDto!=null&&dDiaryDto.getDiaryId()!=null){
           StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());
           Map<String,Object> params=new HashMap<String,Object>();
           stringBuffer.append(" from "+DDiary.class.getName()+" a");
           stringBuffer.append(" where a.diaryId=:uid ");
           params.put("uid",dDiaryDto.getDiaryId());
           return this.executeHql(stringBuffer.toString(),params);
        }
        return 0;
    }

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.DDiaryDao#diaryMove1(com.cx.wxs.dto.DCatalogDto)
	 */

	@Override
	public Integer diaryMove(DDiaryDto diaryDto,DCatalogDto catalogDto) {
		// TODO Auto-generated method stub
		if(catalogDto.getCatalogId()!=null&&diaryDto.getDCatalogDto()!=null&&diaryDto.getUUserDto()!=null){
			 StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());
	           Map<String, Object> params = new HashMap<String, Object>();
	           stringBuffer.append(" from "+DDiary.class.getName()+" a");
	           //移动后的目录
	           stringBuffer.append(" set a.DCatalog.catalogId=:catalogId1");
	           params.put("catalogId1",catalogDto.getCatalogId());
	           //移动前的目录
	           stringBuffer.append(" where a.DCatalog.catalogId=:catalogId2");
	           params.put("catalogId2",diaryDto.getDCatalogDto().getCatalogId());
	           //日志所属作者
	           stringBuffer.append(" and a.UUser.userId=:userId");
	           params.put("userId",diaryDto.getUUserDto().getUserId());
	           if(diaryDto.getDiaryId()!=null){
	           stringBuffer.append(" and a.diaryId=:uid");
	           params.put("uid",diaryDto.getDiaryId());
	           }
	           return this.executeHql(stringBuffer.toString(),params);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.DDiaryDao#getCurrentDiarys(com.cx.wxs.dto.DDiaryDto)
	 */
	@Override
	public List<DDiaryDto> getCurrentDiarys(DDiaryDto diaryDto) {
		// TODO Auto-generated method stub
		if(diaryDto!=null&&diaryDto.getDiaryId()!=null&&diaryDto.getUUserDto().getUserId()!=null){
		List<DDiaryDto> list=new ArrayList<DDiaryDto>();
		DDiary diary1=new DDiary();
		DDiary diary2=new DDiary();
		DDiary diary3=new DDiary();
		StringBuffer stringBuffer=new StringBuffer(" from "+DDiary.class.getName()+"  a where a.role=1");
		Map<String,Object> params=new HashMap<String, Object>();
        params.put("id",diaryDto.getDiaryId());
        params.put("userId",diaryDto.getUUserDto().getUserId());
        String hql0=stringBuffer.toString()+" and a.diaryId=:id and a.UUser.userId=:userId";
        diary1=this.get(hql0,params);
		String hql1=stringBuffer.toString()+" and a.diaryId<:id and a.UUser.userId=:userId order by diaryId desc ";
		diary2=this.get(hql1, params);
		String hql2=stringBuffer.toString()+" and a.diaryId>:id and a.UUser.userId=:userId  ";
		diary3=this.get(hql2,params);
		if(diary1!=null){
		list.add(beanToDto.T1ToD1(diary1, new DDiaryDto()));
		}else{
		    list.add(new DDiaryDto());
		}
		if(diary2!=null){
		list.add(beanToDto.T1ToD1(diary2, new DDiaryDto()));
		}else{
			list.add(new DDiaryDto());
		}
		if(diary3!=null){
		list.add(beanToDto.T1ToD1(diary3, new DDiaryDto()));
		}else{
			list.add(new DDiaryDto());
		}
		return list;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.dao.DDiaryDao#getDiaryCount(com.cx.wxs.dto.DDiaryDto)
	 */
	@Override
	public Integer getDiaryCount(DDiaryDto dDiaryDto) {
		// TODO Auto-generated method stub
		if(dDiaryDto!=null&&dDiaryDto.getUUserDto()!=null){
			StringBuffer stringBuffer=new StringBuffer(DbType.SELECT+" count(*) ");
			Map<String,Object> params=new HashMap<String, Object>();
			stringBuffer.append(" from "+DDiary.class.getName()+" a where 1=1 ");
			stringBuffer.append(" and a.UUser.userId=:userId");
			params.put("userId",dDiaryDto.getUUserDto().getUserId());
			if(dDiaryDto.getDCatalogDto()!=null){
			stringBuffer.append(" and a.DCatalog.catalogId=:catalogId");
			params.put("catalogId",dDiaryDto.getDCatalogDto().getCatalogId());
			}
			if(dDiaryDto.getRole()!=null){
				stringBuffer.append(" and a.role=:role");
				params.put("role",dDiaryDto.getRole());
			}else{
				stringBuffer.append(" and a.role=1");
			}
			return this.count(stringBuffer.toString(), params);
		}
		return 0;
	}

}