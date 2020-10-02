package Combat;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;

public class SetStart {
    private Factory _factory;

    public SetStart(Factory factory) {
        this._factory = factory;
        factory.getTime().setStartTime(System.currentTimeMillis());
        _factory.getMain().getSkillTracker().start(Skill.PRAYER);
        _factory.getMain().getSkillTracker().start(Skill.HITPOINTS);
        _factory.getMain().getSkillTracker().start(Skill.STRENGTH);
        _factory.getMain().getSkillTracker().start(Skill.DEFENCE);
        _factory.getMain().getSkillTracker().start(Skill.ATTACK);
        _factory.getMain().getSkillTracker().start(Skill.RANGED);
        _factory.getMain().getSkillTracker().start(Skill.MAGIC);
        _factory.getSkillCheck().SkillCheckSelectType();
    }

}
