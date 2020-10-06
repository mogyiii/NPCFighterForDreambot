package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.magic.Magic;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;


public class SelectedAttackTypeHandle {
    private Factory _factory;
    private SkillDetails SelectedSkill;
    public SelectedAttackTypeHandle(Factory factory) {
        _factory = factory;
    }
    public void SelectCombatType(){
        if(!_factory.getMain().getLocalPlayer().isMoving()){
            switch (_factory.getMain().get_CombatVariables().get_WindowVariables().getAttackType()){
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
    }
    private void Range(){
        if(ChoseSkill() != null){
            _factory.getInteractionUser().SetActivity("Select combat type");
            Tabs.openWithMouse(Tab.COMBAT);
            if(ChoseSkill().get_Name().equals("Defend")){
                _factory.getDynamicCombat().getRangeWithDefend().interact();
            }else if(ChoseSkill().get_Name().equals("")){
                _factory.getDynamicCombat().getRange().interact();
            }
        }
        _factory.getCombat().Fight();
    }
    private void Magic(){
        if(ChoseSkill() != null){
            Tabs.openWithMouse(Tab.COMBAT);
            _factory.getInteractionUser().SetActivity("Select combat type");
            if(ChoseSkill().get_Name().equals("Defend") && EquipmentSlot.WEAPON.toString().contains("Staff")){
                _factory.getDynamicCombat().getSpellWithStaffDefend().interact();
                _factory.getDynamicCombat().getCombatMenuAltMenuSpellList().interact();
            }else if(ChoseSkill().get_Name().equals("Magic") && EquipmentSlot.WEAPON.toString().contains("Staff")){
                _factory.getDynamicCombat().getSpellWithStaff().interact();
                _factory.getDynamicCombat().getCombatMenuAltMenuSpellList().interact();
            }else{
                try{
                    Magic.castSpell(_factory.getDynamicCombat().GetStrongestSpellWhichCast());
                }catch (Exception e){
                    _factory.getMain().log("Magic spell Json can't open: " + e.toString());
                }
            }
        }
        _factory.getCombat().Fight();
    }
    private void Melee(){
        if(ChoseSkill() != null){
            _factory.getInteractionUser().SetActivity("Select combat type");
            Tabs.openWithMouse(Tab.COMBAT);
            if(ChoseSkill().get_Name().equals("Attack")){
                _factory.getDynamicCombat().getMeleeAttack().interact();
            }else if(ChoseSkill().get_Name().equals("Defend")){
                _factory.getDynamicCombat().getMeleeDefend().interact();
            }else if(ChoseSkill().get_Name().equals("Strength")){
                _factory.getDynamicCombat().getMeleeStrenght().interact();
            }
        }
        _factory.getCombat().Fight();
    }
    private SkillDetails ChoseSkill(){
        SkillDetails  CheckSkillDetails = null;
        int SmallestIncrease = 99;
        for(int i = 0; i < _factory.getSkillCheck().get_skillDetails().length; i++){
            int SelectedSkillUpped = Skills.getRealLevel(Skill.valueOf(_factory.getSkillCheck().get_skillDetails()[i].get_Name())) - _factory.getSkillCheck().get_skillDetails()[i].get_StartLevel();
            if(SelectedSkillUpped < SmallestIncrease){
                CheckSkillDetails = _factory.getSkillCheck().get_skillDetails()[i];
            }
        }
        return CheckSkillDetails;
    }
}
