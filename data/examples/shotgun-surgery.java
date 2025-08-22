// When adding a new payment method, multiple classes need to be modified

class Order {
    public String id;
    public String paymentType;
    public double amount;
    public String customerEmail;
    
    public Order(String id, String paymentType, double amount, String customerEmail) {
        this.id = id;
        this.paymentType = paymentType;
        this.amount = amount;
        this.customerEmail = customerEmail;
    }
}

class OrderProcessor {
    public void processOrder(Order order) {
        if ("credit_card".equals(order.paymentType)) {
            processCreditCard(order);
        } else if ("paypal".equals(order.paymentType)) {
            processPayPal(order);
        } else if ("bank_transfer".equals(order.paymentType)) {
            processBankTransfer(order);
        } else if ("apple_pay".equals(order.paymentType)) {
            processApplePay(order);
        } else if ("google_pay".equals(order.paymentType)) {
            processGooglePay(order);
        }
        // Need to add new payment method processing here
    }
    
    private void processCreditCard(Order order) {
        System.out.println("Processing credit card payment for order: " + order.id);
    }
    
    private void processPayPal(Order order) {
        System.out.println("Processing PayPal payment for order: " + order.id);
    }
    
    private void processBankTransfer(Order order) {
        System.out.println("Processing bank transfer for order: " + order.id);
    }
    
    private void processApplePay(Order order) {
        System.out.println("Processing Apple Pay for order: " + order.id);
    }
    
    private void processGooglePay(Order order) {
        System.out.println("Processing Google Pay for order: " + order.id);
    }
}

class PaymentValidator {
    public boolean validate(Order order) {
        if ("credit_card".equals(order.paymentType)) {
            return validateCreditCard(order);
        } else if ("paypal".equals(order.paymentType)) {
            return validatePayPal(order);
        } else if ("bank_transfer".equals(order.paymentType)) {
            return validateBankTransfer(order);
        } else if ("apple_pay".equals(order.paymentType)) {
            return validateApplePay(order);
        } else if ("google_pay".equals(order.paymentType)) {
            return validateGooglePay(order);
        }
        // Need to add new validation logic here
        return false;
    }
    
    private boolean validateCreditCard(Order order) {
        return order.amount <= 10000; // Credit limit check
    }
    
    private boolean validatePayPal(Order order) {
        return order.customerEmail != null && order.customerEmail.contains("@");
    }
    
    private boolean validateBankTransfer(Order order) {
        return order.amount >= 10; // Minimum transfer amount
    }
    
    private boolean validateApplePay(Order order) {
        return order.amount <= 5000; // Apple Pay limit
    }
    
    private boolean validateGooglePay(Order order) {
        return order.amount <= 5000; // Google Pay limit
    }
}

class Receipt {
    public String generate(Order order) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order: ").append(order.id).append("\n");
        receipt.append("Amount: $").append(order.amount).append("\n");
        
        if ("credit_card".equals(order.paymentType)) {
            receipt.append("Paid by Credit Card\n");
            receipt.append("Transaction secured by Visa/MasterCard\n");
        } else if ("paypal".equals(order.paymentType)) {
            receipt.append("Paid by PayPal\n");
            receipt.append("PayPal Buyer Protection applies\n");
        } else if ("bank_transfer".equals(order.paymentType)) {
            receipt.append("Paid by Bank Transfer\n");
            receipt.append("Transfer may take 2-3 business days\n");
        } else if ("apple_pay".equals(order.paymentType)) {
            receipt.append("Paid by Apple Pay\n");
            receipt.append("Touch ID / Face ID verification used\n");
        } else if ("google_pay".equals(order.paymentType)) {
            receipt.append("Paid by Google Pay\n");
            receipt.append("Google security protection enabled\n");
        }
        // Need to add new payment method information here
        
        return receipt.toString();
    }
}

class PaymentFeeCalculator {
    public double calculateFee(Order order) {
        if ("credit_card".equals(order.paymentType)) {
            return order.amount * 0.029; // 2.9% fee
        } else if ("paypal".equals(order.paymentType)) {
            return order.amount * 0.034; // 3.4% fee
        } else if ("bank_transfer".equals(order.paymentType)) {
            return 5.0; // Flat $5 fee
        } else if ("apple_pay".equals(order.paymentType)) {
            return order.amount * 0.025; // 2.5% fee
        } else if ("google_pay".equals(order.paymentType)) {
            return order.amount * 0.025; // 2.5% fee
        }
        // Need to add new fee calculation here
        return 0.0;
    }
}

