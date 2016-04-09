package com.cx.wxs.create;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



import com.cx.wxs.base.dao.BaseDaoImpl;
import com.cx.wxs.base.dao.IBaseDao;
import com.cx.wxs.create.BeanType;
import com.cx.wxs.dto.UBookDto;
import com.cx.wxs.dto.UFriendDto;
import com.cx.wxs.enums.DbType;
import com.cx.wxs.po.*;
import com.cx.wxs.service.UBookService;
import com.cx.wxs.utils.BeanToDto;
import com.cx.wxs.utils.StringUtils;



/**
 * @author 陈义
 * @date   2015-12-9 上午11:33:10
 */
public class CreateDto {
	
	//公共部分
    private static final String RT_1 = "\r\n";
    private static final String RT_2 = RT_1+RT_1;
    private static final String BLANK_1 =" ";
    private static final String BLANK_2=BLANK_1+BLANK_1+BLANK_1;
    private static final String BLANK_4 ="    ";
    private static final String BLANK_8 =BLANK_4 + BLANK_4;
    private static final String PACKAGE="package";
    private static final String IMPORT="import";
    
    
    
    //注释部分
    private static final String ANNOTATION_AUTHOR_PARAMTER = "@author ";
    private static final String ANNOTATION_AUTHOR_NAME = "陈义";
    private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
    private static final String ANNOTATION_DATE = "@date ";
    private static final String ANNOTATION = "/**"+RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_DATE +getDate()+RT_1+BLANK_1+"*/"+RT_1;
    private static final String ANNOTATION1="/** default constructor */";
    private static final String ANNOTATION2="/** minimal constructor */";
    private static final String ANNOTATION3="/** full constructor */";
    private static final String OVERRIDE="@Override";
    private static final String AUTOWIRED="@Autowired";
 
    
    //文件 地址
    //private static final String BEAN_PATH = "com/b510/base/bean";
    private static final String PATH="com/cx/wxs";
    private static final String DAO_PATH = PATH+"/dao";
    private static final String DTO_PATH=PATH+"/dto";
    private static final String DAO_IMPL_PATH = PATH+"/dao/impl";
    private static final String SERVICE_PATH = PATH+"/service";
    private static final String SERVICE_IMPL_PATH = PATH+"/service/impl";
    

    
    
    //包名
    private static final String URL="com.cx.wxs.";
    private static final String PO_URL=URL+"po";
    private static final String DTO_URL = URL+"dto";
    private static final String DAO_URL = URL+"dao";
    private static final String DAO_IMPL_URL = URL+"dao.impl";
    private static final String SERVICE_URL = URL+"service";
    private static final String SERVICE_IMPL_URL = URL+"service.impl";

    //基本类名称
    private static final String BASE_BEAN=URL+"base.BeanBase;";
    private static final String BASE_DAO_NAME = URL + "base.dao.IBaseDao;";
    private static final String BASE_DAO_IMPL_NAME=URL+"base.dao.BaseDaoImpl;";
    private static final String ABSTRACT_BASE_DAO_IMPL_NAME = DAO_IMPL_URL + ".AbstractBaseDaoImpl";
    private static final String BASE_SERVICE_NAME = SERVICE_URL + ".BaseService";
    private static final String ABSTRACT_BASE_SERVICE_IMPL_NAME = SERVICE_IMPL_URL + ".AbstractBaseServiceImpl";

    /***
     * 获取当前时间
     * @return
     * @author 陈义
     * @date   2015-12-9下午7:21:19
     */
    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
	/***
	 * 获取.最后的一个字符串
	 * @param str
	 * @return
	 * @author 陈义
	 * @date   2015-12-9下午7:21:38
	 */
    public static String getLastChar(String str) {
        if ((str != null) && (str.length() > 0)) {
            int dot = str.lastIndexOf('.');
            if ((dot > -1) && (dot < (str.length() - 1))) {
                return str.substring(dot + 1);
            }
        }
        return str;
    }
    /***
     * 显示信息
     * @param info
     * @author 陈义
     * @date   2015-12-9下午8:59:22
     */
    public static void showInfo(String info){
        System.out.println("创建文件："+ info+ "成功！");
    }
    
