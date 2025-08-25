---
slug: "global-data"
nameCn: "全局数据"
nameEn: "Global Data"
category: "Couplers"
description: "从代码库的任何一个角落都可以修改全局数据，且没有任何机制可以探测出到底哪段代码做出了修改。"
descriptionEn: "Global data can be modified from anywhere in the codebase, and there's no mechanism to detect which code made the modifications."
exampleFile: "global-data.java"
---

# Introduction

Global data is one of the most pungent code smells. The problem with global data is that it can be modified from any corner of the codebase, and there's no mechanism to detect which code made the modifications. Time and again, global data causes mysterious bugs where the source of the problem is somewhere far away, making it extremely difficult to find the erroneous code.

## Key Identifiers

- Global variables accessible from anywhere in the codebase
- Static class variables that can be modified globally
- Singleton objects with mutable state
- Data that can be modified without clear ownership or control
- Lack of encapsulation around shared data

## Refactoring Suggestions

1. **Encapsulate Variable**: Wrap global data with functions to control access
2. **Move Field**: Move global data into a class or module where it belongs
3. **Limit Scope**: Restrict access to data within specific modules or classes
4. **Make Immutable**: If data must be global, make it immutable after initialization
5. **Dependency Injection**: Pass data as parameters rather than accessing globally

## Explanation

Global data violates the principle of encapsulation and makes code unpredictable. When data can be modified from anywhere, it becomes impossible to reason about the state of the system. The primary defense is to encapsulate the data with functions, allowing you to see where it's being modified and control access to it. Ideally, move the data into a class or module and allow only that module's code to use it, thus limiting its scope as much as possible.
