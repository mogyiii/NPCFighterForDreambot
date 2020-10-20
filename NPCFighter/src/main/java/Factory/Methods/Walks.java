package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.items.Item;

import static org.dreambot.api.methods.walking.impl.Walking.*;

public class Walks {
    private Factory _factory;
    public Walks(Factory factory) {
        _factory = factory;
    }
    public void WalkingHandler(){
        Item Foods = Inventory.get(item -> item != null && (item.hasAction(InteractionCenter.Eat.toString()) ));
        Item Bones = Inventory.get(item -> item != null && item.hasAction(InteractionCenter.Bury.toString()));
        if ((Bones == null && Foods == null && (Inventory.isFull() || _factory.getMain().getLocalPlayer().getHealthPercent() < 30))
            || (Bones != null && Foods == null && _factory.getMain().getLocalPlayer().getHealthPercent() < 30)) {
                if(Inventory.isFull()){
                    _factory.getMain().log("Go to Bank!");
                    _factory.getInteractionUser().SetActivity("Go to Bank!");

                }else{
                    _factory.getMain().log("Escaping!");
                    _factory.getInteractionUser().SetActivity("Escaping!");
                }
                _factory.getBotArea().setWalkToArea(Bank.getClosestBankLocation().getArea(3));
                while(true){
                    if(_factory.getBotArea().getWalkToArea().contains(_factory.getMain().getLocalPlayer().getTile())){
                        _factory.getBanking().banking();
                        break;
                    }
                    WalkTo();
                }
        }else{
            _factory.getBotArea().setWalkToArea(_factory.getBotArea().getStartedArea());
            while(true && _factory.getBotArea() != null){
                if(_factory.getBotArea().getWalkToArea().contains(_factory.getMain().getLocalPlayer().getTile())){
                    break;
                }else {
                    WalkTo();
                }
            }
        }
        if(_factory.getMain().getLocalPlayer().getHealthPercent() <= 0){
            _factory.getBotArea().setWalkToArea(_factory.getBotArea().getStartedArea());
        }
    }
    private void WalkTo(){
        _factory.getInteractionUser().SetActivity("Walking to area!");
        if(Walking.shouldWalk()){
            walk(_factory.getBotArea().getWalkToArea().getCenter().getRandomizedTile(3));
        }
        if(getRunEnergy() >= 20){
            if(!(isRunEnabled())){
                toggleRun();
            }
        }
        /*if(_factory.getMain().getPlayers().localPlayer().getY() > 3515 && _factory.getMain().getPlayers().localPlayer().getY() < 3520){
            WildernessJumping();
        }*/
        _factory.getMain().sleep(100, 400);
    }
}
