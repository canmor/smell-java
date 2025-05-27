class PaymentProcessor {
public:
    void processCreditCardPayment(double amount, const std::string& cardNumber, 
                               const std::string& expiryDate, const std::string& cvv) {
        // 验证信用卡详情
        if (cardNumber.length() != 16) {
            throw std::invalid_argument("Card number must be 16 digits");
        }
        
        if (!std::all_of(cardNumber.begin(), cardNumber.end(), ::isdigit)) {
            throw std::invalid_argument("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate[2] != '/') {
            throw std::invalid_argument("Expiry date format must be MM/YY");
        }
        
        if (cvv.length() != 3 || !std::all_of(cvv.begin(), cvv.end(), ::isdigit)) {
            throw std::invalid_argument("CVV must be 3 digits");
        }
        
        // 处理付款
        std::cout << "Processing credit card payment of $" << amount << std::endl;
        std::cout << "Card details validated" << std::endl;
        std::cout << "Payment approved" << std::endl;
    }
    
    void processGiftCardPayment(double amount, const std::string& cardNumber, 
                             const std::string& expiryDate, const std::string& pin) {
        // 验证礼品卡详情 (几乎与信用卡验证相同)
        if (cardNumber.length() != 16) {
            throw std::invalid_argument("Card number must be 16 digits");
        }
        
        if (!std::all_of(cardNumber.begin(), cardNumber.end(), ::isdigit)) {
            throw std::invalid_argument("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate[2] != '/') {
            throw std::invalid_argument("Expiry date format must be MM/YY");
        }
        
        if (pin.length() != 4 || !std::all_of(pin.begin(), pin.end(), ::isdigit)) {
            throw std::invalid_argument("PIN must be 4 digits");
        }
        
        // 处理付款
        std::cout << "Processing gift card payment of $" << amount << std::endl;
        std::cout << "Card details validated" << std::endl;
        std::cout << "Payment approved" << std::endl;
    }
    
    void processStoreCardPayment(double amount, const std::string& cardNumber, 
                              const std::string& expiryDate) {
        // 验证商店卡详情 (还是与信用卡验证相似)
        if (cardNumber.length() != 16) {
            throw std::invalid_argument("Card number must be 16 digits");
        }
        
        if (!std::all_of(cardNumber.begin(), cardNumber.end(), ::isdigit)) {
            throw std::invalid_argument("Card number must contain only digits");
        }
        
        if (expiryDate.length() != 5 || expiryDate[2] != '/') {
            throw std::invalid_argument("Expiry date format must be MM/YY");
        }
        
        // 处理付款
        std::cout << "Processing store card payment of $" << amount << std::endl;
        std::cout << "Card details validated" << std::endl;
        std::cout << "Payment approved" << std::endl;
    }
};