class PaymentLogger {
    public void logPayment(Order order) {
        String message = "Payment processed for order " + order.id + " using ";
        
        if ("credit_card".equals(order.paymentType)) {
            message += "Credit Card";
        } else if ("paypal".equals(order.paymentType)) {
            message += "PayPal";
        } else if ("bank_transfer".equals(order.paymentType)) {
            message += "Bank Transfer";
        } else if ("apple_pay".equals(order.paymentType)) {
            message += "Apple Pay";
        } else if ("google_pay".equals(order.paymentType)) {
            message += "Google Pay";
        }
        // Need to add new payment method logging here
        
        System.out.println("[PAYMENT LOG] " + message);
    }
}

class PaymentNotifier {
    public void sendConfirmation(Order order) {
        String method = "";
        String additionalInfo = "";
        
        if ("credit_card".equals(order.paymentType)) {
            method = "Credit Card";
            additionalInfo = "Your card ending in ****1234 was charged.";
        } else if ("paypal".equals(order.paymentType)) {
            method = "PayPal";
            additionalInfo = "Payment sent from your PayPal account.";
        } else if ("bank_transfer".equals(order.paymentType)) {
            method = "Bank Transfer";
            additionalInfo = "Transfer initiated from your bank account.";
        } else if ("apple_pay".equals(order.paymentType)) {
            method = "Apple Pay";
            additionalInfo = "Payment authorized with biometric verification.";
        } else if ("google_pay".equals(order.paymentType)) {
            method = "Google Pay";
            additionalInfo = "Payment processed through Google Pay.";
        }
        // Need to add new notification messages here
        
        System.out.println("Sending notification: Payment via " + method + ". " + additionalInfo);
    }
}

// Demonstration of the shotgun surgery problem
class PaymentSystem {
    private OrderProcessor processor;
    private PaymentValidator validator;
    private Receipt receiptGenerator;
    private PaymentFeeCalculator feeCalculator;
    private PaymentLogger logger;
    private PaymentNotifier notifier;
    
    public PaymentSystem() {
        this.processor = new OrderProcessor();
        this.validator = new PaymentValidator();
        this.receiptGenerator = new Receipt();
        this.feeCalculator = new PaymentFeeCalculator();
        this.logger = new PaymentLogger();
        this.notifier = new PaymentNotifier();
    }
    
    public void handlePayment(Order order) {
        if (validator.validate(order)) {
            processor.processOrder(order);
            double fee = feeCalculator.calculateFee(order);
            System.out.println("Processing fee: $" + String.format("%.2f", fee));
            
            String receipt = receiptGenerator.generate(order);
            System.out.println(receipt);
            
            logger.logPayment(order);
            notifier.sendConfirmation(order);
        } else {
            System.out.println("Payment validation failed for order: " + order.id);
        }
    }
    
    // This method demonstrates the problem: 
    // Adding "cryptocurrency" would require changes in 6+ classes!
    public static void demonstrateShotgunSurgery() {
        PaymentSystem system = new PaymentSystem();
        
        Order[] orders = {
            new Order("ORD001", "credit_card", 100.0, "john@example.com"),
            new Order("ORD002", "paypal", 250.0, "jane@example.com"),
            new Order("ORD003", "apple_pay", 75.0, "bob@example.com")
        };
        
        for (Order order : orders) {
            System.out.println("\n=== Processing Order " + order.id + " ===");
            system.handlePayment(order);
        }
        
        System.out.println("\n=== PROBLEM DEMONSTRATION ===");
        System.out.println("To add 'cryptocurrency' payment method, you need to modify:");
        System.out.println("1. OrderProcessor.processOrder() - add new if-else branch");
        System.out.println("2. PaymentValidator.validate() - add new validation logic");
        System.out.println("3. Receipt.generate() - add new receipt text");
        System.out.println("4. PaymentFeeCalculator.calculateFee() - add new fee logic");
        System.out.println("5. PaymentLogger.logPayment() - add new log message");
        System.out.println("6. PaymentNotifier.sendConfirmation() - add new notification");
        System.out.println("This is SHOTGUN SURGERY - one change, many files to edit!");
    }
}
