package user;

import java.util.ArrayList;
import java.util.List;

import item.Salable;

public class User {

	private List<Salable> inventory;
	private double balance;
	
	public User() {
		this.inventory = new ArrayList();
	}

	public List<Salable> getInventory() {
		return this.inventory;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void addBalance(double balance) {
		this.balance += balance;
	}
	
	public void subBalance(double balance) {
		this.balance -= balance;
	}
	
}
