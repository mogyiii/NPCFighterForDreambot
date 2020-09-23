package Factory;

import Combat.Main;
import Factory.Methods.AntiBan;
import Factory.Methods.DynamicCombat;
import Factory.Methods.SelectedAttackTypeHandle;
import Factory.Methods.SkillCheck;
import main.java.Factory.Methods.Npcs;

public class Factory {
    private Main _main;
    private Npcs _Npcs;
    private InteractionUser _IU;
    private AntiBan _AB;
    private SkillCheck _SC;
    private SelectedAttackTypeHandle _SATH;
    private DynamicCombat _DC;
    public Factory(Main main) {
        this._main = main;
        this._Npcs = new Npcs(this);
        this._IU = new InteractionUser(this);
        this._AB = new AntiBan(this);
        this._SC = new SkillCheck(this);
        this._SATH = new SelectedAttackTypeHandle(this);
        this._DC = new DynamicCombat(this);
    }

    public Main get_main() {
        return _main;
    }

    public Npcs get_Npcs() {
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
}
