---
slug: "temporary-field"
nameCn: "临时字段"
nameEn: "Temporary Field"
category: "Object-Orientation Abusers"
description: "对象中的某些字段只在特定情况下才有值。"
exampleFile: "temporary-field.cpp"
---

# 简介

当一个对象的某些字段只在特定算法或情况下才被使用时，这些字段就是临时字段。它们让代码难以理解，因为你期望对象的所有字段都有用。

## 识别要点

- 某些字段只在特定方法中使用
- 字段的值在大部分时间为空或无意义
- 对象的状态不一致
- 难以理解字段的用途

## 重构建议

1. **提取类**：将临时字段和相关方法提取到新类中
2. **引入空对象**：用空对象模式处理特殊情况
3. **使用局部变量**：将临时数据作为方法参数传递
4. **策略模式**：用不同的策略类处理不同情况

## 说明

临时字段应该被提取到专门的类中，或者作为方法的局部变量。这样可以让对象的状态更加一致和可预测。
\`\`\`

```cpp file="data/examples/temporary-field.cpp"
class Calculator {
private:
    double operand1;
    double operand2;
    char operation;
    
    // 这些字段只在复杂计算时使用
    double tempResult;
    double intermediateValue;
    bool isComplexCalculation;
    std::vector<double> calculationSteps;
    
public:
    double calculate(double a, double b, char op) {
        operand1 = a;
        operand2 = b;
        operation = op;
        
        if (op == '^') {
            // 只有在幂运算时才使用这些临时字段
            isComplexCalculation = true;
            tempResult = 1;
            intermediateValue = a;
            calculationSteps.clear();
            
            for (int i = 0; i &lt; b; i++) {
                tempResult *= intermediateValue;
                calculationSteps.push_back(tempResult);
            }
            return tempResult;
        } else {
            isComplexCalculation = false;
            // 简单运算时这些字段都没有意义
            return a + b;
        }
    }
};
