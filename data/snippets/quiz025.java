import java.util.*;

class ShoppingCart {
    public List<String> items = new ArrayList<>();
    public double totalPrice = 0.0;
    public String customerType = "regular";
    public Map<String, Object> metadata = new HashMap<>();
}

class OrderService {
    public void addItem(ShoppingCart cart, String item, double price) {
        // Direct modification of shared mutable data
        cart.items.add(item);
        cart.totalPrice += price;
        cart.metadata.put("lastAddedItem", item);
        cart.metadata.put("lastAddedTime", System.currentTimeMillis());
    }
    
    public void removeItem(ShoppingCart cart, String item, double price) {
        cart.items.remove(item);
        cart.totalPrice -= price; // Manual update of derived data
        cart.metadata.remove("lastAddedItem");
    }
}

class DiscountService {
    public void applyDiscount(ShoppingCart cart, double discountPercent) {
        // Modifying the same mutable totalPrice from different class
        cart.totalPrice = cart.totalPrice * (1 - discountPercent / 100);
        cart.metadata.put("discountApplied", discountPercent);
        
        // Changing customer type affects other services
        if (discountPercent > 20) {
            cart.customerType = "premium";
        }
    }
    
    public void clearCart(ShoppingCart cart) {
        cart.items.clear(); // Clearing shared mutable list
        cart.totalPrice = 0.0;
        cart.metadata.clear();
        cart.customerType = "regular";
    }
}

class TaxService {
    public void calculateTax(ShoppingCart cart) {
        double taxRate = cart.customerType.equals("premium") ? 0.05 : 0.08;
        
        // Another place modifying the same mutable data
        cart.totalPrice = cart.totalPrice * (1 + taxRate);
        cart.metadata.put("taxRate", taxRate);
        cart.metadata.put("taxCalculated", true);
    }
}
