---
slug: "duplicate-code"
nameCn: "重复代码"
nameEn: "Duplicate Code"
category: "Dispensables"
description: "相同的代码结构在多个地方重复出现。"
exampleFile: "duplicate-code.cpp"
---

# 简介

重复代码是最常见的坏味道之一。当相同的代码出现在多个地方时，修改时需要在多处进行，容易遗漏，也增加了维护成本。

## 识别要点

- 相同或相似的代码片段重复出现
- 修改时需要在多个地方同步更新
- 容易出现不一致的修改
- 增加了代码库的大小

## 重构建议

1. **提取方法**：将重复代码提取为独立方法
2. **提取类**：为相关的重复代码创建新类
3. **模板方法模式**：提取算法的公共结构
4. **策略模式**：处理相似但略有不同的逻辑

## 说明

验证逻辑在两个方法中重复，应该提取到一个独立的验证方法中。这样修改验证规则时只需要在一个地方进行。
\`\`\`

```cpp file="data/examples/duplicate-code.cpp"
class UserService {
public:
    void createUser(const std::string& name, const std::string& email) {
        // 验证输入（重复代码开始）
        if (name.empty()) {
            throw std::invalid_argument("Name cannot be empty");
        }
        if (email.empty()) {
            throw std::invalid_argument("Email cannot be empty");
        }
        if (email.find('@') == std::string::npos) {
            throw std::invalid_argument("Invalid email format");
        }
        if (name.length() < 2) {
            throw std::invalid_argument("Name too short");
        }
        // 验证输入（重复代码结束）
        
        User user(name, email);
        database.save(user);
    }
    
    void updateUser(int id, const std::string& name, const std::string& email) {
        // 验证输入（重复代码开始）
        if (name.empty()) {
            throw std::invalid_argument("Name cannot be empty");
        }
        if (email.empty()) {
            throw std::invalid_argument("Email cannot be empty");
        }
        if (email.find('@') == std::string::npos) {
            throw std::invalid_argument("Invalid email format");
        }
        if (name.length() < 2) {
            throw std::invalid_argument("Name too short");
        }
        // 验证输入（重复代码结束）
        
        User user = database.findById(id);
        user.setName(name);
        user.setEmail(email);
        database.update(user);
    }
    
private:
    Database database;
};
