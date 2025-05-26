---
slug: "data-class"
nameCn: "数据类"
nameEn: "Data Class"
category: "Dispensables"
description: "类只包含字段和访问器方法，没有其他功能。"
exampleFile: "data-class.cpp"
---

# 简介

数据类只包含数据和简单的访问器方法，没有任何行为。这样的类往往表明行为被放在了错误的地方。

## 识别要点

- 类只包含字段和getter/setter方法
- 没有业务逻辑或行为方法
- 相关行为分散在其他类中
- 违反了面向对象的封装原则

## 重构建议

1. **移动方法**：将相关行为移到数据类中
2. **封装字段**：减少不必要的setter方法
3. **添加行为**：为数据类添加有意义的业务方法

## 说明

Customer类只是数据容器，相关的业务行为应该移到Customer类中，让数据和行为保持在一起。