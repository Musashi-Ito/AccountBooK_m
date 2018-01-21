package model;

public class User implements java.io.Serializable{
	private int id = -1; //mypageの例外処理用に明記。別に初期値の0でもいい。
	private String address;
	private String pwd;
	private String name;

	public User(String name,String address, String pwd){
		this.name = name;
		this.address = address;
		this.pwd = pwd;
	}

	public User(String address, String pwd){
		this.address = address;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
