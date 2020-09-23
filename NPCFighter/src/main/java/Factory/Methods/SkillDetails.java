package Factory.Methods;

public class SkillDetails{
    private String _Name;
    private int _StartLevel;
    public SkillDetails(String name, int startlevel) {
        this._Name = name;
        this._StartLevel = startlevel;
    }

    public String get_Name() {
        return _Name;
    }

    public int get_StartLevel() {
        return _StartLevel;
    }
}
