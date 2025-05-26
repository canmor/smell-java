---
slug: "speculative-generality"
nameCn: "过度设计"
nameEn: "Speculative Generality"
category: "Dispensables"
description: "为了未来可能的需求而设计的过度复杂的结构。"
exampleFile: "speculative-generality.cpp"
---

# 简介

当代码为了处理可能永远不会发生的情况而变得过度复杂时，就出现了过度设计。这种"以防万一"的编程方式会增加不必要的复杂性。

## 识别要点

- 过度抽象和复杂的继承层次
- 只有一个实现的抽象类或接口
- 过度参数化的设计
- 为未来需求预留的复杂结构

## 重构建议

1. **折叠继承层次**：移除不必要的抽象层
2. **内联类**：将过度抽象的类合并
3. **移除参数**：删除未使用的参数
4. **简化设计**：采用最简单可行的解决方案

## 说明

复杂的抽象和配置系统是为了未来可能的需求而设计的，但实际上只需要简单的实现。应该遵循YAGNI（You Aren't Gonna Need It）原则。