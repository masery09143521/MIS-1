package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Guitar {
  @Id
  @GeneratedValue()
  private int id;
  private String serialNumber;
  private double price;
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="spec_id",unique=true)
  private GuitarSpec spec;

  public Guitar(String serialNumber, double price, GuitarSpec spec) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = spec;
  }
  

  public Guitar() {
	super();
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(float newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return spec;
  }

public void setSpec(GuitarSpec spec) {
	this.spec = spec;
}
  
}
