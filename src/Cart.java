import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) throws Exception {
        if (!product.isAvailable(quantity)) {
            throw new Exception("Product " + product.getName() + " is out of stock or insufficient quantity available");
        }
        if (product.isExpired()) {
            throw new Exception("Product " + product.getName() + " is expired");
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }
    
    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}