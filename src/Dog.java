public class Dog extends Animal {
    public Dog() { super("Dog",500,20,"");}

    public String toString(){
        return "Dog:"+ this.getQuantity()+"  Health:"+ this.getHealth();
    }
}
