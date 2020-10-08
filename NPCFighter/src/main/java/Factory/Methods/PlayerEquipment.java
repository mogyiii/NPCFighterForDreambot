package Factory.Methods;

import org.dreambot.api.wrappers.items.Item;

public class PlayerEquipment {
    public static Item Hat;
    public static Item Chest;
    public static Item Weapon;
    public static Item Shield;
    public static Item Amulet;
    public static Item Legs;
    public static Item Feet;
    public static Item Ring;
    public static Item Cape;
    public PlayerEquipment(Item hat, Item chest, Item weapon, Item shield, Item amulet, Item legs, Item feet, Item ring, Item cape) {
        Hat = hat;
        Chest = chest;
        Weapon = weapon;
        Shield = shield;
        Amulet = amulet;
        Legs = legs;
        Feet = feet;
        Ring = ring;
        Cape = cape;
    }
}
