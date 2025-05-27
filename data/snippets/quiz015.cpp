// 过于简单的文件实用工具类
class FileUtil {
public:
    // 只有一个简单的功能
    bool fileExists(const std::string& filename) {
        std::ifstream file(filename);
        return file.good();
    }
};

// 一个太简单的格式化器类
class DateFormatter {
public:
    // 只有一个简单的方法
    std::string formatDate(const std::tm& date) {
        char buffer[11];
        std::strftime(buffer, sizeof(buffer), "%Y-%m-%d", &date);
        return std::string(buffer);
    }
};

// 一个不必要的包装类
class IntegerWrapper {
private:
    int value;
    
public:
    IntegerWrapper(int v) : value(v) {}
    
    int getValue() const {
        return value;
    }
    
    void setValue(int v) {
        value = v;
    }
    
    bool isPositive() const {
        return value > 0;
    }
    
    bool isNegative() const {
        return value < 0;
    }
};

// 客户端代码使用这些类
void clientCode() {
    // 使用FileUtil
    FileUtil fileUtil;
    if (fileUtil.fileExists("data.txt")) {
        std::cout << "File exists" << std::endl;
    }
    
    // 使用DateFormatter
    std::time_t t = std::time(nullptr);
    std::tm now = *std::localtime(&t);
    DateFormatter formatter;
    std::string dateStr = formatter.formatDate(now);
    
    // 使用IntegerWrapper
    IntegerWrapper number(42);
    if (number.isPositive()) {
        std::cout << "Value is positive: " << number.getValue() << std::endl;
    }
}
