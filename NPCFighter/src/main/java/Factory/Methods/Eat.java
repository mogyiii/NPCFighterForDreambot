package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Factory;
import Factory.Models.FoodsModel;
import org.dreambot.api.methods.skills.Skill;

public class Eat {
    private Factory _factory;
    public Eat(Factory factory) {
        _factory = factory;
    }
    public void Eating(){
        try{
            if(_factory.getMain().getInventory().get(getEdibleFoodFromInvertory()).interact(InteractionCenter.Eat.toString())){
                _factory.getInteractionUser().SetActivity("Eating...");
            }
        }catch (Exception e){
            _factory.getMain().log("Food error: " + e.toString());

        }
    }
    public String getEdibleFoodFromInvertory(){
        FoodsModel[] FoodModel =  _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("Foods.json"), FoodsModel[].class);
        for (int i = 0; i < FoodModel.length; i++) {
            if (getMissingHitpoints() > FoodModel[i].Heals && _factory.getMain().getInventory().contains(FoodModel[i].Food)) {
                return FoodModel[i].Food;
            }
        }
        return null;
    }
    private int getMissingHitpoints(){
        return _factory.getMain().getSkills().getRealLevel(Skill.HITPOINTS) +_factory.getMain().getSkills().getBoostedLevels(Skill.HITPOINTS);
    }
}
