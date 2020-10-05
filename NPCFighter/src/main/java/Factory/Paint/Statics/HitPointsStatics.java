package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;
import static Factory.Paint.Statics.Lines.Line3;

public class HitPointsStatics {
    private Factory _factory;

    public HitPointsStatics(Factory factory) {
        this._factory = factory;
    }
    public void DrawHitPoints(Graphics graphics){
        graphics.setColor(new Color(252, 3, 78));
        graphics.drawString("HitPoints level: " + Skills.getRealLevel(Skill.HITPOINTS)
                + " (" + (Skills.getRealLevel(Skill.HITPOINTS) - SkillTracker.getStartLevel(Skill.HITPOINTS)) + ")",Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.HITPOINTS), Line2[0], Line2[1]);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.HITPOINTS) / 60000 + "(Minutes)", Line3[0], Line3[1]);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.HITPOINTS)), Line4[0], Line4[1]);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.HITPOINTS)), Line5[0], Line5[1]);
    }
}
