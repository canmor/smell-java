---
slug: "data-class"
nameCn: "数据类"
nameEn: "Data Class"
category: "Dispensables"
description: "类只包含字段和访问器方法，没有其他功能。"
descriptionEn: "The class only contains fields and accessor methods and has no other functionality."
exampleFile: "data-class.cpp"
---

# Introduction

A Data Class contains only data and simple accessor methods, with no behavior. Such classes often indicate that behavior has been placed in the wrong location.

## Key Identifiers

- The class contains only fields and getter/setter methods
- No business logic or behavioral methods
- Related behavior is scattered across other classes
- Violates the object-oriented principle of encapsulation

## Refactoring Suggestions

1. **Move Method**: Move related behavior into the data class
2. **Encapsulate Field**: Reduce unnecessary setter methods
3. **Add Behavior**: Add meaningful domain methods to the data class

## Explanation

The Customer class is merely a data container; related business behavior should be moved into the Customer class so that data and behavior stay together.