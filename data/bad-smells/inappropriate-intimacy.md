---
slug: "inappropriate-intimacy"
nameCn: "不适当的亲密关系"
nameEn: "Inappropriate Intimacy"
category: "Couplers"
description: "两个类过于亲密，知道彼此太多的私有细节。"
exampleFile: "inappropriate-intimacy.cpp"
---

# 简介

当两个类过于了解彼此的内部实现细节时，就出现了不适当的亲密关系。这增加了耦合度，使得修改一个类时可能影响另一个类。

## 识别要点

- 类之间过度使用friend关键字
- 频繁访问其他类的私有成员
- 两个类的修改经常需要同步进行
- 类之间的边界不清晰

## 重构建议

1. **移动方法**：将方法移到合适的类中
2. **提取类**：为共同关心的数据创建新类
3. **隐藏委托关系**：通过公共接口交互
4. **减少friend的使用**：尽量通过公共接口访问

## 说明

Transaction类过于了解BankAccount的内部实现，应该通过公共接口进行交互，而不是直接访问私有成员。