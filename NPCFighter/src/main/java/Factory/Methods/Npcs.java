package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.wrappers.interactive.NPC;

import java.util.List;

public class Npcs {
    private Factory _factory;
    public Npcs(Factory factory) {
        this._factory = factory;
    }

    public List<NPC> GetAllNpc(){
        return NPCs.all();
    }
}
