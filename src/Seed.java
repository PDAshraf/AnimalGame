public class Seed extends Food {
    public Seed(String type, int purchasePrice, int quantity) {
        super(type, purchasePrice, quantity);
    }

    public String toString() {
        return "Seeds"+this.getQuantity();
    }
}
