package item;

public enum ItemCategory {
	WEAPON("Weapon"),
	ARMOR("Armor"),
	MEDICAL("Medical");
	
	private final String name;
	
	ItemCategory(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
