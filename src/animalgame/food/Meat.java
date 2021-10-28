package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Meat extends Food {
    public Meat() { //constructor to set diet, cost and healthboost
        setDiet(Diet.MEAT);
        setCost(1);
        setHealthBoost(2);
    }
}