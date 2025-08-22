---
slug: "message-chains"
nameCn: "过长的消息链"
nameEn: "Message Chains"
category: "Couplers"
description: "客户端需要通过一长串的方法调用来获取所需的对象。"
descriptionEn: "The client needs to obtain the required object through a long chain of method calls."
exampleFile: "message-chains.cpp"
---

# Introduction

Message Chains occur when a client must navigate through a sequence of method calls to get the final object it needs. This increases coupling to multiple classes and violates the Law of Demeter.

## Key Identifiers

- Long chains of successive method calls
- The client must understand internal object structure
- Changes to intermediate objects ripple into client code
- Violates the "talk only to your immediate friends" principle

## Refactoring Suggestions

1. **Hide Delegation**: Provide convenience methods on the intermediate class
2. **Extract Method**: Wrap the long navigation chain inside a single method
3. **Move Method**: Relocate behavior to a class that can directly supply the needed data
4. **Introduce Local Extension**: Add helper/convenience methods (e.g., via wrapper or extension) to shorten access

## Explanation

The client traverses a long chain to obtain the office location. A direct method such as getManagerOfficeLocation() should be added to the Company class to shorten the chain and reduce coupling.