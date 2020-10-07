package Factory.Paint;

import Factory.Factory;
import org.dreambot.api.methods.map.Map;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;

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
        if(_factory.getMain().isSaved() && _factory.getButtons().isDebug()) {
            graphics.setColor(Color.MAGENTA);
            Tile[] currentareatiles = _factory.getBotArea().getStartedArea().getTiles();
            if (currentareatiles != null) {
                for (int i = 0; i < currentareatiles.length - 1; i++){
                    graphics.drawRect((int) Map.tileToMiniMap(currentareatiles[i]).getX(), (int) Map.tileToMiniMap(currentareatiles[i]).getY(), 2, 2);
                }
            }
            graphics.setColor(Color.RED);
            NPC SelectedNpc = _factory.getCombat().getSelectedEnemy();
            Font font = new Font("Franklin Gothic Medium", Font.PLAIN, 10);
            graphics.setFont(font);
            if(SelectedNpc.isOnScreen()){
                graphics.drawRect((int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getX(),
                        (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getY(),
                        SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().width,
                        SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().height);
                graphics.drawString("Name: " + SelectedNpc.getName(), (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getX() + SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().width + 5, (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getY());
                graphics.drawString("Level: " + SelectedNpc.getLevel(), (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getX() + SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().width + 5, (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getY() + 15);
                graphics.drawString("ID: " + SelectedNpc.getID(), (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getX() + SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().width + 5, (int)SelectedNpc.getModel().getEntity().getBoundingBox().getBounds().getY() + 30);
            }

            //graphics.drawRoundRect(150, 150,50,50,50,50);
        }
    }
}
