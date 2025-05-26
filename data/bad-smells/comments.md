---
slug: "comments"
nameCn: "多余注释"
nameEn: "Comments"
category: "Dispensables"
description: "代码中有过多的注释，通常表明代码不够清晰。"
exampleFile: "comments.cpp"
---

# 简介

虽然注释很有用，但过多的注释往往表明代码本身不够清晰。好的代码应该是自解释的，注释应该解释"为什么"而不是"做什么"。

## 识别要点

- 注释解释显而易见的代码
- 注释与代码不同步
- 大量的行内注释
- 注释比代码还多

## 重构建议

1. **提取方法**：用有意义的方法名替代注释
2. **引入解释性变量**：用变量名解释复杂表达式
3. **重命名**：使用更清晰的变量和方法名
4. **删除多余注释**：保留真正有价值的注释

## 说明

这些注释都是多余的，因为代码本身已经很清楚了。应该删除这些注释，让代码更简洁，或者用更好的命名来让代码自解释。
\`\`\`

```cpp file="data/examples/comments.cpp"
class Calculator {
public:
    // 这个方法计算两个数的和
    int add(int a, int b) {
        // 将第一个数和第二个数相加
        int result = a + b;
        // 返回结果
        return result;
    }
    
    // 这个方法计算圆的面积
    // 参数r是半径
    // 返回值是面积
    double calculateCircleArea(double r) {
        // 使用公式 π * r * r
        double pi = 3.14159; // π的值
        double area = pi * r * r; // 计算面积
        return area; // 返回计算结果
    }
    
    // 这个方法检查数字是否为偶数
    bool isEven(int number) {
        // 如果数字除以2的余数为0，则为偶数
        if (number % 2 == 0) {
            return true; // 返回真
        } else {
            return false; // 返回假
        }
    }
    
    // 计算阶乘
    // 输入：一个正整数n
    // 输出：n的阶乘
    int factorial(int n) {
        // 如果n等于0或1，返回1
        if (n &lt;= 1) {
            return 1;
        }
        // 否则返回n乘以(n-1)的阶乘
        return n * factorial(n - 1);
    }
};
