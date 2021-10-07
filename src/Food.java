public abstract class Food {
    private String type;
    private int purchasePrice;
    private int quantity;
    //Declare food types

    public Food(String type,int purchasePrice,int quantity){
        this.type = type;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getType(String type){
        return this.type;
    }

    public void setPurchasePrice(int purchasePrice){
        this.purchasePrice=purchasePrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

}
