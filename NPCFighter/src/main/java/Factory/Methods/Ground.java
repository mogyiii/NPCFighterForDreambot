package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import static Moduls.GrandExchangeApi.*;

public class Ground {
    private Factory _factory;
    private String[] Bones = {"Searing ashes", "Reinforced dragon bones", "Frost dragon bones", "Hardened dragon bones", "Ourg bones", "Ourg bones", "Airut bones", "Dagannoth bones", "Raurg bones","Tortured ashes", "Fayrg bones", "Dragon bones", "Infernal ashes", "Wyvern bones", "Baby dragon bones", "Shaikahan bones", "Zogre bones", "Jogre bones", "Big bones", "Accursed ashes", "Bat bones","Monkey bones", "Burnt bones", "Wolf bones", "Bones", "Impious ashesImpious ashes"};
    public Ground(Factory factory) {
        _factory = factory;
    }
    public void BonesHandle(){
        if(!_factory.getMain().getLocalPlayer().isInCombat()){
            if(_factory.getMain().getInventory().isFull()){
                BuryBones();
            }
        }else{
           TakeBones();
            TakeSelectedItem();
        }
    }
    public void TakeSelectedItem(){
        for(int i = 0; i < _factory.getMain().getGroundItems().all().size(); i++){
            //TakeList
            for(int j = 0; j < _factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems().length; j++){
                if(_factory.getMain().getGroundItems().all().get(i).toString().toUpperCase().equals(_factory.getMain().get_CombatVariables().get_WindowVariables().getPickUpItems()[j].toUpperCase())){
                    _factory.getMain().getGroundItems().all().get(i).interact(InteractionCenter.Take.toString());
                    do{
                        _factory.getMain().sleep(100, 500);
                    }while (_factory.getMain().getGroundItems().all().get(i) != null || _factory.getMain().getLocalPlayer().isMoving());
                }
            }
            //TakeHightValueItem
            for (int j = 0; j < _factory.getMain().getGroundItems().all().size(); j++){
                GELookupResult lookupResult = _factory.getGrandExchangeApi().lookup(_factory.getMain().getGroundItems().all().get(j).getID());
                if(lookupResult.price >= _factory.getMain().get_CombatVariables().get_WindowVariables().getPickupItemCost()){
                    _factory.getMain().getGroundItems().all().get(i).interact(InteractionCenter.Take.toString());
                    do{
                        _factory.getMain().sleep(100, 500);
                    }while (_factory.getMain().getGroundItems().all().get(i) != null || _factory.getMain().getLocalPlayer().isMoving());
                }
            }
        }
    }


    public void TakeBones(){
        _factory.getInteractionUser().SetActivity("TakeBones");
        String groundItem = GroundcheckBones();
        if(groundItem.isEmpty()){
            _factory.getMain().log(_factory.getMain().getGroundItems().all().get(_factory.getMain().getGroundItems().all().size()-1).toString());
        }else{
            ClosesItem closesItems = new ClosesItem();
            closesItems.setCost(99);
            for(int i = 0; i < _factory.getMain().getGroundItems().all(groundItem).size(); i++)
            {
                if(closesItems.getCost() > _factory.getMain().getWalking().getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(),_factory.getMain().getGroundItems().all(groundItem).get(i).getTile()).size()) {
                    closesItems.setCost(_factory.getMain().getWalking().getAStarPathFinder().calculate(_factory.getMain().getLocalPlayer().getTile(), _factory.getMain().getGroundItems().all(groundItem).get(i).getTile()).size());
                    closesItems.setIndex(i);
                }
            }
            _factory.getMain().getGroundItems().all(groundItem).get(closesItems.getIndex()).interact(InteractionCenter.Take.toString());
            do{
                _factory.getMain().sleep(100, 500);
            }while (_factory.getMain().getGroundItems().all().get(closesItems.getIndex()) != null || _factory.getMain().getLocalPlayer().isMoving());
        }
    }
    private void BuryBones(){
        _factory.getInteractionUser().SetActivity("Bury Bones");
        while(_factory.getMain().getInventory().contains(CheckInvertory())){
            if (_factory.getMain().getInventory().contains(CheckInvertory())){
                _factory.getMain().getInventory().interact(CheckInvertory(), InteractionCenter.Bury.toString());
                _factory.getInterfaceGraphics().setBurydBones(_factory.getInterfaceGraphics().getBurydBones() + 1);
                _factory.getMain().sleep(800, 1300);
            }
        }
    }
    public String GroundcheckBones(){
        for(int i = 0; i < Bones.length; i++) {
            for(int j = 0; j < _factory.getMain().getGroundItems().all().size(); j++){
                if(_factory.getMain().getGroundItems().all().get(j).toString().equals(Bones[i])){
                    return Bones[i];
                }
            }

        }
        return "";
    }
    public String CheckInvertory(){
        for(int i = 0; i < Bones.length; i++) {
            if (_factory.getMain().getInventory().contains(Bones[i])){
                return Bones[i];
            }
        }
        return  "";
    }

}
