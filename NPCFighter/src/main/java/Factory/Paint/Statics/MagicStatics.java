package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;
import static Factory.Paint.Statics.Lines.Line3;

public class MagicStatics {
    private Factory _factory;

    public MagicStatics(Factory factory) {
        this._factory = factory;
    }
    public static void DrawMagic(Graphics graphics){
        graphics.setColor(new Color(90, 3, 252));
        graphics.drawString("Magic level: " + Skills.getRealLevel(Skill.MAGIC)
                + " (" + (Skills.getRealLevel(Skill.MAGIC) - SkillTracker.getStartLevel(Skill.MAGIC)) + ")", Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.MAGIC), Line2[0], Line2[1]);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.MAGIC) / 60000 + "(Minutes)",  Line3[0], Line3[1]);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.MAGIC)), Line4[0], Line4[1]);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.MAGIC)), Line5[0], Line5[1]);
    }
}
