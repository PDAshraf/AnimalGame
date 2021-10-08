public class Cat extends Animal { // meat milk

    public Cat(String name, String gender) {
        super(name, gender);
        super.price=50;
        super.health=40;
    }

    public String getSpecies(){
        String species ="Cat";
        return species;
    }

    public void eat(Food food, Player player, int indexChosen, int amountFood) { //Cats eat meat/milk
        if (food instanceof Vegetables) {
            System.out.println("Not valid food");
        } else if ((food instanceof Meat) || (food instanceof Milk)) {
            System.out.println("**Cat Eating**");
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