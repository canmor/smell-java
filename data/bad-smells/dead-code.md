---
slug: "dead-code"
nameCn: "死代码"
nameEn: "Dead Code"
category: "Dispensables"
description: "不再被使用的代码。"
exampleFile: "dead-code.cpp"
---

# 简介

死代码是不再被调用或使用的代码。它增加了代码库的大小和复杂性，应该被删除。死代码的存在会误导开发者，增加维护成本。

## 识别要点

- 方法或类不再被调用
- 无法到达的代码分支
- 过时的功能或特性
- 注释掉的代码块

## 重构建议

1. **删除未使用的方法**：移除不再被调用的方法
2. **删除未使用的类**：移除不再被使用的类
3. **删除无用的变量**：移除未使用的变量和字段
4. **清理注释代码**：删除被注释掉的代码

## 说明

oldRenderMethod和deprecatedSaveMethod不再被使用，应该删除这些死代码。保留死代码会增加代码库的复杂性，误导其他开发者。
\`\`\`

```cpp file="data/examples/dead-code.cpp"
class GameEngine {
private:
    bool debugMode;
    int unusedVariable; // 未使用的变量
    
public:
    void startGame() {
        initializeGraphics();
        loadAssets();
        startGameLoop();
    }
    
    // 这个方法不再被使用
    void oldRenderMethod() {
        // 旧的渲染逻辑，已被新方法替代
        std::cout << "Old rendering..." << std::endl;
    }
    
    // 这个方法也不再被使用
    void deprecatedSaveMethod() {
        // 旧的保存逻辑
        std::cout << "Old save method..." << std::endl;
    }
    
    void render() {
        // 新的渲染逻辑
        std::cout << "New rendering..." << std::endl;
    }
    
    // 永远不会被执行的代码
    void unreachableCode() {
        return;
        std::cout << "This will never be printed" << std::endl; // 死代码
    }
    
    /*
    // 被注释掉的旧代码
    void oldMethod() {
        // 这些代码应该被删除而不是注释
        std::cout << "Old implementation" << std::endl;
    }
    */
    
private:
    void initializeGraphics() { /* ... */ }
    void loadAssets() { /* ... */ }
    void startGameLoop() { /* ... */ }
    
    // 未使用的私有方法
    void unusedPrivateMethod() {
        std::cout << "This method is never called" << std::endl;
    }
};
