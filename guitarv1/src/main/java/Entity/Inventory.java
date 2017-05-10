package Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private List<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<>();
	}

	public List<Guitar> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public void addGuitar(int serialNumber, Double price, String model, String builder, String type, String backWood,
			String topWood) {
		Guitar guitar = new Guitar(serialNumber, price, model, builder, type, backWood, topWood);
		guitars.add(guitar);
	}
    public Guitar getGuitar(int serialNumber){
    	for (Iterator iterator = guitars.iterator(); iterator.hasNext();) {
			Guitar guitar = (Guitar) iterator.next();
			if(guitar.getSerialNumber()==serialNumber){
				return guitar;
			}
		}
		return null;
    }
    public List<Guitar> search(Guitar searchGuitar){
    	List<Guitar> guitarlist = new ArrayList<>();
    	for (Iterator<Guitar> iterator = guitars.iterator(); iterator.hasNext();) {
			Guitar guitar = (Guitar) iterator.next();
			String builder=searchGuitar.getBuilder();
			if((builder!=null)&&(!builder.equals("")&&(!builder.equals(guitar.getBuilder()))))
				continue;
			
			String type=searchGuitar.getType();
			if((type!=null)&&(!type.equals("")&&(!type.equals(guitar.getType()))))
				continue;
			
			String model=searchGuitar.getModel();
			if((model!=null)&&(!model.equals("")&&(!model.equals(guitar.getModel()))))
				continue;
			
			String backWood=searchGuitar.getBackWood();
			if((backWood!=null)&&(!backWood.equals("")&&(!backWood.equals(guitar.getBackWood()))))
				continue;
			
			String topWood=searchGuitar.getTopWood();
			if((topWood!=null)&&(!topWood.equals("")&&(!topWood.equals(guitar.getTopWood()))))
				continue;
			guitarlist.add(guitar);
		}
		return guitarlist;
    }
}
