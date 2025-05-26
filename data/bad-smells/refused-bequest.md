---
slug: "refused-bequest"
nameCn: "拒绝继承"
nameEn: "Refused Bequest"
category: "Object-Orientation Abusers"
description: "子类不使用父类的某些方法或数据。"
exampleFile: "refused-bequest.cpp"
---

# 简介

当子类只使用父类的部分功能，或者需要重写父类方法来抛出异常时，就出现了拒绝继承。这表明继承层次设计有问题。

## 识别要点

- 子类重写方法只为抛出异常
- 子类不使用父类的某些方法
- 继承关系不符合"is-a"关系
- 违反里氏替换原则

## 重构建议

1. **重新设计继承层次**：创建更合适的抽象
2. **使用组合替代继承**：用委托模式
3. **提取超类**：为共同行为创建新的父类
4. **接口分离**：将大接口拆分为小接口

## 说明

企鹅不能飞行，这表明继承层次设计有问题。应该重新设计类层次结构，可能需要将飞行能力提取为单独的接口或特征。
\`\`\`

```cpp file="data/examples/refused-bequest.cpp"
class Bird {
public:
    virtual void fly() {
        std::cout << "Flying..." << std::endl;
    }
    
    virtual void eat() {
        std::cout << "Eating..." << std::endl;
    }
    
    virtual void makeSound() {
        std::cout << "Chirp..." << std::endl;
    }
    
    virtual void layEggs() {
        std::cout << "Laying eggs..." << std::endl;
    }
};

class Penguin : public Bird {
public:
    // 拒绝继承：企鹅不能飞
    void fly() override {
        throw std::runtime_error("Penguins can't fly!");
    }
    
    void makeSound() override {
        std::cout << "Squawk..." << std::endl;
    }
    
    void swim() {
        std::cout << "Swimming..." << std::endl;
    }
};

class Ostrich : public Bird {
public:
    // 鸵鸟也不能飞
    void fly() override {
        throw std::runtime_error("Ostriches can't fly!");
    }
    
    void run() {
        std::cout << "Running fast..." << std::endl;
    }
};
