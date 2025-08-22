---
slug: "switch-statements"
nameCn: "过多的 switch"
nameEn: "Switch Statements"
category: "Object-Orientation Abusers"
description: "复杂的switch语句，通常可以用多态替代。"
descriptionEn: "Complex switch statements that could typically be replaced by polymorphism."
exampleFile: "switch-statements.cpp"
---

# Introduction

Complex switch statements often indicate missing polymorphism. Each time you add a new case, you must modify the switch, violating the Open/Closed Principle.

## Key Identifiers

- Large or complex switch / if-else chains
- Same switch logic duplicated in multiple places
- Adding a new type requires editing several switches
- Violates the Open/Closed Principle

## Refactoring Suggestions

1. **Replace with Polymorphism**: Use inheritance and virtual/overridden methods instead
2. **Strategy Pattern**: Encapsulate varying behavior in strategy classes
3. **State Pattern**: For state-dependent switch logic

## Explanation

Use polymorphism so each Shape class implements calculateArea() and draw(). Then adding a new shape doesn't require changes to existing code.