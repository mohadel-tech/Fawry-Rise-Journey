import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    public static void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty");
        }
        if (customer == null) {
            throw new Exception("Customer is not registered");
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isExpired()) {
                throw new Exception("Product " + product.getName() + " is expired");
            }
            if (!product.isAvailable(item.getQuantity())) {
                throw new Exception("Product " + product.getName() + " is out of stock or insufficient quantity");
            }
        }

       
        double subtotal = cart.getSubtotal();
        
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.requiresShipping() && product instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }

        double shippingFees = ShippingService.calculateShippingFee(shippableItems);
        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            throw new Exception("Customer's balance is insufficient");
        }

        // Process payment
        customer.deductBalance(totalAmount);
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Ship and print receipt
        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (int)item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shippingFees);
        System.out.println("Amount " + (int)totalAmount);
        System.out.println("Customer balance after payment: " + customer.getBalance());
        System.out.println("END.");
    }
}