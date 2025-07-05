public class Mobile extends Product {
    private double weight;
    public Mobile(String name, double price, int quantity , double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

   
   

    @Override
    public boolean isExpired() {
        return false; 
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}