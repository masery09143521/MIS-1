package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




//设计的一个用于拼接成根据参数查找的hql语句
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
	    //过滤空值
		for (int i = 0; i < canshu[1].length; i++) {
			if (canshu[1][i] != null && !"".equals(canshu[1][i])) {
				map.put(canshu[0][i], canshu[1][i]);
				list.add(canshu[0][i]);
			}else{
				continue;
			}
		}
        //次数创建了一个list集合，是为了下面的循环拼接hql语句
		List<String> Hql = new ArrayList<String>();
		//这里这么些是为了，拼接hql语句的时候，可以 为" and username=10 " 这样的类型，加在后面才不会多或少and
		String hql = "from "+entityname+"  where 1=1 ";
		//把这个hql放到我要拼接的Hql集合中，下面自有妙用
		Hql.add(hql);
		//创建一个空数组，为了拼接部分hql
		String[] ddhql = new String[list.size()];
		//判断传来的参数是否都有值，如果有值，则拼接hql语句，如果没有，则直接分页查询
	
			for (int a = 0; a < list.size(); a++) {
                //开始拼接
				ddhql[a] = " and " + list.get(a) + "  = " + map.get(list.get(a))+"";
				//然后调用下面写的一个循环小方法；
				String c = pinhql(Hql.get(a), ddhql[a]);
				//让集合+1，然后再回去调用，类似于数字的  a+=b;
				Hql.add(c);
		}
			//根据拼接好的hql语句查询符合条件的总数
      	return Hql.get(list.size()); 
	

  }
  //用于拼接hql语句设计的小循环调用，被上面调用
   public String pinhql(String Hql, String hql) {
		String finalHql = Hql + hql;
		return finalHql;
	}
   

}
