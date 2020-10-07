package Factory.Paint;

import Factory.Enums.DrawSkill;
import Factory.Factory;
import Factory.Paint.Statics.*;

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
        graphics.drawString("Time running: " + _factory.getTime().eclapsedtime(_factory.getTime().getStartTime()), 22, 51);
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

}
