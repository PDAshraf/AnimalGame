package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Vegetables extends Food {
    public Vegetables() {
        setDiet(Diet.VEGETABLES);
        setCost(1);
        setHealthBoost(2);
    }
}