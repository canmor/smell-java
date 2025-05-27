// 为可能的未来需求而过度设计的日志系统
class AbstractLogStrategy {
public:
    virtual void log(const std::string& message, int level) = 0;
    virtual void initialize() {}
    virtual void cleanup() {}
    virtual bool isEnabled() { return true; }
    virtual void setFormat(const std::string& format) {}
    virtual std::string getLastLog() { return ""; }
    virtual ~AbstractLogStrategy() = default;
};

class LogManager {
private:
    std::vector<std::shared_ptr<AbstractLogStrategy>> strategies;
    std::map<std::string, int> logLevels;
    std::map<std::string, std::function<void(const std::string&)>> customHandlers;
    std::vector<std::string> logBuffer;
    bool enableBuffering;
    int maxBufferSize;
    std::string defaultFormat;
    
public:
    LogManager() : enableBuffering(false), maxBufferSize(100) {
        // 初始化默认日志级别
        logLevels["DEBUG"] = 0;
        logLevels["INFO"] = 1;
        logLevels["WARNING"] = 2;
        logLevels["ERROR"] = 3;
        logLevels["CRITICAL"] = 4;
        
        defaultFormat = "[%time%] [%level%] %message%";
    }
    
    void addStrategy(std::shared_ptr<AbstractLogStrategy> strategy) {
        strategies.push_back(strategy);
    }
    
    void setBuffering(bool enable, int size = 100) {
        enableBuffering = enable;
        maxBufferSize = size;
    }
    
    void addCustomHandler(const std::string& name, 
                         std::function<void(const std::string&)> handler) {
        customHandlers[name] = handler;
    }
    
    void log(const std::string& message, const std::string& level = "INFO") {
        int logLevel = logLevels[level];
        
        if (enableBuffering) {
            logBuffer.push_back(message);
            if (logBuffer.size() > maxBufferSize) {
                logBuffer.erase(logBuffer.begin());
            }
        }
        
        for (auto& strategy : strategies) {
            if (strategy->isEnabled()) {
                strategy->log(message, logLevel);
            }
        }
        
        for (auto& [name, handler] : customHandlers) {
            handler(message);
        }
    }
    
    void flushBuffer() {
        logBuffer.clear();
    }
};

// 实际应用中只使用了这个简单的控制台日志实现
class ConsoleLogStrategy : public AbstractLogStrategy {
public:
    void log(const std::string& message, int level) override {
        std::cout << "LOG [Level " << level << "]: " << message << std::endl;
    }
};

// 客户端代码使用日志系统
void clientCode() {
    LogManager logManager;
    auto consoleLog = std::make_shared<ConsoleLogStrategy>();
    logManager.addStrategy(consoleLog);
    
    // 实际上，客户端只使用了基本的日志功能
    logManager.log("Application started", "INFO");
    logManager.log("Operation completed", "INFO");
}
