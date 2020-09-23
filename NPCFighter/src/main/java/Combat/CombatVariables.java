package Combat;

import Factory.WindowVariables;
import GUI.Window;

public class CombatVariables {
    private Window _window;
    private WindowVariables _WindowVariables;
    private boolean isStarted = false;
    public CombatVariables(Window _window) {
        this._window = _window;
        this._WindowVariables = new WindowVariables();
    }

    public Window get_window() {
        return _window;
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
