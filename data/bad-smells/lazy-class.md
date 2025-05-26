---
slug: "lazy-class"
nameCn: "懒惰类"
nameEn: "Lazy Class"
category: "Dispensables"
description: "类没有做足够的工作来证明其存在的必要性。"
exampleFile: "lazy-class.cpp"
---

# 简介

当一个类没有做足够的工作时，它就是懒惰类。这样的类增加了代码的复杂性而没有提供相应的价值，应该被重构或删除。

## 识别要点

- 类只有很少的方法和字段
- 类的功能过于简单
- 类只是简单地委托给其他类
- 维护成本超过了其价值

## 重构建议

1. **内联类**：将类的功能合并到使用它的类中
2. **折叠继承层次**：如果子类过于简单，合并到父类
3. **移动方法**：将方法移到更合适的类中
4. **删除类**：如果类确实没有价值，直接删除

## 说明

PointPrinter类只有一个简单的方法，可能应该将print方法移到Point类中，或者作为自由函数，而不需要单独的类。
\`\`\`

```cpp file="data/examples/lazy-class.cpp"
class Point {
private:
    int x, y;
    
public:
    Point(int x, int y) : x(x), y(y) {}
    
    int getX() const { return x; }
    int getY() const { return y; }
    void setX(int x) { this->x = x; }
    void setY(int y) { this->y = y; }
};

// 这个类太简单了，可能不需要单独存在
class PointPrinter {
public:
    void print(const Point& point) {
        std::cout << "(" << point.getX() << ", " << point.getY() << ")" << std::endl;
    }
};

// 另一个懒惰类的例子
class MathConstants {
public:
    static const double PI;
};

const double MathConstants::PI = 3.14159;

// 这个类也很简单，可能直接用常量就够了
class StringValidator {
public:
    bool isEmpty(const std::string& str) {
        return str.empty();
    }
};
