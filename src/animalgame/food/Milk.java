package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Milk extends Food {
    public Milk() { //constructor to set diet, cost and healthboost
        setDiet(Diet.MILK);
        setCost(1);
        setHealthBoost(2);
    }
}