---
slug: "mysterious-name"
nameCn: "神秘命名"
nameEn: "Mysterious Name"
category: "Change Preventers"
description: "函数、模块、变量或类的名称无法清楚地表达它们的用途。"
descriptionEn: "Functions, modules, variables, or classes have names that don't clearly express what they do."
exampleFile: "mysterious-name.java"
---

# Introduction

Good naming is one of the fundamental aspects of clean code. When names don't clearly express what they do, it makes the code harder to understand and maintain. Mysterious names force readers to spend extra mental effort to understand the code's purpose.

## Key Identifiers

- Variable, method, or class names that don't explain their purpose
- Single-letter variables (except for loop counters)
- Abbreviated names that save few characters but lose clarity
- Names that are misleading or don't match the actual functionality
- Generic names like `data`, `info`, `manager`, `handler` without context

## Refactoring Suggestions

1. **Rename Variable**: Use descriptive names that explain the variable's purpose
2. **Rename Method**: Choose method names that clearly describe what the method does
3. **Rename Class**: Use class names that reflect their responsibility
4. **Use Intention-Revealing Names**: Make the code read like well-written prose

## Explanation

Mysterious names create unnecessary cognitive load for anyone reading the code. By using clear, descriptive names, we make the code self-documenting and reduce the need for additional comments. Good names should answer three key questions: Why does it exist? What does it do? How is it used?
