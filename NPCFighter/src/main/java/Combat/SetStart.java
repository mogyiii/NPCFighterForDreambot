package Combat;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;

public class SetStart {
    private Factory _factory;

    public SetStart(Factory factory) {
        this._factory = factory;
        factory.getTime().setStartTime(System.currentTimeMillis());
        SkillTracker.start(Skill.PRAYER);
        SkillTracker.start(Skill.HITPOINTS);
        SkillTracker.start(Skill.STRENGTH);
        SkillTracker.start(Skill.DEFENCE);
        SkillTracker.start(Skill.ATTACK);
        SkillTracker.start(Skill.RANGED);
        SkillTracker.start(Skill.MAGIC);
        _factory.getSkillCheck().SkillCheckSelectType();
    }

}
