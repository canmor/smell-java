---
slug: "duplicate-code"
nameCn: "重复代码"
nameEn: "Duplicate Code"
category: "Dispensables"
description: "相同的代码结构在多个地方重复出现。"
descriptionEn: "The same code structure appears repeatedly in multiple places."
exampleFile: "duplicate-code.cpp"
---

# Introduction

Duplicate code is one of the most common code smells. When the same code appears in multiple places, any change must be made in several locations, making omissions likely and increasing maintenance cost.

## Key Identifiers

- Identical or very similar code fragments appear multiple times
- Changes require synchronized edits across multiple places
- Inconsistent modifications easily slip in
- Increases the overall size of the codebase

## Refactoring Suggestions

1. **Extract Method**: Pull duplicated code into a single method
2. **Extract Class**: Create a new class to hold related duplicated behavior
3. **Template Method Pattern**: Extract the common structure of an algorithm
4. **Strategy Pattern**: Handle similar logic that varies slightly

## Explanation

The validation logic is duplicated in two methods and should be extracted into a single validation method. Then changes to the validation rules need to be made only once.