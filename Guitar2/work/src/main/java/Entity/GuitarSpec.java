package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class GuitarSpec {
  @Id
  @GeneratedValue()
  private int spec_id;
  private String builder; 
  private String model;
  private String type;
  private int numStrings;
  private String backWood;
  private String topWood;

  public GuitarSpec(String builder, String model, String type,
                    int numStrings, String backWood, String topWood) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.numStrings = numStrings;
    this.backWood = backWood;
    this.topWood = topWood;
  }

public GuitarSpec() {
	super();
}



public int getSpec_id() {
	return spec_id;
}



public void setSpec_id(int spec_id) {
	this.spec_id = spec_id;
}





  public String getModel() {
    return model;
  }



  public int getNumStrings() {
    return numStrings;
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



public boolean matches(GuitarSpec otherSpec) {
    if ((builder != null) && (!builder.equals("")) &&
            (!builder.toLowerCase().equals(otherSpec.builder.toLowerCase())))
      return false;
    if ((model != null) && (!model.equals("")) &&
        (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
      return false;
    if ((type != null) && (!type.equals("")) &&
            (!type.toLowerCase().equals(otherSpec.type.toLowerCase())))
      return false;
    if (numStrings != otherSpec.numStrings)
      return false;
    if ((backWood != null) && (!backWood.equals("")) &&
            (!backWood.toLowerCase().equals(otherSpec.backWood.toLowerCase())))
      return false;
    if ((topWood != null) && (!topWood.equals("")) &&
            (!topWood.toLowerCase().equals(otherSpec.topWood.toLowerCase())))
      return false;
    return true;
  }
}
