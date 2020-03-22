package atm;

public class User {
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String stk;
	private String name;
	private String pin;
	private int money;
	
	
	
	
	public User(String stk, String name, String pin, int money) {
		super();
		this.stk = stk;
		this.name = name;
		this.pin = pin;
		this.money = money;
	}
	
	
	public String getStk() {
		return stk;
	}
	public void setStk(String stk) {
		this.stk = stk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
