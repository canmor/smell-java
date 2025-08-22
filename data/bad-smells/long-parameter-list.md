---
slug: "long-parameter-list"
nameCn: "冗长参数列表"
nameEn: "Long Parameter List"
category: "Bloaters"
description: "函数参数过多，难以理解和使用。"
descriptionEn: "A function has too many parameters, making it hard to understand and use."
exampleFile: "long-parameter-list.cpp"
---

# Introduction

When a function has too many parameters, it becomes harder to understand and use. Typically, once a function takes more than 3–4 parameters, refactoring should be considered. A long parameter list usually indicates the function is doing too much.

## Key Identifiers

- More than 3–4 parameters
- Parameters of similar types that are easy to mix up
- Callers must remember positional ordering
- Adding a new parameter forces changes at every call site

## Refactoring Suggestions

1. **Introduce Parameter Object**: Group related parameters into a dedicated object
2. **Preserve Whole Object**: Pass the whole object instead of plucking its individual fields
3. **Builder Pattern**: Use a builder for constructing complex objects with many optional parts
4. **Split Function**: Break one large function into smaller, focused ones

## Explanation

A CharacterConfig (or CharacterBuilder) class should encapsulate these parameters to improve readability and reduce the chance of passing arguments in the wrong order.