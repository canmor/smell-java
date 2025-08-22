---
slug: "dead-code"
nameCn: "死代码"
nameEn: "Dead Code"
category: "Dispensables"
description: "不再被使用的代码。"
descriptionEn: "Code that is no longer used."
exampleFile: "dead-code.cpp"
---

# Introduction

Dead code is code that is no longer invoked or used. It increases the size and complexity of the codebase and should be removed. Its presence misleads developers and raises maintenance costs.

## Key Identifiers

- Methods or classes are no longer called
- Unreachable code branches
- Outdated features or functionality
- Large commented-out code blocks

## Refactoring Suggestions

1. **Remove Unused Methods**: Delete methods that are never called
2. **Remove Unused Classes**: Delete classes that are no longer referenced
3. **Remove Unused Variables**: Delete unused variables and fields
4. **Clean Commented Code**: Remove commented-out code blocks

## Explanation

oldRenderMethod and deprecatedSaveMethod are no longer used and should be deleted. Keeping dead code adds complexity and misleads other developers.