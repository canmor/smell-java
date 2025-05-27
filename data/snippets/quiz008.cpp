class OrderProcessor {
private:
    int orderId;
    std::string customerName;
    double totalAmount;
    
    // 这些字段只在季末促销时使用
    double discountPercentage;
    bool isHolidaySeason;
    double seasonalBonus;
    std::vector<std::string> appliedPromotions;
    
public:
    OrderProcessor(int id, std::string name, double amount) 
        : orderId(id), customerName(name), totalAmount(amount),
          discountPercentage(0), isHolidaySeason(false), 
          seasonalBonus(0) {}
    
    double calculateFinalPrice(bool isEndOfSeason) {
        if (isEndOfSeason) {
            // 季末处理逻辑 - 使用临时字段
            isHolidaySeason = checkIfHolidaySeason();
            
            // 确定折扣比例
            if (isHolidaySeason) {
                discountPercentage = 0.20; // 假日季额外折扣
                seasonalBonus = 10.0;      // 假日季奖励
                appliedPromotions.push_back("Holiday Special");
            } else {
                discountPercentage = 0.10; // 普通季末折扣
                seasonalBonus = 0;
                appliedPromotions.push_back("End of Season");
            }
            
            double discount = totalAmount * discountPercentage;
            return totalAmount - discount - seasonalBonus;
        } else {
            // 正常价格计算，不使用临时字段
            return totalAmount;
        }
    }
    
    bool checkIfHolidaySeason() {
        // 假设检查当前是否为假日季
        return false;
    }
};
