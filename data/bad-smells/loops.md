---
slug: "loops"
nameCn: "循环语句"
nameEn: "Loops"
category: "Dispensables"
description: "传统的循环语句已经过时，现代函数式编程提供了更清晰的管道操作来替代循环。"
descriptionEn: "Traditional loop statements are outdated, modern functional programming provides clearer pipeline operations to replace loops."
exampleFile: "loops.java"
---

# Introduction

Since the earliest programming languages, loops have been a core element of programming. However, we feel that loops are now somewhat outdated, like bell-bottom pants and flocked wallpaper. With widespread support for functions as first-class citizens, we can use "Replace Loop with Pipeline" to retire these old relics.

## Key Identifiers

- Traditional for/while loops that iterate over collections
- Loops that perform filtering, mapping, or reducing operations
- Multiple nested loops that could be simplified
- Loops with complex logic that obscure the main intent
- Accumulator patterns that build up results step by step

## Refactoring Suggestions

1. **Replace Loop with Pipeline**: Use stream operations like filter, map, reduce
2. **Extract Method**: Break complex loop logic into smaller, named operations
3. **Use Collection Methods**: Leverage built-in collection operations
4. **Functional Composition**: Chain operations together for clarity
5. **Parallel Processing**: Use parallel streams when appropriate

## Explanation

Pipeline operations like filter and map help us see more clearly what elements are being processed and what actions are being performed on them. Modern functional programming constructs make code more readable, less error-prone, and often more performant than traditional imperative loops. The intent becomes clearer when we express operations as a series of transformations rather than step-by-step instructions.
