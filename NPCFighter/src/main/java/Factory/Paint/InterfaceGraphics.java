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
    private Image BackgroundPaint = getImage("https://i.imgur.com/x28IfI6.png");
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
    private ThreeD threeD;
    public InterfaceGraphics(Factory factory) {
        _factory = factory;
        attackStatics = new AttackStatics(factory);
        defendStatics = new DefendStatics(factory);
        magicStatics = new MagicStatics(factory);
        prayerStatics = new PrayerStatics(factory);
        rangedStatics = new RangedStatics(factory);
        strengthStatics = new StrengthStatics(factory);
        hitPointsStatics = new HitPointsStatics(factory);
        threeD = new ThreeD(factory);
    }


    public void Drawn(Graphics graphics){
        graphics.drawImage(BackgroundPaint, 0, 0, null);
        Font font = new Font("Franklin Gothic Medium", Font.PLAIN, 12);
        graphics.setFont(font);
        graphics.setColor(new Color(255, 255, 255));
        GeneralDraw(graphics);
        switch (getSelectedDrawSkill()){
            case Magic:
                break;
            case Attack:
                break;
            case Defend:
                break;
            case Prayer:
                prayerStatics.DrawPrayer(graphics);
                break;
            case Ranged:
                break;
            case Strength:
                break;
        }

    }
    private void GeneralDraw(Graphics graphics){
        graphics.drawString("Time running: " + _factory.getTime().eclapsedtime(_factory.getTime().getStartTime()), 10, 370);
        graphics.drawString(_factory.getInteractionUser().getActivity() + dot(), 230, 472);
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
