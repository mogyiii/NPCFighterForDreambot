package Factory.Paint.Statics;

import Factory.Factory;
import org.dreambot.api.methods.skills.Skill;

import java.awt.*;

public class PrayerStatics {
    private Factory _factory;

    public PrayerStatics(Factory factory) {
        this._factory = factory;
    }
    public void DrawPrayer(Graphics graphics){

        graphics.drawString("Prayer level: " + _factory.getMain().getSkills().getRealLevel(Skill.PRAYER) + " (" + (_factory.getMain().getSkills().getRealLevel(Skill.PRAYER) - _factory.getMain().getSkillTracker().getStartLevel(Skill.PRAYER)) + ")", 10, 385);
        graphics.drawString("Estimated Xp/hour: " + _factory.getMain().getSkillTracker().getGainedExperiencePerHour(Skill.PRAYER), 10, 415);
        graphics.drawString("Next level: " + _factory.getMain().getSkillTracker().getTimeToLevel(Skill.PRAYER) / 60000 + "(Minutes)", 10, 430);
        graphics.drawString("Xp gained: " + (_factory.getMain().getSkillTracker().getGainedExperience(Skill.PRAYER)), 10, 445);
        graphics.drawString("Xp remaining: " + (_factory.getMain().getSkills().getExperienceToLevel(Skill.PRAYER)), 10, 460);
        graphics.drawString("Bury/hour: " + _factory.getInterfaceGraphics().getBuriedBones() * (int) (3600D / _factory.getTime().eclapsedsec(_factory.getTime().getStartTime())), 10, 400);
        graphics.drawString("Buried Bones: " + _factory.getInterfaceGraphics().getBuriedBones(), 10, 355);
    }
}
