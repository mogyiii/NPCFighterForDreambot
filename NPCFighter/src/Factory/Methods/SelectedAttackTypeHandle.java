package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;


public class SelectedAttackTypeHandle {
    private Factory _factory;
    private SkillDetails SelectedSkill;
    public SelectedAttackTypeHandle(Factory factory) {
        _factory = factory;
        switch (_factory.get_main().get_CombatVariables().get_WindowVariables().getAttackType()){
            case Magic:
                Magic();
                break;
            case Melee:
                Melee();
                break;
            case Range:
                Range();
                break;
        }
    }
    private void Range(){
        if(ChoseSkill() != null){
            _factory.get_main().getWidgets()
            ChoseSkill().get_Name();
        }
    }
    private void Magic(){

    }
    private void Melee(){

    }
    private SkillDetails ChoseSkill(){
        SkillDetails  CheckSkillDetails = null;
        int SmallestIncrease = 99;
        for(int i = 0; i < _factory.getSkillCheck().get_skillDetails().length; i++){
            int SelectedSkillUpped = _factory.get_main().getSkills().getRealLevel(Skill.valueOf(_factory.getSkillCheck().get_skillDetails()[i].get_Name())) - _factory.getSkillCheck().get_skillDetails()[i].get_StartLevel();
            if(SelectedSkillUpped < SmallestIncrease){
                CheckSkillDetails = _factory.getSkillCheck().get_skillDetails()[i];
            }
        }
        return CheckSkillDetails;
    }
}
