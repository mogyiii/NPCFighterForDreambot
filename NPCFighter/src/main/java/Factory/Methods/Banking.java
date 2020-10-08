package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.wrappers.interactive.NPC;

public class Banking {
    private Factory _factory;
    public Banking(Factory factory) {
        _factory = factory;
    }
    public void banking(){
        _factory.getInteractionUser().SetActivity("Banking");
        NPC banker = NPCs.closest(npc -> npc != null && npc.hasAction(InteractionCenter.Bank.toString()));
        if (banker.interact(InteractionCenter.Bank.toString())) {
            if (_factory.getMain().sleepUntil(() -> Bank.open(), 9000)) {
                Bank.depositAllExcept(i -> _factory.getItems().getStarterItemsList().contains(i.getName()));
                _factory.getMain().sleep(300, 500);
                Bank.withdraw(i -> i.hasAction(InteractionCenter.Eat.toString()));
                _factory.getMain().sleep(300, 500);
                Bank.close();
                _factory.getMain().sleep(200, 3000);
            }
        }
    }
}
