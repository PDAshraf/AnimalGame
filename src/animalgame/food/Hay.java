package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Hay extends Food {
    public Hay() { //constructor to set diet, cost and healthboost
        setDiet(Diet.HAY);
        setCost(1);
        setHealthBoost(2);
    }
}