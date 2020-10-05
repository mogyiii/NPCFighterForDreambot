package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.map.Area;

public class BotArea {
    private Factory _factory;
    private Area StartedArea;
    private Area WalkToArea;
    public BotArea(Factory factory) {
        _factory = factory;
    }
    public void setStartedArea(){
        StartedArea = new Area().generateArea(_factory.getMain().get_CombatVariables().get_WindowVariables().getAreaSize(), _factory.getMain().getLocalPlayer().getTile());
    }

    public Area getStartedArea() {
        return StartedArea;
    }

    public Area getWalkToArea() {
        return WalkToArea;
    }

    public void setWalkToArea(Area walkToArea) {
        WalkToArea = walkToArea;
    }
}
