package Factory.Methods;

import Factory.Factory;
import Factory.Models.AttackSpellModel;
import Factory.Models.WidgetChildClass;
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
    static WidgetChildClass[] widgetChildClass;

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
        widgetChildClass = new WidgetChildClass[]{
                new WidgetChildClass("Wind Strike", Widgets.getWidgetChild(201, 1, 1)),
                new WidgetChildClass("Water Strike", Widgets.getWidgetChild(201, 1, 2)),
                new WidgetChildClass("Earth Strike", Widgets.getWidgetChild(201, 1, 3)),
                new WidgetChildClass("Fire Strike", Widgets.getWidgetChild(201, 1, 4)),
                new WidgetChildClass("Wind Bolt", Widgets.getWidgetChild(201, 1, 5)),
                new WidgetChildClass("Water Bolt", Widgets.getWidgetChild(201, 1, 6)),
                new WidgetChildClass("Earth Bolt", Widgets.getWidgetChild(201, 1, 7)),
                new WidgetChildClass("Fire Bolt", Widgets.getWidgetChild(201, 1, 8)),
                new WidgetChildClass("Wind Blast", Widgets.getWidgetChild(201, 1, 9)),
                new WidgetChildClass("Water Blast", Widgets.getWidgetChild(201, 1, 10)),
                new WidgetChildClass("Earth Blast", Widgets.getWidgetChild(201, 1, 11)),
                new WidgetChildClass("Fire Blast", Widgets.getWidgetChild(201, 1, 12)),
                new WidgetChildClass("Wind Wave", Widgets.getWidgetChild(201, 1, 13)),
                new WidgetChildClass("Water Wave", Widgets.getWidgetChild(201, 1, 14)),
                new WidgetChildClass("Earth Wave", Widgets.getWidgetChild(201, 1, 15)),
                new WidgetChildClass("Fire Wave", Widgets.getWidgetChild(201, 1, 16)),
                new WidgetChildClass("Wind Surge", Widgets.getWidgetChild(201, 1, 48)),
                new WidgetChildClass("Water Surge", Widgets.getWidgetChild(201, 1, 49)),
                new WidgetChildClass("Earth Surge", Widgets.getWidgetChild(201, 1, 50)),
                new WidgetChildClass("Fire Surge", Widgets.getWidgetChild(201, 1, 51))
        };
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
        try {
            if(spellModel == null){
                //spellModel = _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("AttackSpells.json"), AttackSpellModel[].class);
                spellModel = _factory.getJSON().GetNewGson().fromJson(_factory.getDownload().DownloadString("https://raw.githubusercontent.com/mogyiii/NPCFighterForDreambot/master/NPCFighter/resources/AttackSpells.json"), AttackSpellModel[].class);
            }
            for(int i = 0; i < spellModel.length - 1; i++){
                if(Magic.canCast(Normal.valueOf(spellModel[i].Spell))){
                    return Normal.valueOf(spellModel[i].Spell);
                }
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }
    public void IscanCastStrongest() throws NullPointerException{
        for(int i = widgetChildClass.length - 1; i >= 0; i--){
            _factory.getMain().log(widgetChildClass[i].getName());
            Normal spell = Normal.valueOf(widgetChildClass[i].getName().toUpperCase().replace(" ", "_"));
            if(Magic.canCast(spell)){
                Magic.castSpell(spell);
                break;
            }
        }
    }
}
