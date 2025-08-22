---
slug: "primitive-obsession"
nameCn: "原始类型偏执"
nameEn: "Primitive Obsession"
category: "Bloaters"
description: "过度使用基本数据类型而不是创建小对象来表示概念。"
descriptionEn: "Overuse of basic primitive types instead of creating small objects to represent domain concepts."
exampleFile: "primitive-obsession.cpp"
---

# Introduction

Primitive Obsession arises when primitive data types (int, string, etc.) are used excessively to represent domain concepts that deserve their own types. This reduces expressiveness and makes the code harder to maintain.

## Key Identifiers

- Heavy use of primitive types to model rich concepts
- Validation logic duplicated and scattered
- Lack of type safety (easy to swap arguments of the same primitive type)
- Code lacks self-explanatory intent

## Refactoring Suggestions

1. **Introduce Value Objects**: Create small domain classes to represent concepts
2. **Encapsulate Validation**: Put validation rules inside those value objects
3. **Increase Type Safety**: Prevent parameter mix-ups by using distinct types
4. **Enhance Readability**: Make intent explicit through domain-specific names

## Explanation

Create value objects like Email, Phone, and Address instead of using raw strings. This centralizes validation and increases both safety and readability.