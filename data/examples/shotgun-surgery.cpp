// 当需要添加新的支付方式时，需要修改多个类

class OrderProcessor {
public:
    void processOrder(Order order) {
        if (order.paymentType == "credit_card") {
            processCreditCard(order);
        } else if (order.paymentType == "paypal") {
            processPayPal(order);
        } else if (order.paymentType == "bank_transfer") {
            processBankTransfer(order);
        }
        // 需要添加新的支付方式判断
    }
    
private:
    void processCreditCard(Order order) { /* ... */ }
    void processPayPal(Order order) { /* ... */ }
    void processBankTransfer(Order order) { /* ... */ }
};

class PaymentValidator {
public:
    bool validate(Order order) {
        if (order.paymentType == "credit_card") {
            return validateCreditCard(order);
        } else if (order.paymentType == "paypal") {
            return validatePayPal(order);
        } else if (order.paymentType == "bank_transfer") {
            return validateBankTransfer(order);
        }
        // 需要添加新的验证逻辑
        return false;
    }
    
private:
    bool validateCreditCard(Order order) { return true; }
    bool validatePayPal(Order order) { return true; }
    bool validateBankTransfer(Order order) { return true; }
};

class Receipt {
public:
    std::string generate(Order order) {
        std::string receipt = "Order: " + order.id + "\n";
        if (order.paymentType == "credit_card") {
            receipt += "Paid by Credit Card\n";
        } else if (order.paymentType == "paypal") {
            receipt += "Paid by PayPal\n";
        } else if (order.paymentType == "bank_transfer") {
            receipt += "Paid by Bank Transfer\n";
        }
        // 需要添加新的支付方式信息
        return receipt;
    }
};
