---
slug: "long-parameter-list"
nameCn: "冗长参数列表"
nameEn: "Long Parameter List"
category: "Bloaters"
description: "函数参数过多，难以理解和使用。"
exampleFile: "long-parameter-list.cpp"
---

# 简介

当函数有太多参数时，它变得难以理解和使用。通常超过3-4个参数就应该考虑重构。长参数列表往往表明函数承担了太多职责。

## 识别要点

- 函数参数超过3-4个
- 参数类型相似，容易混淆
- 调用时需要记住参数顺序
- 添加新参数时影响所有调用点

## 重构建议

1. **引入参数对象**：将相关参数封装为对象
2. **保持对象完整**：传递整个对象而不是其字段
3. **使用构建器模式**：对于复杂对象的创建
4. **拆分函数**：将大函数拆分为小函数

## 说明

应该创建一个CharacterConfig或CharacterBuilder类来封装这些参数，这样可以提高代码的可读性，减少参数传递错误的可能性。