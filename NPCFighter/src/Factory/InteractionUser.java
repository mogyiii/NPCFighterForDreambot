package Factory;

public class InteractionUser {
    private String thought = "";
    private String activity;
    private Factory _factory;
    private  boolean starting = true;
    public InteractionUser(Factory factory) {
        _factory = factory;
    }

    public void SetThought(String _thought){thought = _thought;}
    public void SetActivity(String _activity){activity = _activity;}

    public String getThought() {
        return thought;
    }

    public String getActivity() {
        return activity;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }
}
