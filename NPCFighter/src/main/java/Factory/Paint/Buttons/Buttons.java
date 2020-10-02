package Factory.Paint.Buttons;

import Factory.Factory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Buttons {
    private Factory _factory;
    public Buttons(Factory factory) {
        this._factory = factory;
    }
    public void ButtonsHandle(MouseEvent event){

    }
    Point p;
    boolean hide = false;
    Rectangle close = new Rectangle(10, 457, 118, 20);
    Rectangle open = new Rectangle(10, 457, 118, 20);
}
