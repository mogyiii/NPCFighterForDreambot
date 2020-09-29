package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;

public class SkillCheck{
    private Factory _factory;
    private SkillDetails _skillDetails[]= new SkillDetails[]{};
    private int SkillCount = 0;
    public SkillCheck(Factory factory) {
        _factory = factory;

    }
    public void SkillCheckSelectType(){
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseAttack()){
            _skillDetails[SkillCount] = new SkillDetails("Attack", _factory.getMain().getSkills().getRealLevel(Skill.ATTACK));
            SkillCount++;
        }
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseDefend()){
            _skillDetails[SkillCount] = new SkillDetails("Defend", _factory.getMain().getSkills().getRealLevel(Skill.DEFENCE));
            SkillCount++;
        }
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseStrength()){
            _skillDetails[SkillCount] = new SkillDetails("Strength", _factory.getMain().getSkills().getRealLevel(Skill.STRENGTH));
            SkillCount++;
        }
    }
    public SkillDetails[] get_skillDetails() {
        return _skillDetails;
    }
}
