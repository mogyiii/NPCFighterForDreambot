package Combat;

import Factory.Factory;

public class SetStart {
    private Factory _factory;

    public SetStart(Factory factory) {
        this._factory = factory;
        factory.getTime().setStartTime(System.currentTimeMillis());
    }

}
