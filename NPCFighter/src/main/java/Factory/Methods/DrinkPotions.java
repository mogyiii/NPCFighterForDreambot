package Factory.Methods;

import Factory.Enums.InteractionCenter;
import Factory.Enums.PotionsType;
import Factory.Factory;
import Factory.Models.PotionsModel;
import org.dreambot.api.methods.skills.Skill;

public class DrinkPotions {
    private Factory _factory;
    public DrinkPotions(Factory factory) {
        _factory = factory;
    }

    public void CheckCanDrinkPotion(){
        PotionsModel[] PotionsModel =  _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("Potions.json"), PotionsModel[].class);
        if(_factory.getMain().getSkills().getRealLevel(Skill.PRAYER) >= _factory.getMain().getSkills().getBoostedLevels(Skill.PRAYER)){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(_factory.getMain().getInventory().contains(PotionsModel[i].Name) && PotionsModel[i].Type == PotionsType.Prayer.toString()){
                    _factory.getMain().getInventory().get(PotionsModel[i].Name).interact(InteractionCenter.Drink.toString());
                    break;
                }
            }
        }
        if(_factory.getMain().getSkills().getRealLevel(Skill.ATTACK) >= _factory.getMain().getSkills().getBoostedLevels(Skill.ATTACK)){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(_factory.getMain().getInventory().contains(PotionsModel[i].Name) && PotionsModel[i].Type == PotionsType.Attack.toString()){
                    _factory.getMain().getInventory().get(PotionsModel[i].Name).interact(InteractionCenter.Drink.toString());
                    break;
                }
            }
        }
        if(_factory.getMain().getSkills().getRealLevel(Skill.STRENGTH) >= _factory.getMain().getSkills().getBoostedLevels(Skill.STRENGTH)){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(_factory.getMain().getInventory().contains(PotionsModel[i].Name) && PotionsModel[i].Type == PotionsType.Strength.toString()){
                    _factory.getMain().getInventory().get(PotionsModel[i].Name).interact(InteractionCenter.Drink.toString());
                    break;
                }
            }
        }
        if(_factory.getMain().getSkills().getRealLevel(Skill.RANGED) >= _factory.getMain().getSkills().getBoostedLevels(Skill.RANGED)){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(_factory.getMain().getInventory().contains(PotionsModel[i].Name) && PotionsModel[i].Type == PotionsType.Ranging.toString()){
                    _factory.getMain().getInventory().get(PotionsModel[i].Name).interact(InteractionCenter.Drink.toString());
                    break;
                }
            }
        }
        if(_factory.getMain().getSkills().getRealLevel(Skill.MAGIC) >= _factory.getMain().getSkills().getBoostedLevels(Skill.MAGIC)){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(_factory.getMain().getInventory().contains(PotionsModel[i].Name) && PotionsModel[i].Type == PotionsType.Magic.toString()){
                    _factory.getMain().getInventory().get(PotionsModel[i].Name).interact(InteractionCenter.Drink.toString());
                    break;
                }
            }
        }
        if(_factory.getMain().getWalking().getRunEnergy() < 10){
            for(int i = 0; i < PotionsModel.length; i ++){
                if(_factory.getMain().getInventory().contains(PotionsModel[i].Name) && PotionsModel[i].Type == PotionsType.Energy.toString()){
                    _factory.getMain().getInventory().get(PotionsModel[i].Name).interact(InteractionCenter.Drink.toString());
                    break;
                }
            }
        }
    }
}
