package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.wrappers.items.Item;

import java.util.*;

public class Items {
    private Factory _factory;
    private Item[] StartedItems;
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
        /*for(int i = 0; i < StartedItems.length; i++){
            ReturnItems.add(StartedItems[i]);
        }*/
        return ReturnItems;
    }

}
