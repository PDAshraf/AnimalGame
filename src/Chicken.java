public class Chicken extends Animal { // meat milk

    public Chicken(String name, String gender) {
        super(name, gender);
        super.price=20;
        super.health=20;
    }

    public String getSpecies(){
        String species ="Chicken";
        return species;
    }

    public void eat(Food food, Player player, int indexChosen, int amountFood) { //Cats eat meat/milk
        if (food instanceof Hay) {
            System.out.println("Not valid food");
        } else if ((food instanceof Meat) || (food instanceof Seed)) {
            System.out.println("**Chicken Eating**");
            gainHealth(food,player,indexChosen,amountFood);
        }
    }

    public void gainHealth(Food food, Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).health;
        if (food instanceof Meat) {
            player.animalList.get(indexChosen).health = healthLv + 10 * amountOfFood;
        } else {
            player.animalList.get(indexChosen).health= healthLv + 5 * amountOfFood;
        }
    }
}