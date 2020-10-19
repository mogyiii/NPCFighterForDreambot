package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
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
        String groundItem = GroundcheckArrow();
        if(groundItem.isEmpty()){

        }else {
            ClosesItem closesItems = new ClosesItem();
            closesItems.setCost(99);
            closesItems.setIndex(-1);
            for (int i = 0; i < GroundItems.all(groundItem).size(); i++) {
                GroundItem scannedItem = GroundItems.all(groundItem).get(i);
                if(closesItems.getCost() > Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(),scannedItem.getTile()).size() && _factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                    closesItems.setCost(Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(), scannedItem.getTile()).size());
                    closesItems.setIndex(i);
                    closesItems.setSelectedItem(scannedItem);
                }
                    if (_factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                        closesItems.getSelectedItem().interact(InteractionCenter.Take.toString());
                        _factory.getTime().setActionTime(0);
                        if(closesItems.getIndex() != -1) {
                            do {
                                _factory.getMain().sleep(500, 1000);
                                if (BreakWhile()) {
                                    break;
                                }
                            } while (closesItems.getSelectedItem().exists() || !_factory.getMain().getLocalPlayer().isMoving());
                            _factory.getTime().setActionTime(0);
                        }
                    }
            }
        }
    }
    public void EquipArrow(){
        Item arrow = null;
        Tabs.open(Tab.INVENTORY);
        if(Equipment.getItemInSlot(EquipmentSlot.ARROWS.getSlot())  != null){
            arrow = Inventory.get(item -> item != null && item.getName().equals(Equipment.getItemInSlot(EquipmentSlot.ARROWS.getSlot()).getName()));
        }else if(Inventory.contains("Arrow")){
            arrow = Inventory.get(item -> item.getName().toUpperCase().contains("ARROW") && item != null);
        }
        if(arrow != null && !_factory.getMain().getLocalPlayer().isMoving()){
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
    public String GroundcheckArrow(){

            for(int j = 0; j < GroundItems.all().size(); j++){
                if(GroundItems.all().get(j).getName().toUpperCase().contains("ARROW")){
                    return GroundItems.all().get(j).getName();
                }
            }


        return "";
    }
}
