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
            _factory.getInteractionUser().SetActivity("Toggle Special attack");
        }
        if(!_factory.getMain().getLocalPlayer().isInCombat()){
            _factory.getInteractionUser().SetActivity("Search Npcs");
            for(int i = 0; i < _factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList().length; i++){
                for(int j = 0; j < NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).size(); j++){
                    NPC ScannEnemy = NPCs.all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j);
                    if((!ScannEnemy.isInCombat()
                            ||
                            Combat.isInMultiCombat())
                            && ScannEnemy.canAttack()
                            && ScannEnemy != null
                            && _factory.getBotArea().getWalkToArea().contains(ScannEnemy.getTile()) ){

                        if(SelectedEnemy == null || Walking.getAStarPathFinder().calculate(
                                _factory.getMain().getLocalPlayer().getTile(),
                                SelectedEnemy.getTile()).size()
                                >
                                Walking.getAStarPathFinder().calculate(
                                        _factory.getMain().getLocalPlayer().getTile(),
                                        ScannEnemy.getTile()).size()){
                            SelectedEnemy = ScannEnemy;
                        }
                    }
                }
            }
            try{
                if(SelectedEnemy != null && SelectedEnemy.getHealthPercent() >= 10){
                    SelectedEnemy.interact(InteractionCenter.Attack.toString());
                }else{
                    SelectedEnemy = null;
                }
            }catch (Exception e){
                SelectedEnemy = null;
            }
        }else{
            _factory.getInteractionUser().SetActivity("Fighting!");
        }
    }

    public NPC getSelectedEnemy() {
        return SelectedEnemy;
    }
}
