package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Seed extends Food {
    public Seed() {
        setDiet(Diet.SEED);
        setCost(1);
        setHealthBoost(2);
    }
}