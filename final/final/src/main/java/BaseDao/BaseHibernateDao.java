package BaseDao;

import java.util.List;
import java.io.Serializable;

public interface BaseHibernateDao<T>
{
	
	// 根据ID加载实体
		T get(Class<T> entityClazz , Serializable id);
		// 保存/更新实体/删除实体
		Serializable save(T entity);
		void update(T entity);
		void delete(T entity);
		// 根据ID删除实体
		void delete(Class<T> entityClazz , Serializable id);
		public void deletes(Class<T> entityClazz , String ids);
		public void deleteAll(Class<T> entityClazz );
		
		
		//自定义
		public  T getOne(String hql);
		List<T> findAll(Class<T> entityClazz);
		// 获取实体总数
		long findCount(Class<T> entityClazz);
		// 根据HQL语句查询实体
		public  List<T> find(String hql);
		// 根据带占位符参数HQL语句查询实体
		public List<T> find(String hql , Object... params);
		
		public List<T> findByPage(String hql,
				 int pageNo, int pageSize);
		
		public List<T> findByPage(String hql , int pageNo, int pageSize
				, Object... params);
}
