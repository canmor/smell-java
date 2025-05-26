---
slug: "middle-man"
nameCn: "中间人"
nameEn: "Middle Man"
category: "Couplers"
description: "类的大部分方法都是简单地委托给其他类。"
exampleFile: "middle-man.cpp"
---

# 简介

当一个类的大部分方法都只是简单地委托给其他类时，这个类就成了中间人。它可能没有存在的必要，应该考虑直接使用被委托的类。

## 识别要点

- 类的大部分方法都是简单的委托
- 类没有添加额外的价值
- 类只是简单地转发调用
- 增加了不必要的间接层

## 重构建议

1. **移除中间人**：让客户端直接使用被委托的类
2. **内联方法**：将简单的委托方法内联
3. **部分委托**：只保留有价值的委托方法
4. **替换委托为继承**：如果合适的话

## 说明

DatabaseManager类只是简单地委托给DatabaseConnection，可能应该直接使用DatabaseConnection，或者为DatabaseManager添加更多有价值的功能。