package Factory.Methods;

import Factory.Factory;

public class Combat {
    private Factory _factory;
    public Combat(Factory factory) {
        _factory = factory;
    }
    public void Fight(){
        boolean TargetIsExist = false;
        if(!_factory.get_main().getLocalPlayer().isInCombat()){
            for(int i = 0; i < _factory.get_main().get_CombatVariables().get_WindowVariables().getSelectedList().length - 1; i++){
                for(int j = 0; j < _factory.get_main().getNpcs().all(_factory.get_main().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).size() - 1 ; j++){
                    if(!_factory.get_main().getNpcs().all(_factory.get_main().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).isInCombat() && _factory.get_main().getNpcs().all(_factory.get_main().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).canAttack() && _factory.get_main().getNpcs().all(_factory.get_main().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j) != null && !TargetIsExist){
                        _factory.get_main().getNpcs().all(_factory.get_main().get_CombatVariables().get_WindowVariables().getSelectedList()[i]).get(j).interact("Attack");
                        TargetIsExist = true;
                        break;
                    }
                    if(TargetIsExist){
                        break;
                    }
                }
            }
        }
    }
}
