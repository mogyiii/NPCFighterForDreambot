package Combat;

import GUI.Window;

public class CombatVariables {
    private Window _window;

    public CombatVariables(Window _window) {
        this._window = _window;
    }

    public Window get_window() {
        return _window;
    }
}
