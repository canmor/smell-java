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
