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
    static FoodsModel[] FoodModel = null;
    public Eat(Factory factory) {
        _factory = factory;
    }
    private static int foodIDs[] = {315, 316, 319, 320, 325, 326, 329, 330, 333, 334,
            339, 340, 345, 346, 347, 348, 351, 352, 355, 356, 361, 362, 365,
            366, 373, 374, 379, 385, 386, 391, 392, 397, 398, 1552, 1553, 1865,
            1866, 1867, 1868, 1891, 1892, 1893, 1894, 1895, 1896, 1897, 1898,1899,
            1900, 2140, 2141, 2142, 2143, 2289, 2290, 2291, 2292, 2293, 2294, 2295,
            2296, 2297, 2298, 2299, 2300, 2301, 2302, 2303, 2304, 2307, 2308, 2309,
            2310, 2323, 2324, 2325, 2326, 2327, 2328, 2331, 2332, 2333, 2334, 2335,
            2336, 2343, 2344, 2878, 2879, 3144, 3145, 3146, 3147, 3228, 3229, 3381,
            3382, 4291, 4292, 4293, 4294, 6703, 6704, 6705, 6706, 7060, 7061, 7068,
            7069, 7086, 7087, 7164, 7164, 7165, 7166, 7167, 7168, 7169, 7170, 7171,
            7172, 7172, 7173, 7173, 7174, 7174, 7175, 7175, 7176, 7177, 7178, 7178,
            7179, 7179, 7180, 7180, 7181, 7181, 7182, 7183, 7184, 7188, 7189, 7190,
            7191, 7192, 7193, 7194, 7195, 7196, 7197, 7198, 7199, 7200, 7201, 7202,
            7203, 7204, 7205, 7208, 7209, 7210, 7211, 7212, 7213, 7214, 7215, 7216,
            7217, 7218, 7219, 7220, 7221, 7228, 7229, 7512, 7515, 7521, 7522, 7523,
            7524, 7525, 7526, 7528, 7530, 7542, 7568, 7569, 7580, 7919, 7920, 7942,
            7943, 7946, 7947, 7989, 7990, 8951, 9475, 9476, 10841, 11328, 11329,
            11330, 11331, 13433, 13714, 14540, 14543, 14825, 14831, 15266, 15267,
            15272, 18111, 18112, 18131, 18132, 18151, 18152, 18171, 18172, 19948,
            19949, 20111, 20112, 20113, 20179, 20181, 20182, 20205, 20206, 20207,
            23060, 23061, 23062, 23063, 23075, 75273};

    public int[] getFoodIDs() {
        return foodIDs;
    }

    public void Eating(){
        try{
            String FoodName = getEdibleFoodFromInvertory();
            if(Inventory.contains(FoodName) && FoodName != null){
                Inventory.get(FoodName).interact(InteractionCenter.Eat.toString());
                _factory.getInteractionUser().SetActivity("Eating...");
            }else if(FoodName == null && _factory.getMain().getLocalPlayer().getHealthPercent() <= 30){
                NotRecognizableFood();
            }
        }catch (Exception e){
            _factory.getMain().log("Food error: " + e.toString());
            NotRecognizableFood();
        }
    }
    public String getEdibleFoodFromInvertory(){
        if(FoodModel == null){
            FoodModel =  _factory.getJSON().GetNewGson().fromJson(_factory.getJSON().getJson("Foods.json"), FoodsModel[].class);
        }
        for (int i = 0; i < FoodModel.length; i++) {
            //_factory.getMain().log("Scanned item = Name: " + FoodModel[i].Food +" Heals percent: " + FoodModel[i].Heals + " check: " + ((getMissingHitpoints() >= FoodModel[i].Heals) && Inventory.contains(FoodModel[i].Food)));
            if ((getMissingHitpoints() >= FoodModel[i].Heals) && Inventory.contains(FoodModel[i].Food)) {
                _factory.getMain().log(FoodModel[i].Food);
                return FoodModel[i].Food;
            }
        }
        return null;
    }
    private int getMissingHitpoints(){
        return Skills.getRealLevel(Skill.HITPOINTS) - Skills.getBoostedLevels(Skill.HITPOINTS);
    }
    private void NotRecognizableFood(){
        if(_factory.getMain().getLocalPlayer().getHealthPercent() <= 30){
            if(Inventory.contains(getFoodIDs())){
                for(int i = 0; i < getFoodIDs().length; i++){
                    if(Inventory.contains(getFoodIDs()[i])){
                        Inventory.get(getFoodIDs()[i]).hasAction(InteractionCenter.Eat.toString());
                        break;
                    }
                }
            }else{
                Item Food = Inventory.get(i -> i != null && i.hasAction(InteractionCenter.Eat.toString()));
                if(Food != null){
                    Food.hasAction(InteractionCenter.Eat.toString());
                }
            }
        }
    }
}
