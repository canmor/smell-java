---
slug: "temporary-field"
nameCn: "临时字段"
nameEn: "Temporary Field"
category: "Object-Orientation Abusers"
description: "对象中的某些字段只在特定情况下才有值。"
descriptionEn: "Some fields in an object only have meaningful values in specific situations."
exampleFile: "temporary-field.cpp"
---

# Introduction

Temporary Fields appear when certain fields of an object are only used in specific algorithms or situations. They make code harder to understand because you expect all fields of an object to be generally meaningful.

## Key Identifiers

- Some fields are only referenced in one or two methods
- Field values are null/empty/meaningless most of the time
- Object state appears inconsistent or partially populated
- It's unclear why the field exists when reading the class

## Refactoring Suggestions

1. **Extract Class**: Move temporary fields and related methods into a dedicated helper class
2. **Introduce Null Object**: Use a Null Object to handle special cases instead of optional fields
3. **Use Local Variables**: Pass temporary data as parameters or keep it local within methods
4. **Strategy Pattern**: Use different strategy objects for varying scenarios instead of conditional fields

## Explanation

Temporary fields should be extracted into a dedicated class or converted into local variables. This keeps the object's state consistent and predictable.