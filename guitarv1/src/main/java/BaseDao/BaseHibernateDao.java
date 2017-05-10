package BaseDao;

import java.util.List;
import java.io.Serializable;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public interface BaseHibernateDao<T>
{
	
	// 根据ID加载实体
		T get(Class<T> entityClazz , Serializable id);
		// 保存实体
		Serializable save(T entity);
		// 更新实体
		void update(T entity);
		// 删除实体
		void delete(T entity);
		// 根据ID删除实体
		void delete(Class<T> entityClazz , Serializable id);
		public void deletes(Class<T> entityClazz , String ids);
		public void deleteAll(Class<T> entityClazz );
		//自定义
		public  T getOne(String hql);
		// 获取所有实体
		List<T> findAll(Class<T> entityClazz);
		// 获取实体总数
		long findCount(Class<T> entityClazz);
		// 根据HQL语句查询实体
		public  List<T> find(String hql);
		// 根据带占位符参数HQL语句查询实体
		public List<T> find(String hql , Object... params);
		 //使用hql 语句进行分页查询操作
		public List<T> findByPage(String hql,
				 int pageNo, int pageSize);
		//	 * 使用hql 语句进行分页查询操作(带参数);
		public List<T> findByPage(String hql , int pageNo, int pageSize
				, Object... params);
}
