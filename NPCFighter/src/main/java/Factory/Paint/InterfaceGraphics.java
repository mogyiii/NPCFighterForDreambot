package Factory.Paint;

import Factory.Enums.DrawSkill;
import Factory.Factory;
import Factory.Paint.Statics.*;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.world.Worlds;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import static java.lang.Math.toIntExact;

public class InterfaceGraphics {
    private Factory _factory;
    private int BurieddBones = 0;
    private Image BackgroundPaint = getImage("https://i.imgur.com/QB32DJT.png");
    private long FollowerTimeSecond;
    private int DotCounter = 0;
    private String Dot = "...";
    private AttackStatics attackStatics;
    private DefendStatics defendStatics;
    private MagicStatics magicStatics;
    private PrayerStatics prayerStatics;
    private RangedStatics rangedStatics;
    private StrengthStatics strengthStatics;
    private DrawSkill selectedDrawSkill;
    private HitPointsStatics hitPointsStatics;

    public InterfaceGraphics(Factory factory) {
        _factory = factory;
        attackStatics = new AttackStatics(factory);
        defendStatics = new DefendStatics(factory);
        magicStatics = new MagicStatics(factory);
        prayerStatics = new PrayerStatics(factory);
        rangedStatics = new RangedStatics(factory);
        strengthStatics = new StrengthStatics(factory);
        hitPointsStatics = new HitPointsStatics(factory);

    }


    public void Drawn(Graphics graphics){

        if(!_factory.getButtons().isHide()){
            graphics.drawImage(BackgroundPaint, 0, 0, null);
            if(!_factory.getButtons().isHide()){
                _factory.getDebug().DebugHandle(graphics);
            }
            Font font = new Font("Franklin Gothic Medium", Font.PLAIN, 15);
            graphics.setFont(font);
            graphics.setColor(new Color(255, 255, 255));
            GeneralDraw(graphics);
            SelectDraw(graphics);
            HoverButtons(graphics);

        }else{
            graphics.drawString("x", 597, 10);
        }

    }
    private void SelectDraw(Graphics graphics){
        switch (getSelectedDrawSkill()){
            case Magic:
                magicStatics.DrawMagic(graphics);
                break;
            case Attack:
                attackStatics.DrawAttack(graphics);
                break;
            case Defend:
                defendStatics.DrawDefend(graphics);
                break;
            case Prayer:
                prayerStatics.DrawPrayer(graphics);
                break;
            case Ranged:
                rangedStatics.DrawRanged(graphics);
                break;
            case Strength:
                strengthStatics.DrawStrength(graphics);
                break;
            case Hitpoints:
                hitPointsStatics.DrawHitPoints(graphics);
                break;
        }
    }
    private void HoverButtons(Graphics graphics){
        graphics.drawRect((int)_factory.getButtons().getHoverBtn().getX(),
                (int)_factory.getButtons().getHoverBtn().getY(),
                (int)_factory.getButtons().getHoverBtn().getWidth(),
                (int)_factory.getButtons().getHoverBtn().getHeight());
    }
    private void GeneralDraw(Graphics graphics){
        graphics.drawString("Time running: " + _factory.getTime().eclapsedtime(_factory.getTime().getStartTime()), 22, 45);
        graphics.drawString("Combat level: " + _factory.getMain().getLocalPlayer().getLevel(), 22, 65);
        graphics.drawString("Total level: " + Skills.getTotalLevel(), 22, 85);
        graphics.drawString("Current world: " + Worlds.getCurrentWorld(), 22, 105);
        graphics.drawString("Is MultiCombat Area? (" + Combat.isInMultiCombat() + ")", 22, 125);
        graphics.drawString("Special percentage: " + Combat.getSpecialPercentage(), 22, 145);
        graphics.drawString("Total estimated Xp/hour: " + TotalEstimatedXp(), 22, 165);
        graphics.drawString(_factory.getInteractionUser().getActivity() + dot(), 22, 185);
    }

    private String dot(){
        long TimeSecond = System.currentTimeMillis()/ 1000l;
        if(toIntExact(FollowerTimeSecond) <  toIntExact(TimeSecond)){


            for(int j = 0; j < DotCounter; j++){
                Dot +=".";
            }
            if(Dot.length() >= 4){
                Dot ="";
                DotCounter = 0;
            }
            DotCounter++;
        }
        FollowerTimeSecond = System.currentTimeMillis()/ 1000l;
        return Dot;
    }
    public int getBuriedBones() {
        return BurieddBones;
    }
    public void setBuriedBones(int burieddBones) {
        this.BurieddBones = burieddBones;
    }
    private Image getImage(String url){
        try{
            return ImageIO.read(new URL(url));
        }catch(IOException e){
            return null;
        }
    }

    public DrawSkill getSelectedDrawSkill() {
        return selectedDrawSkill;
    }

    public void setSelectedDrawSkill(DrawSkill selectedDrawSkill) {
        this.selectedDrawSkill = selectedDrawSkill;
    }
    public float TotalEstimatedXp(){
        return SkillTracker.getGainedExperiencePerHour(Skill.MAGIC)
                + SkillTracker.getGainedExperiencePerHour(Skill.PRAYER)
                + SkillTracker.getGainedExperiencePerHour(Skill.ATTACK)
                + SkillTracker.getGainedExperiencePerHour(Skill.STRENGTH)
                + SkillTracker.getGainedExperiencePerHour(Skill.DEFENCE)
                + SkillTracker.getGainedExperiencePerHour(Skill.HITPOINTS)
                + SkillTracker.getGainedExperiencePerHour(Skill.RANGED);
    }
}
