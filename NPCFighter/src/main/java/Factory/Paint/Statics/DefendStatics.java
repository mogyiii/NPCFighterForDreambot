package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;

public class DefendStatics {
    private Factory _factory;

    public DefendStatics(Factory factory) {
        this._factory = factory;
    }
    public void DrawDefend(Graphics graphics){
        graphics.setColor(new Color(3, 103, 252));
        graphics.drawString("Defend level: " + Skills.getRealLevel(Skill.DEFENCE)
                + " (" + (Skills.getRealLevel(Skill.DEFENCE) - SkillTracker.getStartLevel(Skill.DEFENCE)) + ")", Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.DEFENCE), Line2[0], Line2[1]);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.DEFENCE) / 60000 + "(Minutes)", Line3[0], Line3[1]);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.DEFENCE)), Line4[0], Line4[1]);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.DEFENCE)), Line5[0], Line5[1]);
    }
}
