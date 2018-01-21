

public class Payed implements java.io.Serializable{
	private int id;
	private String name;
	private String day;
	private int money;
	
	public Payed(){}

	public Payed(String name,String day ,int money){
		this.name = name;
		this.day = day;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String a){
		this.name = a;
	}

	public String getName(){
		return name;
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

