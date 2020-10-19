package Factory.Methods;

import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public List<Item> GetEquipmentItems(){
        List<Item> equipmentitems = new ArrayList<>(Arrays.asList());

        if(Hat != null){
            equipmentitems.add(Hat);
        }
        if(Chest != null){
            equipmentitems.add(Chest);
        }
        if(Weapon != null){
            equipmentitems.add(Weapon);
        }
        if(Shield != null){
            equipmentitems.add(Shield);
        }
        if(Amulet != null){
            equipmentitems.add(Amulet);
        }
        if(Legs != null){
            equipmentitems.add(Legs);
        }
        if(Feet != null){
            equipmentitems.add(Feet);
        }if(Ring != null){
            equipmentitems.add(Ring);
        }if(Cape != null){
            equipmentitems.add(Cape);
        }
        return equipmentitems;
    }
}
