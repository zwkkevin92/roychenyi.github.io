package com.cx.wxs.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;

import com.cx.wxs.utils.GenericsUtils;
import com.cx.wxs.utils.StringUtils;



/**
 * @author 陈义
 * @date   2015-12-3 下午3:29:50
 */
public  class BeanBase implements Serializable{

	public final static int STATUS_NORMAL  = 0;     //
	public final static int STATUS_DELETED = 2;     //删除状态
	
	public final static int STATUS_ONLINE  = 1;     //在线
	public final static int STATUS_OFFLINE = 0;     //不在线
	
	public final static int TYPE_DIARY 	 = 0x01;    //日志
	public final static int TYPE_PHOTO   = 0x02;    //图片
	public final static int TYPE_MMEDIA	 = 0x03;	//多媒体(音频/视频/动画)
	public final static int TYPE_BBS	 = 0x04;    //论坛

	public final static int INFO_TYPE_GENERAL 	= 0x00;	//普通信息
	public final static int INFO_TYPE_ELITE 	= 0x01;	//精华信息
	public final static int INFO_TYPE_TOP 		= 0x10;	//置顶信息
	public final static int INFO_TYPE_TOP_ELITE = 0x11;	//置顶且是精华信息

	public final static int CLIENT_HTML = 0;            //PC端
	public final static int CLIENT_WML = 1;             //手机端

   private Integer page;  //当前页面
   private Integer rows;  //行数
   private String sort; //排序字段
   private String dir;   //排序方向
   private String group;//分组字段
   private String order;   //排序方向
   private Integer pageCount; //页数
   private String batch;//批量删除的参数，格式：1,2,3,...
   private String field;//查询字段
   private String ip;//当前请求终端操作的IP
   private String local;//当前请求终端的IP归属地
   private String msg="";//内部返回的消息
   private Boolean isSucceed=false;//内部返回的操作是否成功标识
   private Object object;//返回的数据
   private Integer uid;//用户uid
   private Boolean isUsers=false;//是否查询用户信息
   private Boolean isFortyLogin=false;
   private String url;  //获取前一个页面的URL

	//**************验证信息参数******************/

	private String validateNum;
	private String validateCode;
	private String validateMark;
	private String validateType;

	private BigDecimal ROWNUM_;//此字段是在使用createsqlquery并且结合了Transformers.aliasToBean 自动封装功能的时候使用
	private String search;//搜索关键词或者搜索条件

	
	

	public BeanBase() {
		super();
	}

	public BeanBase(Integer page, Integer rows, String sort, String dir,
			String group, Integer pageCount) {
		super();
		this.page = page;
		this.rows = rows;
		this.sort = sort;
		this.dir = dir;
		this.group = group;
		this.pageCount = pageCount;

	}

	
	
	
	public BeanBase(Integer page, Integer rows, String sort, String dir,
			String group, String order, Integer pageCount, String batch,
			String field, String ip, String local, String msg,
			Boolean isSucceed, Object object, Integer uid, Boolean isUsers,
			Boolean isFortyLogin, String validateNum, String validateCode,
			String validateMark, String validateType, BigDecimal rOWNUM_,
			String search) {
		super();
		this.page = page;
		this.rows = rows;
		this.sort = sort;
		this.dir = dir;
		this.group = group;
		this.order = order;
		this.pageCount = pageCount;
		this.batch = batch;
		this.field = field;
		this.ip = ip;
		this.local = local;
		this.msg = msg;
		this.isSucceed = isSucceed;
		this.object = object;
		this.uid = uid;
		this.isUsers = isUsers;
		this.isFortyLogin = isFortyLogin;
		this.validateNum = validateNum;
		this.validateCode = validateCode;
		this.validateMark = validateMark;
		this.validateType = validateType;
		ROWNUM_ = rOWNUM_;
		this.search = search;
	}
	
	

