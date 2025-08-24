/// Imagine when adding a new membership level, what changes would be needed?

class DiscountCalculator {
    public double calculateDiscount(double amount, String memberLevel) {
        if ("bronze".equals(memberLevel)) {
            return amount * 0.05; // Bronze member 5% discount
        } else if ("silver".equals(memberLevel)) {
            return amount * 0.10; // Silver member 10% discount
        } else if ("gold".equals(memberLevel)) {
            return amount * 0.15; // Gold member 15% discount
        } else if ("platinum".equals(memberLevel)) {
            return amount * 0.20; // Platinum member 20% discount
        }
        return 0;
    }
}

class RewardPointsCalculator {
    public int calculatePoints(double purchaseAmount, String memberLevel) {
        int basePoints = (int) purchaseAmount;
        
        if ("bronze".equals(memberLevel)) {
            return basePoints * 1; // Bronze member 1x points
        } else if ("silver".equals(memberLevel)) {
            return basePoints * 2; // Silver member 2x points
        } else if ("gold".equals(memberLevel)) {
            return basePoints * 3; // Gold member 3x points
        } else if ("platinum".equals(memberLevel)) {
            return basePoints * 4; // Platinum member 4x points
        }
        return basePoints;
    }
}

class MemberBenefitDisplay {
    public String getBenefitDescription(String memberLevel) {
        if ("bronze".equals(memberLevel)) {
            return "Bronze member benefits: 5% discount, 1x points, standard support";
        } else if ("silver".equals(memberLevel)) {
            return "Silver member benefits: 10% discount, 2x points, priority support";
        } else if ("gold".equals(memberLevel)) {
            return "Gold member benefits: 15% discount, 3x points, VIP support, birthday gift";
        } else if ("platinum".equals(memberLevel)) {
            return "Platinum member benefits: 20% discount, 4x points, dedicated support, exclusive events";
        }
        return "Non-member: no special benefits";
    }
}

class CustomerService {
    public int getResponsePriority(String memberLevel) {
        if ("bronze".equals(memberLevel)) {
            return 3; // Standard priority
        } else if ("silver".equals(memberLevel)) {
            return 2; // Medium priority
        } else if ("gold".equals(memberLevel)) {
            return 1; // High priority
        } else if ("platinum".equals(memberLevel)) {
            return 0; // Highest priority
        }
        return 4; // Non-member lowest priority
    }
    
    public boolean hasVIPHotline(String memberLevel) {
        return "gold".equals(memberLevel) || "platinum".equals(memberLevel);
    }
    
    public boolean hasDedicatedManager(String memberLevel) {
        return "platinum".equals(memberLevel);
    }
}

class ShippingService {
    public double getShippingDiscount(String memberLevel) {
        if ("bronze".equals(memberLevel)) {
            return 0.0; // No shipping discount
        } else if ("silver".equals(memberLevel)) {
            return 0.5; // 50% shipping discount
        } else if ("gold".equals(memberLevel)) {
            return 1.0; // Free shipping
        } else if ("platinum".equals(memberLevel)) {
            return 1.0; // Free express shipping
        }
        return 0.0;
    }
    
    public boolean hasExpressShipping(String memberLevel) {
        return "platinum".equals(memberLevel);
    }
}

class EventInvitationManager {
    public boolean canAttendSaleEvents(String memberLevel) {
        return !"".equals(memberLevel) && memberLevel != null;
    }
    
    public boolean canAttendVIPEvents(String memberLevel) {
        return "gold".equals(memberLevel) || "platinum".equals(memberLevel);
    }
    
    public boolean canAttendExclusiveEvents(String memberLevel) {
        return "platinum".equals(memberLevel);
    }
}

// Client usage example
class CheckoutProcess {
    public void processCheckout(double amount, String memberLevel) {
        DiscountCalculator discountCalc = new DiscountCalculator();
        RewardPointsCalculator pointsCalc = new RewardPointsCalculator();
        MemberBenefitDisplay benefitDisplay = new MemberBenefitDisplay();
        ShippingService shippingService = new ShippingService();
        
        double discount = discountCalc.calculateDiscount(amount, memberLevel);
        int points = pointsCalc.calculatePoints(amount, memberLevel);
        double shippingDiscount = shippingService.getShippingDiscount(memberLevel);
        
        System.out.println("Order amount: " + amount);
        System.out.println("Discount: " + discount);
        System.out.println("Final amount: " + (amount - discount));
        System.out.println("Points earned: " + points);
        System.out.println("Shipping discount: " + (shippingDiscount * 100) + "%");
        System.out.println(benefitDisplay.getBenefitDescription(memberLevel));
    }
}
