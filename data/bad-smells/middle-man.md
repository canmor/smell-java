---
slug: "middle-man"
nameCn: "中间人"
nameEn: "Middle Man"
category: "Couplers"
description: "类的大部分方法都是简单地委托给其他类。"
descriptionEn: "Most of a class's methods simply delegate to other classes."
exampleFile: "middle-man.cpp"
---

# Introduction

When most of a class's methods merely delegate to other classes, it becomes a Middle Man. The class may not need to exist; clients could work directly with the underlying collaborator.

## Key Identifiers

- Majority of methods are trivial delegations
- The class adds no extra value or logic
- Methods just forward calls verbatim
- Adds an unnecessary layer of indirection

## Refactoring Suggestions

1. **Remove Middle Man**: Let clients talk directly to the delegated class
2. **Inline Method**: Inline trivial delegation methods
3. **Selective Delegation**: Keep only delegations that add value or simplify usage
4. **Replace Delegation with Inheritance**: If appropriate and safe (rarely the first choice)

## Explanation

The DatabaseManager class simply delegates to DatabaseConnection. Either use DatabaseConnection directly, or enrich DatabaseManager with meaningful behavior to justify its existence.