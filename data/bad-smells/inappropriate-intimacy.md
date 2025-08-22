---
slug: "inappropriate-intimacy"
nameCn: "不适当的亲密关系"
nameEn: "Inappropriate Intimacy"
category: "Couplers"
description: "两个类过于亲密，知道彼此太多的私有细节。"
descriptionEn: "Two classes are overly intimate and know too many private details about each other."
exampleFile: "inappropriate-intimacy.cpp"
---

# Introduction

Inappropriate Intimacy occurs when two classes know too many internal implementation details about each other. This increases coupling so that changing one class may impact the other.

## Key Identifiers

- Overuse of the friend keyword (in languages that support it)
- Frequent access to another class's private or overly internal members
- Changes to one class often require synchronized changes to the other
- Blurry or leaky boundaries between the two classes

## Refactoring Suggestions

1. **Move Method**: Relocate methods to the class whose data they primarily use
2. **Extract Class**: Create a new class to own data or behavior of shared concern
3. **Hide Delegation**: Interact via clear public interfaces instead of internal fields
4. **Reduce friend Usage**: Prefer accessor methods or interfaces over friendship

## Explanation

The Transaction class knows too much about BankAccount's internals. Interaction should occur through BankAccount's public interface rather than direct access to private members.