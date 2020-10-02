package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.item.GroundItems;
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
        for (int i = 0; i < _factory.getMain().getGroundItems().all().size(); i++){
            if(GroundItems.all().get(i).getName().toUpperCase().contains("ARROW")) {
                GroundItems.all().get(i).interact(InteractionCenter.Take.toString());
                do {
                    _factory.getMain().sleep(100, 500);
                } while (GroundItems.all().get(i) != null || _factory.getMain().getLocalPlayer().isMoving());
            }
        }
    }
    public void EquipArrow(){
        Item arrow = Inventory.get(item -> item.getName().equals(EquipmentSlot.ARROWS.name()) && EquipmentSlot.ARROWS != null);
        if(arrow != null){
            arrow.interact(InteractionCenter.Equip.toString());
        }else{
            Inventory.get(item -> item.getName().toUpperCase().contains("ARROW") && item != null).interact(InteractionCenter.Equip.toString());
        }
    }
}
