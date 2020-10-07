package Factory.Methods;

import org.dreambot.api.wrappers.items.GroundItem;

public class ClosesItem {
    private int Cost;
    private int index;
    private GroundItem selectedItem;
    public ClosesItem() {
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GroundItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(GroundItem selectedItem) {
        this.selectedItem = selectedItem;
    }
}
