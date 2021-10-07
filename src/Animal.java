 public abstract class Animal {
    private String type;
    private String name;
    private int purchasePrice;
    private int health;
    private int quantity;

    public Animal(String type, int purchasePrice, int health,String Gender) {
        this.type = type;
        this.purchasePrice = purchasePrice;
        this.health = health;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void Food() {
        this.health += 5;
        if (this.health > 100) {
            this.health = 100;
        }
    }
}