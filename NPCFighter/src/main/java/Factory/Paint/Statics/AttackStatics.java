package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;

public class AttackStatics {
    private Factory _factory;
    public AttackStatics(Factory factory) {
        _factory = factory;
    }
    public static void DrawAttack(Graphics graphics){
        graphics.setColor(new Color(252, 236, 3));
        graphics.drawString("Attack level: " + Skills.getRealLevel(Skill.ATTACK) +
                " (" + (Skills.getRealLevel(Skill.PRAYER) - SkillTracker.getStartLevel(Skill.ATTACK)) + ")", Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.ATTACK), Line2[0], Line2[1]);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.ATTACK) / 60000 + "(Minutes)", Line3[0], Line3[1]);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.ATTACK)), Line4[0], Line4[1]);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.ATTACK)), Line5[0], Line5[1]);
    }
}
