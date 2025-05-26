---
slug: "speculative-generality"
nameCn: "过度设计"
nameEn: "Speculative Generality"
category: "Dispensables"
description: "为了未来可能的需求而设计的过度复杂的结构。"
exampleFile: "speculative-generality.cpp"
---

# 简介

当代码为了处理可能永远不会发生的情况而变得过度复杂时，就出现了过度设计。这种"以防万一"的编程方式会增加不必要的复杂性。

## 识别要点

- 过度抽象和复杂的继承层次
- 只有一个实现的抽象类或接口
- 过度参数化的设计
- 为未来需求预留的复杂结构

## 重构建议

1. **折叠继承层次**：移除不必要的抽象层
2. **内联类**：将过度抽象的类合并
3. **移除参数**：删除未使用的参数
4. **简化设计**：采用最简单可行的解决方案

## 说明

复杂的抽象和配置系统是为了未来可能的需求而设计的，但实际上只需要简单的实现。应该遵循YAGNI（You Aren't Gonna Need It）原则。
\`\`\`

```cpp file="data/examples/speculative-generality.cpp"
// 过度设计的抽象层次
template<typename T>
class AbstractDataProcessor {
public:
    virtual void process(T data) = 0;
    virtual void preProcess(T data) {}
    virtual void postProcess(T data) {}
    virtual bool shouldProcess(T data) { return true; }
    virtual void onError(const std::exception& e) {}
    virtual void onSuccess(T data) {}
    virtual ~AbstractDataProcessor() = default;
};

template<typename T>
class ConfigurableDataProcessor : public AbstractDataProcessor<T> {
private:
    std::map<std::string, std::function<void(T)>> processors;
    std::vector<std::function<bool(T)>> filters;
    std::vector<std::function<void(T)>> preprocessors;
    std::vector<std::function<void(T)>> postprocessors;
    
public:
    void addProcessor(const std::string& name, std::function<void(T)> proc) {
        processors[name] = proc;
    }
    
    void addFilter(std::function<bool(T)> filter) {
        filters.push_back(filter);
    }
    
    void addPreprocessor(std::function<void(T)> preprocessor) {
        preprocessors.push_back(preprocessor);
    }
    
    void process(T data) override {
        // 复杂的处理逻辑，但实际上只有一种使用方式
        for (auto& preprocessor : preprocessors) {
            preprocessor(data);
        }
        
        for (auto& filter : filters) {
            if (!filter(data)) return;
        }
        
        for (auto& [name, processor] : processors) {
            processor(data);
        }
    }
};

// 实际上只需要这样简单的实现
class SimpleStringProcessor {
public:
    void process(const std::string& data) {
        std::cout << "Processing: " << data << std::endl;
    }
};
