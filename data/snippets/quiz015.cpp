class FileUtil {
public:
    bool fileExists(const std::string& filename) {
        std::ifstream file(filename);
        return file.good();
    }
};

class DateFormatter {
public:
    std::string formatDate(const std::tm& date) {
        char buffer[11];
        std::strftime(buffer, sizeof(buffer), "%Y-%m-%d", &date);
        return std::string(buffer);
    }
};

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

void clientCode() {
    FileUtil fileUtil;
    if (fileUtil.fileExists("data.txt")) {
        std::cout << "File exists" << std::endl;
    }
    
    std::time_t t = std::time(nullptr);
    std::tm now = *std::localtime(&t);
    DateFormatter formatter;
    std::string dateStr = formatter.formatDate(now);
    
    IntegerWrapper number(42);
    if (number.isPositive()) {
        std::cout << "Value is positive: " << number.getValue() << std::endl;
    }
}
