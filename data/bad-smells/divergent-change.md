---
slug: "divergent-change"
nameCn: "发散式变化"
nameEn: "Divergent Change"
category: "Change Preventers"
description: "一个类因为不同的原因需要经常修改。"
exampleFile: "divergent-change.cpp"
---

# 简介

当一个类因为多种不同的原因需要修改时，就出现了发散式变化。这违反了单一职责原则，表明类承担了太多职责。

## 识别要点

- 类因为不同原因需要修改
- 修改一个功能时需要改动类的多个部分
- 类的职责不明确
- 违反单一职责原则

## 重构建议

1. **提取类**：将不同职责分离到不同类中
2. **单一职责**：确保每个类只有一个变化原因
3. **委托模式**：使用组合替代大类
4. **模块化设计**：按功能领域组织代码

## 说明

这个类因为薪资政策、税法、报告格式、数据库结构等不同原因需要修改，应该拆分职责，让每个类只负责一个方面的变化。
\`\`\`

```cpp file="data/examples/divergent-change.cpp"
class Employee {
private:
    std::string name;
    double salary;
    std::string department;
    std::string address;
    std::string email;
    
public:
    // 因为薪资政策变化需要修改
    double calculatePay() {
        if (department == "Engineering") {
            return salary * 1.2;
        } else if (department == "Sales") {
            return salary * 1.1;
        } else if (department == "Management") {
            return salary * 1.5;
        }
        return salary;
    }
    
    // 因为税法变化需要修改
    double calculateTax() {
        double pay = calculatePay();
        if (pay > 100000) {
            return pay * 0.35;
        } else if (pay > 50000) {
            return pay * 0.25;
        }
        return pay * 0.15;
    }
    
    // 因为报告格式变化需要修改
    std::string generateReport() {
        return "Employee: " + name + 
               "\nDepartment: " + department +
               "\nPay: " + std::to_string(calculatePay()) +
               "\nTax: " + std::to_string(calculateTax());
    }
    
    // 因为数据库结构变化需要修改
    void saveToDatabase() {
        // 数据库保存逻辑
        std::cout << "Saving to database..." << std::endl;
    }
    
    // 因为邮件系统变化需要修改
    void sendPayslip() {
        std::cout << "Sending payslip to: " << email << std::endl;
    }
};
