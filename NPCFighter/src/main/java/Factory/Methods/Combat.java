package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.wrappers.interactive.NPC;

public class Combat {
    private Factory _factory;
    public Combat(Factory factory) {
        _factory = factory;
    }
    public void Fight(){
        NPC SelectedEnemy = null;
        if(_factory.getMain().getCombat().isSpecialActive()){
            _factory.getMain().getCombat().toggleSpecialAttack(true);
        }
        if(!_factory.getMain().getLocalPlayer().isInCombat()){
            for(int i = 0; i < _factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList().length - 1; i++){
                for(int j = 0; j < _factory.getMain().getNpcs().all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).size() - 1 ; j++){

                    if((!_factory.getMain().getNpcs().all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).isInCombat()
                            ||
                            _factory.getMain().getCombat().isInMultiCombat())
                            && _factory.getMain().getNpcs().all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).canAttack()
                            && _factory.getMain().getNpcs().all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j) != null){

                        if(SelectedEnemy == null || _factory.getMain().getWalking().getAStarPathFinder().calculate(
                                _factory.getMain().getLocalPlayer().getTile(),
                                SelectedEnemy.getTile()).size()
                                >
                                _factory.getMain().getWalking().getAStarPathFinder().calculate(
                                        _factory.getMain().getLocalPlayer().getTile(),
                                        _factory.getMain().getNpcs().all(
                                                _factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).getTile()).size()){
                            SelectedEnemy = _factory.getMain().getNpcs().all(_factory.getMain().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j);
                        }
                    }

                }
            }
            SelectedEnemy.interact(InteractionCenter.Attack.toString());
        }
    }
}
