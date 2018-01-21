package model_fix;



public class Fixity implements java.io.Serializable{
	private int id;
	//private int balance;
	//private int goal;
	private String type;
	private int money;
	private int day;

	public Fixity(){
		 //this.balance = 0;
		 //this.goal = 0;
	}

	public Fixity(int id,String type,int money, int day){
		this.id = id;
		this.type = type;
		this.money = money;
		this.day = day;
	}

	/*
	public Fixity(int ba, int go){
		this.balance = ba;
		this.goal = go;
	}


	public void setBalance(int a){
		this.balance = a;
	}

	public int getBalance(){
		return balance;
	}

	public void setGoal(int a){
		this.goal = a;
	}

	public int getGoal(){
		return goal;
	}
	*/

	public void setId(int a){
		this.id = a;
	}

	public int getId(){
		return id;
	}

	public void setMoney(int a){
		this.money = a;
	}

	public int getMoney(){
		return money;
	}

	public void setType(String b){
		this.type = b;
	}
	public String getType(){
		return type;
	}

	public void setDay(int c){
		this.day = c;
	}

	public int getDay(){
		return day;
	}

}
