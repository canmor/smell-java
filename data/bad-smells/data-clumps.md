---
slug: "data-clumps"
nameCn: "数据团"
nameEn: "Data Clumps"
category: "Bloaters"
description: "相同的数据项总是一起出现在多个地方。"
descriptionEn: "The same group of data items always appears together in multiple places."
exampleFile: "data-clumps.java"
---

# Introduction

When you see the same set of data items (typically 2–3 fields) duplicated across multiple classes, that data should be extracted into its own class.

## Key Identifiers

- The same combination of fields is repeated in multiple classes
- These fields are always passed or used together
- The same parameter grouping frequently appears in method parameter lists
- A proper abstraction concept is missing

## Refactoring Suggestions

1. **Extract Class**: Create a dedicated class for the data clump
2. **Introduce Parameter Object**: Replace long parameter lists with an object
3. **Keep Data Cohesive**: Keep related data together to preserve integrity

## Explanation

startX, startY and endX, endY often appear together. A Point (or perhaps a Range/LineSegment depending on context) class should be introduced to encapsulate the coordinate concept and improve readability and maintainability.