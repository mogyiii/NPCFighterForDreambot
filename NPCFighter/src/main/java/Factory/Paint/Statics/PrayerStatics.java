package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;

import java.awt.*;

import static Factory.Paint.Statics.Lines.*;

public class PrayerStatics {
    private Factory _factory;

    public PrayerStatics(Factory factory) {
        this._factory = factory;
    }
    public void DrawPrayer(Graphics graphics){

        graphics.drawString("Prayer level: " + Skills.getRealLevel(Skill.PRAYER) + " (" + (Skills.getRealLevel(Skill.PRAYER) - SkillTracker.getStartLevel(Skill.PRAYER)) + ")", Line1[0], Line1[1]);
        graphics.drawString("Estimated Xp/hour: " + SkillTracker.getGainedExperiencePerHour(Skill.PRAYER), Line2[0], Line2[1] - 10);
        graphics.drawString("Next level: " + SkillTracker.getTimeToLevel(Skill.PRAYER) / 60000 + "(Minutes)", Line3[0], Line3[1] - 20);
        graphics.drawString("Xp gained: " + (SkillTracker.getGainedExperience(Skill.PRAYER)), Line4[0], Line4[1] - 30);
        graphics.drawString("Xp remaining: " + (Skills.getExperienceToLevel(Skill.PRAYER)), Line5[0], Line5[1] - 40);
        graphics.drawString("Bury/hour: " + _factory.getInterfaceGraphics().getBuriedBones() * (int) (3600D / _factory.getTime().eclapsedsec(_factory.getTime().getStartTime())), Line6[0], Line6[1] - 50);
        graphics.drawString("Buried Bones: " + _factory.getInterfaceGraphics().getBuriedBones(), Line7[0], Line7[1] - 60);
    }
}
