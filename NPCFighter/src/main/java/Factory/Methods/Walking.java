package Factory.Methods;

import Factory.Factory;

public class Walking {
    private Factory _factory;
    public Walking(Factory factory) {
        _factory = factory;
    }
    public void WalkingHandler(){

        if (_factory.getMain().getInventory().get(item -> item != null && item.hasAction("Eat")) == null) {
            if(_factory.getMain().getLocalPlayer().getHealthPercent() < 30){
                _factory.getBotArea().setWalkToArea(_factory.getMain().getBank().getClosestBankLocation().getArea(3));
                while(true){
                    if(_factory.getBotArea().getWalkToArea().contains(_factory.getMain().getLocalPlayer().getTile())){
                        _factory.getBanking().banking();
                        break;
                    }
                    WalkTo();
                }
            }
        }else{
            _factory.getBotArea().setWalkToArea(_factory.getBotArea().getStartedArea());
            while(true){
                if(_factory.getBotArea().getWalkToArea().contains(_factory.getMain().getLocalPlayer().getTile())){
                    break;
                }
                WalkTo();
            }
        }
    }
    private void WalkTo(){
        _factory.getInteractionUser().SetActivity("Walking to area!");
        _factory.getMain().getWalking().walk(_factory.getBotArea().getWalkToArea().getCenter().getRandomizedTile(3));
        if(_factory.getMain().getWalking().getRunEnergy() >= 20){
            if(!(_factory.getMain().getWalking().isRunEnabled())){
                _factory.getMain().getWalking().toggleRun();
            }
        }
        /*if(_factory.getMain().getPlayers().localPlayer().getY() > 3515 && _factory.getMain().getPlayers().localPlayer().getY() < 3520){
            WildernessJumping();
        }*/
        _factory.getMain().sleep(100, 400);
    }
}
