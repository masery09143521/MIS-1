package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




//��Ƶ�һ������ƴ�ӳɸ��ݲ������ҵ�hql���
public class SearchBackge {
	private Map<String,Object> map=new HashMap<String,Object>();
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	private List<String> list = new ArrayList<String>();

  public  String selectByParam(String[][] canshu,String entityname){
	    //���˿�ֵ
		for (int i = 0; i < canshu[1].length; i++) {
			if (canshu[1][i] != null && !"".equals(canshu[1][i])) {
				map.put(canshu[0][i], canshu[1][i]);
				list.add(canshu[0][i]);
			}else{
				continue;
			}
		}
        //����������һ��list���ϣ���Ϊ�������ѭ��ƴ��hql���
		List<String> Hql = new ArrayList<String>();
		//������ôЩ��Ϊ�ˣ�ƴ��hql����ʱ�򣬿��� Ϊ" and username=10 " ���������ͣ����ں���Ų�������and
		String hql = "from "+entityname+"  where 1=1 ";
		//�����hql�ŵ���Ҫƴ�ӵ�Hql�����У�������������
		Hql.add(hql);
		//����һ�������飬Ϊ��ƴ�Ӳ���hql
		String[] ddhql = new String[list.size()];
		//�жϴ����Ĳ����Ƿ���ֵ�������ֵ����ƴ��hql��䣬���û�У���ֱ�ӷ�ҳ��ѯ
	
			for (int a = 0; a < list.size(); a++) {
                //��ʼƴ��
				ddhql[a] = " and " + list.get(a) + "  = " + map.get(list.get(a))+"";
				//Ȼ���������д��һ��ѭ��С������
				String c = pinhql(Hql.get(a), ddhql[a]);
				//�ü���+1��Ȼ���ٻ�ȥ���ã����������ֵ�  a+=b;
				Hql.add(c);
		}
			//����ƴ�Ӻõ�hql����ѯ��������������
      	return Hql.get(list.size()); 
	

  }
  //����ƴ��hql�����Ƶ�Сѭ�����ã����������
   public String pinhql(String Hql, String hql) {
		String finalHql = Hql + hql;
		return finalHql;
	}
   

}
