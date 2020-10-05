package Factory;

import Combat.Main;
import Factory.Methods.*;
import Factory.Paint.Buttons.Buttons;
import Factory.Paint.Debug;
import Factory.Paint.InterfaceGraphics;
import Moduls.DownloadData;
import Moduls.GrandExchangeApi;
import Moduls.Json;
import Moduls.Time;

public class Factory {
    private Main _main;
    private Npcs _Npcs;
    private InteractionUser _IU;
    private AntiBan _AB;
    private SkillCheck _SC;
    private SelectedAttackTypeHandle _SATH;
    private DynamicCombat _DC;
    private Fight _CB;
    private Eat _EAT;
    private Json JSON;
    private InterfaceWidgets _IW;
    private DownloadData _DF;
    private ChatBot _ChatBot;
    private Items Items;
    private DrinkPotions Potions;
    private BotArea BotArea;
    private Walks Walking;
    private Banking Banking;
    private Ground ground;
    private InterfaceGraphics InterfaceGraphics;
    private Time time;
    private Arrow arrow;
    private Buttons buttons;
    private Debug Debug;
    public Factory(Main main) {
        this._main = main;
        this._Npcs = new Npcs(this);
        this._IU = new InteractionUser(this);
        this._AB = new AntiBan(this);
        this._SC = new SkillCheck(this);
        this._DC = new DynamicCombat(this);
        this._SATH = new SelectedAttackTypeHandle(this);
        this._CB = new Fight(this);
        this._EAT = new Eat(this);
        this.JSON = new Json(this);
        this._DF = new DownloadData(this);
        this._IW  = new InterfaceWidgets(this);
        this._ChatBot = new ChatBot(this);
        this.Items = new Items(this);
        this.Potions = new DrinkPotions(this);
        this.BotArea = new BotArea(this);
        this.Walking = new Walks(this);
        this.Banking = new Banking(this);
        this.ground = new Ground(this);
        this.InterfaceGraphics = new InterfaceGraphics(this);
        this.time = new Time(this);
        this.arrow = new Arrow(this);
        this.buttons = new Buttons(this);
        this.Debug = new Debug(this);

    }

    public Main getMain() {
        return _main;
    }

    public Npcs getNpcs() {
        return _Npcs;
    }

    public InteractionUser getInteractionUser() {
        return _IU;
    }

    public AntiBan getAntiBan() {
        return _AB;
    }

    public SkillCheck getSkillCheck() {
        return _SC;
    }

    public SelectedAttackTypeHandle getSelectedAttackTypeHandle() {
        return _SATH;
    }

    public DynamicCombat getDynamicCombat(){
        return _DC;
    }
    public Fight getCombat(){
        return _CB;
    }

    public Eat getEAT() {
        return _EAT;
    }

    public Json getJSON() {
        return JSON;
    }
    public DownloadData getDownload(){
        return _DF;
    }
    public InterfaceWidgets getInterfaceWidgets() {
        return _IW;
    }

    public ChatBot getChatBot() {
        return _ChatBot;
    }

    public Items getItems() {
        return Items;
    }

    public DrinkPotions getPotions() {
        return Potions;
    }

    public BotArea getBotArea() {
        return BotArea;
    }
    public Walks getWalking(){
        return Walking;
    }

    public Banking getBanking() {
        return Banking;
    }
    public Ground getGround() {
        return ground;
    }

    public InterfaceGraphics getInterfaceGraphics() {
        return InterfaceGraphics;
    }

    public GrandExchangeApi getGrandExchangeApi() {
        return new GrandExchangeApi(true);
    }

    public Time getTime() {
        return time;
    }

    public Arrow getArrow() {
        return arrow;
    }

    public Buttons getButtons() {
        return buttons;
    }

    public Debug getDebug() {
        return Debug;
    }
}
