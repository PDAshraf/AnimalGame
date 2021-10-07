public class Chicken extends Animal {
    public Chicken(){
        super("Chicken",500,20,"");
    }

    public String toString(){
        return "Chicken"+this.getQuantity() + "    Health:" + this.getHealth();
    }
}
