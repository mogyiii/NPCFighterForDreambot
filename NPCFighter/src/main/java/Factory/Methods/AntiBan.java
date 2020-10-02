package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;

import java.util.Random;

public class AntiBan {
    private Factory _factory;
    public AntiBan(Factory factory) {
        _factory = factory;
    }

    public void RandomAntiBan() {
        Random srand = new Random();
        double chances = srand.nextInt(1000) + 0;
        if (chances < 100) {
            _factory.getInteractionUser().SetActivity("Anti-ban: Changing Camera angle");
            _factory.getMain().getCamera().rotateToEvent(srand.nextInt() + 360, srand.nextInt() + 90);
        }
        if(chances > 80 && chances < 200){
            _factory.getInteractionUser().SetActivity("Anti-ban: Changing mouse position");
            _factory.getMain().getMouse().move();
        }
        if(chances > 200 && chances < 220){
            _factory.getInteractionUser().SetActivity("Anti-ban: Checking skill XP");
            _factory.getMain().getSkills().open();
            _factory.getMain().sleep(100, 500);
            _factory.getMain().getSkills().hoverSkill(Skill.valueOf(ChoseRandomSkill()));
            _factory.getMain().sleep(1000, 1500);
        }
        if(chances > 296 && chances < 350){
            _factory.getInteractionUser().SetActivity("Anti-ban: Move cursor Outside Screen");
            _factory.getMain().getMouse().moveMouseOutsideScreen();
            _factory.getMain().sleep(2888, 5111);
            _factory.getMain().getMouse().isMouseInScreen();
        }
        if(chances > 350 && chances < 355){
            //_factory.getInterfaceWidgets().GetRandomInterfaceTab().interact();
            _factory.getMain().getTabs().openWithMouse(_factory.getInterfaceWidgets().getRandomTab());
            _factory.getInteractionUser().SetActivity("Anti-ban: Open Random tab");
            _factory.getMain().sleep(200, 500);
        }
        if(chances > 355 && chances <360){
            if(!_factory.getMain().get_CombatVariables().get_WindowVariables().isUseWorldHopper()) {
                _factory.getInteractionUser().SetActivity("Anti-ban: Hop world");

                if (!_factory.getMain().getClient().isMembers()) {
                    _factory.getMain().getWorldHopper().hopWorld(_factory.getMain().getWorlds().f2p().get(srand.nextInt(_factory.getMain().getWorlds().f2p().size())).getID(), _factory.getMain().getWorldHopper().openWorldHopper());
                    _factory.getMain().getWorldHopper().isWorldHopperOpen();
                    _factory.getMain().sleep(5000, 7000);
                } else {
                    _factory.getMain().getWorldHopper().hopWorld(_factory.getMain().getWorlds().members().get(srand.nextInt(_factory.getMain().getWorlds().f2p().size())).getID(), _factory.getMain().getWorldHopper().openWorldHopper());
                    _factory.getMain().getWorldHopper().isWorldHopperOpen();
                    _factory.getMain().sleep(5000, 7000);
                }
            }
        }
    }
    private String ChoseRandomSkill(){
        String[] Skills = new String[]{"Strength", "Attack", "Prayer", "Magic", "Defend", "Range", "Hitpoints"};
        Random ran = new Random();
        return Skills[ran.nextInt(Skills.length) + 0];
    }
}
