package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

import java.util.ArrayList;
import java.util.List;

public class SkillCheck{
    private Factory _factory;
    private List<SkillDetails> _skillDetails = new ArrayList<>();
    public static Skill SelectedSkills;
    public SkillCheck(Factory factory) {
        _factory = factory;

    }
    public void SkillCheckSelectType(){
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseAttack()){
            _skillDetails.add(new SkillDetails(Skill.ATTACK.toString(), Skills.getRealLevel(Skill.ATTACK)));
        }
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseDefend()){
            _skillDetails.add(new SkillDetails(Skill.DEFENCE.toString(), Skills.getRealLevel(Skill.DEFENCE)));
        }
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseStrength()){
            _skillDetails.add(new SkillDetails(Skill.STRENGTH.toString(), Skills.getRealLevel(Skill.STRENGTH)));
        }

    }
    public List<SkillDetails> get_skillDetails() {
        return _skillDetails;
    }
}
