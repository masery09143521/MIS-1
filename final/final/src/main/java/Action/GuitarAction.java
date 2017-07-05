package Action;

import Entity.Guitar;
import Entity.Inventory;
import Util.SearchBackge;
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

	public String addGuitar() {
		Guitar guitar = new Guitar(1, 1.00, "1", "1", "1", "1", "1");
		guitarService.addGuitar(guitar);
		return "jsonArray";
	}

	public String queryAllGuitar() {

		SearchBackge searchBackge = new SearchBackge();
		String[][] strings = { { "serialNumber", "price", "model", "builder", "type", "backWood", "topWood" },
				{ serialNumber, price, model, builder, type, backWood, topWood } };
		String hql = searchBackge.selectByParam(strings, "Guitar");
		System.out.println(hql);
		lists = guitarService.queryallGuitar(hql);
		if(lists.size()>0){
			if(serialNumber!=null){			
				maps.put("rows", lists);
			}else{
				Guitar guitar=new Guitar();
				guitar.setBuilder("all Guitar");
				lists.add(guitar);
				maps.put("rows", lists);
			}		
		}else{
			jsonObject.put("serialNumber", "sorry ,nothing£¡");
			jsonArray.add(jsonObject);
			maps.put("rows", jsonArray);
		}
		

		return "maps";
	}
}
