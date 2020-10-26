package Combat;

import Factory.WindowVariables;
import GUI.WindowSetting;

public class CombatVariables {
    private WindowSetting _windowSetting;
    private WindowVariables _WindowVariables;
    private boolean isStarted;
    public CombatVariables(Main main) {
        this._windowSetting = new WindowSetting(main);
        this._WindowVariables = new WindowVariables();
        this.isStarted = false;
    }

    public WindowSetting get_window() {
        return _windowSetting;
    }

    public WindowVariables get_WindowVariables() {
        return _WindowVariables;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }
}
