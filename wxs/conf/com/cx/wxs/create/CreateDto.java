package com.cx.wxs.create;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.cx.wxs.create.BeanType;
import com.cx.wxs.po.*;
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
    private static final String BLANK_4 ="    ";
    private static final String BLANK_8 =BLANK_4 + BLANK_4;
    
    
    
    //注释部分
    private static final String ANNOTATION_AUTHOR_PARAMTER = "@author ";
    private static final String ANNOTATION_AUTHOR_NAME = "陈义";
    private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
    private static final String ANNOTATION_DATE = "@date ";
    private static final String ANNOTATION = "/**"+RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_DATE +getDate()+RT_1+BLANK_1+"*/"+RT_1;
    private static final String ANNOTATION1="/** default constructor */";
    private static final String ANNOTATION2="/** minimal constructor */";
    private static final String ANNOTATION3="/** full constructor */";
    
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
    private static final String DTO_URL = URL+"dto";
    private static final String DAO_URL = URL+"dao";
    private static final String DAO_IMPL_URL = URL+"dao.impl";
    private static final String SERVICE_URL = URL+"service";
    private static final String SERVICE_IMPL_URL = URL+"service.impl";

    //基本类名称
    private static final String BASE_DAO_NAME = URL + ".base.dao.IBaseDao";
    private static final String BASE_DAO_IMPL_NAME=URL+"base.dao.BaseDaoImpl";
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
		stringBuffer.append("package "+URL+"dto;"+RT_2);
		stringBuffer.append("import "+URL+"base.BeanBase;"+RT_1);
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
	    stringBuffer.append(RT_1+BLANK_4+ANNOTATION3+RT_1+BLANK_4+"public "+getLastChar(c.getName())+"Dto("+Constructors.substring(1)+"){"+constructors1+BLANK_4+"}"+RT_1);
	    stringBuffer.append(method);
		stringBuffer.append(RT_1+"}");
		return stringBuffer.toString();
	}
	
	public void creatBeanDto(Class c,String content,String module) throws IOException{
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
	
	@SuppressWarnings("null")
	public  Map<String,Object> getFields(Class c){
		 Map<String,Object> map=new HashMap<String,Object>();
		 Field[] fields=c.getDeclaredFields();
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

	 
	
	public static void main(String[] avg) throws IOException, ClassNotFoundException{
		CreateDto create=new CreateDto();
		Class c=null;
		//System.out.println(c.getName());
		String module="";
		String popath=System.getProperty("user.dir") + "/src/" + PATH+"/po";
		File file=new File(popath);
		String[] javaname=file.list();
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
					module="syetem";
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

//			Map<String,Object> map= create.getFields(c);
//			String content= create.createDtoFileContent(c, map);
//			create.creatBeanDto(c, content, module);
//			System.out.println(content);
		}
	    c=SysLoginRecord.class;
	    module="system";
		Map<String,Object> map= create.getFields(c);
		String content= create.createDtoFileContent(c, map);
		create.creatBeanDto(c, content, module);
		System.out.println(content);
	}

}
