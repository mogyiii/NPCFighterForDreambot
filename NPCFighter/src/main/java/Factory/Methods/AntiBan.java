package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.Client;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;

import java.util.Random;

public class AntiBan {
    private Factory _factory;
    public AntiBan(Factory factory) {
        _factory = factory;
    }

    public void RandomAntiBan() {
        Random RandomAntibanSelector = new Random();
        int chances = RandomAntibanSelector.nextInt(1000) + 0;
        if (chances < 100) {
            Random RandomCameraRotate = new Random();
            _factory.getInteractionUser().SetActivity("Anti-ban: Changing Camera angle");
            Camera.rotateToEvent(RandomCameraRotate.nextInt() + 720, RandomCameraRotate.nextInt() + 90);
        }
        if(chances > 80 && chances < 200){
            _factory.getInteractionUser().SetActivity("Anti-ban: Changing mouse position");
            Mouse.move();
        }
        if(chances > 200 && chances < 220){
            _factory.getInteractionUser().SetActivity("Anti-ban: Checking skill XP");
            Skills.open();
            _factory.getMain().sleep(100, 500);
            Skills.hoverSkill(Skill.valueOf(ChoseRandomSkill().toString()));
            _factory.getMain().sleep(1000, 1500);
        }
        if(chances > 330 && chances < 350){
            _factory.getInteractionUser().SetActivity("Anti-ban: Move cursor Outside Screen");
            Mouse.moveMouseOutsideScreen();
            _factory.getMain().sleep(2888, 5111);
            Mouse.isMouseInScreen();
        }
        if(chances > 350 && chances < 355){
            //_factory.getInterfaceWidgets().GetRandomInterfaceTab().interact();
            Tabs.openWithMouse(_factory.getInterfaceWidgets().getRandomTab());
            _factory.getInteractionUser().SetActivity("Anti-ban: Open Random tab");
            _factory.getMain().sleep(200, 500);
        }
        if(chances > 355 && chances <360){
            if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseWorldHopper()) {
                _factory.getInteractionUser().SetActivity("Anti-ban: Hop world");

                if (!Client.isMembers()) {
                    WorldHopper.hopWorld(Worlds.f2p().get(RandomAntibanSelector.nextInt(Worlds.f2p().size())).getWorld(), WorldHopper.openWorldHopper());
                    WorldHopper.isWorldHopperOpen();
                    _factory.getMain().sleep(5000, 7000);
                } else {
                    WorldHopper.hopWorld(Worlds.members().get(RandomAntibanSelector.nextInt(Worlds.f2p().size())).getWorld(), WorldHopper.openWorldHopper());
                    WorldHopper.isWorldHopperOpen();
                    _factory.getMain().sleep(5000, 7000);
                }
            }
        }
        if(Dialogues.canContinue()){
            Dialogues.clickContinue();
        }
    }
    private Skill ChoseRandomSkill(){
        Skill[] Skills = new Skill[]{Skill.STRENGTH, Skill.ATTACK, Skill.PRAYER, Skill.MAGIC, Skill.DEFENCE, Skill.RANGED, Skill.HITPOINTS};
        Random ran = new Random();
        return Skills[ran.nextInt(Skills.length - 1) + 0];
    }
}
