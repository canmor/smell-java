class OrderProcessor {
public:
    void processOrder(int orderId, std::string customerName, 
                     std::string shippingStreet, std::string shippingCity, 
                     std::string shippingZipCode, std::string shippingCountry) {
        // 处理订单...
        std::cout << "Processing order #" << orderId << " for " << customerName << std::endl;
        std::cout << "Shipping to: " << shippingStreet << ", " << shippingCity << ", " 
                  << shippingZipCode << ", " << shippingCountry << std::endl;
    }
    
    void updateShippingInfo(int orderId, std::string shippingStreet, 
                           std::string shippingCity, std::string shippingZipCode, 
                           std::string shippingCountry) {
        // 更新配送信息...
        std::cout << "Updated shipping info for order #" << orderId << std::endl;
        std::cout << "New address: " << shippingStreet << ", " << shippingCity << ", " 
                  << shippingZipCode << ", " << shippingCountry << std::endl;
    }
    
    void printShippingLabel(std::string customerName, std::string shippingStreet, 
                           std::string shippingCity, std::string shippingZipCode, 
                           std::string shippingCountry) {
        // 打印配送标签...
        std::cout << "Shipping Label:" << std::endl;
        std::cout << customerName << std::endl;
        std::cout << shippingStreet << std::endl;
        std::cout << shippingCity << ", " << shippingZipCode << std::endl;
        std::cout << shippingCountry << std::endl;
    }
};
