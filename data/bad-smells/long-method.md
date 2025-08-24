---
slug: "long-method"
nameCn: "过长函数"
nameEn: "Long Method"
category: "Bloaters"
description: "函数代码过长，难以阅读和维护。通常是多个职责未拆分的迹象。"
descriptionEn: "A function is too long, making it hard to read and maintain—usually a sign multiple responsibilities haven't been split."
exampleFile: "long-method.java"
---

# Introduction

When a function becomes too long, it's usually handling too many responsibilities. Long functions are harder to understand, test, and maintain. As a rule of thumb, consider splitting a function once it exceeds 20–30 lines.

## Key Identifiers

- Too many lines of code (often more than 20–30)
- The function performs multiple distinct responsibilities
- Overall logic is difficult to grasp at a glance
- Hard to test: requires many scenarios or setup branches

## Refactoring Suggestions

1. **Extract Method**: Break logical chunks into separate functions
2. **Separate Responsibilities**: Ensure each function does exactly one thing
3. **Use Meaningful Names**: Make extracted function names express intent clearly

## Explanation

This function handles too much: base score calculation, equipment bonuses, skill modifiers, and achievement bonuses. It should be split into several smaller functions, each responsible for a specific calculation step.