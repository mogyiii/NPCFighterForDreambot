package Combat;

import Factory.Factory;
import GUI.Window;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.widgets.message.Message;

import java.awt.*;
import java.awt.event.MouseEvent;

@ScriptManifest(category = Category.COMBAT, name = "Mogy NPC Fighter", author = "Mogyiii", version = 1.0)
public class Main extends AbstractScript {
	private CombatVariables _CombatVariables;
	private Factory _factory;
	private boolean IsSaved = false;
	private SetStart setStart;
	@Override
	public void onStart() {
		super.onStart();
        this._CombatVariables = new CombatVariables(new Window(this));
        this._factory = new Factory(this);
		this.setStart = new SetStart(this._factory);
	}

	@Override
	public void onPaint(Graphics graphics) {
		super.onPaint(graphics);
		_factory.getInterfaceGraphics().Drawn(graphics);
	}

	@Override
	public void onMessage(Message message) {
		if(get_CombatVariables().isStarted() && !_factory.getMain().getRandomManager().isSolving()){
			if(message.getMessage().contains("You get some")){

		/*}else if(message.getMessage().contains("I can't reach that!")){
			if(getGameObjects().closest("Wilderness Ditch").exists()){
				GetFactory().getIU().SetActivity( "Jump!");
				GetFactory().getDoWalk().WildernessJumping();
			}*/
			}else{
				_factory.getChatBot().Answer(message);
			}
		}
	}

	@Override
	public int onLoop() {
		if(get_CombatVariables().isStarted() && !_factory.getMain().getRandomManager().isSolving()){
			if(!IsSaved && !_factory.getMain().getRandomManager().getWelcomeScreenSolver().shouldExecute()){
				_factory.getItems().setStartedItems();
				_factory.getItems().setEquipItems();
				_factory.getBotArea().setStartedArea();
				_factory.getBotArea().setWalkToArea(_factory.getBotArea().getStartedArea());
				get_CombatVariables().get_window().setVisible(false);
				IsSaved = true;
			}

			_factory.getWalking().WalkingHandler();
			if(_factory.getCombat().getSelectedEnemy() == null){
				_factory.getGround().BonesHandle();
				_factory.getArrow().ArrowHandler();
			}
			_factory.getSelectedAttackTypeHandle().SelectCombatType();
			_factory.getArrow().EquipArrow();
			_factory.getPotions().CheckCanDrinkPotion();
			_factory.getEAT().Eating();
			_factory.getAntiBan().RandomAntiBan();
			_factory.getMain().getRandomManager().runRandomManager();
		}else if(!_factory.getMain().getRandomManager().isSolving() && !get_CombatVariables().isStarted()){
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

	@Override
	public void onMouse(MouseEvent event) {
		super.onMouse(event);
		_factory.getButtons().ButtonsHandle(event);

	}

	public CombatVariables get_CombatVariables() {
		return _CombatVariables;
	}

	public Factory get_factory() {
		return _factory;
	}

	public boolean isSaved() {
		return IsSaved;
	}
}
