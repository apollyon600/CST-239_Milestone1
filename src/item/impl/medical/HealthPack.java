package item.impl.medical;

import item.ItemCategory;
import item.Salable;

public class HealthPack extends Salable {

	public HealthPack(String name, ItemCategory category, double price, int quantity) {
		super(name, category, price, quantity);
	}

}
