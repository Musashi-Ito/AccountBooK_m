package model;

public class UserMoney  implements java.io.Serializable{
	private int id = -1; //setting.jsp用。別に初期値の0でも問題ないはず。
	private int balance;
	private int goal;

	public UserMoney(){
		 this.setBalance(0);
		 this.setGoal(0);
	}

	public UserMoney(int balance, int goal){
		this.setBalance(balance);
		this.setGoal(goal);
	}

	public UserMoney(int id, int balance, int goal) {
		this.setId(id);
		this.setBalance(balance);
		this.setGoal(goal);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}
}
