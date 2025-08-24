---
slug: "refused-bequest"
nameCn: "被拒绝的遗赠"
nameEn: "Refused Bequest"
category: "Object-Orientation Abusers"
description: "子类不使用父类的某些方法或数据。"
descriptionEn: "A subclass does not use (or rejects) some of the methods or data it inherits from its parent."
exampleFile: "refused-bequest.java"
---

# Introduction

Refused Bequest occurs when a subclass uses only part of its parent's functionality or overrides inherited methods just to throw exceptions. This signals a flawed inheritance design.

## Key Identifiers

- Subclass overrides methods solely to throw exceptions or disable them
- Subclass ignores or never calls certain inherited methods
- Inheritance does not reflect a true "is-a" relationship
- Violates the Liskov Substitution Principle

## Refactoring Suggestions

1. **Redesign the Hierarchy**: Create a more accurate abstraction
2. **Prefer Composition**: Replace inheritance with delegation/composition
3. **Extract Superclass / Interfaces**: Factor shared behavior into a proper parent or interface set
4. **Interface Segregation**: Split large interfaces into focused ones

## Explanation

Penguins cannot fly—yet a Penguin subclass might inherit a fly() method from Bird. This mismatch indicates a hierarchy problem. Redesign by extracting flying capability into a separate interface/trait rather than forcing all birds to implement it.