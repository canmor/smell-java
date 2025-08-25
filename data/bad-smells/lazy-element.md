---
slug: "lazy-element"
nameCn: "冗赘的元素"
nameEn: "Lazy Element"
category: "Dispensables"
description: "程序元素（如类和函数）不再提供足够的价值来证明其存在的必要性，应该被内联或移除。"
descriptionEn: "Program elements (like classes and functions) no longer provide enough value to justify their existence and should be inlined or removed."
exampleFile: "lazy-element.java"
---

# Introduction

Program elements such as classes and functions can add structure to code, supporting change, promoting reuse, or simply providing better names. But sometimes we really don't need that extra layer of structure. There might be a function whose name looks exactly the same as its implementation code, or a class that is essentially just a simple function.

## Key Identifiers

- Functions that are just one line and don't add meaningful abstraction
- Classes that contain only one method or just delegate to another class
- Classes that have become too simple after refactoring
- Inheritance hierarchies with unnecessary intermediate classes
- Interfaces with only one implementation that adds no value
- Wrapper methods that just call another method without adding logic

## Refactoring Suggestions

1. **Inline Function**: Replace function calls with the function body when the function doesn't add value
2. **Inline Class**: Move the class's features into another class when it's too simple
3. **Collapse Hierarchy**: Remove unnecessary classes from inheritance hierarchies
4. **Remove Wrapper Methods**: Eliminate methods that just delegate without adding value
5. **Merge Classes**: Combine classes that are too closely related or too simple

## Explanation

Lazy elements often arise because a programmer expected a function or class to grow and become more complex someday, but that day never came. Or perhaps the class was originally useful but became smaller and smaller through refactoring until only one function remained. Whatever the reason, such program elements should be retired gracefully. The key is to maintain only the structure that actually adds value to the codebase.
