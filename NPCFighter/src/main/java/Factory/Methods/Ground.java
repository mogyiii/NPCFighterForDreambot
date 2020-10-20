package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.items.GroundItem;
import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Moduls.GrandExchangeApi.GELookupResult;

public class Ground {
    private Factory _factory;
    private String[] BonesName = {"Searing ashes", "Reinforced dragon bones", "Frost dragon bones", "Hardened dragon bones", "Ourg bones", "Ourg bones", "Airut bones", "Dagannoth bones", "Raurg bones","Tortured ashes", "Fayrg bones", "Dragon bones", "Infernal ashes", "Wyvern bones", "Baby dragon bones", "Shaikahan bones", "Zogre bones", "Jogre bones", "Big bones", "Accursed ashes", "Bat bones","Monkey bones", "Burnt bones", "Wolf bones", "Bones", "Impious ashesImpious ashes"};

    private List<GroundItem> GroundItemsArray;
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
            }
        }
    }
    public void TakeSelectedItem(){
        GroundItemsArray = new ArrayList<>();
        CheckGrave();
        TakeList();
        TakeHightValueItem();
        //CheckEquipmentItems();
        TakeBones();
        TakeItemsFromGround();
    }
    private void TakeList(){
        for(int i = 0; i < GroundItems.all().size(); i++){
            //Take List
            for(int j = 0; j < _factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems().length; j++){
                GroundItem scannedItem = GroundItems.all().get(i);
                if(scannedItem.toString().toUpperCase().equals(_factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems()[j].toUpperCase())){
                    if (_factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                        GroundItemsArray.add(scannedItem);
                    }
                }
            }
        }
    }
    private void TakeHightValueItem(){
        //Take Hight Value Item
        for (int j = 0; j < GroundItems.all().size(); j++){
            GroundItem scannedItem = GroundItems.all().get(j);
            //_factory.getMain().log("Size: " + GroundItems.all().size() + " Name: " + scannedItem.getName() + " ID: " + scannedItem.getID());
            if(scannedItem.getID() != 995 && scannedItem.getItem().isTradable()){
                GELookupResult lookupResult = _factory.getGrandExchangeApi().lookup(scannedItem.getID());
                if(lookupResult.price >= _factory.getMain().get_CombatVariables().get_WindowVariables().getPickupItemCost() && lookupResult != null){
                    if (_factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                        GroundItemsArray.add(scannedItem);
                    }
                }
            }
        }
    }
    private void CheckGrave(){
        GameObject Grave =GameObjects.closest(grave -> grave != null && grave.hasAction("Loot"));
        if(Grave != null){
            _factory.getMain().log("Looting Grave!");
            _factory.getInteractionUser().SetActivity("Looting Grave!");
            Mouse.click(Grave);
            Grave.hasAction(InteractionCenter.Loot.toString());
            _factory.getMain().sleep(400, 600);
            for(int j = 0; j < _factory.getPlayerEquipment().GetEquipmentItems().size(); j++){
                EquipItem(_factory.getPlayerEquipment().GetEquipmentItems().get(j).getName());
            }
        }
    }
    private void CheckEquipmentItems(){
        //CheckEquipment items
        /*if(_factory.getBotArea().getWalkToArea().contains(_factory.getMain().getLocalPlayer().getTile())){
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
                                } while (IndexedGroundItem != null || !_factory.getMain().getLocalPlayer().isMoving());
                                _factory.getTime().setActionTime(0);
                                _factory.getMain().sleep(1000, 2000);
                                EquipItem(IndexedGroundItem);
                            }
                        }
                    }
                }
            }
        }*/
    }
    public void TakeBones(){
        _factory.getInteractionUser().SetActivity("Take Bones");
        String groundItem = GroundcheckBones();
        if(!groundItem.isEmpty()){
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
                GroundItemsArray.add(closesItems.getSelectedItem());
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
        for(int i = 0; i < BonesName.length; i++) {
            for(int j = 0; j < GroundItems.all().size(); j++){
                if(GroundItems.all().get(j).toString().equals(BonesName[i])){
                    return BonesName[i];
                }
            }

        }
        return "";
    }
    public String CheckInvertory(){
        for(int i = 0; i < BonesName.length; i++) {
            if (Inventory.contains(BonesName[i])){
                return BonesName[i];
            }
        }
        return  "";
    }
    private void EquipItem(String ItemName){
        Item checkitem = Inventory.get(item -> item != null && item.getName().equals(ItemName));
        if (checkitem != null && Inventory.contains(checkitem.getName()) && !Equipment.contains(checkitem.getName())) {
            List<String> ActionList = Arrays.asList(checkitem.getActions());
            if(ActionList.contains(InteractionCenter.Equip.toString())){
                checkitem.interact(InteractionCenter.Equip.toString());
            }else if(ActionList.contains(InteractionCenter.Wield.toString())){
                checkitem.interact(InteractionCenter.Wield.toString());
            }else if(ActionList.contains(InteractionCenter.Wear.toString())){
                checkitem.interact(InteractionCenter.Wear.toString());
            }
        }
    }
    private void TakeItemsFromGround() {
        for(int indexGroundItems = 0; indexGroundItems < GroundItemsArray.size(); indexGroundItems++){
            GroundItem groundItem = GroundItemsArray.get(indexGroundItems);
            if (groundItem.exists()) {
                ClosesItem closesItems = new ClosesItem();
                closesItems.setCost(99);
                closesItems.setIndex(-1);
                for (int i = 0; i < GroundItemsArray.size(); i++) {
                    GroundItem scannedItem = GroundItemsArray.get(i);
                    if (closesItems.getCost() > Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(), scannedItem.getTile()).size() && _factory.getBotArea().getWalkToArea().contains(scannedItem.getTile())) {
                        closesItems.setCost(Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(), scannedItem.getTile()).size());
                        closesItems.setIndex(i);
                        closesItems.setSelectedItem(scannedItem);
                    }
                }
                if (closesItems.getIndex() != -1) {
                    if(Inventory.isFull() && !CheckInvertory().equals("")){
                        BuryBones();
                    }else{
                        closesItems.getSelectedItem().interact(InteractionCenter.Take.toString());
                    }
                    _factory.getTime().setActionTime(0);
                    do {
                        if (BreakWhile()) {
                            break;
                        }
                        _factory.getMain().sleep(100, 500);
                    } while (closesItems.getSelectedItem().exists() || !_factory.getMain().getLocalPlayer().isMoving());
                    _factory.getTime().setActionTime(0);
                    _factory.getMain().sleep(1000, 2000);
                }
            }
        }

    }
}
