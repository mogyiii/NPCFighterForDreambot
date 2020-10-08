package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
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
        _factory.getInteractionUser().SetActivity("Take Arrows");
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
        Item arrow;
        if(Equipment.getItemInSlot(EquipmentSlot.ARROWS.getSlot())  != null){
            arrow = Inventory.get(item -> item != null && item.getName().equals(Equipment.getItemInSlot(EquipmentSlot.ARROWS.getSlot()).getName()));
        }else{
            arrow = Inventory.get(item -> item.getName().toUpperCase().contains("ARROW") && item != null);
        }
        if(arrow != null ){
            _factory.getInteractionUser().SetActivity("Equip arrow");
            arrow.interact(InteractionCenter.Equip.toString());
        }
    }
}
