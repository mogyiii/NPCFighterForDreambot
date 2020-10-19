package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.magic.Magic;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;


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
            if(ChoseSkill().get_Name().equals(Skill.DEFENCE.toString()) && _factory.getSkillCheck().SelectedSkills != Skill.DEFENCE){
                Tabs.openWithMouse(Tab.COMBAT);
                _factory.getDynamicCombat().getRangeWithDefend().interact();
                _factory.getSkillCheck().SelectedSkills = Skill.DEFENCE;
            }
        }
        _factory.getCombat().Fight();
    }
    private void Magic(){
        if(ChoseSkill() != null) {
            _factory.getInteractionUser().SetActivity("Select combat type");
            if (ChoseSkill().get_Name().equals(Skill.DEFENCE.toString()) && Equipment.getItemInSlot(EquipmentSlot.WEAPON.getSlot()).getName().contains("Staff") && _factory.getSkillCheck().SelectedSkills != Skill.DEFENCE) {
                Tabs.openWithMouse(Tab.COMBAT);
                //Tabs.open(Tab.COMBAT.getWidgetChild().);
                _factory.getMain().sleep(200, 500);
                if(Widgets.getAllWidgets().contains(_factory.getDynamicCombat().getSpellWithStaffDefend())){
                    _factory.getDynamicCombat().getSpellWithStaffDefend().interact();
                }
                _factory.getMain().sleep(200, 500);
                if(Widgets.getAllWidgets().contains(Widgets.getWidgetChild(201,1))){
                    _factory.getDynamicCombat().IscanCastStrongest(201,2);
                }

                _factory.getSkillCheck().SelectedSkills = Skill.DEFENCE;
            }
        }else{
            if(!Equipment.getItemInSlot(EquipmentSlot.WEAPON.getSlot()).getName().contains("Staff")){
                try {
                    Magic.castSpell(_factory.getDynamicCombat().GetStrongestSpellWhichCast());
                } catch (Exception e) {
                    _factory.getMain().log("Magic spell Json can't open: " + e.toString());
                }
            }else {
                Tabs.openWithMouse(Tab.COMBAT);
                _factory.getMain().sleep(200, 500);
                _factory.getDynamicCombat().getSpellWithStaff().interact();
                _factory.getMain().sleep(200, 500);
                _factory.getDynamicCombat().IscanCastStrongest(201,1);
                _factory.getSkillCheck().SelectedSkills = Skill.MAGIC;
            }
        }
        _factory.getCombat().Fight();
    }
    private void Melee(){
        if(ChoseSkill() != null){
            _factory.getInteractionUser().SetActivity("Select combat type");
            Tabs.openWithMouse(Tab.COMBAT);
            if(ChoseSkill().get_Name().equals(Skill.ATTACK.toString()) && _factory.getSkillCheck().SelectedSkills != Skill.ATTACK){
                _factory.getDynamicCombat().getMeleeAttack().interact();
                _factory.getSkillCheck().SelectedSkills = Skill.ATTACK;
            }else if(ChoseSkill().get_Name().equals(Skill.DEFENCE.toString()) && _factory.getSkillCheck().SelectedSkills != Skill.DEFENCE){
                _factory.getDynamicCombat().getMeleeDefend().interact();
                _factory.getSkillCheck().SelectedSkills = Skill.DEFENCE;
            }else if(ChoseSkill().get_Name().equals(Skill.STRENGTH.toString()) && _factory.getSkillCheck().SelectedSkills != Skill.STRENGTH){
                _factory.getDynamicCombat().getMeleeStrenght().interact();
                _factory.getSkillCheck().SelectedSkills = Skill.STRENGTH;
            }
        }
        _factory.getCombat().Fight();
    }
    private SkillDetails ChoseSkill(){
        SkillDetails  CheckSkillDetails = null;
        int SmallestIncrease = 99;
        for(int i = 0; i < _factory.getSkillCheck().get_skillDetails().size(); i++){
            int SelectedSkillUpped = Skills.getRealLevel(Skill.valueOf(_factory.getSkillCheck().get_skillDetails().get(i).get_Name())) - _factory.getSkillCheck().get_skillDetails().get(i).get_StartLevel();
            if(SelectedSkillUpped < SmallestIncrease){
                CheckSkillDetails = _factory.getSkillCheck().get_skillDetails().get(i);
                SmallestIncrease = SelectedSkillUpped;
            }
        }
        return CheckSkillDetails;
    }
}
