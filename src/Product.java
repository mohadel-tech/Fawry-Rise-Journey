public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price;
     }
    public int getQuantity() { 
        return quantity;
     }
     
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isAvailable(int requestedQuantity) {
        return quantity >= requestedQuantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    public abstract boolean isExpired();
    public  abstract boolean requiresShipping();
}