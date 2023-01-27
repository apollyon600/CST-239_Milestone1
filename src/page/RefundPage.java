package page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import item.Salable;
import user.User;

public class RefundPage extends Page {

	private Map<Integer, Salable> contents = new HashMap<>();
	
	@Override
	public void load(User user) {
		clear();
		System.out.println(LINE);
		System.out.println("\t\t\t   Refund Item");
		System.out.println("\t\t       Your Balance: $" + user.getBalance());
		List<Salable> ownedItems = user.getInventory();
		if (ownedItems.size() > 0) {
			System.out.println(LINE); 	
			System.out.println(
					String.format(" %-4s | %-11s | %-11s | %-6s\t| %s", "Id", "Name", "Category", "Worth", "Amount"));
		}
		System.out.println(LINE);
		ownedItems.sort((a, b) -> a.getCategory().compareTo(b.getCategory()));
		int index = 1;
		for (Salable salable : ownedItems) {
			if (contents.containsValue(salable)) continue;
			contents.put(index, salable);
			System.out.println(String.format(" %-4s | %-11s | %-11s | $%s\t| x%-2s Left", index++,
					salable.getName(), salable.getCategory(), salable.getPrice(), ownedItems.stream().filter(i -> i.getName().equals(salable.getName())).toList().size()));
		}
		if (ownedItems.size() == 0)
			System.out.println("\t\t   You do not own anything yet!");
		System.out.println(LINE);
		System.out.println(String.format("\t\t    Type %s to go back to menu.", index));
		if (ownedItems.size() > 0)
			System.out.println("\t\t  Type the corresponding number");
		System.out.print("\t\t\t\t");
	}

	@Override
	public Page handle(User user, int option) {
		if (option == contents.size() + 1) return new HomePage();
		Salable item = contents.get(option);
		if (item == null) return this;
		return new RefundItemPage(item);
	}

}
