---
slug: "insider-trading"
nameCn: "内幕交易"
nameEn: "Insider Trading"
category: "Couplers"
description: "模块之间过多的私下数据交换增加了耦合，应该减少这种私下交流并将交换放到明面上来。"
descriptionEn: "Excessive private data exchange between modules increases coupling and should be reduced with transparent communication mechanisms."
exampleFile: "insider-trading.java"
---

# Introduction

Software developers like to build high walls between modules and are extremely averse to extensive data exchange between modules, as this increases coupling. In practice, some data exchange is inevitable, but we must minimize this and make all such exchanges transparent.

## Key Identifiers

- Two modules frequently accessing each other's internal data
- Classes that know too much about each other's implementation details
- Excessive method calls between related classes
- Subclasses that access too many protected members of their superclass
- Classes that bypass proper interfaces to access internal state
- Modules that share data through back-channel communication

## Refactoring Suggestions

1. **Move Function**: Reduce private communication by moving functions closer to the data they use
2. **Move Field**: Move fields to reduce inappropriate intimacy between classes
3. **Extract Class**: Create a new module for shared interests and common data
4. **Hide Delegate**: Make one module act as an intermediary between two others
5. **Replace Subclass with Delegate**: Break inheritance when subclasses know too much about superclass
6. **Replace Superclass with Delegate**: Remove inheritance when it creates inappropriate intimacy

## Explanation

When two modules are always "whispering by the coffee machine", it indicates they have inappropriate intimacy that should be addressed. If two modules have common interests, try creating a new module to put shared data in a well-managed place. Inheritance often causes conspiracy because subclasses always know more about their superclass than the latter would prefer. Sometimes it's time to let the child live independently from the inheritance hierarchy.
