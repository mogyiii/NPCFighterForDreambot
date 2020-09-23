package main.java.Factory.Methods;

import Factory.Factory;
import org.dreambot.api.wrappers.interactive.NPC;

import java.util.List;

public class Npcs {
    private Factory _factory;
    public Npcs(Factory factory) {
        this._factory = factory;
    }

    public List<NPC> GetAllNpc(){
        return _factory.get_main().getNpcs().all();
    }
}
