package BaseDao;

import java.util.List;
import java.io.Serializable;

public interface BaseHibernateDao<T>
{
	
	// ����ID����ʵ��
		T get(Class<T> entityClazz , Serializable id);
		// ����/����ʵ��/ɾ��ʵ��
		Serializable save(T entity);
		void update(T entity);
		void delete(T entity);
		// ����IDɾ��ʵ��
		void delete(Class<T> entityClazz , Serializable id);
		public void deletes(Class<T> entityClazz , String ids);
		public void deleteAll(Class<T> entityClazz );
		
		
		//�Զ���
		public  T getOne(String hql);
		List<T> findAll(Class<T> entityClazz);
		// ��ȡʵ������
		long findCount(Class<T> entityClazz);
		// ����HQL����ѯʵ��
		public  List<T> find(String hql);
		// ���ݴ�ռλ������HQL����ѯʵ��
		public List<T> find(String hql , Object... params);
		
		public List<T> findByPage(String hql,
				 int pageNo, int pageSize);
		
		public List<T> findByPage(String hql , int pageNo, int pageSize
				, Object... params);
}
