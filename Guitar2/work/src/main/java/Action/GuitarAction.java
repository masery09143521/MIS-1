package Action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import Entity.Builder;
import Entity.Guitar;
import Entity.GuitarSpec;
import Entity.Inventory;
import Entity.Type;
import Entity.Wood;
import Test.FindGuitarTester;

import net.sf.json.JSONObject;

public class GuitarAction extends BaseAction<Guitar> {
	public String serialNumber;
	public String price;
	public String model;
	private String builder, type, backWood, topWood;
	private int numberStrings;

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

	public int getNumberStrings() {
		return numberStrings;
	}

	public void setNumberStrings(int numberStrings) {
		this.numberStrings = numberStrings;
	}

	public String add() {
		FindGuitarTester find = new FindGuitarTester();
		Inventory inventory = new Inventory();
		List<Guitar> list = find.initializeInventory(inventory);
		for(Guitar g : list){
			guitarService.addGuitar(g);
		}
		System.out.println("success");
		return SUCCESS;
	}

	public String search() {
		String result = "";
		System.out.println("aaaa");
		Inventory inventory = new Inventory();
		inventory.setGuitars(guitarService.queryallGuitar());
	    GuitarSpec whatErinLikes = 
	    	      new GuitarSpec(builder, model, 
	    	                     type, numberStrings,backWood,topWood);
	    	    List matchingGuitars = inventory.search(whatErinLikes);
	    	    if (!matchingGuitars.isEmpty()) {
	    	      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	    	        Guitar guitar = (Guitar)i.next();
	    	        GuitarSpec spec = guitar.getSpec();
	    	        result = result  + "  We have a " +
	    	          spec.getBuilder() + " " + spec.getModel() + " " +
	    	          spec.getType() + " guitar:\n     " +
	    	          spec.getBackWood() + " back and sides,\n     " +
	    	          spec.getTopWood() + " top.\n  You can have it for only $" +
	    	          guitar.getPrice() + "!\n  ----<br>";
	    	      }
	    	    } else {
	    	      result = "Sorry, Erin, we have nothing for you.";
	    	    }
	    	    ActionContext.getContext().getSession().put("result", result);
		return SUCCESS;
	}
}
