package model_pay;


public class Payed implements java.io.Serializable{
	private int id;
	private String itemname;
	private String day;
	private int money;

	public Payed(){}

	public Payed(int i ,String name,String day ,int money){
		this.id = i;
		this.itemname = name;
		this.day = day;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setitemname(String a){
		this.itemname = a;
	}

	public String getitemname(){
		return itemname;
	}

	public void setDay(String b){
		this.day = b;
	}

	public String getDay(){
		return day;
	}

	public void setMoney(int a){
		this.money = a;
	}

	public int getMoney(){
		return money;
	}
}

