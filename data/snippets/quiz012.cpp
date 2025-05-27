// 当需要添加新的会员等级时，需要修改多个类和方法

class DiscountCalculator {
public:
    double calculateDiscount(double amount, std::string memberLevel) {
        if (memberLevel == "bronze") {
            return amount * 0.05; // 铜牌会员 5% 折扣
        } else if (memberLevel == "silver") {
            return amount * 0.10; // 银牌会员 10% 折扣
        } else if (memberLevel == "gold") {
            return amount * 0.15; // 金牌会员 15% 折扣
        }
        return 0;
    }
};

class RewardPointsCalculator {
public:
    int calculatePoints(double purchaseAmount, std::string memberLevel) {
        int basePoints = static_cast<int>(purchaseAmount);
        
        if (memberLevel == "bronze") {
            return basePoints * 1; // 铜牌会员 1倍积分
        } else if (memberLevel == "silver") {
            return basePoints * 2; // 银牌会员 2倍积分
        } else if (memberLevel == "gold") {
            return basePoints * 3; // 金牌会员 3倍积分
        }
        return basePoints;
    }
};

class MemberBenefitDisplay {
public:
    std::string getBenefitDescription(std::string memberLevel) {
        if (memberLevel == "bronze") {
            return "铜牌会员福利: 5%折扣, 1倍积分, 普通客服";
        } else if (memberLevel == "silver") {
            return "银牌会员福利: 10%折扣, 2倍积分, 优先客服";
        } else if (memberLevel == "gold") {
            return "金牌会员福利: 15%折扣, 3倍积分, VIP客服, 生日礼物";
        }
        return "非会员无特殊福利";
    }
};

class CustomerService {
public:
    int getResponsePriority(std::string memberLevel) {
        if (memberLevel == "bronze") {
            return 3; // 普通优先级
        } else if (memberLevel == "silver") {
            return 2; // 中等优先级
        } else if (memberLevel == "gold") {
            return 1; // 最高优先级
        }
        return 4; // 非会员优先级最低
    }
    
    bool hasVIPHotline(std::string memberLevel) {
        return memberLevel == "gold"; // 只有金牌会员有VIP热线
    }
};

// 其他可能需要修改的类...

// 客户端使用示例
class CheckoutProcess {
public:
    void processCheckout(double amount, std::string memberLevel) {
        DiscountCalculator discountCalc;
        RewardPointsCalculator pointsCalc;
        MemberBenefitDisplay benefitDisplay;
        
        double discount = discountCalc.calculateDiscount(amount, memberLevel);
        int points = pointsCalc.calculatePoints(amount, memberLevel);
        
        std::cout << "订单金额: " << amount << std::endl;
        std::cout << "折扣: " << discount << std::endl;
        std::cout << "应付金额: " << (amount - discount) << std::endl;
        std::cout << "获得积分: " << points << std::endl;
        std::cout << benefitDisplay.getBenefitDescription(memberLevel) << std::endl;
    }
};
