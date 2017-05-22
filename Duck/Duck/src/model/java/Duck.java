package model.java;

public abstract class Duck {  
	private FlyBehavior ﬂyBehavior;
	private QuackBehavior quackBehavior;
  
	 public  String swim(){
	        return "会游泳";
	    }
	 public String display(){
	        return null;
	    }
	    public String performQuack() {
	    	 return quackBehavior.quack();
	    }
	    public String performFly() {
			 return ﬂyBehavior.fly();
		}
	    public void setQuackBehavior(QuackBehavior quackBehavior) {
	    	this.quackBehavior = quackBehavior;
		}

		public void setFlyBehavior(FlyBehavior flyBehavior) {
			this.ﬂyBehavior = ﬂyBehavior;
		}
	 }
