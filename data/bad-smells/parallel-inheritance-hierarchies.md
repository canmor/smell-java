---
slug: "parallel-inheritance-hierarchies"
nameCn: "平行继承结构"
nameEn: "Parallel Inheritance Hierarchies"
category: "Change Preventers"
description: "每当为某个类添加子类时，也需要为另一个类添加子类。"
descriptionEn: "Whenever you add a subclass to one class hierarchy, you must add a corresponding subclass to another."
exampleFile: "parallel-inheritance-hierarchies.cpp"
---

# Introduction

Parallel Inheritance Hierarchies occur when every time you add a subclass to one hierarchy you also have to add a corresponding subclass to another related hierarchy. This inflates maintenance cost and couples evolution across modules.

## Key Identifiers

- Two class hierarchies mirror each other
- Adding a new subclass in one forces creation in the other
- Class names share similar prefixes/suffixes indicating pairing
- Increases structural complexity and change surface area

## Refactoring Suggestions

1. **Eliminate One Hierarchy**: Have one hierarchy reference or contain behavior from the other instead of mirroring it
2. **Use Visitor Pattern**: Centralize operations instead of distributing them across paired subclasses
3. **Merge Hierarchies**: Combine related responsibilities into a single class (or a single hierarchy) where appropriate
4. **Apply Strategy / Composition**: Replace one dimension of inheritance with pluggable strategy objects

## Explanation

If every Shape requires a corresponding Renderer subclass, let Shape handle rendering itself (with overridable hooks) or introduce a Visitor/Strategy to decouple rendering from shape types and avoid parallel subclass proliferation.