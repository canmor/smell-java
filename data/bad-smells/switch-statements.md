---
slug: "switch-statements"
nameCn: "过多的 switch"
nameEn: "Switch Statements"
category: "Object-Orientation Abusers"
description: "复杂的switch语句，通常可以用多态替代。"
exampleFile: "switch-statements.cpp"
---

# 简介

复杂的switch语句往往表明缺少多态性。每当需要添加新的case时，都需要修改switch语句，违反了开闭原则。

## 识别要点

- 复杂的switch或if-else语句
- 相同的switch逻辑在多处重复
- 添加新类型需要修改多个switch语句
- 违反开闭原则

## 重构建议

1. **多态替换**：使用继承和虚函数替代switch
2. **策略模式**：将不同的行为封装为策略类
3. **状态模式**：用于处理状态相关的switch语句

## 说明

应该使用多态，让每个形状类自己实现calculateArea()和draw()方法，这样添加新形状时不需要修改现有代码。
\`\`\`

```cpp file="data/examples/switch-statements.cpp"
double calculateArea(Shape shape) {
    switch (shape.type) {
        case RECTANGLE:
            return shape.width * shape.height;
        case CIRCLE:
            return 3.14159 * shape.radius * shape.radius;
        case TRIANGLE:
            return 0.5 * shape.base * shape.height;
        case SQUARE:
            return shape.side * shape.side;
        default:
            return 0;
    }
}

void draw(Shape shape) {
    switch (shape.type) {
        case RECTANGLE:
            drawRectangle(shape);
            break;
        case CIRCLE:
            drawCircle(shape);
            break;
        case TRIANGLE:
            drawTriangle(shape);
            break;
        case SQUARE:
            drawSquare(shape);
            break;
    }
}
