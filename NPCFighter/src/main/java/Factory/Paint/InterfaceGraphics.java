package Factory.Paint;

import Factory.Factory;

public class InterfaceGraphics {
    private Factory _factory;
    private int burydBones = 0;
    public InterfaceGraphics(Factory factory) {
        _factory = factory;
    }

    public int getBurydBones() {
        return burydBones;
    }

    public void setBurydBones(int burydBones) {
        this.burydBones = burydBones;
    }
}
