public class OrderProcessor {
    
    public void processOrder(int orderId, String customerName, 
                           String shippingStreet, String shippingCity, 
                           String shippingZipCode, String shippingCountry,
                           String billingStreet, String billingCity,
                           String billingZipCode, String billingCountry) {
        
        System.out.println("Processing order #" + orderId + " for " + customerName);
        System.out.println("Shipping to: " + shippingStreet + ", " + shippingCity + ", " 
                          + shippingZipCode + ", " + shippingCountry);
        System.out.println("Billing to: " + billingStreet + ", " + billingCity + ", " 
                          + billingZipCode + ", " + billingCountry);
    }
    
    public void updateShippingInfo(int orderId, String shippingStreet, 
                                 String shippingCity, String shippingZipCode, 
                                 String shippingCountry) {
        
        System.out.println("Updated shipping info for order #" + orderId);
        System.out.println("New address: " + shippingStreet + ", " + shippingCity + ", " 
                          + shippingZipCode + ", " + shippingCountry);
        
        validateAddress(shippingStreet, shippingCity, shippingZipCode, shippingCountry);
    }
    
    public void updateBillingInfo(int orderId, String billingStreet, 
                                String billingCity, String billingZipCode, 
                                String billingCountry) {
        
        System.out.println("Updated billing info for order #" + orderId);
        System.out.println("New billing address: " + billingStreet + ", " + billingCity + ", " 
                          + billingZipCode + ", " + billingCountry);
        
        validateAddress(billingStreet, billingCity, billingZipCode, billingCountry);
    }
    
    public void printShippingLabel(String customerName, String shippingStreet, 
                                 String shippingCity, String shippingZipCode, 
                                 String shippingCountry) {
        
        System.out.println("Shipping Label:");
        System.out.println(customerName);
        System.out.println(shippingStreet);
        System.out.println(shippingCity + ", " + shippingZipCode);
        System.out.println(shippingCountry);
    }
    
    public void calculateShippingCost(String shippingStreet, String shippingCity, 
                                    String shippingZipCode, String shippingCountry,
                                    double weight, String serviceType) {
        
        String fullAddress = shippingStreet + ", " + shippingCity + ", " 
                           + shippingZipCode + ", " + shippingCountry;
        
        System.out.println("Calculating shipping cost for: " + fullAddress);
        System.out.println("Weight: " + weight + "kg, Service: " + serviceType);
    }
    
    public boolean validateAddress(String street, String city, String zipCode, String country) {
        if (street == null || street.trim().isEmpty()) {
            return false;
        }
        if (city == null || city.trim().isEmpty()) {
            return false;
        }
        if (zipCode == null || !zipCode.matches("\\d{5}")) {
            return false;
        }
        if (country == null || country.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    
    public String formatAddress(String street, String city, String zipCode, String country) {
        return street + ", " + city + " " + zipCode + ", " + country;
    }
}
