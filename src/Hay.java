public class Hay extends Food {
    public Hay(String type, int purchasePrice, int quantity) {
        super(type, purchasePrice, quantity);
    }
    public String toString() {
        return "Hay"+this.getQuantity();
    }
}
