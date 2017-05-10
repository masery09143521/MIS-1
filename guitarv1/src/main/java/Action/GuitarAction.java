package Action;

import com.opensymphony.xwork2.ActionContext;

import Entity.Guitar;
import Entity.Inventory;
import net.sf.json.JSONObject;

public class GuitarAction extends BaseAction<Guitar> {
	public String serialNumber;
	public String price;
	public String model;
	private String builder, type, backWood, topWood;

	public void setModel(String model) {
		this.model = model;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBackWood() {
		return backWood;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	public String getTopWood() {
		return topWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}

	public String add() {
		  Guitar guitar = new Guitar(1,100.00,"1厂","a模型","a类型","前面1","后面1");
		  Guitar guitar2 = new Guitar(2,100.00,"2厂","2模型","2类型","前面2","后面2");
		  Guitar guitar3 = new Guitar(3,100.00,"1厂","3模型","3类型","前面1","后面1");
		guitarService.addGuitar(guitar);
		guitarService.addGuitar(guitar2);
		guitarService.addGuitar(guitar3);
		ActionContext.getContext().getSession().put("result", "添加完成");	
		return SUCCESS;
		
	}

	public String search() {
		lists = guitarService.queryallGuitar();
		System.out.println(lists.size());
		Inventory inventory = new Inventory();
		inventory.setGuitars(lists);
		Guitar guitar = new Guitar();
		guitar.setBackWood(backWood);
		guitar.setTopWood(topWood);
		guitar.setBuilder(builder);
		guitar.setModel(model);
		guitar.setType(type);
		lists = inventory.search(guitar);
		System.out.println(lists.size());
		ActionContext.getContext().getSession().put("list", lists);	
		return SUCCESS;

	}
}
