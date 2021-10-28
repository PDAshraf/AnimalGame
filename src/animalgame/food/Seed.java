package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Seed extends Food {
    public Seed() { //constructor to set diet, cost and healthboost
        setDiet(Diet.SEED);
        setCost(1);
        setHealthBoost(2);
    }
}