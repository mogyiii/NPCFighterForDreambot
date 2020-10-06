package Factory.Paint;

import Factory.Factory;
import org.dreambot.api.methods.map.Map;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;

import java.awt.*;

public class Debug {
    private Factory _factory;
    private ThreeD threeD;
    public Debug(Factory factory) {
        _factory = factory;
        threeD = new ThreeD(factory);
    }
    public void DebugHandle(Graphics graphics){
        MapDrawStartedArea(graphics);
    }
    private void MapDrawStartedArea(Graphics graphics){
        if(_factory.getMain().isSaved() && _factory.getButtons().isDebug()) {
            graphics.setColor(Color.MAGENTA);
            Tile[] currentareatiles = _factory.getBotArea().getStartedArea().getTiles();
            if (currentareatiles != null) {
                for (int i = 0; i < currentareatiles.length - 1; i++){
                    graphics.drawRect((int) Map.tileToMiniMap(currentareatiles[i]).getX(), (int) Map.tileToMiniMap(currentareatiles[i]).getY(), 2, 2);
                }
            }
            NPC SelectedNpc = _factory.getCombat().getSelectedEnemy();
            graphics.drawRect(new Rectangle(SelectedNpc.getLocalX(), SelectedNpc.getLocalY(),SelectedNpc.));
        }
    }
}