    public static String getAnnotation(String str){
    	return BLANK_4+"/**"+RT_1+BLANK_4+"*"+BLANK_1+str+RT_1+BLANK_4+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_4+"*"+BLANK_1+ANNOTATION_DATE +getDate()+RT_1+BLANK_4+"*/"+RT_1+BLANK_4+OVERRIDE+RT_1;
    }
	/** 
	  * 创建文件 
	  * @param fileName 
	  * @return 
	  */  
	 public static boolean createFile(File fileName,String content)throws Exception{  
	  boolean flag=false;  
	  try{  
	   if(!fileName.exists()){  
	    fileName.createNewFile();  
	    flag=true;  
	   }  
	  }catch(Exception e){  
	   e.printStackTrace();  
	  }  
	  return true;  
	 }   
	 
	public  String createDtoFileContent(Class c,Map map){
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("package "+DTO_URL+";"+RT_2);
		stringBuffer.append("import "+BASE_BEAN+RT_1);
		if(map.get("Timestamp")!=null){
			stringBuffer.append("import java.sql."+map.get("Timestamp")+";"+RT_2);
		}
		for(int i=0;i<map.size();i++){
			if(map.get("Dto"+i)!=null){
				stringBuffer.append("import "+URL+"dto."+map.get("Dto"+i)+";"+RT_1);
			}
		}
		
		stringBuffer.append(ANNOTATION+"public class "+getLastChar(c.getName())+"Dto extends BeanBase{"+RT_1);
	    List<BeanType> beanTypeList=(List<BeanType>) map.get("list");
	    StringBuffer Constructors=new StringBuffer();
	    StringBuffer constructors1=new StringBuffer();
	    constructors1.append("super();"+RT_1);
	    StringBuffer method=new StringBuffer();
	    for(BeanType beanType:beanTypeList){
	    	stringBuffer.append(BLANK_4+"private "+beanType.getType()+BLANK_1+beanType.getName()+";"+RT_1);
	    	Constructors.append(","+beanType.getType()+" "+beanType.getName());
	    	constructors1.append(BLANK_8+"this."+beanType.getName()+"="+beanType.getName()+";"+RT_1);
	    	method.append(BLANK_4+"public"+BLANK_1+beanType.getType()+BLANK_1+"get"+StringUtils.firstUpperCase(beanType.getName())+"(){"
	    			+RT_1+BLANK_8+"return"+BLANK_1+beanType.getName()+";"+RT_1+BLANK_4+"}"+RT_1
	    			+BLANK_4+"public"+BLANK_1+"void set"+StringUtils.firstUpperCase(beanType.getName())+"("+beanType.getType()+BLANK_1+beanType.getName()+"){"
	    			+RT_1+BLANK_8+"this."+beanType.getName()+"="+beanType.getName()+";"+RT_1+BLANK_4+"}"+RT_2);	   
	    }
	    stringBuffer.append(RT_1+BLANK_4+ANNOTATION1+RT_1+BLANK_4+"public "+getLastChar(c.getName())+"Dto(){"+RT_2+BLANK_4+"}"+RT_1);
	    stringBuffer.append(RT_1+BLANK_4+ANNOTATION3+RT_1+BLANK_4+"public "+getLastChar(c.getName())+"Dto("+Constructors.substring(1)+"){"+constructors1+BLANK_4+"}"+RT_2);
	    stringBuffer.append(method);
		stringBuffer.append(RT_1+"}");
		return stringBuffer.toString();
	}
	
