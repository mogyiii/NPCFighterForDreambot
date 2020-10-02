package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Random;

public class InterfaceWidgets {
    private Factory _factory;
    private WidgetChild FriendList;
    private WidgetChild Emote;
    private WidgetChild Worn;
    private WidgetChild Quests;
    private WidgetChild Musics;
    private WidgetChild Clan;
    private WidgetChild Settings;
    private WidgetChild Invertory;
    public InterfaceWidgets(Factory factory) {
        this._factory = factory;
        FriendList = Widgets.getChildWidget(164, 46);
        Emote = Widgets.getChildWidget(164, 48);
        Worn = Widgets.getChildWidget(164, 64);
        Quests = Widgets.getChildWidget(164, 62);
        Musics = Widgets.getChildWidget(164, 49);
        Clan = Widgets.getChildWidget(164, 44);
        Settings = Widgets.getChildWidget(164, 47);
        Invertory = Widgets.getChildWidget(164, 63);
    }
    public WidgetChild GetRandomInterfaceTab(){
        WidgetChild[] Widgets = new WidgetChild[]{FriendList, Emote, Worn, Quests, Musics, Clan, Settings, Invertory};
        Random ran = new Random();
        return Widgets[ran.nextInt(Widgets.length) + 0];
    }
    public Tab getRandomTab(){
        Tab[] Tabs = new Tab[]{Tab.FRIENDS, Tab.EMOTES, Tab.EQUIPMENT, Tab.QUEST, Tab.MUSIC, Tab.CLAN, Tab.OPTIONS, Tab.INVENTORY};
        Random ran = new Random();
        return Tabs[ran.nextInt(Tabs.length) + 0];
    }
    public WidgetChild getFriendList() {
        return FriendList;
    }

    public WidgetChild getEmote() {
        return Emote;
    }

    public WidgetChild getWorn() {
        return Worn;
    }

    public WidgetChild getQuests() {
        return Quests;
    }

    public WidgetChild getMusics() {
        return Musics;
    }

    public WidgetChild getClan() {
        return Clan;
    }

    public WidgetChild getSettings() {
        return Settings;
    }

    public WidgetChild getInvertory() {
        return Invertory;
    }
}
