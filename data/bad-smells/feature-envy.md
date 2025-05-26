---
slug: "feature-envy"
nameCn: "特性嫉妒"
nameEn: "Feature Envy"
category: "Couplers"
description: "一个方法对其他类的数据比对自己类的数据更感兴趣。"
exampleFile: "feature-envy.cpp"
---

# 简介

当一个方法频繁访问其他类的数据而很少使用自己类的数据时，就出现了特性嫉妒。这表明方法可能放在了错误的类中。

## 识别要点

- 方法大量使用其他类的数据
- 方法很少使用自己类的数据
- 方法与其他类的耦合度很高
- 违反了"数据和行为应该在一起"的原则

## 重构建议

1. **移动方法**：将方法移到它最感兴趣的类中
2. **提取方法**：将部分逻辑提取到合适的类中
3. **引入参数对象**：为相关数据创建新的类
4. **保持数据和行为的一致性**

## 说明

getCustomerAddressInfo方法应该移到Address类中，因为它主要操作Address的数据。这样可以提高内聚性，减少耦合。
\`\`\`

```cpp file="data/examples/feature-envy.cpp"
class Customer {
private:
    std::string name;
    Address address;
    
public:
    std::string getName() const { return name; }
    Address getAddress() const { return address; }
    void setName(const std::string& name) { this->name = name; }
    void setAddress(const Address& address) { this->address = address; }
};

class Address {
private:
    std::string street;
    std::string city;
    std::string zipCode;
    std::string country;
    
public:
    std::string getStreet() const { return street; }
    std::string getCity() const { return city; }
    std::string getZipCode() const { return zipCode; }
    std::string getCountry() const { return country; }
};

class Invoice {
private:
    Customer customer;
    double amount;
    
public:
    // 这个方法对Address类的数据更感兴趣
    std::string getCustomerAddressInfo() {
        Address addr = customer.getAddress();
        return addr.getStreet() + ", " + 
               addr.getCity() + " " + 
               addr.getZipCode() + ", " +
               addr.getCountry();
    }
    
    // 这个方法也主要使用Customer的数据
    std::string getCustomerSummary() {
        Address addr = customer.getAddress();
        return "Customer: " + customer.getName() + 
               " from " + addr.getCity() + ", " + addr.getCountry();
    }
    
    double getAmount() const { return amount; }
};
