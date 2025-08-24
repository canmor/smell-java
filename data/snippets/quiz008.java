import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private int orderId;
    private String customerName;
    private double totalAmount;
    private String paymentMethod;
    
    private double discountPercentage;
    private boolean isHolidaySeason;
    private double seasonalBonus;
    private List<String> appliedPromotions;
    private String specialOfferCode;
    private boolean isVipCustomer;
    private double bulkOrderDiscount;
    private int loyaltyPoints;
    
    public OrderProcessor(int id, String name, double amount, String paymentMethod) {
        this.orderId = id;
        this.customerName = name;
        this.totalAmount = amount;
        this.paymentMethod = paymentMethod;
        this.discountPercentage = 0;
        this.isHolidaySeason = false;
        this.seasonalBonus = 0;
        this.appliedPromotions = new ArrayList<>();
        this.specialOfferCode = null;
        this.isVipCustomer = false;
        this.bulkOrderDiscount = 0;
        this.loyaltyPoints = 0;
    }
    
    public double calculateFinalPrice(boolean isEndOfSeason, boolean isBulkOrder) {
        double finalPrice = totalAmount;
        
        if (isEndOfSeason) {
            isHolidaySeason = checkIfHolidaySeason();
            
            if (isHolidaySeason) {
                discountPercentage = 0.20;
                seasonalBonus = 10.0;
                appliedPromotions.add("Holiday Special");
                specialOfferCode = "HOLIDAY2024";
            } else {
                discountPercentage = 0.10;
                seasonalBonus = 0;
                appliedPromotions.add("End of Season");
                specialOfferCode = "SEASON_END";
            }
            
            double discount = totalAmount * discountPercentage;
            finalPrice = totalAmount - discount - seasonalBonus;
        }
        
        if (isBulkOrder) {
            isVipCustomer = checkVipStatus();
            
            if (isVipCustomer) {
                bulkOrderDiscount = 0.15;
                loyaltyPoints = (int)(totalAmount / 10);
                appliedPromotions.add("VIP Bulk Discount");
            } else {
                bulkOrderDiscount = 0.05;
                loyaltyPoints = (int)(totalAmount / 20);
                appliedPromotions.add("Bulk Order Discount");
            }
            
            finalPrice = finalPrice * (1 - bulkOrderDiscount);
        }
        
        return finalPrice;
    }
    
    public void processOrder() {
        System.out.println("Processing order #" + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Total amount: $" + totalAmount);
        System.out.println("Payment method: " + paymentMethod);
        
        double finalPrice = calculateFinalPrice(false, false);
        System.out.println("Final price: $" + finalPrice);
    }
    
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order #").append(orderId).append("\n");
        summary.append("Customer: ").append(customerName).append("\n");
        summary.append("Amount: $").append(totalAmount).append("\n");
        
        if (!appliedPromotions.isEmpty()) {
            summary.append("Promotions: ").append(String.join(", ", appliedPromotions)).append("\n");
        }
        
        return summary.toString();
    }
    
    private boolean checkIfHolidaySeason() {
        return false;
    }
    
    private boolean checkVipStatus() {
        return totalAmount > 1000;
    }
}
