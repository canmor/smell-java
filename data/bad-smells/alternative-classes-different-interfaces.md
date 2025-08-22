---
slug: "alternative-classes-different-interfaces"
nameCn: "不同接口的相似类"
nameEn: "Alternative Classes with Different Interfaces"
category: "Object-Orientation Abusers"
description: "两个类功能相似但接口不同。"
descriptionEn: "Two classes have similar functionality but different interfaces."
exampleFile: "alternative-classes-different-interfaces.cpp"
---

# Introduction

When two classes do the same thing but have different method names, this smell occurs. It increases learning costs and maintenance difficulty, and violates the principle of consistency.

## Key Identifiers

- Two classes provide similar functionality
- Method names differ but functionality is the same
- Parameter types or order are inconsistent
- Increases learning costs for users

## Refactoring Suggestions

1. **Unify Interfaces**: Ensure similar classes implement the same interface
2. **Rename Methods**: Use consistent naming conventions
3. **Extract Superclass**: Create a base class for shared behavior
4. **Merge Classes**: If functionality is identical, consider merging them

## Explanation

These two classes do the same thing but with different interfaces. The interfaces should be unified or the classes merged. This reduces learning costs and improves code consistency.