	public String createDaoFileContent(Class c){
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("package"+BLANK_1+DAO_URL+";"+RT_2);
		stringBuffer.append("import"+BLANK_1+"java.util.List;"+RT_2);
		stringBuffer.append("import"+BLANK_1+DTO_URL+"."+getLastChar(c.getName())+"Dto;"+RT_1);
		stringBuffer.append("import"+BLANK_1+URL+"po."+getLastChar(c.getName())+";"+RT_1);
		stringBuffer.append("import"+BLANK_1+BASE_DAO_NAME+RT_2);
		stringBuffer.append(ANNOTATION+"public interface "+getLastChar(c.getName())+"Dao extends IBaseDao<"+getLastChar(c.getName())+",Integer>{"+RT_1);
		stringBuffer.append(getAnnotation("通过id获取"+getLastChar(c.getName())+"Dto")+BLANK_4+"public"+BLANK_1+getLastChar(c.getName())+"Dto"+BLANK_1+"get"+getLastChar(c.getName())+"ByID("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+");"+RT_2);
		stringBuffer.append(getAnnotation("通过相关数据获取"+getLastChar(c.getName())+"DtoList")+BLANK_4+"public"+BLANK_1+"List<"+getLastChar(c.getName())+"Dto>"+BLANK_1+"get"+getLastChar(c.getName())+"List("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+");"+RT_2);
		stringBuffer.append(getAnnotation("添加一个新的"+getLastChar(c.getName())+"到数据库")+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"add"+getLastChar(c.getName())+"("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+");"+RT_2);
		stringBuffer.append(getAnnotation("更新"+getLastChar(c.getName()))+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"update"+getLastChar(c.getName())+"("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+");"+RT_2);
		stringBuffer.append(getAnnotation("删除"+getLastChar(c.getName()))+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"delete"+getLastChar(c.getName())+"("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+");"+RT_2);
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	/***
	 * 获取DaoImpl文件内容
	 * @param c
	 * @param content
	 * @param module
	 * @throws IOException
	 * @author 陈义
	 * @date   2015-12-10上午10:12:46
	 */
	public String createDaoImplFileContent(Class c,Map map){
		String className=getLastChar(c.getName());
		String lowerName=StringUtils.firstLowerCase(className);
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(PACKAGE+BLANK_1+DAO_IMPL_URL+";"+RT_2);
		
		stringBuffer.append(IMPORT+BLANK_1+"java.sql.Timestamp;"+RT_1+IMPORT+BLANK_1+"java.util.*;"+RT_2+IMPORT+BLANK_1+"org.springframework.beans.BeanUtils;"+RT_1+IMPORT+BLANK_1+"org.springframework.stereotype.Repository;"+RT_2);
		stringBuffer.append(IMPORT+BLANK_1+BASE_DAO_IMPL_NAME+RT_1+IMPORT+BLANK_1+DAO_URL+"."+className+"Dao;"+RT_1+IMPORT+BLANK_1+DTO_URL+"."+className+"Dto;"+RT_1+IMPORT+BLANK_1+"com.cx.wxs.enums.DbType;"+RT_1+IMPORT+BLANK_1+PO_URL+"."+getLastChar(c.getName())+";"+RT_1+IMPORT+BLANK_1+"com.cx.wxs.utils.StringUtils;"+RT_2);
		stringBuffer.append(IMPORT+BLANK_1+"com.cx.wxs.utils.BeanToDto;"+RT_2);
		stringBuffer.append(ANNOTATION+"@Repository(\""+className+"Dao\")"+RT_1+"public class"+BLANK_1+className+"DaoImpl"+BLANK_1+"extends BaseDaoImpl<"+className+", Integer> implements"+BLANK_1+className+"Dao{"+RT_2);
		stringBuffer.append(BLANK_4+"private BeanToDto<"+className+", "+className+"Dto> beanToDto=new BeanToDto<"+className+", "+className+"Dto>();"+RT_2);
		stringBuffer.append(BLANK_4+"public BeanToDto<"+className+", "+className+"Dto> getBeanToDto(){"+RT_1+BLANK_8+"return beanToDto;"+RT_1+BLANK_4+"}"+RT_1);
		stringBuffer.append(RT_1+BLANK_4+"public void setBeanToDto(BeanToDto<"+className+", "+className+"Dto> beanToDto) {"+RT_1+BLANK_8+"this.beanToDto = beanToDto;"+RT_1+BLANK_4+"}"+RT_1);
		
		stringBuffer.append(getAnnotation("通过id获取"+className+"Dto")+BLANK_4+"public"+BLANK_1+className+"Dto"+BLANK_1+"get"+className+"ByID("+className+"Dto"+BLANK_1+lowerName+"Dto"+"){"+RT_1);
		
		stringBuffer.append(BLANK_8+"// TODO Auto-generated method stub"+RT_1+BLANK_8+"if("+lowerName+"Dto!=null&&"+lowerName+"Dto.get"+StringUtils.firstUpperCase((String)map.get("id"))+"()!=null"+"){"+RT_1); 
		stringBuffer.append(BLANK_8+BLANK_2+"StringBuffer stringBuffer=new StringBuffer();"+RT_1+BLANK_8+BLANK_2+"Map<String,Object> params=new HashMap<String, Object>();"+RT_1+BLANK_8+BLANK_2+"stringBuffer.append(\"from  \"+"+className+".class.getName()+\"  a where a."+map.get("id")+"=:id\");"+RT_1);
		stringBuffer.append(BLANK_8+BLANK_2+"params.put(\"id\","+lowerName+"Dto"+".get"+StringUtils.firstUpperCase((String)map.get("id"))+"());"+RT_1+BLANK_8+BLANK_2+"List<"+className+"> list=this.find(stringBuffer.toString(), params);"+RT_1+BLANK_8+BLANK_2+
				"if(list!=null&&list.size()>0){"+RT_1+BLANK_8+BLANK_4+className+" t1= list.get(0);"+RT_1+BLANK_8+BLANK_4+className+"Dto"+BLANK_4+"dto"+"=new"+BLANK_4+className+"Dto();"+RT_1+BLANK_8+BLANK_4+"dto=beanToDto.T1ToD1(t1,dto);"+RT_1+BLANK_8+BLANK_4+"return dto;"+RT_1+BLANK_8+BLANK_2+" }"+RT_1+BLANK_8+"}"+RT_1);
		stringBuffer.append(BLANK_8+"return null;"+RT_1+BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("通过相关数据获取"+getLastChar(c.getName())+"DtoList")+BLANK_4+"public"+BLANK_1+"List<"+className+"Dto>"+BLANK_1+"get"+className+"List("+className+"Dto"+BLANK_1+lowerName+"Dto){"+RT_1);
		
		stringBuffer.append(BLANK_8+"return null;"+RT_1+BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("添加一个新的"+getLastChar(c.getName())+"到数据库")+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"add"+className+"("+className+"Dto"+BLANK_1+lowerName+"Dto){"+RT_1);
		
		stringBuffer.append(BLANK_1+BLANK_8+"// TODO Auto-generated method stub"+RT_1+BLANK_8+"if("+lowerName+"Dto!=null){"+RT_1
				+BLANK_8+BLANK_2+className+	BLANK_1+lowerName+"= new "+className+"();"+RT_1+BLANK_8+BLANK_2+lowerName+"=beanToDto.D1ToT1("+lowerName+", "+lowerName+"Dto);"+RT_1
				+BLANK_8+BLANK_2+"return this.save("+lowerName+");"+RT_1+BLANK_8+"}"+RT_1);	
		stringBuffer.append(BLANK_8+"return 0;"+RT_1+BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("更新"+getLastChar(c.getName()))+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"update"+getLastChar(c.getName())+"("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+"){"+RT_1);

		stringBuffer.append(BLANK_8+"// TODO Auto-generated method stub"+RT_1+BLANK_8+"if("+lowerName+"Dto!=null&&"+lowerName+"Dto.get"+StringUtils.firstUpperCase((String)map.get("id"))+"()!=null){"+RT_1
				+BLANK_8+BLANK_2+"StringBuffer stringBuffer =new StringBuffer(DbType.UPDATE.toString());"+RT_1+BLANK_8+BLANK_2+"String[] fl = new String[]{\"uid\"};//过滤掉的字段"+RT_1
				+BLANK_8+BLANK_2+"Map<String, Object> map = "+lowerName+"Dto.createSetPropertiesVal("+lowerName+"Dto, \"a\", fl);"+RT_1+BLANK_8+BLANK_2+"Map<String, Object> params = (Map<String, Object>) map.get(StringUtils.PARAMS);"+RT_1
				+BLANK_8+BLANK_2+"stringBuffer.append(\" from \"+"+className+".class.getName()+\" a\");"+RT_1+BLANK_8+BLANK_2+"stringBuffer.append(map.get(StringUtils.SET_HQL));"+RT_1
				+BLANK_8+BLANK_2+"stringBuffer.append(\" where a."+map.get("id")+"=:uid\");"+RT_1+BLANK_8+BLANK_2+"params.put(\"uid\","+lowerName+"Dto.get"+StringUtils.firstUpperCase((String)map.get("id"))+"());"+RT_1+BLANK_8+BLANK_2+"return this.executeHql(stringBuffer.toString(),params);"+RT_1+BLANK_8+"}"+RT_1
				);		
		stringBuffer.append(BLANK_8+"return 0;"+RT_1+BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("删除"+getLastChar(c.getName()))+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"delete"+getLastChar(c.getName())+"("+getLastChar(c.getName())+"Dto"+BLANK_1+StringUtils.firstLowerCase(getLastChar(c.getName())+"Dto")+"){"+RT_1);		

	   stringBuffer.append(BLANK_1+BLANK_8+"// TODO Auto-generated method stub"+RT_1+BLANK_8+"if("+lowerName+"Dto!=null&&"+lowerName+"Dto.get"+StringUtils.firstUpperCase((String)map.get("id"))+"()!=null){"+RT_1
			           +BLANK_8+BLANK_2+"StringBuffer stringBuffer=new StringBuffer(DbType.DELETE.toString());"+RT_1+BLANK_8+BLANK_2+"Map<String,Object> params=new HashMap<String,Object>();"+RT_1
			           +BLANK_8+BLANK_2+"stringBuffer.append(\"  \"+"+className+".class.getName()+\" a\");"+RT_1+BLANK_8+BLANK_2+"stringBuffer.append(\" where a."+map.get("id")+"=:uid \");"+RT_1
					   +BLANK_8+BLANK_2+"params.put(\"uid\","+lowerName+"Dto.get"+StringUtils.firstUpperCase((String)map.get("id"))+"());"+RT_1
			      //     +BLANK_8+BLANK_2+className+BLANK_1+lowerName+"= new "+className+"();"+RT_1+BLANK_8+BLANK_2+"BeanUtils.copyProperties("+lowerName+"Dto, "+lowerName+");"+RT_1
						+BLANK_8+BLANK_2+"return this.executeHql(stringBuffer.toString(),params);"+RT_1+BLANK_8+"}"+RT_1);		
		stringBuffer.append(BLANK_8+"return 0;"+RT_1+BLANK_4+"}"+RT_2);
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	/***
	 * 常见service的内容
	 * @param c
	 * @return
	 * @author 陈义
	 * @date   2015-12-11下午5:08:32
	 */
	public String createServiceFileContent(Class c){
		String className=getLastChar(c.getName());
		String dtoName=className+"Dto";
		String lowerName=StringUtils.firstLowerCase(className);
		String lowerDtoName=lowerName+"Dto";
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(PACKAGE+BLANK_1+SERVICE_URL+";"+RT_2);
		stringBuffer.append(IMPORT+BLANK_1+"java.util.List;"+RT_2);
		stringBuffer.append(IMPORT+BLANK_1+DTO_URL+"."+dtoName+";"+RT_2);
		stringBuffer.append(ANNOTATION+RT_1+"public interface"+BLANK_1+className+"Service"+BLANK_1+"{"+RT_1);
		stringBuffer.append(getAnnotation("通过用户id获取"+dtoName+"信息")+BLANK_4+"public"+BLANK_1+dtoName+BLANK_1+"get"+className+"ByID("+dtoName+BLANK_1+lowerDtoName+");"+RT_2);
		stringBuffer.append(getAnnotation("通过相关信息获取"+dtoName+"List信息")+BLANK_4+"public"+BLANK_1+"List<"+dtoName+">"+BLANK_1+"get"+className+"List("+dtoName+BLANK_1+lowerDtoName+");"+RT_2);
		stringBuffer.append(getAnnotation("添加一个新的"+className+"到数据库")+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"add"+className+"("+dtoName+BLANK_1+lowerDtoName+");"+RT_2);
		stringBuffer.append(getAnnotation("更新"+className)+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"update"+className+"("+dtoName+BLANK_1+lowerDtoName+");"+RT_2);
		stringBuffer.append(getAnnotation("删除"+className)+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"delete"+className+"("+dtoName+BLANK_1+lowerDtoName+");"+RT_2);
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	/***
	 * 创建serviceImpl的文件内容
	 * @param c
	 * @param content
	 * @param map
	 * @return
	 * @author 陈义
	 * @date   2015-12-11下午5:27:49
	 */
	public String createServiceImplContent(Class c,String content,Map map){
		String className=getLastChar(c.getName());
		String dtoName=className+"Dto";
		String lowerName=StringUtils.firstLowerCase(className);
		String lowerDtoName=lowerName+"Dto";
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(PACKAGE+BLANK_1+SERVICE_IMPL_URL+";"+RT_2);
		stringBuffer.append(IMPORT+BLANK_1+"java.util.*;"+RT_2);
		stringBuffer.append("import org.springframework.beans.factory.annotation.Autowired;"+RT_1);
		stringBuffer.append("import org.springframework.stereotype.Service;"+RT_2);
		stringBuffer.append(IMPORT+BLANK_1+DAO_URL+"."+className+"Dao;"+RT_1);
		stringBuffer.append(IMPORT+BLANK_1+DTO_URL+"."+dtoName+";"+RT_1);
		stringBuffer.append(IMPORT+BLANK_1+SERVICE_URL+"."+className+"Service;"+RT_2);
		stringBuffer.append(ANNOTATION+RT_1+"@Service(\""+className+"Service\")"+RT_1+"public class"+BLANK_1+className+"ServiceImpl"+BLANK_1+"implements "+className+"Service {"+RT_1);
		stringBuffer.append(BLANK_4+AUTOWIRED+RT_1+BLANK_4+"private "+className+"Dao "+lowerName+"Dao;"+RT_2);
		stringBuffer.append(BLANK_4+"public void set"+className+"Dao("+className+"Dao"+BLANK_1+lowerName+"Dao){"+RT_1);
		stringBuffer.append(BLANK_8+"this."+lowerName+"Dao="+lowerName+"Dao;"+RT_1+BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("通过用户id获取"+dtoName+"信息")+BLANK_4+"public"+BLANK_1+dtoName+BLANK_1+"get"+className+"ByID("+dtoName+BLANK_1+lowerDtoName+"){"+RT_1);
		stringBuffer.append(BLANK_8+"return"+BLANK_1+lowerName+"Dao.get"+className+"ByID("+lowerDtoName+");"+RT_1);
		stringBuffer.append(BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("通过相关信息获取"+dtoName+"List信息")+BLANK_4+"public"+BLANK_1+"List<"+dtoName+">"+BLANK_1+"get"+className+"List("+dtoName+BLANK_1+lowerDtoName+"){"+RT_1);
		stringBuffer.append(BLANK_8+"return"+BLANK_1+lowerName+"Dao.get"+className+"List("+lowerDtoName+");"+RT_1);
		stringBuffer.append(BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("添加一个新的"+className+"到数据库")+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"add"+className+"("+dtoName+BLANK_1+lowerDtoName+"){"+RT_1);
		stringBuffer.append(BLANK_8+"return"+BLANK_1+lowerName+"Dao.add"+className+"("+lowerDtoName+");"+RT_1);
		stringBuffer.append(BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("更新"+className)+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"update"+className+"("+dtoName+BLANK_1+lowerDtoName+"){"+RT_1);
		stringBuffer.append(BLANK_8+"return"+BLANK_1+lowerName+"Dao.update"+className+"("+lowerDtoName+");"+RT_1);
		stringBuffer.append(BLANK_4+"}"+RT_2);
		stringBuffer.append(getAnnotation("删除"+className)+BLANK_4+"public"+BLANK_1+"Integer"+BLANK_1+"delete"+className+"("+dtoName+BLANK_1+lowerDtoName+"){"+RT_1);
		stringBuffer.append(BLANK_8+"return"+BLANK_1+lowerName+"Dao.delete"+className+"("+lowerDtoName+");"+RT_1);
		stringBuffer.append(BLANK_4+"}"+RT_2);
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	/***
	 * 创建Dto文件
	 * @param c
	 * @param content
	 * @param module
	 * @throws IOException
	 * @author 陈义
	 * @date   2015-12-10上午11:10:51
	 */
	public void createBeanDto(Class c,String content,String module) throws IOException{
		 String cName = c.getName();
	        String fileName = System.getProperty("user.dir") + "/"+module+"/" + DTO_PATH
	                + "/" + getLastChar(cName) + "Dto.java";
	        File f = new File(fileName);
	        String folder=System.getProperty("user.dir") + "/"+module+"/" + DTO_PATH;
	        File f1=new File(folder);
	        if(!f1.exists()){
	        	f1.mkdirs();
	        }
	        if(!f.exists()){
	        	f.createNewFile();
	        }
	        FileWriter fw = new FileWriter(f);
	        fw.write(content);
	        fw.flush();
	        fw.close();
	        showInfo(fileName);
	}
	/***
	 * 穿件新的Dao文件
	 * @param c
	 * @param content
	 * @param module
	 * @author 陈义
	 * @throws IOException 
	 * @date   2015-12-10上午10:13:03
	 */
	public void createBeanDao(Class c,String content,String module) throws IOException{
		String cName = c.getName();
        String fileName = System.getProperty("user.dir") + "/"+module+"/" + DAO_PATH
                + "/" + getLastChar(cName) + "Dao.java";
        File f = new File(fileName);
        String folder=System.getProperty("user.dir") + "/"+module+"/" + DAO_PATH;
        File f1=new File(folder);
        if(!f1.exists()){
        	f1.mkdirs();
        }
        if(!f.exists()){
        	f.createNewFile();
        }
        FileWriter fw = new FileWriter(f);
        fw.write(content);
        fw.flush();
        fw.close();
        showInfo(fileName);
	}
	/***
	 * 创建DaoImpl文件
	 * @param c
	 * @param content
	 * @param module
	 * @throws IOException
	 * @author 陈义
	 * @date   2015-12-11下午4:37:47
	 */
	public void createBeanDaoImp(Class c,String content,String module) throws IOException{
		String cName = c.getName();
        String fileName = System.getProperty("user.dir") + "/"+module+"/" + DAO_IMPL_PATH
                + "/" + getLastChar(cName) + "DaoImpl.java";
        File f = new File(fileName);
        String folder=System.getProperty("user.dir") + "/"+module+"/" + DAO_IMPL_PATH;
        File f1=new File(folder);
        if(!f1.exists()){
        	f1.mkdirs();
        }
        if(!f.exists()){
        	f.createNewFile();
        }
        FileWriter fw = new FileWriter(f);
        fw.write(content);
        fw.flush();
        fw.close();
        showInfo(fileName);
	}

	/***
	 * 创建Service
	 * @param c
	 * @param content
	 * @param module
	 * @throws IOException
	 * @author 陈义
	 * @date   2015-12-11下午5:09:08
	 */
	public void createService(Class c,String content,String module) throws IOException{
		String cName = c.getName();
        String fileName = System.getProperty("user.dir") + "/"+module+"/" + SERVICE_PATH
                + "/" + getLastChar(cName) + "Service.java";
        File f = new File(fileName);
        String folder=System.getProperty("user.dir") + "/"+module+"/" + SERVICE_PATH;
        File f1=new File(folder);
        if(!f1.exists()){
        	f1.mkdirs();
        }
        if(!f.exists()){
        	f.createNewFile();
        }
        FileWriter fw = new FileWriter(f);
        fw.write(content);
        fw.flush();
        fw.close();
        showInfo(fileName);
	}
	/***
	 * 创建ServiceImpl的文件
	 * @param c
	 * @param content
	 * @param module
	 * @throws IOException
	 * @author 陈义
	 * @date   2015-12-13下午6:17:17
	 */
	public void createServiceImpl(Class c,String content,String module) throws IOException{
		String cName = c.getName();
        String fileName = System.getProperty("user.dir") + "/"+module+"/" + SERVICE_IMPL_PATH
                + "/" + getLastChar(cName) + "ServiceImpl.java";
        File f = new File(fileName);
        String folder=System.getProperty("user.dir") + "/"+module+"/" + SERVICE_IMPL_PATH;
        File f1=new File(folder);
        if(!f1.exists()){
        	f1.mkdirs();
        }
        if(!f.exists()){
        	f.createNewFile();
        }
        FileWriter fw = new FileWriter(f);
        fw.write(content);
        fw.flush();
        fw.close();
        showInfo(fileName);
	}
	@SuppressWarnings("null")
	public  Map<String,Object> getFields(Class c){
		 Map<String,Object> map=new HashMap<String,Object>();
		 Field[] fields=c.getDeclaredFields();
		 map.put("id",fields[0].getName());
		 List<BeanType> DtoList=new ArrayList<BeanType>();
		 int m=0;
		 for(Field field:fields){
		//	 System.out.println(field.getGenericType()+":"+field.getName());
			 BeanType dto=new BeanType();
			 if(field.getGenericType().toString().contains("class com.cx.wxs.po.")){
				 dto.setName(field.getName()+"Dto");
			 }else{
			 dto.setName(field.getName());
			 }
		//	 map.put(field.getGenericType().toString(),field.getName());
			 switch(field.getGenericType().toString()){
			 case "class java.lang.String":dto.setType("String"); break;
			 case "class java.lang.Long":dto.setType("Long");break;
			 case "class java.sql.Timestamp":map.put("Timestamp","Timestamp");dto.setType("Timestamp");break;
			 case "class java.lang.Integer":dto.setType("Integer"); break;
			 case "class java.lang.Short":dto.setType("Short"); break;
			 case "class java.lang.Double":dto.setType("Double"); break;
			 case "class java.lang.Byte":dto.setType("Byte"); break;
			 case "class java.lang.Boolean":dto.setType("Boolean"); break;
			 default:if(field.getGenericType().toString().contains("class com.cx.wxs.po.")){
				 int a=field.getGenericType().toString().indexOf(".po.")+4;
				 map.put("Dto"+m,field.getGenericType().toString().substring(a)+"Dto"); 
				 m++;
				 dto.setType(field.getGenericType().toString().substring(a)+"Dto");
				 }
			 }
			 if(dto.getType()!=null){
			 DtoList.add(dto);
			 }
		 }
//		 System.out.println("----------------------------");
//		 for(BeanType dto1:DtoList){
//			 System.out.println(dto1.getType()+":"+dto1.getName());
//		 }
		 map.put("list",DtoList);
       return map;
	 }

	 public String[] getModule(){
		 String popath=System.getProperty("user.dir") + "/src/" + PATH+"/po";
			File file=new File(popath);
			String[] javaname=file.list();
			
			return javaname;
	 }
	
	 public void createAll() throws ClassNotFoundException, IOException{
		 CreateDto create=new CreateDto();
			Class c=null;
			//System.out.println(c.getName());
			String module="";
			String popath=System.getProperty("user.dir") + "/src/" + PATH+"/po";
			File file=new File(popath);
			String[] javaname=file.list();
			int m=0; //计数生成的po对应的server、serverImp 、dao、daoImp
			for(int i=0;i<javaname.length;i++){
			//	System.out.println(javaname[i]+":"+javaname[i].substring(0,javaname[i].indexOf(".java")));
				String className=URL+"po."+ javaname[i].substring(0,javaname[i].indexOf(".java"));
				String name=javaname[i].substring(0,javaname[i].indexOf(".java"));
				if(name.substring(0,1).equals("B")){
					module="blog";
				}else if(name.substring(0,1).equals("D")){
					module="diary";
				}else if(name.substring(0,1).equals("I")){
					module="image";
				}else if(name.substring(0,1).equals("M")){
					module="message";
				}else if(name.substring(0,1).equals("S")){
					if(name.substring(0,3).equals("Sys")){
						module="system";
					}else{
						module="sound";
					}
				}else if(name.substring(0,1).equals("U")){
					module="user";
				}else if(name.substring(0,1).equals("V")){
					module="vote";
				}else if(name.substring(0,1).equals("W")){
					module="wxs";
				}
				c=Class.forName(className);
				System.out.println(c.getName());
				
	            if(!module.equals("user")){
	            	 Map<String,Object> map= create.getFields(c);
	            	 String content= create.createDtoFileContent(c, map);
	            //	 create.createBeanDto(c, content, module);
	            	 String content1=create.createDaoFileContent(c);
	         //   	 create.createBeanDao(c, content1, module);
	            	 String content2=create.createDaoImplFileContent(c, map);
	            	 create.createBeanDaoImp(c, content2, module);
	            	 String content3=create.createServiceFileContent(c);
	         //   	 create.createService(c, content3, module);
	            	 String content4=create.createServiceImplContent(c, content3, map);
	        //    	 create.createServiceImpl(c, content4, module);
	            	 m++;
	            }
//				System.out.println(content);
			}
			System.out.println("计数:"+m);
		    c=SysLoginRecord.class;
		    module="system";
			Map<String,Object> map= create.getFields(c);
//			String content= create.createDtoFileContent(c, map);
		    String content1=create.createDaoImplFileContent(c, map);
//		    System.out.println(content1);
//			create.creatBeanDto(c, content, module);
//			System.out.println(content);
		    String content3=create.createServiceFileContent(c);
		    System.out.println(content3);
		 
	 }
	public static void main(String[] avg) throws IOException, ClassNotFoundException{
		CreateDto create=new CreateDto();
		create.createAll();
//		String className="com.cx.wxs.po.SysIllegal";
//		Class c=Class.forName(className);
//		System.out.println(c.getName());
//		String module="system";
//        if(!module.equals("user")){
//        	 Map<String,Object> map= create.getFields(c);
//        	 String content= create.createDtoFileContent(c, map);
//        	 create.createBeanDto(c, content, module);
//        	 String content1=create.createDaoFileContent(c);
//        	 create.createBeanDao(c, content1, module);
//        	 String content2=create.createDaoImplFileContent(c, map);
//        	 create.createBeanDaoImp(c, content2, module);
//        	 String content3=create.createServiceFileContent(c);
//        	 create.createService(c, content3, module);
//        	 String content4=create.createServiceImplContent(c, content3, map);
//        	 create.createServiceImpl(c, content4, module);
//       // 	 m++;
//        }
//		System.out.println(content);
	
//	System.out.println("计数:"+m);
//    c=SysLoginRecord.class;
//    module="system";
//	Map<String,Object> map= create.getFields(c);
////	String content= create.createDtoFileContent(c, map);
//    String content1=create.createDaoImplFileContent(c, map);
////    System.out.println(content1);
////	create.creatBeanDto(c, content, module);
////	System.out.println(content);
//    String content3=create.createServiceFileContent(c);
//    System.out.println(content3);
	}

}
