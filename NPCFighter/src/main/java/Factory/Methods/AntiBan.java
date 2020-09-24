package Factory.Methods;

import Factory.Factory;

import java.util.Random;

public class AntiBan {
    private Factory _factory;
    public AntiBan(Factory factory) {
        _factory = factory;
    }

    public void RandomAntiBan() {
        Random srand = new Random();
        double chances = srand.nextDouble();
        if (chances < 0.119) {
            _factory.getInteractionUser().SetActivity("Anti-ban: Changing Camera angle");
            _factory.get_main().getCamera().rotateToEvent(srand.nextInt() + 360, srand.nextInt() + 90);
        }else if(chances > 0.120 && chances < 0.192){
            _factory.getInteractionUser().SetActivity("Anti-ban: Changing mouse position");
            _factory.get_main().getMouse().move();
        }
        else if(chances > 0.200 && chances < 0.256){
            _factory.getInteractionUser().SetActivity("Anti-ban: Checking skill XP");
            _factory.get_main().getSkills().open();
            _factory.get_main().sleep(100, 500);
            //_factory.get_main().getSkills().hoverSkill(Skill.valueOf());
            _factory.get_main().sleep(1000, 1500);
        }else if(chances > 0.296 && chances < 0.350){
            _factory.getInteractionUser().SetActivity("Anti-ban: Move cursor Outside Screen");
            _factory.get_main().getMouse().moveMouseOutsideScreen();
            _factory.get_main().sleep(2888, 5111);
            _factory.get_main().getMouse().isMouseInScreen();
        }else if(chances > 0.350 && chances < 0.355){
            //getWidgets().
            _factory.getInteractionUser().SetActivity("Anti-ban: Open Random tab");
            _factory.get_main().sleep(200, 500);
        }else if(chances > 0.355 && chances < 0.360){
            if(!_factory.get_main().get_CombatVariables().get_WindowVariables().isUseWorldHopper()) {
                _factory.getInteractionUser().SetActivity("Anti-ban: Hop world");

                if (!_factory.get_main().getClient().isMembers()) {
                    _factory.get_main().getWorldHopper().hopWorld(_factory.get_main().getWorlds().f2p().get(srand.nextInt(_factory.get_main().getWorlds().f2p().size())).getID(), _factory.get_main().getWorldHopper().openWorldHopper());
                    _factory.get_main().getWorldHopper().isWorldHopperOpen();
                    _factory.get_main().sleep(5000, 7000);
                } else {
                    _factory.get_main().getWorldHopper().hopWorld(_factory.get_main().getWorlds().members().get(srand.nextInt(_factory.get_main().getWorlds().f2p().size())).getID(), _factory.get_main().getWorldHopper().openWorldHopper());
                    _factory.get_main().getWorldHopper().isWorldHopperOpen();
                    _factory.get_main().sleep(5000, 7000);
                }
            }
        }
    }
}
