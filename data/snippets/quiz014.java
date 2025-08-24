public class PaymentProcessor {
    
    public void processCreditCardPayment(double amount, String cardNumber, 
                                       String expiryDate, String cvv) {
        // Validate credit card details
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits");
        }
        
        if (!cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate.charAt(2) != '/') {
            throw new IllegalArgumentException("Expiry date format must be MM/YY");
        }
        
        if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
            throw new IllegalArgumentException("CVV must be 3 digits");
        }
        
        // Process payment
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card details validated");
        System.out.println("Payment approved");
    }
    
    public void processDebitCardPayment(double amount, String cardNumber, 
                                      String expiryDate, String pin) {
        // Validate debit card details (almost identical to credit card validation)
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits");
        }
        
        if (!cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate.charAt(2) != '/') {
            throw new IllegalArgumentException("Expiry date format must be MM/YY");
        }
        
        if (pin.length() != 4 || !pin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN must be 4 digits");
        }
        
        // Process payment
        System.out.println("Processing debit card payment of $" + amount);
        System.out.println("Card details validated");
        System.out.println("Payment approved");
    }
    
    public void processGiftCardPayment(double amount, String cardNumber, 
                                     String expiryDate, String pin) {
        // Validate gift card details (almost identical to credit card validation)
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits");
        }
        
        if (!cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate.charAt(2) != '/') {
            throw new IllegalArgumentException("Expiry date format must be MM/YY");
        }
        
        if (pin.length() != 4 || !pin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN must be 4 digits");
        }
        
        // Process payment
        System.out.println("Processing gift card payment of $" + amount);
        System.out.println("Card details validated");
        System.out.println("Payment approved");
    }
    
    public void processStoreCardPayment(double amount, String cardNumber, 
                                      String expiryDate) {
        // Validate store card details (still similar to credit card validation)
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits");
        }
        
        if (!cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate.charAt(2) != '/') {
            throw new IllegalArgumentException("Expiry date format must be MM/YY");
        }
        
        // Process payment
        System.out.println("Processing store card payment of $" + amount);
        System.out.println("Card details validated");
        System.out.println("Payment approved");
    }
    
    public void processBusinessCardPayment(double amount, String cardNumber, 
                                         String expiryDate, String cvv, String businessId) {
        // Validate business card details (duplicate validation again)
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits");
        }
        
        if (!cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate.charAt(2) != '/') {
            throw new IllegalArgumentException("Expiry date format must be MM/YY");
        }
        
        if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
            throw new IllegalArgumentException("CVV must be 3 digits");
        }
        
        if (businessId == null || businessId.trim().isEmpty()) {
            throw new IllegalArgumentException("Business ID is required");
        }
        
        // Process payment
        System.out.println("Processing business card payment of $" + amount);
        System.out.println("Card details validated");
        System.out.println("Business ID verified");
        System.out.println("Payment approved");
    }
}
