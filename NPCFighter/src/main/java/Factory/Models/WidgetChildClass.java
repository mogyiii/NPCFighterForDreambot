package Factory.Models;

import org.dreambot.api.wrappers.widgets.WidgetChild;

public class WidgetChildClass {
    public WidgetChildClass(String name, WidgetChild widgetChild) {
        Name = name;
        this.widgetChild = widgetChild;
    }
    private String Name;
    private WidgetChild widgetChild;

    public String getName() {
        return Name;
    }

    public WidgetChild getWidgetChild() {
        return widgetChild;
    }
}
