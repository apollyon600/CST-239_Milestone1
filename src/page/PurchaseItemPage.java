package page;

import item.Salable;
import user.User;

public class PurchaseItemPage extends Page {

	private Salable item;
	
	public PurchaseItemPage(Salable item) {
		this.item = item;
	}
	
	@Override
	public void load(User user) {
		clear();
		System.out.println(LINE);
		System.out.println("\tHow much of " + item.getName() + " do you want to purchase?");
		System.out.println("\t\t\tWe got x" + item.getQuantity() + " In Stock");
		System.out.println("\t\t    Each " + item.getName() + " is $" + item.getPrice());
		System.out.println(LINE);
		System.out.println("\t\t  Type how much you want to buy");
		System.out.print("\t\t\t\t ");

	}

	@Override
	public Page handle(User user, int option) {
		if (option > item.getQuantity() || option <= 0) return this;
		item.setQuantity(item.getQuantity() - option);
		for (int i = 0; i < option; i++) 
			user.getInventory().add(item);
		return new StoreFront();
	}

}
