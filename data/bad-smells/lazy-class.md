---
slug: "lazy-class"
nameCn: "懒惰类"
nameEn: "Lazy Class"
category: "Dispensables"
description: "类没有做足够的工作来证明其存在的必要性。"
descriptionEn: "A class does not do enough work to justify its existence."
exampleFile: "lazy-class.cpp"
---

# Introduction

When a class does not do enough meaningful work, it becomes a Lazy Class. Such a class adds structural noise and complexity without proportional value and should be refactored or removed.

## Key Identifiers

- The class has very few methods or fields
- Its functionality is overly trivial
- It simply delegates to other classes
- Maintenance cost exceeds its value

## Refactoring Suggestions

1. **Inline Class**: Merge its behavior into the primary consuming class
2. **Collapse Hierarchy**: If a subclass is too trivial, fold it into its parent
3. **Move Method**: Relocate methods to a more appropriate class
4. **Delete Class**: Remove it entirely if it adds no real value

## Explanation

The PointPrinter class has only a single trivial method. The print behavior likely belongs on the Point class itself or as a standalone utility function—no need for a separate class.