	/**
	 * full 构造器
	 * @author 陈义
	 * @date   2016-1-7下午4:38:39
	 */
	public BeanBase(Integer page, Integer rows, String sort, String dir,
			String group, String order, Integer pageCount, String batch,
			String field, String ip, String local, String msg,
			Boolean isSucceed, Object object, Integer uid, Boolean isUsers,
			Boolean isFortyLogin, String url, String validateNum,
			String validateCode, String validateMark, String validateType,
			BigDecimal rOWNUM_, String search) {
		super();
		this.page = page;
		this.rows = rows;
		this.sort = sort;
		this.dir = dir;
		this.group = group;
		this.order = order;
		this.pageCount = pageCount;
		this.batch = batch;
		this.field = field;
		this.ip = ip;
		this.local = local;
		this.msg = msg;
		this.isSucceed = isSucceed;
		this.object = object;
		this.uid = uid;
		this.isUsers = isUsers;
		this.isFortyLogin = isFortyLogin;
		this.url = url;
		this.validateNum = validateNum;
		this.validateCode = validateCode;
		this.validateMark = validateMark;
		this.validateType = validateType;
		ROWNUM_ = rOWNUM_;
		this.search = search;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCont(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getIsSucceed() {
		return isSucceed;
	}

	public void setIsSucceed(Boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Boolean getIsUsers() {
		return isUsers;
	}

	public void setIsUsers(Boolean isUsers) {
		this.isUsers = isUsers;
	}

	public Boolean getIsFortyLogin() {
		return isFortyLogin;
	}

	public void setIsFortyLogin(Boolean isFortyLogin) {
		this.isFortyLogin = isFortyLogin;
	}

	public String getValidateNum() {
		return validateNum;
	}

	public void setValidateNum(String validateNum) {
		this.validateNum = validateNum;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getValidateMark() {
		return validateMark;
	}

	public void setValidateMark(String validateMark) {
		this.validateMark = validateMark;
	}

	public String getValidateType() {
		return validateType;
	}

	public void setValidateType(String validateType) {
		this.validateType = validateType;
	}

	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}

	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 根据当前传入的field（以,号格式隔开）的字符串，转换为字符串数组
	 * @param ignore 忽略的“实体类”属性，其余“实体类”属性都查询
	 * @return

	 * @date 2015-2-4 上午9:25:53
	 */
	public String[] toPorpertiesStringArray(String... ignore){
		boolean isIgnore = false;
		String propertys = "";
		if(StringUtils.isNotEmpty(this.field)){//查询属性不为空的情况下
			//去掉重复属性字段
			String[] fields = StringUtils.uniqStringArray(this.field.split(","));
			for (int i = 0; i < fields.length; i++) {
				String f = fields[i];
				isIgnore = false;
				if(ignore!=null&&ignore.length>0){
					for (int j = 0; j < ignore.length; j++) {
						String ig = ignore[j];
						if(f.equals(ig)){//找到被忽略的属性
							isIgnore = true;
							break;
						}
					}
				}
				if(!isIgnore)propertys += f+",";
			}
		}else{
			//为空，表示查询全部属性，但可以忽略某些属性
			Map<String, Object> map = getPropertiesValue(this,true);
			if(map!=null&&map.size()>0){
				for (String key : map.keySet()) {
					isIgnore = false;
					if(ignore!=null&&ignore.length>0){
						for (String ig : ignore) {
							if(key.equals(ig)){
								isIgnore = true;
								break;
							}
						}
					}
					if(!isIgnore){
						if(key.indexOf("Dto")==-1){
							propertys += key+",";
						}
					}
				}
			}
		}
		propertys = propertys.substring(0, propertys.length()-1);
		return propertys.split("[,]");
	}
	/**
	 * 获取 Class中的属性值不为空（null）等属性的列表，并以键值形式返回
	 * @param filter 需要过滤的属性名称，如uid等
	 * @return

	 * @date 2015-2-6 上午11:21:07
	 * @deprecated 该函数已过时
	 */
	public Map<String, Object> getPropertiesValue(String... filter) {
		String fieldString = toString();//字符串格式field=null,field=value,...
		if(StringUtils.isNotEmpty(fieldString)){
			if(filter!=null&&filter.length>0){
				filter = StringUtils.uniqStringArray(filter);//去掉重复
			}
			String[] fields = fieldString.split(",");
			Map<String, Object> map = new HashMap<String, Object>();
			String[] v,tem = new String[2];
			boolean isFilter =false;//是否存在过滤字段
			for (String str : fields) {//str格式：field=value
				v = str.split("=");
				if(v.length==1){//此处兼容value等于空字符串时候
					tem[0] = v[0];
					tem[1] = "";
					v = tem;
				}
				if(!v[1].equals("null")){//不为空的，这里只能判断是否为字符串"null"，不能直接判断是否为空或null，因为null已被字符串格式化了。
					//过滤
					isFilter =false;
					if(filter!=null&&filter.length>0){
						for (String fl : filter) {
							if(fl.equals(v[0])){
								isFilter = true;
								break;//存在
							}
						}
					}
					if(!isFilter){//添加到集合中
						//这里判断是否为数字，非数字，加上单引号
						//						map.put(v[0], NumberUtils.isNumber(v[1])?v[1]:("'"+v[1]+"'"));
						map.put(v[0], v[1]);
					}
				}
			}
			return map;
		}
		return null;
	}
	/**
	 * 根据传输类对象，过滤实体类属性，返回不为空的属性及其值,并封装到Map中
	 * @param obj
	 * @return

	 * @date 2015-2-26 上午10:52:26
	 */
	public Map<String, Object> getPropertiesValue(Object obj,boolean isDto){
		//获取实体类的查询字段，非实体类，请忽略
		Field[] fields = obj.getClass().getDeclaredFields();
		if(isDto){
			BeanBase bDto = new BeanBase();
			fields = ArrayUtils.addAll(fields, bDto.getClass().getDeclaredFields());
		}
		if(fields.length>0){
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				for(int i = 0 , len = fields.length; i < len; i++) { 
					// 对于每个属性，获取属性名 
					String varName = fields[i].getName(); 
					//					if(isInArray(fields, varName))continue;
					// 获取原来的访问控制权限 
					boolean accessFlag = fields[i].isAccessible(); 
					// 修改访问控制权限 
					fields[i].setAccessible(true); 
					// 获取在对象f中属性fields[i]对应的对象中的变量 
					Object value = fields[i].get(obj); 
					map.put(varName, value);
					// 恢复访问控制权限 
					fields[i].setAccessible(accessFlag); 
				}
			} catch (IllegalArgumentException ex) { 
				ex.printStackTrace(); 
			} catch (IllegalAccessException ex) { 
				ex.printStackTrace(); 
			} 
			return map;
		}
		return null;
	}
	/**
	 * 检查一个对象是否在一个对象数组元素中
	 * @param objects
	 * @param obj
	 * @return 存在返回true，否则返回false
	 * @date 2015-4-3 上午10:29:03

	 */
	public boolean isInArray(Object[] objects,Object obj) {
		for (Object object : objects) {
			if(obj.equals(object)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 根据传输类对象，过滤实体类属性，返回不为空的属性及其值
	 * @param obj 传输类对象
	 * @param filter 需要过滤的实体类属性集合
	 * @return

	 * @date 2015-2-26 上午11:19:32
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getPropertiesValue(Object obj,String... filter){
		Map<String, Object> mapDto = getPropertiesValue(obj,true);//得到传输类属性集合
		if(mapDto!=null&&mapDto.size()>0){
			String className = obj.getClass().getName().replace("dto", "entity").replace("Dto", "");//得到实体类名称
			try {
				Class clazz = Class.forName(className);//得到实体类
				if(!clazz.getName().equals(obj.getClass().getName())){
					Map<String, Object> mapEntity = getPropertiesValue(clazz.newInstance(),false);//记得初始化对象
					if(mapEntity!=null&&mapEntity.size()>0){
						Map<String, Object> map = new HashMap<String, Object>();
						boolean isFilter =false;//是否存在过滤字段
						for (String key : mapDto.keySet()) {
							if(key.equals("serialVersionUID")){
								continue;
							}
							for (String ekey : mapEntity.keySet()) {
								//检查dto与实体对象的属性
								if(key.lastIndexOf("Dto")!=-1){
									ekey+="Dto";
								}
								if(key.equals(ekey)){//这里根据两者的key值来判断
									//找到在实体类中的属性
									//进行过滤
									//过滤
									isFilter =false;
									if(filter!=null&&filter.length>0){
										for (String fl : filter) {
											if(fl.equals(key)){
												isFilter = true;
												break;//存在
											}
										}
									}
									if(!isFilter){//添加到集合中
										//不为null的属性，则添加。
										if(StringUtils.isNotNull(mapDto.get(key))){
											String temKey = key;
											Object temObject = mapDto.get(key);
											//检查dto与实体对象的属性
											if(key.indexOf("Dto")!=-1&&!(temObject instanceof Collection)){
												temKey = temKey.replace("Dto", "");
												Class temClass = Class.forName(temObject.getClass().getName().replace("Dto", "").replace("dto", "entity"));//得到实体类
												Object newObject = temClass.newInstance();
												BeanUtils.copyProperties(temObject, newObject);
												temObject = newObject;
											}
											map.put(temKey, temObject);//注意这里添加是dto中的属性及其值，实体类中并没有值
										}
									}
								}
							}
						}
						return map;
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 在DTO中，获取 Class中的属性值不为空（null）等属性的列表，并创建HQL更新语句，以字符串形式返回
	 * @param filter  需要过滤的属性名称，如id、uid等
	 * @param tAlisName 实体类表名，如Users.java 中的u，可以为空
	 * @return

	 * @date 2015-2-10 上午10:30:37
	 * @deprecated 该函数已过时，不能继续再使用
	 */
	public String createSetPropertiesValString(String tAlisName,String... filter){
		return GenericsUtils.createSetPropertiesString(getPropertiesValue(filter), tAlisName);
	}
	/**
	 * 在DTO中，获取 Class中的属性值不为空（null）等属性的列表，并创建HQL更新语句，以字符串形式返回
	 * @param obj 传输类对象
	 * @param tAlisName 实体类表名，如Users.java 中的u，可以为空
	 * @param filter  需要过滤的属性名称，如id、uid等
	 * @return

	 * @date 2015-2-26 上午11:20:40
	 */
	public String createSetPropertiesValString(Object obj,String tAlisName,String... filter){
		return GenericsUtils.createSetPropertiesString(getPropertiesValue(obj,filter), tAlisName);
	}
	/**
	 * 在DTO中，获取 Class中的属性值不为空（null）等属性的列表，并创建HQL更新语句
	 * 并以键值对形式返回,注意条件参数名称不要与更新的属性名称一致，否则被覆盖掉
	 * @param obj 传输类对象
	 * @param tAlisName 实体类表名，如Users.java 中的u，可以为空
	 * @param filter  需要过滤的属性名称，如id、uid等
	 * @return 生成格式，map，key=params参数列表，key=setHql更新字符串语句，如set u.email = :email,u.mobile = :mobile

	 * @date 2015-3-10 下午2:23:56
	 */
	public Map<String, Object> createSetPropertiesVal(Object obj,String tAlisName,String... filter) {
		return GenericsUtils.createSetProperties(getPropertiesValue(obj,filter), tAlisName);
	}
	/**
	 * 批量参数的值，转换为整数数组形式
	 * @return

	 * @date 2015-2-13 上午11:20:24
	 */
	public List<Integer> toBatchIntArray(){
		List<Integer> list= null;
		if(this.batch!=null){
			String[] batch = getBatch().split(",");
			list = new ArrayList<Integer>();
			for (String string : batch) {
				list.add(Integer.valueOf(string));
			}
		}
		return list;
	}
	/**
	 * 批量参数的值，转换为整数数组形式
	 * @param batch 以逗号分隔开的数字字符串
	 * @return

	 * @author 2015-5-13下午5:17:24
	 */
	public List<Integer> toBatchIntArray(String batch){
		List<Integer> list= null;
		if(StringUtils.isNotEmpty(batch)){
			String[] batchs = batch.split(",");
			list = new ArrayList<Integer>();
			for (String string : batchs) {
				list.add(Integer.valueOf(string));
			}
		}
		return list;
	}

	/**
	 * 批量参数的值，转换为字符串数组形式
	 * @return
	 * @author 2015-5-13下午5:15:59
	 */
	public List<String> toBatchStringArray(){
		List<String> list= null;
		if(this.batch!=null){
			String[] batch = getBatch().split(",");
			list = new ArrayList<String>();
			for (String string : batch) {
				list.add(string);
			}
		}
		return list;
	}

	/**
	 * 批量参数的值，转换为字符串数组形式
	 * @param batch 以逗号分隔开的字符串
	 * @return
	 * @author 2015-5-13下午5:19:08
	 */
	public List<String> toBatchStringArray(String batch){
		List<String> list= null;
		if(StringUtils.isNotEmpty(batch)){
			String[] batchs = batch.split(",");
			list = new ArrayList<String>();
			for (String string : batchs) {
				list.add(string);
			}
		}
		return list;
		}
	
	
}
