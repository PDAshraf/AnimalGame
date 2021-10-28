package animalgame.food;

import animalgame.food.abstractmodels.Food;

public class Meat extends Food {
    public Meat() {
        setDiet(Diet.MEAT);
        setCost(30);
        setHealthBoost(30);
    }
}