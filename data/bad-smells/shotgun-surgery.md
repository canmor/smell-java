---
slug: "shotgun-surgery"
nameCn: "霰弹式修改"
nameEn: "Shotgun Surgery"
category: "Change Preventers"
description: "每当需要修改时，都需要在多个类中做小修改。"
descriptionEn: "Whenever a change is needed, small edits must be made across many different classes."
exampleFile: "shotgun-surgery.cpp"
---

# Introduction

Shotgun Surgery occurs when implementing a single change forces you to make many small edits across numerous classes. This indicates related behavior is scattered instead of being properly localized.

## Key Identifiers

- One feature change requires touching many classes/files
- Related logic is scattered in multiple places
- Easy to miss one of the required edit points
- Higher maintenance cost and risk of inconsistent updates

## Refactoring Suggestions

1. **Move Method**: Gather related behavior into a single class or cohesive module
2. **Inline Class**: Merge tiny classes that only fragment logic
3. **Extract Class**: Create a dedicated class to centralize dispersed responsibilities
4. **Apply Design Patterns**: Use Strategy/Polymorphism (or similar) to concentrate variation points

## Explanation

If adding a new payment method requires edits in many classes, introduce a PaymentStrategy (or polymorphic hierarchy) so new behaviors are added in one focused place rather than scattered changes.