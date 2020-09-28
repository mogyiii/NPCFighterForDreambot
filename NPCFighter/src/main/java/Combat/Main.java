package Combat;

import Factory.Factory;
import GUI.Window;
import org.dreambot.api.methods.Calculations;
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
        this._CombatVariables = new CombatVariables(new Window(this));
        this._factory = new Factory(this);
	}

	@Override
	public int onLoop() {
		if(get_CombatVariables().isStarted() && !_factory.get_main().getRandomManager().isSolving()){
			get_CombatVariables().get_window().setVisible(false);
			_factory.getSelectedAttackTypeHandle().SelectCombatType();


			_factory.getEAT().Eating();
			_factory.getAntiBan().RandomAntiBan();
			_factory.get_main().getRandomManager().runRandomManager();
		}else if(!_factory.get_main().getRandomManager().isSolving() && !get_CombatVariables().isStarted()){
			get_CombatVariables().get_window().setVisible(true);
		}
		return Calculations.random(300, 500);
	}

    @Override
    public void onExit() {
        super.onExit();
        get_CombatVariables().get_window().setVisible(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        get_CombatVariables().get_window().setVisible(false);
    }

    public CombatVariables get_CombatVariables() {
		return _CombatVariables;
	}

	public Factory get_factory() {
		return _factory;
	}

}
