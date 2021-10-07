public class Meat extends Food{
    public Meat(String type, int purchasePrice, int quantity) {
        super(type, purchasePrice, quantity);
    }
    public String toString() {
        return "Meat"+this.getQuantity();
    }

}
