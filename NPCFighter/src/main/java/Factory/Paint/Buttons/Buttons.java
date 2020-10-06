package Factory.Paint.Buttons;

import Factory.Enums.DrawSkill;
import Factory.Factory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Buttons {
    private Factory _factory;
    public Buttons(Factory factory) {
        this._factory = factory;
        _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Hitpoints);
    }
    //Close/Open
    Point p;
    boolean hide = false;
    boolean debug = false;
    Rectangle close = new Rectangle(596, 2, 10, 10);
    Rectangle DebugBTN = new Rectangle(596, 20, 10, 10);
    Rectangle HitpointBtn = new Rectangle(388, 168, 25, 25);
    Rectangle PrayerBtn = new Rectangle(419, 168, 25, 25);
    Rectangle MagicBtn = new Rectangle(451, 168, 25, 25);
    Rectangle RangedBtn = new Rectangle(481, 168, 25, 25);
    Rectangle DefendBtn = new Rectangle(513, 168, 25, 25);
    Rectangle AttackBtn = new Rectangle(544, 168, 25, 25);
    Rectangle StrengthBtn = new Rectangle(574, 168, 25, 25);
    Rectangle HoverBtn;
    public void ButtonsHandle(MouseEvent event){
        ClickButtons(event);
        HoverButtons(event);
    }
    public void ClickButtons(MouseEvent event){
        p = event.getPoint();
        if (close.contains(p) && !hide) {
            hide = true;
        } else if (close.contains(p) && hide) {
            hide = false;
        }else if (DebugBTN.contains(p) && !debug) {
            debug = true;
        }else if (DebugBTN.contains(p) && debug) {
            debug = false;
        }else if (HitpointBtn.contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Hitpoints);
        }else if (PrayerBtn.contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Prayer);
        }else if (MagicBtn.contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Magic);
        }else if (RangedBtn.contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Ranged);
        }else if (DefendBtn .contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Defend);
        }else if (AttackBtn.contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Attack);
        }else if (StrengthBtn.contains(p)){
            _factory.getInterfaceGraphics().setSelectedDrawSkill(DrawSkill.Strength);
        }
    }
    public void HoverButtons(MouseEvent event){
        Point pointHover = new Point();
        pointHover.setLocation(event.getX(), event.getY());
        if (close.contains(pointHover)) {
            HoverBtn = close;
        }else if (DebugBTN.contains(pointHover)) {
            HoverBtn = DebugBTN;
        }else if (HitpointBtn.contains(pointHover)){
            HoverBtn = HitpointBtn;
        }else if (PrayerBtn.contains(pointHover)){
            HoverBtn = PrayerBtn;
        }else if (MagicBtn.contains(pointHover)){
            HoverBtn = MagicBtn;
        }else if (RangedBtn.contains(pointHover)){
            HoverBtn = RangedBtn;
        }else if (DefendBtn .contains(pointHover)){
            HoverBtn = DefendBtn;
        }else if (AttackBtn.contains(pointHover)){
            HoverBtn = AttackBtn;
        }else if (StrengthBtn.contains(pointHover)){
            HoverBtn = StrengthBtn;
        }else{
            HoverBtn = new Rectangle(0, 0, 0, 0);
        }
    }

    public boolean isHide() {
        return hide;
    }

    public boolean isDebug() {
        return debug;
    }

    public Rectangle getHoverBtn() {
        return HoverBtn;
    }
}
