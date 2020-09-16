package Combat;

import GUI.Window;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(category = Category.COMBAT, name = "Mogy NPC Fighter", author = "Mogyiii", version = 1.0)
public class Main extends AbstractScript {
	private CombatVariables _CombatVariables;
	@Override
	public void onStart() {
		super.onStart();
		_CombatVariables = new CombatVariables(new Window(this));
		get_CombatVariables().get_window().GetJFrame().setVisible(true);
	}

	@Override
	public int onLoop() {
		// TODO Auto-generated method stub
		log("Working?");
		return 500;
	}

	public CombatVariables get_CombatVariables() {
		return _CombatVariables;
	}
}
