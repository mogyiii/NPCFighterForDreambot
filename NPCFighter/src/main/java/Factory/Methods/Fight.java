package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.interactive.NPC;

public class Fight {
    private Factory _factory;
    private NPC SelectedEnemy = null;
    public Fight(Factory factory) {
        _factory = factory;
    }
    public void Fight(){
        if(Combat.isSpecialActive() && _factory.getMain().get_CombatVariables().get_WindowVariables().isUseSpecialAttack()){
            Combat.toggleSpecialAttack(true);
        }
        if(!_factory.getMain().getLocalPlayer().isInCombat()){
            for(int i = 0; i < _factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList().length; i++){
                for(int j = 0; j < NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).size(); j++){

                    if((!NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).isInCombat()
                            ||
                            Combat.isInMultiCombat())
                            && NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).canAttack()
                            && NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j) != null){

                        if(SelectedEnemy == null || Walking.getAStarPathFinder().calculate(
                                _factory.getMain().getLocalPlayer().getTile(),
                                SelectedEnemy.getTile()).size()
                                >
                                Walking.getAStarPathFinder().calculate(
                                        _factory.getMain().getLocalPlayer().getTile(),
                                        NPCs.all(
                                                _factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).getTile()).size()){
                            SelectedEnemy = NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j);
                        }
                    }

                }
            }
            SelectedEnemy.interact(InteractionCenter.Attack.toString());
        }
    }

    public NPC getSelectedEnemy() {
        return SelectedEnemy;
    }
}
