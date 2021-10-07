public class Cat extends Animal{

    public Cat(){super ("Cat",500,20,"G");}

    public String toString() {
        return "Cat"+this.getQuantity()+"  Health:"+ this.getHealth();
    }
}
