package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.items.Item;


public class Arrow {
    private Factory _factory;

    public Arrow(Factory factory) {
        this._factory = factory;
    }
    public void ArrowHandler(){
        if(!_factory.getMain().getLocalPlayer().isMoving() && !_factory.getMain().getLocalPlayer().isInCombat() && _factory.getMain().get_CombatVariables().get_WindowVariables().isPickUpArrow()){
            TakeArrows();
        }
    }
    private void TakeArrows(){
        _factory.getInteractionUser().SetActivity("Take Arrows");
        for (int i = 0; i < GroundItems.all().size(); i++){
            GroundItem scannedItem = GroundItems.all().get(i);
            if(scannedItem.getName().toUpperCase().contains("ARROW")) {
                if(_factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                    scannedItem.interact(InteractionCenter.Take.toString());
                    _factory.getTime().setActionTime(0);
                    do {
                        if (BreakWhile()) {
                            break;
                        }
                        _factory.getMain().sleep(100, 500);
                    } while (scannedItem != null);
                    _factory.getTime().setActionTime(0);
                }
            }
        }
    }
    public void EquipArrow(){
        Item arrow;
        Tabs.open(Tab.INVENTORY);
        if(Equipment.getItemInSlot(EquipmentSlot.ARROWS.getSlot())  != null){
            arrow = Inventory.get(item -> item != null && item.getName().equals(Equipment.getItemInSlot(EquipmentSlot.ARROWS.getSlot()).getName()));
        }else{
            arrow = Inventory.get(item -> item.getName().toUpperCase().contains("ARROW") && item != null);
        }
        if(arrow != null ){
            _factory.getInteractionUser().SetActivity("Equip arrow");
            arrow.interact(InteractionCenter.Wield.toString());
        }
    }
    private boolean BreakWhile(){
        if(_factory.getTime().eclapsedsec(_factory.getTime().getActionTime()) == 0){
            _factory.getTime().setActionTime(System.currentTimeMillis());
        }else if(_factory.getTime().eclapsedsec(_factory.getTime().getActionTime()) > 30){
            return true;
        }
        return false;
    }
}
