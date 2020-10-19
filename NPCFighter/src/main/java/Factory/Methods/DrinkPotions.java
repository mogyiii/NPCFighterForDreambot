package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Enums.PotionsType;
import Factory.Factory;
import Factory.Models.PotionsModel;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.wrappers.items.Item;

public class DrinkPotions {
    private Factory _factory;
    static PotionsModel[] PotionsModel = null;
    public DrinkPotions(Factory factory) {
        _factory = factory;
    }

    public void CheckCanDrinkPotion(){
        if(PotionsModel == null){
            PotionsModel = _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("Potions.json"), PotionsModel[].class);
        }
        Item Potion = Inventory.get(item -> item != null && item.getName().contains("potion") && item.hasAction(InteractionCenter.Drink.toString()));
        if(Potion != null){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(Skills.getRealLevel(Skill.PRAYER) >= Skills.getBoostedLevels(Skill.PRAYER)){
                    if(Potion.getName().contains(PotionsModel[i].Name) && (PotionsModel[i].Type.equals(PotionsType.Prayer.toString()))){
                        Potion.interact(InteractionCenter.Drink.toString());
                        break;
                    }
                }
                if(Skills.getRealLevel(Skill.ATTACK) >= Skills.getBoostedLevels(Skill.ATTACK)){
                    if(Potion.getName().contains(PotionsModel[i].Name) && (PotionsModel[i].Type.equals(PotionsType.Attack.toString()))){
                        Potion.interact(InteractionCenter.Drink.toString());
                        break;
                    }
                }
                if(Skills.getRealLevel(Skill.STRENGTH) >= Skills.getBoostedLevels(Skill.STRENGTH)){
                    if(Potion.getName().contains(PotionsModel[i].Name) && (PotionsModel[i].Type.equals(PotionsType.Strength.toString()))){
                        Potion.interact(InteractionCenter.Drink.toString());
                        break;
                    }
                }
                if(Skills.getRealLevel(Skill.RANGED) >= Skills.getBoostedLevels(Skill.RANGED)){
                    if(Potion.getName().contains(PotionsModel[i].Name) && (PotionsModel[i].Type.equals(PotionsType.Ranging.toString()))){
                        Potion.interact(InteractionCenter.Drink.toString());
                        break;
                    }

                }
                if(Skills.getRealLevel(Skill.MAGIC) >= Skills.getBoostedLevels(Skill.MAGIC)){
                    if(Potion.getName().contains(PotionsModel[i].Name) && (PotionsModel[i].Type.equals(PotionsType.Magic.toString()))){
                        Potion.interact(InteractionCenter.Drink.toString());
                        break;
                    }
                }
                if(Walking.getRunEnergy() < 10){
                    if(Potion.getName().contains(PotionsModel[i].Name) && (PotionsModel[i].Type.equals(PotionsType.Energy.toString()))){
                        Potion.interact(InteractionCenter.Drink.toString());
                        break;
                    }
                }
            }
        }
    }
}
