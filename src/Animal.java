//superclass Animal
public abstract class Animal {
    public String name;
    private String gender;
    public int health;
    public int price;


    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.health = health;
        this.price = price;

    }

    public abstract String getSpecies();

    public abstract void eat(Food food, Player player, int indexChosen, int amountOfFood);

    public abstract void gainHealth(Food food, Player player, int indexChosen, int amountOfFood);


    public void die(Player player) {
        System.out.println(this + "is dead:( You can't reach" + this + " anymore");
        player.animalList.remove(this);
    }

    public void newBorn(Animal animal, Player player, String babyName) {
        int randomGender = (int) (Math.random() * 2) + 1;
        switch (randomGender) {
            case 1:
                System.out.println("Male Animal Generated");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog(babyName, "male"));
                } else if (animal instanceof Cat) {
                    player.animalList.add(new Cat(babyName, "male"));
                } else if (animal instanceof Cow) {
                    player.animalList.add(new Cow(babyName, "male"));
                } else if (animal instanceof Chicken) {
                    player.animalList.add(new Chicken(babyName, "male"));
                }
                break;

            case 2:
                System.out.println("Female Animal Generated");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog(babyName, "female"));
                } else if (animal instanceof Cat) {
                    player.animalList.add(new Cat(babyName, "female"));
                } else if (animal instanceof Cow) {
                    player.animalList.add(new Cow(babyName, "female"));
                } else if (animal instanceof Chicken) {
                    player.animalList.add(new Chicken(babyName, "female"));

                }
                break;

            }
        }

    public String getGender() {
        return gender;
    }
}