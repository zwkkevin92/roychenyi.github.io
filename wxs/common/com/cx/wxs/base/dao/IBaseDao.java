package com.cx.wxs.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.transform.ResultTransformer;
/**
 * 基础Dao接口
 
 *
 * @param <T> 实体类
 * @param <PK> 键值
 */
@SuppressWarnings("rawtypes")
public interface IBaseDao<T extends Serializable, PK extends Serializable>  {
	/**
	 * 获取sessionFactory中当前的Session
	 
	 * @return SessionFactory的Session 对象
	 * @date 2015-1-20 上午9:58:24
	 */
	public Session getCurrentSession();
	/**
	 * 根据对象删除一条记录
	 * @param t 操作的对象
	 
	 * @date 2015-1-20 上午9:59:23
	 */
	public void delete(T t);
	/**
	 * 根据hql语句来执行删除操作
	 * @param hql
	 * @return 受影响的函数
	 
	 * @date 2015-2-2 下午9:58:09
	 */
	public Integer delete(String hql);
	/**
	 * 根据hql语句来执行删除操作
	 * @param hql
	 * @param params 条件参数
	 * @return
	 
	 * @date 2015-2-2 下午10:06:27
	 */
	public Integer delete(String hql,Map<String, Object> params);
	/**
	 * 根据hql语句来执行删除操作
	 * @param hql
	 * @param param 条件数组
	 * @return
	 
	 * @date 2015-2-2 下午10:06:43
	 */
	public Integer delete(String hql,Object[] param);
	/**
	 * 通过一个键值来删除一条记录
	 * @param pk
	 
	 * @date 2015-1-26 下午10:30:07
	 */
	public void deleteEntityByPK(PK pk);
	/**
	 * 根据对象更新一条记录
	 * @param t 操作的对象
	 
	 * @date 2015-1-20 上午10:01:04
	 */
	public void update(T t);
	/**
	 * 根据hql语句来执行更新操作
	 * @param hql
	 * @return 受影响的函数
	 
	 * @date 2015-2-2 下午9:58:09
	 */
	public Integer update(String hql);
	/**
	 * 根据hql语句来执行更新操作
	 * @param hql
	 * @param params 条件参数
	 * @return
	 
	 * @date 2015-2-2 下午10:06:27
	 */
	public Integer update(String hql,Map<String, Object> params);
	/**
	 * 根据hql语句来执行更新操作
	 * @param hql
	 * @param param 条件数组
	 * @return
	 
	 * @date 2015-2-2 下午10:06:43
	 */
	public Integer update(String hql,Object[] param);
	/**
	 * 通过对象中的值保存（添加）一条记录
	 * @param t 操作的对象
	 * @return
	 
	 * @date 2015-1-20 上午10:01:18
	 */
	public Integer save(T t);
	/**
	 * 通过对象中的值保存（添加）或更新一条记录
	 * @param t 操作的对象
	 
	 * @date 2015-1-20 上午10:01:27
	 */
	public void saveOrUpdate(T t);
	/**
	 * 通过对象中的值保存（添加）或更新一条记录
	 * @param arg 
	 * @param t 操作的对象
	 
	 * @date 2015-1-20 上午10:01:39
	 */
	public void saveOrUpdate(String arg,T t);
	/**
	 * 批量保存
	 * @param list 保存实体对象的集合
	 * @return
	 * @date 2015-4-22 下午8:55:35
	 
	 */
	public List<Integer> batchSave(List<T> list);
	/**
	 * 批量更新
	 * @param list
	 * @date 2015-4-22 下午9:28:45
	 
	 */
	public void batchUpdate(List<T> list);
	/**
	 * 根据hql语句查找一组数据
	 * @param hql 要执行的hql语句
	 * @return List<T>
	 
	 * @date 2015-1-20 上午10:01:48
	 */
	public List<T> find(String hql);
	/**
	 * 根据外键来获取一组数据
	 * @param pk 外键值
	 * @return T
	 
	 * @date 2015-1-20 上午10:02:21
	 */
	public T findByFK(PK pk);
	/**
	 * 根据外键来查找对象
	 * @param hql 语句
	 * @param o 
	 * @return
	 
	 * @date 2015-1-20 上午10:02:37
	 */
	public T findByFK(String hql,Object o);
	
