---
slug: "divergent-change"
nameCn: "发散式变化"
nameEn: "Divergent Change"
category: "Change Preventers"
description: "一个类因为不同的原因需要经常修改。"
descriptionEn: "A class needs to be modified frequently for different, unrelated reasons."
exampleFile: "divergent-change.java"
---

# Introduction

When a class needs to be modified for many different reasons, you've encountered Divergent Change. This violates the Single Responsibility Principle (SRP) and indicates the class is doing too much.

## Key Identifiers

- The class must change for different reasons
- Modifying one feature requires editing multiple parts of the same class
- The class's responsibilities are unclear
- Violates the Single Responsibility Principle

## Refactoring Suggestions

1. **Extract Class**: Separate distinct responsibilities into their own classes
2. **Single Responsibility**: Ensure each class has only one reason to change
3. **Delegate / Composition**: Use composition to replace a large, monolithic class
4. **Modular Design**: Organize code by functional or domain boundaries

## Explanation

This class changes for different reasons: payroll rules, tax regulations, reporting formats, database schema, etc. Responsibilities should be split so each class handles only one axis of change.