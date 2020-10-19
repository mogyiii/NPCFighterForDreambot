package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {
    private Factory _factory;
    private List<Item> StartedItems;
    private Item[] PlayerEquipmentsStarted;
    public Items(Factory factory) {
        _factory = factory;
    }
    public void setStartedItems(){
        StartedItems = Inventory.all();
    }
    public List<Item> getStarterItemsList(){
        return StartedItems;
    }
    public Filter<Item> getStarterItemsFilter(){
        return (Filter<Item>) StartedItems;
    }
    public boolean CheckEquipmentItems(){
        PlayerEquipmentsStarted = new Item[]{
                PlayerEquipment.Amulet,
                PlayerEquipment.Shield,
                PlayerEquipment.Weapon,
                PlayerEquipment.Hat,
                PlayerEquipment.Legs,
                PlayerEquipment.Chest,
                PlayerEquipment.Cape,
                PlayerEquipment.Feet,
                PlayerEquipment.Ring,
        };

        return Equipment.contains(new ArrayList<>(Arrays.asList(PlayerEquipmentsStarted)));
    }
}
