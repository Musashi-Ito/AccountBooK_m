package model_want;

public class Wantlist implements java.io.Serializable{
	private int id;
	private String category;
	private String tradename;
	private int amount;
	private int priority;

	public Wantlist(int id, String category, String tradename,int priority, int amount){
		this.id = id;
		this.category = category;
		this.tradename = tradename;
		this.priority = priority;
		this.amount = amount;

	}


	public void setId(int a){
		this.id = a;
	}

	public int getId(){
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTradename(String na){
		this.tradename = na;
	}

	public String getTradename(){
		return tradename;
	}

	public void setPriority(int priority){
		this.priority = priority;
	}

	public int getPriority(){
		return priority;
	}

	public void setAmount(int a){
		this.amount = a;
	}

	public int getAmount(){
		return amount;
	}
}
