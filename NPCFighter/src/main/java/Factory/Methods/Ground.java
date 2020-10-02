package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.walking.impl.Walking;

import static Moduls.GrandExchangeApi.*;

public class Ground {
    private Factory _factory;
    private String[] Bones = {"Searing ashes", "Reinforced dragon bones", "Frost dragon bones", "Hardened dragon bones", "Ourg bones", "Ourg bones", "Airut bones", "Dagannoth bones", "Raurg bones","Tortured ashes", "Fayrg bones", "Dragon bones", "Infernal ashes", "Wyvern bones", "Baby dragon bones", "Shaikahan bones", "Zogre bones", "Jogre bones", "Big bones", "Accursed ashes", "Bat bones","Monkey bones", "Burnt bones", "Wolf bones", "Bones", "Impious ashesImpious ashes"};
    public Ground(Factory factory) {
        _factory = factory;
    }
    public void BonesHandle(){
        if(!_factory.getMain().getLocalPlayer().isInCombat() && _factory.getMain().get_CombatVariables().get_WindowVariables().isBuryBones()){
            if(Inventory.isFull()){
                BuryBones();
            }else{
                TakeSelectedItem();
                TakeBones();
            }
        }
    }
    public void TakeSelectedItem(){
        for(int i = 0; i < GroundItems.all().size(); i++){
            //TakeList
            for(int j = 0; j < _factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems().length; j++){
                if(GroundItems.all().get(i).toString().toUpperCase().equals(_factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems()[j].toUpperCase())){
                    GroundItems.all().get(i).interact(InteractionCenter.Take.toString());
                    do{
                        _factory.getMain().sleep(100, 500);
                    }while (GroundItems.all().get(i) != null || _factory.getMain().getLocalPlayer().isMoving());
                }
            }
            //TakeHightValueItem
            for (int j = 0; j < GroundItems.all().size(); j++){
                GELookupResult lookupResult = _factory.getGrandExchangeApi().lookup(GroundItems.all().get(j).getID());
                if(lookupResult.price >= _factory.getMain().get_CombatVariables().get_WindowVariables().getPickupItemCost()){
                    GroundItems.all().get(i).interact(InteractionCenter.Take.toString());
                    do{
                        _factory.getMain().sleep(100, 500);
                    }while (GroundItems.all().get(i) != null || _factory.getMain().getLocalPlayer().isMoving());
                }
            }
        }
    }


    public void TakeBones(){
        _factory.getInteractionUser().SetActivity("TakeBones");
        String groundItem = GroundcheckBones();
        if(groundItem.isEmpty()){
            _factory.getMain().log(GroundItems.all().get(GroundItems.all().size()-1).toString());
        }else{
            ClosesItem closesItems = new ClosesItem();
            closesItems.setCost(99);
            for(int i = 0; i < GroundItems.all(groundItem).size(); i++)
            {
                if(closesItems.getCost() > Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(),GroundItems.all(groundItem).get(i).getTile()).size()) {
                    closesItems.setCost(Walking.getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(), GroundItems.all(groundItem).get(i).getTile()).size());
                    closesItems.setIndex(i);
                }
            }
            GroundItems.all(groundItem).get(closesItems.getIndex()).interact(InteractionCenter.Take.toString());
            do{
                _factory.getMain().sleep(100, 500);
            }while (GroundItems.all().get(closesItems.getIndex()) != null || _factory.getMain().getLocalPlayer().isMoving());
        }
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
