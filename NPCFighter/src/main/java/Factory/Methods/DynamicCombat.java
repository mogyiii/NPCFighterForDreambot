package Factory.Methods;

import Factory.Factory;
import Factory.Models.AttackSpellModel;
import org.dreambot.api.methods.magic.Normal;
import org.dreambot.api.methods.magic.Spell;
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
    public DynamicCombat(Factory factory) {
        _factory = factory;
        MeleeAttack = _factory.getMain().getWidgets().getWidgetChild(593, 5);
        MeleeStrenght = _factory.getMain().getWidgets().getWidgetChild(593, 13);
        MeleeDefend = _factory.getMain().getWidgets().getWidgetChild(593, 17);
        Range = _factory.getMain().getWidgets().getWidgetChild(593, 5);
        RangeWithDefend = _factory.getMain().getWidgets().getWidgetChild(593, 17);
        SpellWithStaff = _factory.getMain().getWidgets().getWidgetChild(593, 27);
        SpellWithStaffDefend = _factory.getMain().getWidgets().getWidgetChild(593, 22);
        CombatMenuAltMenuSpellList = _factory.getMain().getWidgets().getWidgetChild(201, 1);
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
        AttackSpellModel[] spellModel;
        spellModel = _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("AttackSpells.json"), AttackSpellModel[].class);
        for(int i = 0; i < spellModel.length - 1; i++){
            if(_factory.getMain().getMagic().canCast(Normal.valueOf(spellModel[i].Spell))){
                return Normal.valueOf(spellModel[i].Spell);
            }
        }
        return null;
    }
}
