int processOrder(Order order) {
    if (order.type == "standard") {
        return order.price * 1.0;
    } else if (order.type == "premium") {
        return order.price * 1.1;
    } else if (order.type == "vip") {
        return order.price * 1.2;
    } else if (order.type == "corporate") {
        return order.price * 0.9;
    }
    return order.price;
}
