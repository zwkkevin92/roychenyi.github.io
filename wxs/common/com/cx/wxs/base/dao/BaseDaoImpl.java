package com.cx.wxs.base.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;


import com.cx.wxs.utils.GenericsUtils;
import com.cx.wxs.utils.NumberUtils;
import com.cx.wxs.utils.SpringUtils;
import com.cx.wxs.utils.StringUtils;



/**
 * 基础Dao实现类
 *
 * @param <T> 实体类
 * @param <PK> 键值
 */
@SuppressWarnings({"unchecked","rawtypes","unused"})
public class BaseDaoImpl<T extends Serializable,PK extends Serializable> implements IBaseDao<T, PK> {
	private SessionFactory sessionFactory;

	private Class<T> pojoClass;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getPojoClass() {
		return pojoClass;
	}

	/**
	 * 获得该DAO对应的POJO类型名
	 * @return
	 */
	public String getPojoClassName() {
		return getPojoClass().getName();
	}

	/**
	 * 初始化DAO，获取POJO类型
	 */
	public BaseDaoImpl() {
		this.pojoClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void delete(T t) {
		this.getCurrentSession().delete(t);
	}

	@Override
	public Integer delete(String hql) {
		return this.executeHql(hql);
	}

	@Override
	public Integer delete(String hql, Map<String, Object> params) {
		return this.executeHql(hql,params);
	}
	@Override
	public Integer delete(String hql, Object[] param) {
		return this.executeHql(hql, param);
	}
	@Override
	public void deleteEntityByPK(PK pk) {
		this.delete(this.findByFK(pk));
	}
	@Override
	public void update(T t) {
		
		this.getCurrentSession().update(t);
        this.getCurrentSession().flush();
	}

	@Override
	public Integer update(String hql) {
		return this.executeHql(hql);
	}
	@Override
	public Integer update(String hql, Map<String, Object> params) {
		return this.executeHql(hql, params);
	}
	@Override
	public Integer update(String hql, Object[] param) {
		return this.executeHql(hql, param);
	}
	@Override
	public Integer save(T t) {
		return Integer.valueOf(this.getCurrentSession().save(t).toString());

	}

	@Override
	public void saveOrUpdate(T t) {
		this.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void saveOrUpdate(String arg, T t) {
		this.getCurrentSession().saveOrUpdate(arg, t);
	}
	
	@Override
	public List<Integer> batchSave(List<T> list) {
		if(list!=null&&list.size()>0){
			List<Integer> serList = new ArrayList<Integer>();
			Session session = this.getCurrentSession();
			for (int i = 0; i < list.size(); i++) {
				T t = list.get(i);
				serList.add(Integer.valueOf(session.save(t).toString()));
				// 批插入的对象立即写入数据库并释放内存  
				if(i%20==0){
					session.flush();
					session.clear();
				}
			}
			return serList;
		}
		return null;
	}
	
	@Override
	public void batchUpdate(List<T> list) {
		if(list!=null&&list.size()>0){
			Session session = this.getCurrentSession();
			for (int i = 0; i < list.size(); i++) {
				T t = list.get(i);
				session.update(t);
				// 批插入的对象立即写入数据库并释放内存  
				if(i%20==0){
					session.flush();
					session.clear();
				}
			}
		}
	}
	@Override
	public List<T> find(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@Override
	public T findByFK(PK pk) {
		return (T) this.getCurrentSession().get(getPojoClass(), pk);
	}
	@Override
	public T findByFK(String hql, Object o) {
		return (T) this.getCurrentSession().createQuery(hql).setParameter(0, o).list().get(0);
	}

	@Override
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = this.getCurrentSession().createCriteria(getPojoClass());
		for (Criterion criterion : criterions) {
			if(criteria!=null){
				criteria.add(criterion);
			}
		}
		return criteria;
	}
	@Override
	public Criteria createCriteria(String orderBy, boolean isAsc,
			Criterion... criterions) {
		Criteria criteria = createCriteria(criterions);
		if(isAsc){
			criteria.addOrder(Order.asc(orderBy));
		}else{
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria;
	}
	@Override
	public List<T> find(Criterion... criterions) {
		return createCriteria(criterions).list();
	}


	@Override
	public List<T> find(String hql, Object[] params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (Integer i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		return query.list();
	}

	@Override
	public List<T> find(String hql, List<Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && params.size() > 0) {
			for (Integer i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		return query.list();
	}
	@Override
	public List<T> find(String hql, Integer page, Integer rows) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return query.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, Integer page,
			Integer rows) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return query.list();
	}
	
	@Override
	public List<T> find(String hql, Object[] params,Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && params.length > 0) {
			for (Integer i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> params,Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		return query.list();
	}

	@Override
	public List<T> find(String hql, List<Object> params,Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && params.size() > 0) {
			for (Integer i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		return query.list();
	}
	@Override
	public List<T> find(String hql, Integer page, Integer rows,Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return query.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, Integer page,
			Integer rows,Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return query.list();
	}

	
	@Override
	public List<T> findByList(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		return query.list();
	}
	@Override
	public List<T> findBySQL(String sql, Map<String, Object> params, Integer page,
			Integer rows) {
		SQLQuery sqlQuery = (SQLQuery) this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				sqlQuery.setParameter(key, params.get(key));
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return sqlQuery.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return sqlQuery.list();
	}
	@Override
	public List<Map> findBySQLForPage(String sql, Map<String, Object> params,
			Integer page, Integer rows) {
		SQLQuery sqlQuery = (SQLQuery) this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if(obj instanceof Collection){
					sqlQuery.setParameterList(key, (Collection)obj);
				}else{
					sqlQuery.setParameter(key, obj);
				}
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return sqlQuery.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return sqlQuery.list();
	}
	@Override
	public List findBySQLForPage(String sql, Map<String, Object> params,
			Integer page, Integer rows, Class o) {
		SQLQuery sqlQuery = (SQLQuery) this.getCurrentSession().createSQLQuery(sql).addEntity(o);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				sqlQuery.setParameter(key, params.get(key));
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return sqlQuery.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return sqlQuery.list();
	}

	@Override
	public List findBySQL(String sql, Map<String, Object> params, Class o) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql).addEntity(o);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				sqlQuery.setParameter(key, params.get(key));
			}
		}
		return sqlQuery.list();
	}
	@Override
	public List findDto(String hql, Map<String, Object> params, Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		return query.list();
	}
	@Override
	public List findDto(String hql, Map<String, Object> params, Integer page,
			Integer rows, Class c) {
		Query query = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List){
					query.setParameterList(key, (List)params.get(key));
				}else{
					query.setParameter(key, params.get(key));
				}
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return query.list();
	}


