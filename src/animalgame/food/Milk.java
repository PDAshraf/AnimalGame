package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Milk extends Food {
    public Milk() {
        setDiet(Diet.MILK);
        setCost(20);
        setHealthBoost(20);
    }
}