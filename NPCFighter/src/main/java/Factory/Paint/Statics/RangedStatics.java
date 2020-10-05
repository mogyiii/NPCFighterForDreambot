package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;
import static Factory.Paint.Statics.Lines.Line3;

public class RangedStatics {
    private Factory _factory;

    public RangedStatics(Factory factory) {
        this._factory = factory;
    }
    public void DrawRanged(Graphics graphics){
        graphics.setColor(new Color(78, 156, 9));
        graphics.drawString("Ranged level: " + Skills.getRealLevel(Skill.RANGED)
                + " (" + (Skills.getRealLevel(Skill.RANGED) - SkillTracker.getStartLevel(Skill.RANGED)) + ")", Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.RANGED), Line2[0], Line2[1]);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.RANGED) / 60000 + "(Minutes)", Line3[0], Line3[1]);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.RANGED)), Line4[0], Line4[1]);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.RANGED)), Line5[0], Line5[1]);
    }
}
