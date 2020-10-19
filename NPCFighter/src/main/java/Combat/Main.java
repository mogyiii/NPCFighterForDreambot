package Combat;

import Factory.Factory;
import Factory.Methods.PlayerEquipment;
import GUI.Window;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
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
				Start();
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
	public void Start(){
		_factory.getItems().setStartedItems();
		_factory.getBotArea().setStartedArea();
		_factory.getBotArea().setWalkToArea(_factory.getBotArea().getStartedArea());
		_factory.setPlayerEquipment(new PlayerEquipment(
				Equipment.getItemInSlot(EquipmentSlot.HAT.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.CHEST.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.WEAPON.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.SHIELD.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.AMULET.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.LEGS.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.FEET.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.RING.getSlot()),
				Equipment.getItemInSlot(EquipmentSlot.CAPE.getSlot())
		));
		SkillTracker.start(Skill.PRAYER);
		SkillTracker.start(Skill.HITPOINTS);
		SkillTracker.start(Skill.STRENGTH);
		SkillTracker.start(Skill.DEFENCE);
		SkillTracker.start(Skill.ATTACK);
		SkillTracker.start(Skill.RANGED);
		SkillTracker.start(Skill.MAGIC);
		_factory.getSkillCheck().SkillCheckSelectType();
		get_CombatVariables().get_window().setVisible(false);
		IsSaved = true;
	}
	public boolean isSaved() {
		return IsSaved;
	}
}