	@Override
	public List findPropertys(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (Integer i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.list();
	}
	@Override
	public List findPropertys(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List)
					query.setParameterList(key, (List)params.get(key));
				else
					query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}
	@Override
	public List<T> findByCriteria(Criteria criteria) {
		return criteria.list();
	}
	@Override
	public List findBySql(String sql) {
		Query query = this.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}
	@Override
	public List findBySql(String sql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  List) {
					query.setParameterList(key, (List)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		return query.list();
	}
	@Override
	public Object findBySqlDto(String sql, Map<String, Object> params, Class c) {
		Query query = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		List<T> list = query.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public List findBySql(String sql, Object[] param) {
		Query query = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (Integer i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.list();
	}



	@Override
	public T get(Class<T> c, Serializable pk) {
		return (T) this.getCurrentSession().get(c, pk);
	}
	@Override
	public T get(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<T> list = query.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public T get(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<T> l = query.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}
	@Override
	public List getBusinessDataForPage(Map searchParams, String where,
			String sql01, Integer page, Integer rows) {
		StringBuffer sql = new StringBuffer(sql01);
		if(StringUtils.isNotNull(where)){
			sql.append(where);
		}
		if(page==0||rows==0){
			return executeSQL(sql.toString(), searchParams).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}
		return findBySQLForPage(sql.toString(), searchParams, page, rows);
	}
	@Override
	public List getBusinessDataForPage01(Map searchParams, String where,
			String countSql, String sql, Integer page, Integer rows, Boolean isCount,
			Boolean isPage) {
		StringBuffer countSql_v=new StringBuffer(countSql);
		StringBuffer sql_v=new StringBuffer(sql);
		if(StringUtils.isNotNull(where)){
			countSql_v.append(where);
			sql_v.append(where);
		}
		if(isPage){
			if(isCount){//返回分页时记录总数
				List<Integer>  list=new ArrayList<Integer>();
				Integer  num=this.countSql(countSql_v.toString(), searchParams);
				list.add(num);
				return  list;
			}else{
				return findBySQLForPage(sql_v.toString(), searchParams, page, rows);
			}

		}else{
			return  executeSQL(sql_v.toString(), searchParams).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}
	}



	@Override
	public Integer count(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (Integer i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		Object obj = query.uniqueResult();
		if(obj!=null){
			return ((Integer)obj).intValue();
		}
		return 0;
	}
	@Override
	public Integer count(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		Object obj = query.uniqueResult();
		if(obj!=null){
			return Integer.valueOf(obj.toString());
		}
		return 0;
	}
	@Override
	public Integer count(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof List)
					query.setParameterList(key, (List)params.get(key));
				else
					query.setParameter(key, params.get(key));
			}
		}
		Object obj = query.uniqueResult();
		if (obj != null){
			return Integer.valueOf(obj.toString());
		}
		return 0;
	}

	@Override
	public Integer count(Criteria criteria) {
		Integer count = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return count.intValue();
	}
	@Override
	public Query createQuery(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		return query;
	}
	@Override
	public Integer countSql(String sql, Map<String, Object> params) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					sqlQuery.setParameterList(key, (Collection)value);
				}else{
					sqlQuery.setParameter(key, params.get(key));
				}
			}
		}
		Object obj = sqlQuery.uniqueResult();
		if (obj != null){
			NumberUtils.toInt(obj.toString());
		}
		return 0;
	}

	/******************
	 * 将联合查询的结果内容从Map或者Object[]转换为实体类型
	 * 
	 * @param items
	 * @return
	 */
	private List transformResults(List items) {

		if (items.size() > 0) {
			if (items.get(0) instanceof Map) {
				ArrayList list = new ArrayList(items.size());
				for (Integer i = 0; i < items.size(); i++) {
					Map map = (Map) items.get(i);
					list.add(map.get(CriteriaSpecification.ROOT_ALIAS));
				}
				return list;
			} else if (items.get(0) instanceof Object[]) {
				ArrayList list = new ArrayList(items.size());
				Integer pos = 0;
				for (Integer i = 0; i < ((Object[]) items.get(0)).length; i++) {
					if (((Object[]) items.get(0))[i].getClass() == getPojoClass()) {
						pos = i;
						break;
					}
				}
				for (Integer i = 0; i < items.size(); i++) {
					list.add(((Object[]) items.get(i))[pos]);
				}
				return list;
			} else
				return items;
		} else
			return items;
	}
	@Override
	public Integer executeHql(String hql) {
		Query query = this.getCurrentSession().createQuery(hql);
		return query.executeUpdate();
	}
	@Override
	public Integer executeHql(String hql, Object[] param) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(param!=null&&param.length>0){
			for (Integer i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		return query.executeUpdate();
	}
	@Override
	public Integer executeHql(String hql, Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		return query.executeUpdate();
	}
	@Override
	public SQLQuery executeSQL(String sql) {
		return this.getCurrentSession().createSQLQuery(sql);
	}
	@Override
	public Query executeSQL(String sql, ResultTransformer transformers) {
		return this.getCurrentSession().createSQLQuery(sql).setResultTransformer(transformers);
	}
	@Override
	public SQLQuery executeSQL(String sql, Map<String, Object> params) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					sqlQuery.setParameterList(key, (Collection)value);
				}else{
					sqlQuery.setParameter(key, value);
				}
			}
		}
		return sqlQuery;
	}
	@Override
	public SQLQuery executeSQL(String sql, Integer page, Integer rows,
			Map<String, Object> params) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					sqlQuery.setParameterList(key, (Collection)value);
				}else{
					sqlQuery.setParameter(key, params.get(key));
				}
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			sqlQuery.setFirstResult((page - 1) * rows).setMaxResults(rows);
		}
		return sqlQuery;
	}
	@Override
	public Integer executeUpdateSQL(String sql, Map<String, Object> params) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		if(params!=null&&!params.isEmpty()){
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					sqlQuery.setParameterList(key, (Collection)value);
				}else{
					sqlQuery.setParameter(key, params.get(key));
				}
			}
		}
		return sqlQuery.executeUpdate();
	}
	@Override
	public Integer executeUpdateSQL(String sql) {
		SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
		return sqlQuery.executeUpdate();
	}
	@Override
	public void exeBatch(final String sql, final List<String> valueList) {
		this.getCurrentSession().doWork(new Work() {

			@Override
			public void execute(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareCall(sql);
				conn.setAutoCommit(true);
				for (Integer i = 0; i < valueList.size(); i++) {
					stmt.setString(1, "");
					stmt.addBatch();
					if(i%100==0){
						stmt.executeBatch();
						conn.commit();
					}
				}
				stmt.executeBatch();
				conn.commit();
			}
		});
	}
	@Override
	public List executeSQL(String sql, Integer page, Integer rows,
			Map<String, Object> params, Class c) {
		Query query = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && !params.isEmpty()){
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		}
		return query.list();
	}
	@Override
	public List executeSQL(String sql, Map<String, Object> params, Class c) {
		Query query = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(c));
		if (params != null && !params.isEmpty()){
			for (String key : params.keySet()) {
				Object value=params.get(key);
				if (value instanceof  Collection) {
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}
			}
		}
		return query.list();
	}
	
	/**
	 * 清除hibernate的缓存
	 * 
	 * @author 2015-6-25上午10:42:35
	 */
	public void flush() {
		this.getCurrentSession().flush();
		this.getCurrentSession().clear();
	}
	
	public void exjdbc(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtils.getBean("jdbcTemplate_sjwdb");
		final String sql="{call last_u()}";
		List<SqlParameter> declaredParameters=new ArrayList<SqlParameter>();
//		String string = jdbcTemplate.queryForObject(sql, String.class);
//		System.out.println(string);
		Map<String, Object> rMap = jdbcTemplate.call(new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection conn)
					throws SQLException {
				CallableStatement cstmt = conn.prepareCall(sql);
				return cstmt;
			}
		}, declaredParameters);
		for (String key : rMap.keySet()) {
			System.out.println(rMap.get(key));
		}
	}

}
