package item;

import user.User;

public abstract class Salable {

	private final ItemCategory category;
	private final double price;
	private final String name;
	private int quantity; 
	
	public Salable(String name, ItemCategory category, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		Items.ALL.add(this);
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public ItemCategory getCategory() {
		return this.category;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void purchase(User user) {
		if (user.getBalance() < this.getPrice()) {
			System.out.println("You cannot afford this item!");
			return;
		}
		
		user.subBalance(this.getPrice());
		user.getInventory().add(this);
		
		System.out.println("You have purchased " + this.getName() + " for $" + this.getPrice());
	}
	
	public void refund(User user) {		
		if (!user.getInventory().contains(this)) {
			System.out.println("You do not own this item!");
			return;
		}
		
		System.out.println("You have sold " + this.getName() + " for $" + this.getPrice());
		user.addBalance(this.getPrice());
	}
	
}
