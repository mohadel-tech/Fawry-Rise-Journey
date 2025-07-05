import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ShippingService {
    private static final double SHIPPING_RATE_PER_KG = 30.0;

    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        
        Map<String, Integer> itemCounts = new HashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();
        
        for (Shippable item : items) {
            String name = item.getName();
            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);
            itemWeights.put(name, item.getWeight());
        }
        
        double totalWeight = 0;
        
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            double weight = itemWeights.get(name);
            
            System.out.println(quantity + "x " + name + " " + (weight * 1000) + "g");
            totalWeight += weight * quantity;
        }
        
        System.out.println("Total package weight " + String.format("%.2f", totalWeight)+ "kg");
    }

    public static double calculateShippingFee(List<Shippable> items) {
        double totalWeight = items.stream().mapToDouble(Shippable::getWeight).sum();
        return totalWeight * SHIPPING_RATE_PER_KG;
    }
}