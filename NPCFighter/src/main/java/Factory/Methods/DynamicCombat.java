package Factory.Methods;

import Factory.Factory;
import Factory.Models.AttackSpellModel;
import org.dreambot.api.methods.magic.Magic;
import org.dreambot.api.methods.magic.Normal;
import org.dreambot.api.methods.magic.Spell;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class DynamicCombat {
    private Factory _factory;
    private WidgetChild MeleeAttack;
    private WidgetChild MeleeStrenght;
    private WidgetChild MeleeDefend;
    private WidgetChild Range;
    private WidgetChild RangeWithDefend;
    private WidgetChild SpellWithStaff;
    private WidgetChild SpellWithStaffDefend;
    private WidgetChild CombatMenuAltMenuSpellList;
    static AttackSpellModel[] spellModel = null;
    public DynamicCombat(Factory factory) {
        _factory = factory;
        MeleeAttack = Widgets.getWidgetChild(593, 5);
        MeleeStrenght = Widgets.getWidgetChild(593, 13);
        MeleeDefend = Widgets.getWidgetChild(593, 17);
        Range = Widgets.getWidgetChild(593, 5);
        RangeWithDefend = Widgets.getWidgetChild(593, 17);
        SpellWithStaff = Widgets.getWidgetChild(593, 27);
        SpellWithStaffDefend = Widgets.getWidgetChild(593, 22);
        CombatMenuAltMenuSpellList = Widgets.getWidgetChild(201, 1);
    }
    public WidgetChild getMeleeAttack() {
        return MeleeAttack;
    }

    public WidgetChild getMeleeStrenght() {
        return MeleeStrenght;
    }

    public WidgetChild getMeleeDefend() {
        return MeleeDefend;
    }

    public WidgetChild getRange() {
        return Range;
    }

    public WidgetChild getRangeWithDefend() {
        return RangeWithDefend;
    }

    public WidgetChild getSpellWithStaff() {
        return SpellWithStaff;
    }

    public WidgetChild getCombatMenuAltMenuSpellList() {
        return CombatMenuAltMenuSpellList;
    }

    public WidgetChild getSpellWithStaffDefend() {
        return SpellWithStaffDefend;
    }
    public Spell GetStrongestSpellWhichCast(){
        if(spellModel == null){
            spellModel = _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("AttackSpells.json"), AttackSpellModel[].class);
        }
        for(int i = 0; i < spellModel.length - 1; i++){
            if(Magic.canCast(Normal.valueOf(spellModel[i].Spell))){
                return Normal.valueOf(spellModel[i].Spell);
            }
        }
        return null;
    }
    public void IscanCastStrongest(int Parent, int Child) throws NullPointerException{
        for(int i = 52; i >= 1; i--){
            WidgetChild SpellWidget = Widgets.getWidgetChild(Parent, Child, i);
            System.out.println(SpellWidget.getActions().length);
            if(SpellWidget.getActions()[0] != null){
                String SpellName = SpellWidget.getSelectedAction();
                if(Magic.canCast(Normal.valueOf(SpellName))){
                    SpellWidget.interact();
                    break;
                }
            }
        }
    }
}
