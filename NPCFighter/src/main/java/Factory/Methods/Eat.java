package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import Factory.Models.FoodsModel;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.wrappers.items.Item;

public class Eat {
    private Factory _factory;
    public Eat(Factory factory) {
        _factory = factory;
    }
    public void Eating(){
        try{
            Item Food = Inventory.get(getEdibleFoodFromInvertory());
            if(Food != null){
                Food.interact(InteractionCenter.Eat.toString());
                _factory.getInteractionUser().SetActivity("Eating...");
            }
        }catch (Exception e){
            _factory.getMain().log("Food error: " + e.toString());
            NotRecognizableFood();
        }
    }
    public String getEdibleFoodFromInvertory(){
        FoodsModel[] FoodModel =  _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("Foods.json"), FoodsModel[].class);
        for (int i = 0; i < FoodModel.length; i++) {
            if (getMissingHitpoints() > FoodModel[i].Heals && Inventory.contains(FoodModel[i].Food)) {
                return FoodModel[i].Food;
            }
        }
        return null;
    }
    private int getMissingHitpoints(){
        return Skills.getRealLevel(Skill.HITPOINTS) + Skills.getBoostedLevels(Skill.HITPOINTS);
    }
    private void NotRecognizableFood(){
        if(_factory.getMain().getLocalPlayer().getHealthPercent() > 30){
            Inventory.get(Item -> Item != null && Item.hasAction(InteractionCenter.Eat.toString())).hasAction(InteractionCenter.Eat.toString());
        }
    }
}
