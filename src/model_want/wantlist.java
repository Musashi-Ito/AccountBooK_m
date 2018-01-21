package model_want;

public class wantlist implements java.io.Serializable{
	private String type;
	private String name;
	private String priority;
	private int money;

	public wantlist(String ty, String na, String pr,int mo){
		this.type = ty;
		this.name = na;
		this.priority = pr;
		this.money = mo;
	}

	public void setType(String a){
		this.type = a;
	}

	public String getType(){
		return type;
	}
	public void setName(String na){
		this.name = na;
	}

	public String getName(){
		return name;
	}

	public void setPriority(String a){
		this.priority = a;
	}

	public String getPriority(){
		return priority;
	}

	public void setMoney(int a){
		this.money = a;
	}

	public int getMoney(){
		return money;
	}
}
