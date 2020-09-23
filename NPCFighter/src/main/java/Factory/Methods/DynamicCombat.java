package Factory.Methods;

import Factory.Factory;
import Factory.Models.AttackSpellModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dreambot.api.methods.magic.Normal;
import org.dreambot.api.methods.magic.Spell;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.io.File;
import java.io.IOException;

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
        MeleeAttack = _factory.get_main().getWidgets().getWidgetChild(593, 5);
        MeleeStrenght = _factory.get_main().getWidgets().getWidgetChild(593, 13);
        MeleeDefend = _factory.get_main().getWidgets().getWidgetChild(593, 17);
        Range = _factory.get_main().getWidgets().getWidgetChild(593, 5);
        RangeWithDefend = _factory.get_main().getWidgets().getWidgetChild(593, 17);
        SpellWithStaff = _factory.get_main().getWidgets().getWidgetChild(593, 27);
        SpellWithStaffDefend = _factory.get_main().getWidgets().getWidgetChild(593, 22);
        CombatMenuAltMenuSpellList = _factory.get_main().getWidgets().getWidgetChild(201, 1);
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
    public Spell GetStrongestSpellWhichCast() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AttackSpellModel[] spellModel = mapper.readValue(new File(".../Lists/AttackSpell.json"), AttackSpellModel[].class);
        for(int i = 0; i < spellModel.length - 1; i++){
            if(_factory.get_main().getMagic().canCast(Normal.valueOf(spellModel[i].spell))){
                return Normal.valueOf(spellModel[i].spell);
            }
        }
        return null;
    }
}