package BaseDao;

import java.util.List;
import java.io.Serializable;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public interface BaseHibernateDao<T>
{
	
	// ����ID����ʵ��
		T get(Class<T> entityClazz , Serializable id);
		// ����ʵ��
		Serializable save(T entity);
		// ����ʵ��
		void update(T entity);
		// ɾ��ʵ��
		void delete(T entity);
		// ����IDɾ��ʵ��
		void delete(Class<T> entityClazz , Serializable id);
		public void deletes(Class<T> entityClazz , String ids);
		public void deleteAll(Class<T> entityClazz );
		//�Զ���
		public  T getOne(String hql);
		// ��ȡ����ʵ��
		List<T> findAll(Class<T> entityClazz);
		// ��ȡʵ������
		long findCount(Class<T> entityClazz);
		// ����HQL����ѯʵ��
		public  List<T> find(String hql);
		// ���ݴ�ռλ������HQL����ѯʵ��
		public List<T> find(String hql , Object... params);
		 //ʹ��hql �����з�ҳ��ѯ����
		public List<T> findByPage(String hql,
				 int pageNo, int pageSize);
		//	 * ʹ��hql �����з�ҳ��ѯ����(������);
		public List<T> findByPage(String hql , int pageNo, int pageSize
				, Object... params);
}