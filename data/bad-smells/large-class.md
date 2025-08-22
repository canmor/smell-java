---
slug: "large-class"
nameCn: "过大的类"
nameEn: "Large Class"
category: "Bloaters"
description: "类包含过多的字段、方法或代码行，违反了单一职责原则。"
descriptionEn: "A class contains too many fields, methods, or lines of code, violating the Single Responsibility Principle."
exampleFile: "large-class.cpp"
---

# Introduction

When a class tries to do too many things, it becomes excessively large. Large classes are hard to understand and maintain and usually signal a violation of the Single Responsibility Principle (SRP).

## Key Identifiers

- The class has an unusually high line count
- Too many fields and methods
- Multiple unrelated responsibilities are mixed together
- Hard to articulate the class's single, clear purpose

## Refactoring Suggestions

1. **Extract Class**: Move cohesive groups of fields and methods into new classes
2. **Use Delegation / Composition**: Prefer composition over inheritance for separating concerns
3. **Enforce Single Responsibility**: Ensure each class has only one reason to change

## Explanation

This class handles game management, rendering, audio, networking, file system access, and more. It should be split into multiple specialized classes, each owning a specific domain concern.
