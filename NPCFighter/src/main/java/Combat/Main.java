package Combat;

import Factory.Factory;
import GUI.Window;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.COMBAT, name = "Mogy NPC Fighter", author = "Mogyiii", version = 1.0)
public class Main extends AbstractScript {
	private CombatVariables _CombatVariables;
	private Factory _factory;
	@Override
	public void onStart() {
		super.onStart();
		Window window = new Window(this);
		_CombatVariables = new CombatVariables(window);
		get_CombatVariables().get_window().GetJFrame().setVisible(true);
		_factory = new Factory(this);
	}

	@Override
	public int onLoop() {
		if(get_CombatVariables().isStarted()){

		}
		//log("Work?");
		return ((int) (Math.random() * 200));
	}

	public CombatVariables get_CombatVariables() {
		return _CombatVariables;
	}

	public Factory get_factory() {
		return _factory;
	}
}
