package page;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import item.Items;
import item.Salable;
import user.User;

public class StoreFront extends Page {

	private Map<Integer, Salable> contents = new HashMap<>();
	private int exitOption;

	@Override
	public void load(User user) {
		clear();
		contents = new HashMap<>();
		List<Salable> items = Items.ALL;
		System.out.println(LINE);
		System.out.println("\t\t\t   Store Front");
		System.out.println("\t\t       Your Balance: $" + user.getBalance());
		System.out.println(LINE);
		System.out.println(
				String.format(" %-4s | %-11s | %-11s | %-6s\t| %s", "Id", "Name", "Category", "Price", "Quantity"));
		System.out.println(LINE);
		items.sort((a, b) -> a.getCategory().compareTo(b.getCategory()));
		int index = 1;
		for (Salable salable : items) {
			contents.put(index, salable);
			if (salable.getQuantity() > 0)
				System.out.println(String.format(" %-4s | %-11s | %-11s | $%s\t| x%-2s In Stock", index++,
					salable.getName(), salable.getCategory(), salable.getPrice(), salable.getQuantity()));
		}
		contents.put(index, null);
		System.out.println(LINE);
		System.out.println(String.format("\t\t    Type %s to go back to menu.", index));
		System.out.println("\t\t  Type the corresponding number");
		System.out.print("\t\t\t\t");
		this.exitOption = index;
	}

	@Override
	public Page handle(User user, int option) {
		if (option == this.exitOption)
			return new HomePage();
		Salable chosenItem = contents.get(option);
		if (chosenItem == null)
			return this;
		if (chosenItem.getQuantity() == 0)
			return this;
		return new PurchaseItemPage(chosenItem);
	}

}
