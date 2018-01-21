package model_want;

public class wantlist implements java.io.Serializable{
	private int id;
	private String tradename;
	private String priority;
	private int amount;

	public wantlist(int i, String na, String pr,int mo){
		this.id = i;
		this.tradename = na;
		this.priority = pr;
		this.amount = mo;
	}

	public void setId(int a){
		this.id = a;
	}

	public int getId(){
		return id;
	}
	public void setTradename(String na){
		this.tradename = na;
	}

	public String getTradename(){
		return tradename;
	}

	public void setPriority(String a){
		this.priority = a;
	}

	public String getPriority(){
		return priority;
	}

	public void setAmount(int a){
		this.amount = a;
	}

	public int getAmount(){
		return amount;
	}
}
