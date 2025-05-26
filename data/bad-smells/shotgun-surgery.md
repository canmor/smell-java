---
slug: "shotgun-surgery"
nameCn: "霰弹式修改"
nameEn: "Shotgun Surgery"
category: "Change Preventers"
description: "每当需要修改时，都需要在多个类中做小修改。"
exampleFile: "shotgun-surgery.cpp"
---

# 简介

当你需要修改某个功能时，发现需要在很多不同的类中做小修改，这就是霰弹式修改。这种情况下，相关的行为被分散在多个类中。

## 识别要点

- 修改一个功能需要改动多个类
- 相关逻辑分散在不同地方
- 容易遗漏某些修改点
- 增加了维护成本

## 重构建议

1. **移动方法**：将相关方法移到同一个类中
2. **内联类**：将小类合并到使用它们的类中
3. **提取类**：为分散的行为创建专门的类
4. **使用设计模式**：如策略模式集中管理变化

## 说明

添加新支付方式需要修改多个类，应该使用策略模式或多态来集中管理支付逻辑，这样修改时只需要在一个地方进行。
\`\`\`

```cpp file="data/examples/shotgun-surgery.cpp"
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
        // 需要添加新的收据格式
        return receipt;
    }
};
