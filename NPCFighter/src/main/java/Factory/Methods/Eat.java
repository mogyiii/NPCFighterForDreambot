package Factory.Methods;

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
            if(_factory.get_main().getInventory().get(getEdibleFoodFromInvertory()).interact("Eat")){
                _factory.getInteractionUser().SetActivity("Eating...");
            }
        }catch (Exception e){
            _factory.get_main().log("Food error: " + e.toString());
        }
    }
    public String getEdibleFoodFromInvertory(){
        FoodsModel[] FoodModel =  _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("/main/resources/Foods.json"), FoodsModel[].class);
        for (int i = 0; i < FoodModel.length; i++) {
            if (getMissingHitpoints() > FoodModel[i].Heals && _factory.get_main().getInventory().contains(FoodModel[i].Food)) {
                return FoodModel[i].Food;
            }
        }
        return null;
    }
    private int getMissingHitpoints(){
        return _factory.get_main().getSkills().getRealLevel(Skill.HITPOINTS) +_factory.get_main().getSkills().getBoostedLevels(Skill.HITPOINTS);
    }
}
