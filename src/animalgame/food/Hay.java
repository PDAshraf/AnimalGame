package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Hay extends Food {
    public Hay() {
        setDiet(Diet.HAY);
        setCost(10);
        setHealthBoost(10);
    }
}