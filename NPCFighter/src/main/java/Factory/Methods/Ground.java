package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.items.Item;

import static Moduls.GrandExchangeApi.GELookupResult;

public class Ground {
    private Factory _factory;
    private String[] Bones = {"Searing ashes", "Reinforced dragon bones", "Frost dragon bones", "Hardened dragon bones", "Ourg bones", "Ourg bones", "Airut bones", "Dagannoth bones", "Raurg bones","Tortured ashes", "Fayrg bones", "Dragon bones", "Infernal ashes", "Wyvern bones", "Baby dragon bones", "Shaikahan bones", "Zogre bones", "Jogre bones", "Big bones", "Accursed ashes", "Bat bones","Monkey bones", "Burnt bones", "Wolf bones", "Bones", "Impious ashesImpious ashes"};
    public Ground(Factory factory) {
        _factory = factory;
    }
    public void BonesHandle(){
        if(!_factory.getMain().getLocalPlayer().isInCombat() && _factory.getMain().get_CombatVariables().get_WindowVariables().isBuryBones()){
            Item item = Inventory.get(Item -> Item != null && Item.hasAction(InteractionCenter.Bury.toString()));
            if(Inventory.isFull() && item != null){
                BuryBones();
                _factory.getInteractionUser().SetActivity("Bury bones");
            }else{
                _factory.getInteractionUser().SetActivity("Take items");
                TakeSelectedItem();
                TakeBones();
            }
        }
    }
    public void TakeSelectedItem(){
        for(int i = 0; i < GroundItems.all().size(); i++){
            //Take List
            for(int j = 0; j < _factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems().length; j++){
                GroundItem scannedItem = GroundItems.all().get(i);
                if(scannedItem.toString().toUpperCase().equals(_factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems()[j].toUpperCase())){
                    if(_factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())){
                        scannedItem.interact(InteractionCenter.Take.toString());
                        do{
                            if(BreakWhile()){
                                break;
                            }
                            _factory.getMain().sleep(100, 500);
                        }while (scannedItem != null || _factory.getMain().getLocalPlayer().isMoving());
                        _factory.getTime().setActionTime(0);
                    }
                }
            }
        }
        //Take Hight Value Item
        for (int j = 0; j < GroundItems.all().size(); j++){
            GroundItem scannedItem = GroundItems.all().get(j);
            //_factory.getMain().log("Size: " + GroundItems.all().size() + " Name: " + scannedItem.getName() + " ID: " + scannedItem.getID());
            if(scannedItem.getID() != 995){
                GELookupResult lookupResult = _factory.getGrandExchangeApi().lookup(scannedItem.getID());
                if(lookupResult.price >= _factory.getMain().get_CombatVariables().get_WindowVariables().getPickupItemCost() && lookupResult != null){
                    if(_factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())){
                        scannedItem.interact(InteractionCenter.Take.toString());
                        do{
                            if(BreakWhile()){
                                break;
                            }
                            _factory.getMain().sleep(100, 500);
                        }while (scannedItem != null || _factory.getMain().getLocalPlayer().isMoving());
                        _factory.getTime().setActionTime(0);
                    }
                }
            }
        }
        //CheckEquipment items
        if(_factory.getBotArea().getWalkToArea().contains(_factory.getMain().getLocalPlayer().getTile())){
            if(!_factory.getItems().CheckEquipmentItems()){
                for(int j = 0; j < GroundItems.all().size(); j++){
                    GroundItem IndexedGroundItem = GroundItems.all().get(j);
                    for(int i = 0; i < _factory.getItems().getStarterItemsList().size(); i++){
                        Item IndexedItem = _factory.getItems().getStarterItemsList().get(i);
                        if(IndexedItem == null){

                        } else if(IndexedGroundItem.getName().equals(IndexedItem.getName())) {
                            if (_factory.getBotArea().getWalkToArea().contains(IndexedGroundItem.getTile())) {
                                IndexedGroundItem.interact(InteractionCenter.Take.toString());
                                do {
                                    if (BreakWhile()) {
                                        break;
                                    }
                                    _factory.getMain().sleep(100, 500);
                                } while (IndexedGroundItem != null || _factory.getMain().getLocalPlayer().isMoving());
                                _factory.getTime().setActionTime(0);
                                if (Inventory.contains(IndexedGroundItem.getName()) && !Equipment.contains(IndexedGroundItem.getName())) {
                                    IndexedGroundItem.interact(InteractionCenter.Equip.toString());
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public void TakeBones(){
        _factory.getInteractionUser().SetActivity("Take Bones");
        String groundItem = GroundcheckBones();
        if(groundItem.isEmpty()){

        }else{
            ClosesItem closesItems = new ClosesItem();
            closesItems.setCost(99);
            closesItems.setIndex(-1);
            for(int i = 0; i < GroundItems.all(groundItem).size(); i++)
            {
                GroundItem scannedItem = GroundItems.all(groundItem).get(i);
                if(closesItems.getCost() > Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(),scannedItem.getTile()).size() && _factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                    closesItems.setCost(Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(), scannedItem.getTile()).size());
                    closesItems.setIndex(i);
                    closesItems.setSelectedItem(scannedItem);
                }
            }
            if(closesItems.getIndex() != -1){
                do {
                    if(BreakWhile()){
                        break;
                    }
                    _factory.getMain().sleep(100, 500);
                } while (closesItems.getSelectedItem() != null || _factory.getMain().getLocalPlayer().isMoving());
                _factory.getTime().setActionTime(0);
            }
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
    private void BuryBones(){
        _factory.getInteractionUser().SetActivity("Bury Bones");
        while(Inventory.contains(CheckInvertory())){
            if (Inventory.contains(CheckInvertory())){
                Inventory.interact(CheckInvertory(), InteractionCenter.Bury.toString());
                _factory.getInterfaceGraphics().setBuriedBones(_factory.getInterfaceGraphics().getBuriedBones() + 1);
                _factory.getMain().sleep(800, 1300);
            }
        }
    }
    public String GroundcheckBones(){
        for(int i = 0; i < Bones.length; i++) {
            for(int j = 0; j < GroundItems.all().size(); j++){
                if(GroundItems.all().get(j).toString().equals(Bones[i])){
                    return Bones[i];
                }
            }

        }
        return "";
    }
    public String CheckInvertory(){
        for(int i = 0; i < Bones.length; i++) {
            if (Inventory.contains(Bones[i])){
                return Bones[i];
            }
        }
        return  "";
    }

}
