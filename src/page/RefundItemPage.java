package page;

import item.Salable;
import user.User;

public class RefundItemPage extends Page {

	private Salable salable;
	private int ownedItem;
	
	public RefundItemPage(Salable salable) {
		this.salable = salable;
	}
	
	@Override
	public void load(User user) {
		clear();
		this.ownedItem = user.getInventory().stream().filter(i -> i.getName().equals(salable.getName())).toList().size();
		System.out.println(LINE);
		System.out.println("\tHow much of " + salable.getName() + " do you want to refund?");
		System.out.println("\t\t\t  You got x" + ownedItem + " left");
		System.out.println("\t\t    Each " + salable.getName() + " is $" + salable.getPrice());
		System.out.println(LINE);
		System.out.println("\t\t  Type how much you want to refund.");
		System.out.print("\t\t\t\t");
	}

	@Override
	public Page handle(User user, int option) {
		if (option > ownedItem || option <= 0) return this;
		salable.setQuantity(salable.getQuantity() + option);
		user.addBalance(salable.getPrice() * option);
		for (int i = 0; i < option; i++)
			user.getInventory().remove(this.salable);
		return new RefundPage();
	}

}