	public List<T> find(Criterion... criterions);
	public List<T> find(String hql, Object[] param);
	public List<T> find(String hql, Map<String, Object> params);
	public List<T> find(String hql, List<Object> params);
	public List<T> find(String hql, Integer page, Integer rows);
	public List<T> find(String hql, Map<String, Object> params, Integer page, Integer rows);
	
	public List<T> find(String hql, Object[] param,Class c);
	public List<T> find(String hql, Map<String, Object> params,Class c);
	public List<T> find(String hql, List<Object> params,Class c);
	public List<T> find(String hql, Integer page, Integer rows,Class c);
	public List<T> find(String hql, Map<String, Object> params, Integer page, Integer rows,Class c);
	
	
	public List<T> findByList(String hql, Map<String, Object> params);
	public List<T> findBySQL(String sql, Map<String, Object> params, Integer page, Integer rows);
	public List<Map> findBySQLForPage(String sql, Map<String, Object> params, Integer page, Integer rows);
	public List findBySQLForPage(String sql, Map<String, Object> params, Integer page, Integer rows,Class o);
	public List findBySQL(String sql, Map<String, Object> params,Class o);
	public List findDto(String hql,Map<String,Object> params,Class c);
	public List findDto(String hql,Map<String,Object> params,Integer page,Integer rows,Class c);
	public List findPropertys(String hql, Object[] param);
	public List findPropertys(String hql, Map<String, Object> params);
	public List<T> findByCriteria(Criteria criteria);
	public List findBySql(String sql);
	public List findBySql(String sql, Map<String, Object> params);
	public Object findBySqlDto(String sql,Map<String,Object> params,Class c);
	public List findBySql(String sql, Object[] param);
	
	
	public T get(Class<T> c, Serializable pk);
	public T get(String hql);
	public T get(String hql, Map<String, Object> params);
	public List getBusinessDataForPage(Map searchParams,String where,String sql01,Integer page,Integer rows);
	public List getBusinessDataForPage01(Map searchParams,String where,String countSql,String sql,Integer page,Integer rows,Boolean isCount,Boolean isPage);
	
	/**
	 * 获取Criteria对象
	 * @param criterions
	 * @return
	 
	 * @date 2015-1-20 上午10:02:45
	 */
	public Criteria createCriteria(Criterion... criterions);
	/**
	 * 获取Criteria对象
	 * @param orderBy 排序
	 * @param isAsc 是否为asc排序，否则为desc排序
	 * @param criterions
	 * @return
	 
	 * @date 2015-1-20 上午10:02:56
	 */
	public Criteria createCriteria(String orderBy, boolean isAsc, Criterion... criterions);
	public Integer count(String hql, Object[] param);
	public Integer count(String hql);
	public Integer count(String hql, Map<String, Object> params);
	public Integer count(final Criteria criteria);
	public Query createQuery(String hql,Map<String, Object> params);
	public Integer countSql(String sql, Map<String, Object> params);
	
	public Integer executeHql(String hql);
	public Integer executeHql(String hql, Object[] param);
	public Integer executeHql(String hql,Map<String, Object> params);
	public SQLQuery executeSQL(String sql);
	public Query executeSQL(String sql,ResultTransformer transformers);
	public SQLQuery executeSQL(String sql,Map<String, Object> params);
	public SQLQuery executeSQL(String sql,Integer page, Integer rows,Map<String, Object> params);
	public Integer executeUpdateSQL(String sql,Map<String, Object> params);
	public Integer executeUpdateSQL(String sql);
	public void exeBatch(final String sql,final List<String> valueList);
	public List executeSQL(String sql,Integer page, Integer rows,Map<String, Object> params,Class c);
	public List executeSQL(String sql, Map<String, Object> params, Class c);
	public void flush();
	public void exjdbc();
	
}
