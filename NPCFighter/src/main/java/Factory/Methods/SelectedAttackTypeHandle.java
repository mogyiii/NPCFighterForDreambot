package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.skills.Skill;

import java.io.IOException;


public class SelectedAttackTypeHandle {
    private Factory _factory;
    private SkillDetails SelectedSkill;
    public SelectedAttackTypeHandle(Factory factory) {
        _factory = factory;
    }
    public void SelectCombatType(){
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
            if(ChoseSkill().get_Name().equals("Defend")){
                _factory.getDynamicCombat().getRangeWithDefend();
            }else if(ChoseSkill().get_Name().equals("")){
                _factory.getDynamicCombat().getRange();
            }
        }
        _factory.getCombat().Fight();
    }
    private void Magic(){
        if(ChoseSkill() != null){
            if(ChoseSkill().get_Name().equals("Defend") && EquipmentSlot.WEAPON.toString().contains("Staff")){
                _factory.getDynamicCombat().getSpellWithStaffDefend();
                _factory.getDynamicCombat().getCombatMenuAltMenuSpellList();
            }else if(ChoseSkill().get_Name().equals("Magic") && EquipmentSlot.WEAPON.toString().contains("Staff")){
                _factory.getDynamicCombat().getSpellWithStaff();
                _factory.getDynamicCombat().getCombatMenuAltMenuSpellList();
            }else{
                try{
                    _factory.getDynamicCombat().GetStrongestSpellWhichCast();
                }catch (IOException e){
                    _factory.get_main().log("Magic spell Json can't open: " + e.toString());
                }
            }
        }
        _factory.getCombat().Fight();
    }
    private void Melee(){
        if(ChoseSkill() != null){
            if(ChoseSkill().get_Name().equals("Attack")){
                _factory.getDynamicCombat().getMeleeAttack();
            }else if(ChoseSkill().get_Name().equals("Defend")){
                _factory.getDynamicCombat().getMeleeDefend();
            }else if(ChoseSkill().get_Name().equals("Strength")){
                _factory.getDynamicCombat().getMeleeStrenght();
            }
        }
        _factory.getCombat().Fight();
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
