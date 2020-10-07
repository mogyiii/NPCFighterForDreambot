package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {
    private Factory _factory;
    private Item[] StartedItems;
    private Item[] EquipmentItems;
    public Items(Factory factory) {
        _factory = factory;
    }
    public void setStartedItems(){
        StartedItems = new Item[Inventory.all().size()];
        for(int i = 0; i < Inventory.all().size() - 1; i++){
            StartedItems[i] = Inventory.all().get(i);
        }
    }

    public Item[] getStartedItems() {
        return StartedItems;
    }
    public List<Item> getStarterItemsList(){
        List<Item> ReturnItems = new ArrayList<>(Arrays.asList(StartedItems));
        return ReturnItems;
    }
    public void setEquipItems(){
        EquipmentItems = new Item[]{Equipment.get(EquipmentSlot.AMULET.toString()),
                Equipment.get(EquipmentSlot.SHIELD.toString()),
                Equipment.get(EquipmentSlot.WEAPON.toString()),
                Equipment.get(EquipmentSlot.HAT.toString()),
                Equipment.get(EquipmentSlot.LEGS.toString()),
                Equipment.get(EquipmentSlot.CHEST.toString()),
                Equipment.get(EquipmentSlot.CAPE.toString()),
                Equipment.get(EquipmentSlot.ARROWS.toString()),
                Equipment.get(EquipmentSlot.FEET.toString()),
                Equipment.get(EquipmentSlot.RING.toString()),
        };
    }

    public List<Item> getEquipmentItems() {
        List<Item> ReturnItems = new ArrayList<>(Arrays.asList(EquipmentItems));
        return ReturnItems;
    }
}
