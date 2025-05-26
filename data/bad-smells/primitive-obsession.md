---
slug: "primitive-obsession"
nameCn: "原始类型偏执"
nameEn: "Primitive Obsession"
category: "Bloaters"
description: "过度使用基本数据类型而不是创建小对象来表示概念。"
exampleFile: "primitive-obsession.cpp"
---

# 简介

当代码中大量使用基本数据类型（int、string等）来表示应该用对象表示的概念时，就出现了原始类型偏执。这种做法会导致代码缺乏表达力，难以维护。

## 识别要点

- 大量使用基本数据类型表示复杂概念
- 相关的验证逻辑分散在各处
- 缺少类型安全保障
- 代码缺乏自解释性

## 重构建议

1. **引入值对象**：为概念创建专门的类
2. **封装验证逻辑**：将验证规则放在对象内部
3. **提高类型安全**：避免参数传递错误
4. **增强可读性**：让代码更具表达力

## 说明

应该创建Email、Phone、Address等值对象来封装这些概念，而不是使用原始的string类型。这样可以将验证逻辑封装在对象内部，提高代码的安全性和可读性。
\`\`\`

```cpp file="data/examples/primitive-obsession.cpp"
class User {
private:
    std::string firstName;
    std::string lastName;
    std::string email;
    std::string phone;
    std::string address;
    std::string city;
    std::string zipCode;
    std::string country;
    
public:
    bool isValidEmail(const std::string& email) {
        return email.find('@') != std::string::npos;
    }
    
    bool isValidPhone(const std::string& phone) {
        return phone.length() >= 10;
    }
    
    std::string getFullAddress() {
        return address + ", " + city + " " + zipCode + ", " + country;
    }
    
    // 验证逻辑分散，缺乏类型安全
    void updateEmail(const std::string& newEmail) {
        if (isValidEmail(newEmail)) {
            email = newEmail;
        }
    }
};
