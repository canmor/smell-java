---
slug: "comments"
nameCn: "多余注释"
nameEn: "Comments"
category: "Dispensables"
description: "代码中有过多的注释，通常表明代码不够清晰。"
descriptionEn: "Too many comments in the code usually indicate that the code is not clear enough."
exampleFile: "comments.java"
---

# Introduction

Although comments are useful, too many comments usually indicate that the code itself is not clear. Good code should be self-explanatory, and comments should explain "why" instead of "what".

## Key Identifiers

- Comments explain obvious code
- Comments are out of sync with the code
- A large number of inline comments
- More comments than code

## Refactoring Suggestions

1. **Extract Method**: Replace comments with meaningful method names  
2. **Introduce Explaining Variable**: Use variable names to explain complex expressions  
3. **Rename**: Use clearer variable and method names  
4. **Remove Redundant Comments**: Keep only truly valuable comments  

## Explanation

These comments are redundant because the code is already clear. They should be removed to make the code more concise, or replaced with better naming to make the code self-explanatory.