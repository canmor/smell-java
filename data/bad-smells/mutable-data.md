---
slug: "mutable-data"
nameCn: "可变数据"
nameEn: "Mutable Data"
category: "Change Preventers"
description: "对数据的修改经常导致出乎意料的结果和难以发现的bug，一处更新数据却影响了软件中其他地方的期望。"
descriptionEn: "Modifications to data often lead to unexpected results and hard-to-find bugs, where updating data in one place affects expectations elsewhere in the software."
exampleFile: "mutable-data.java"
---

# Introduction

Modifications to data often lead to unexpected results and hard-to-find bugs. When you update data in one place without realizing that another part of the software expects completely different data, a feature fails. If the failure only occurs in rare circumstances, finding the cause becomes even more difficult.

## Key Identifiers

- Variables that can be modified from multiple places
- Shared mutable state between different parts of the system
- Data structures that are modified in place rather than replaced
- Variables used for different purposes at different times
- Missing encapsulation around data updates
- Derived data that can be calculated elsewhere

## Refactoring Suggestions

1. **Encapsulate Variable**: Ensure all data updates go through a few functions to make monitoring easier
2. **Split Variable**: Separate variables used for different purposes at different times
3. **Move Statements and Extract Function**: Separate side-effect-free code from data update operations
4. **Separate Query from Modifier**: Ensure callers don't accidentally call side-effect code
5. **Remove Setting Method**: Look for opportunities to reduce variable scope
6. **Replace Derived Variable with Query**: Calculate values instead of storing mutable derived data
7. **Combine Functions into Class/Transform**: Limit the amount of code that needs to modify variables
8. **Change Reference to Value**: Replace entire data structures instead of modifying internal data

## Explanation

Mutable data becomes particularly problematic when its scope expands beyond a few lines of code. The risk increases with the scope of the variable. The ideal solution is to make data immutable whenever possible, but when that's not feasible, we should constrain data updates through encapsulation and careful design to minimize the risk of unexpected modifications affecting other parts of the system.
