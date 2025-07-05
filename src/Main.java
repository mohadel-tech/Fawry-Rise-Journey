import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Cheese cheese = new Cheese("Cheese", 100, 10, LocalDate.now().plusDays(7), 0.2);
            TV tv = new TV("TV", 1000, 5, 15.0);
            MobileScratchCard scratchCard = new MobileScratchCard("Mobile Scratch Card", 50, 20);
            Biscuits biscuits = new Biscuits("Biscuits", 150, 8, LocalDate.now().plusDays(10), 0.7);

            Customer customer = new Customer("John Doe", 5000);
            Cart cart = new Cart();
            
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(scratchCard, 2);
            cart.add(biscuits, 1);

            ECommerceSystem.checkout(customer, cart);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}