package Factory;

import Combat.Main;
import Methods.Npcs;

public class Factory {
    private Main _main;
    private Npcs _Npcs;
    public Factory(Main main) {
        this._main = main;
        this._Npcs = new Npcs(this);
    }

    public Main get_main() {
        return _main;
    }

    public Npcs get_Npcs() {
        return _Npcs;
    }
}
