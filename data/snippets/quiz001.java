public class OrderProcessor {
    public double calculatePrice(Order order) {
        if (order.getType().equals("standard")) {
            return order.getPrice() * 1.0;
        } else if (order.getType().equals("premium")) {
            return order.getPrice() * 1.1;
        } else if (order.getType().equals("vip")) {
            return order.getPrice() * 1.2;
        } else if (order.getType().equals("corporate")) {
            return order.getPrice() * 0.9;
        }
        return order.getPrice();
    }
    
    public double calculateShippingFee(Order order) {
        if (order.getType().equals("standard")) {
            return 10.0;
        } else if (order.getType().equals("premium")) {
            return 5.0;
        } else if (order.getType().equals("vip")) {
            return 0.0;
        } else if (order.getType().equals("corporate")) {
            return 8.0;
        }
        return 10.0;
    }
    
    public int calculateProcessingDays(Order order) {
        if (order.getType().equals("standard")) {
            return 5;
        } else if (order.getType().equals("premium")) {
            return 3;
        } else if (order.getType().equals("vip")) {
            return 1;
        } else if (order.getType().equals("corporate")) {
            return 2;
        }
        return 5;
    }
    
    public String getServiceLevel(Order order) {
        if (order.getType().equals("standard")) {
            return "基础客服";
        } else if (order.getType().equals("premium")) {
            return "高级客服";
        } else if (order.getType().equals("vip")) {
            return "专属客服";
        } else if (order.getType().equals("corporate")) {
            return "企业客服";
        }
        return "基础客服";
    }
}

class Order {
    private String type;
    private double price;
    
    public Order(String type, double price) {
        this.type = type;
        this.price = price;
    }
    
    public String getType() {
        return type;
    }
    
    public double getPrice() {
        return price;
    }
}
