---
slug: "speculative-generality"
nameCn: "过度设计"
nameEn: "Speculative Generality"
category: "Dispensables"
description: "为了未来可能的需求而设计的过度复杂的结构。"
descriptionEn: "Overly complex structures designed for potential future needs that may never arrive."
exampleFile: "speculative-generality.java"
---

# Introduction

Speculative Generality appears when code becomes overly complex to handle scenarios that may never occur. This "just in case" mindset adds unnecessary abstraction and maintenance burden.

## Key Identifiers

- Excessive abstraction layers or deep inheritance hierarchies
- Abstract classes or interfaces with only a single implementation
- Over-parameterized designs (too many unused options/config hooks)
- Complex structures reserved purely for anticipated future needs

## Refactoring Suggestions

1. **Collapse Hierarchy**: Remove unnecessary abstraction layers
2. **Inline Class**: Merge over-abstracted classes back into concrete code
3. **Remove Parameters**: Delete unused or speculative parameters
4. **Simplify Design**: Favor the simplest viable solution (embrace YAGNI)

## Explanation

Elaborate abstractions and configuration systems were added for potential future requirements, but only a simple implementation is actually used. Follow the YAGNI (You Aren't Gonna Need It) principle and strip away speculative complexity.