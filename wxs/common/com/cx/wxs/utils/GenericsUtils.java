package com.cx.wxs.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


/**
 * 泛型工具类
 * @date   2015-12-1 下午5:09:25
 */
@SuppressWarnings("rawtypes")
public class GenericsUtils {

	/*************
	 * 通过反射，获得定义Class时声明的父类的第一个范型参数的类型
	 * 
	 * @param clazz
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/***************
	 * 通过反射，获得定义Class时声明的父类的范型参数的类型。 如没有找到符合要求的范型参数，则递归向上直到Object。
	 * 
	 * @param clazz
	 *            要进行查询的类
	 * @param index
	 *            如有多个范型声明该索引从0开始
	 * @return 在index位置的范型参数的类型，如果无法判断则返回<code>Object.class</code>
	 */
	public static Class getSuperClassGenricType(Class clazz, int index) {
		boolean flag = true;
		Type genType = clazz.getGenericSuperclass();
		Type[] params = null;

		if (!(genType instanceof ParameterizedType))
			flag = false;
		else {
			params = ((ParameterizedType) genType).getActualTypeArguments();
			if (index >= params.length || index < 0)
				flag = false;
			if (!(params[index] instanceof Class))
				flag = false;
		}
		if (!flag) {
			clazz = clazz.getSuperclass();
			if (clazz == Object.class)
				return Object.class;
			else
				return getSuperClassGenricType(clazz, index);
		}
		return (Class) params[index];
	}
	/**
	 * 获取一个类中，定义的所有属性字段名称
	 * @param clazz 
	 * @return
	 * @date 2015-2-3 下午4:21:37
	 */
	public static Map<String, String> getClassField(Class clazz){
		Map<String, String> fieldMap = null;
		if(clazz!=null){
			fieldMap = new HashMap<String, String>();
			Field[] fields = clazz.getDeclaredFields();//得到所有定义的属性
			for (Field field : fields) {
				fieldMap.put(field.getName(), field.getName());
			}
		}
		return fieldMap;
	}
	/**
	 * 获取一个类中，定义的所有属性字段名称
	 * @param clazz
	 * @param tAlisName 此参数为实体类（表）的别名，如果为空，将不返回别名字符串
	 * @param ignore 忽略的字段数组，默认已忽略“serialVersionUID”该字段
	 * @return
	 * @date 2015-2-3 下午4:31:08
	 */
	public static Map<String, String> getClassField(Class clazz,String tAlisName,String... ignore){
		Map<String, String> fieldMap = null;
		if(clazz!=null){
			fieldMap = new HashMap<String, String>();
			Field[] fields = clazz.getDeclaredFields();//得到所有定义的属性
			boolean isIgnore =false;//是否存在有忽略的字段
			for (Field field : fields) {
				String name = field.getName();
				if(!name.equals("serialVersionUID")){//忽略此参数
					if(ignore!=null&&ignore.length>0){
						isIgnore =false;
						for (String str : ignore) {
							if(str.equals(name)){
								isIgnore =true;
							}
						}
					}
					if(!isIgnore){//不存在忽略列表中，则继续拼接
						String value = tAlisName!=null?(tAlisName+"."+name+" as "+name):name;
						fieldMap.put(name, value);
					}
				}
			}
		}
		return fieldMap;
	}
	/**
	 * 获取一个类中，定义的所有属性字段名称，并用“,”连接起来
	 * @param clazz
	 * @param tAlisName 此参数为实体类（表）的别名，不能为空
	 * @param ignore 忽略的字段数组，默认已忽略“serialVersionUID”该字段
	 * @return
	 * @date 2015-2-3 下午4:48:45
	 */
	public static String getClassFieldString(Class clazz,String tAlisName,String... ignore){
		StringBuffer fieldString = new StringBuffer(" ");
		if(clazz!=null&&tAlisName!=null){
			Field[] fields = clazz.getDeclaredFields();//得到所有定义的属性
			boolean isIgnore =false;//是否存在有忽略的字段
			for (Field field : fields) {
				String name = field.getName();
				if(!name.equals("serialVersionUID")){//忽略此参数
					if(ignore!=null&&ignore.length>0){
						isIgnore =false;
						for (String str : ignore) {
							if(str.equals(name)){
								isIgnore =true;
							}
						}
					}
					if(!isIgnore){//不存在忽略列表中，则继续拼接
						fieldString.append(tAlisName+"."+name+" as "+name+",");
					}
				}
			}
		}
		return fieldString.toString().substring(0,fieldString.toString().length()-1)+" ";
	}
	/**
	 * 过滤获取一个类中，定义的所有属性字段名称，并用“,”连接起来
	 * @param clazz 实体类或传输类（若为传输类，系统自动转为实体类）
	 * @param tAlisName 此参数为实体类（表）的别名，可选，系统默认为每个类的首字母；如果是多个表，第二个表开始自己补充，如ui.uid as uid
	 * @param filter 过滤的字段数组，可选
	 * @return
	 * @date 2015-2-3 下午5:13:32
	 */
	public static String filterClassPropertiesString(Class clazz,String tAlisName,String... filter){
		if(clazz==null)return "";
		StringBuffer fieldString = new StringBuffer(" ");
		if(!StringUtils.isNotEmpty(tAlisName)){
			String[] className = clazz.getName().split("[.]");
			tAlisName = className[className.length-1].substring(0, 1).toLowerCase();
		}
		//获取实体类的查询字段，非实体类，请忽略
		try {
			//如果为传输类，则转换为实体类
			if(clazz.getName().indexOf("Dto")!=-1){
				String entityClass = clazz.getName().replace("dto", "po").replace("Dto", "");
				Class class1 = Class.forName(entityClass);
				if(!class1.getName().equals(clazz.getName())){
					clazz = class1;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(clazz!=null&&tAlisName!=null){
			Field[] fields = clazz.getDeclaredFields();//得到所有定义的属性
			for (Field field : fields) {
				String name = field.getName();
				if(name.equals("serialVersionUID")){
					continue;
				}
				if(filter!=null&&filter.length>0){
					for (String str : filter) {
						if(str.equals(name)){
							fieldString.append(tAlisName+"."+name+" as "+name+",");
							break;
						}else{
							//如果本次找不到，则尝试验证是否跟自己开始字符串一直，若为一致，则也添加
							//故为Dto分隔符或前缀一致的名称
							if(str.indexOf("Dto")!=-1||(str.indexOf(name)==0&&str.length()>name.length())){
								//不等于-1，表示名称中含有Dto
								if(str.indexOf("Dto")!=-1){
									String temStr[] = str.split("Dto");
									//再次判断是否相等
//									if(temStr[0].equals(name)||name.indexOf(temStr[0])==0&&name.length()>temStr[0].length()){
									//TODO 暂时设为相等情况下添加
									if(temStr[0].equals(name)){
										fieldString.append(tAlisName+"."+name+" as "+name+",");
										break;
									}
								}else{
									fieldString.append(tAlisName+"."+name+" as "+name+",");
									break;
								}
							}
						}
					}
				}else{
					fieldString.append(tAlisName+"."+name+" as "+name+",");
				}
			}
			//添加额外的字段属性
			if(filter!=null){
				for (String str : filter) {
					if(str.indexOf(".")>0){//格式
						fieldString.append(str+",");
					}
				}
			}
		}
		return fieldString.toString().substring(0,fieldString.toString().length()-1)+" ";//返回时，去掉最后一个“,”
	}
	/**
	 * 创建HQL更新语句
	 * @param map 创建的集合，以key、value形式
	 * @param tAlisName 实体类表名，如u，可以为空
	 * @return 生成格式，如set u.email = 452279388@qq.com,u.mobile = 18697927655
	 * @date 2015-2-6 上午11:00:49
	 */
	public static String createSetPropertiesString(Map<String, Object> map,String tAlisName){
		StringBuffer fieldString = new StringBuffer(" ");
		if(map!=null&&map.size()>0){
			fieldString.append("set ");
			String tan = StringUtils.isNotEmpty(tAlisName)?tAlisName+".":"";//判断前缀是否为空，不为空，则加上"."连接
			for (String key : map.keySet()) {//依次拼接起来
				fieldString.append(tan+key);
				fieldString.append(" = ");
				fieldString.append(map.get(key));
				fieldString.append(",");
			}
		}
		return fieldString.toString().substring(0,fieldString.toString().length()-1)+" ";//返回时，去掉最后一个“,”
	}
	/**
	 * 创建HQL更新语句
	 * 注意条件参数名称不要与更新的属性名称一致，否则被覆盖掉
	 * @param map 创建的集合，以key、value形式
	 * @param tAlisName 实体类表名，如u，可以为空
	 * @return 生成格式，map，key=params参数列表，key=setHql更新字符串语句，如set u.email = :email,u.mobile = :mobile
	 */
	public static Map<String, Object> createSetProperties(Map<String, Object> map,String tAlisName) {
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		if(map!=null&&map.size()>0){
			StringBuffer fieldString = new StringBuffer(" ");
			fieldString.append("set ");
			String tan = StringUtils.isNotEmpty(tAlisName)?tAlisName+".":"";//判断前缀是否为空，不为空，则加上"."连接
			for (String key : map.keySet()) {//依次拼接起来
				fieldString.append(tan+key);
				fieldString.append(" = :");
				fieldString.append(key);//这里保存键值名称
				fieldString.append(",");
				//加入到map中
				params.put(key, map.get(key));
			}
			String setHql = fieldString.toString().substring(0,fieldString.toString().length()-1)+" ";//返回时，去掉最后一个“,”
			maps.put("setHql", setHql);
		}
		maps.put("params", params);
		return maps;
	}

}

