package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Vegetables extends Food {
    public Vegetables() { //constructor to set diet, cost and healthboost
        setDiet(Diet.VEGETABLES);
        setCost(1);
        setHealthBoost(2);
    }
}