
public class Cow extends Animal {

    public Cow() {
        super("Cow", 500, 20,"M");
    }

    public String toString() {
        return "Cow:" + this.getQuantity() + "    Health:" + this.getHealth();
    }
}