package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;
import static Factory.Paint.Statics.Lines.Line3;

public class StrengthStatics {
    private Factory _factory;

    public StrengthStatics(Factory factory) {
        this._factory = factory;
    }
    public void DrawStrength(Graphics graphics){
        graphics.setColor(new Color(205, 235, 9));
        graphics.drawString("Strength level: " + Skills.getRealLevel(Skill.STRENGTH)
                + " (" + (Skills.getRealLevel(Skill.STRENGTH) - SkillTracker.getStartLevel(Skill.STRENGTH)) + ")", Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.STRENGTH),  Line2[0], Line2[1]);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.STRENGTH) / 60000 + "(Minutes)", Line3[0], Line3[1]);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.STRENGTH)), Line4[0], Line4[1]);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.STRENGTH)), Line5[0], Line5[1]);
    }
}
