---
slug: "parallel-inheritance-hierarchies"
nameCn: "平行继承结构"
nameEn: "Parallel Inheritance Hierarchies"
category: "Change Preventers"
description: "每当为某个类添加子类时，也需要为另一个类添加子类。"
exampleFile: "parallel-inheritance-hierarchies.cpp"
---

# 简介

当你发现每次为某个类层次添加子类时，也需要为另一个相关的类层次添加子类时，就出现了平行继承结构。这增加了维护成本。

## 识别要点

- 两个类层次结构相互对应
- 添加新子类时需要同时修改两个层次
- 类名往往有相似的前缀或后缀
- 增加了代码的复杂性

## 重构建议

1. **消除一个层次**：让一个层次引用另一个层次
2. **使用访问者模式**：将操作集中到一个地方
3. **合并层次**：将相关功能合并到一个类中
4. **使用策略模式**：用组合替代继承

## 说明

每个Shape都需要对应的Renderer，应该让Shape自己负责渲染，或者使用访问者模式来避免平行的继承结构。