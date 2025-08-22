---
slug: "feature-envy"
nameCn: "特性嫉妒"
nameEn: "Feature Envy"
category: "Couplers"
description: "一个方法对其他类的数据比对自己类的数据更感兴趣。"
descriptionEn: "A method is more interested in the data of other classes than the data of its own class."
exampleFile: "feature-envy.java"
---

# Introduction

Feature Envy occurs when a method frequently accesses the data of other classes while using little of its own class's data. This suggests the method probably belongs elsewhere.

## Key Identifiers

- The method heavily uses data from other classes
- The method rarely uses its own class's fields
- High coupling between the method and foreign classes
- Violates the principle that data and behavior should live together

## Refactoring Suggestions

1. **Move Method**: Move the method to the class whose data it cares about most
2. **Extract Method**: Extract parts of the logic into more appropriate classes
3. **Introduce Parameter Object**: Create a new class to group related data
4. **Align Data and Behavior**: Keep related state and operations together

## Explanation

The getCustomerAddressInfo method should be moved to the Address class because it primarily operates on Address data. This raises cohesion and reduces coupling.