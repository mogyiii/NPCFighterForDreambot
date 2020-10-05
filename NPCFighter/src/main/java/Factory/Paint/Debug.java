package Factory.Paint;

import Factory.Factory;
import org.dreambot.api.methods.map.Map;
import org.dreambot.api.methods.map.Tile;

import java.awt.*;

public class Debug {
    private Factory _factory;
    public Debug(Factory factory) {
        _factory = factory;
    }
    public void DebugHandle(Graphics graphics){
        MapDrawStartedArea(graphics);
    }
    private void MapDrawStartedArea(Graphics graphics){
        if(_factory.getMain().isSaved()) {
            graphics.setColor(Color.MAGENTA);
            Tile[] currentareatiles = _factory.getBotArea().getStartedArea().getTiles();
            if (currentareatiles != null) {
                for (int i = 0; i < currentareatiles.length - 1; i++){
                    graphics.drawRect((int) Map.tileToMiniMap(currentareatiles[i]).getX(), (int) Map.tileToMiniMap(currentareatiles[i]).getY(), 2, 2);
                }
            }
        }
    }
}
