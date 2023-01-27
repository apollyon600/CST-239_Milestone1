package item;

import java.util.ArrayList;
import java.util.List;

import item.impl.armor.Boots;
import item.impl.armor.Chestplate;
import item.impl.armor.Helmet;
import item.impl.armor.Leggings;
import item.impl.medical.HealthPack;
import item.impl.weapon.Knife;
import item.impl.weapon.Sword;

public class Items {
	
	public static final List<Salable> ALL = new ArrayList<>();

	public static final Knife KNIFE = new Knife("Knife", ItemCategory.WEAPON, 100.00D, 20);
	public static final Sword SWORD = new Sword("Sword", ItemCategory.WEAPON, 500.00D, 20);
	public static final Helmet HELMET = new Helmet("Helmet", ItemCategory.ARMOR, 250.00D, 10);
	public static final Chestplate CHESTPLATE = new Chestplate("Chestplate", ItemCategory.ARMOR, 350.00D, 10);
	public static final Leggings LEGGINGS = new Leggings("Leggings", ItemCategory.ARMOR, 300.00D, 10);
	public static final Boots BOOTS = new Boots("Boots", ItemCategory.ARMOR, 250.00D, 10);
	public static final HealthPack HEALTH_PACK = new HealthPack("Health Pack", ItemCategory.MEDICAL, 100.00D, 50);
	
}
