---
slug: "middle-man"
nameCn: "中间人"
nameEn: "Middle Man"
category: "Couplers"
description: "类的大部分方法都是简单地委托给其他类。"
exampleFile: "middle-man.cpp"
---

# 简介

当一个类的大部分方法都只是简单地委托给其他类时，这个类就成了中间人。它可能没有存在的必要，应该考虑直接使用被委托的类。

## 识别要点

- 类的大部分方法都是简单的委托
- 类没有添加额外的价值
- 类只是简单地转发调用
- 增加了不必要的间接层

## 重构建议

1. **移除中间人**：让客户端直接使用被委托的类
2. **内联方法**：将简单的委托方法内联
3. **部分委托**：只保留有价值的委托方法
4. **替换委托为继承**：如果合适的话

## 说明

DatabaseManager类只是简单地委托给DatabaseConnection，可能应该直接使用DatabaseConnection，或者为DatabaseManager添加更多有价值的功能。
\`\`\`

```cpp file="data/examples/middle-man.cpp"
class DatabaseConnection {
public:
    void connect() { 
        std::cout << "Connecting to database..." << std::endl;
    }
    
    void disconnect() { 
        std::cout << "Disconnecting from database..." << std::endl;
    }
    
    void executeQuery(const std::string& sql) { 
        std::cout << "Executing: " << sql << std::endl;
    }
    
    void beginTransaction() { 
        std::cout << "Beginning transaction..." << std::endl;
    }
    
    void commitTransaction() { 
        std::cout << "Committing transaction..." << std::endl;
    }
    
    void rollbackTransaction() { 
        std::cout << "Rolling back transaction..." << std::endl;
    }
    
    bool isConnected() const { return true; }
};

// 这个类只是简单地委托给DatabaseConnection
class DatabaseManager {
private:
    DatabaseConnection connection;
    
public:
    // 所有方法都是简单的委托
    void connect() {
        connection.connect();
    }
    
    void disconnect() {
        connection.disconnect();
    }
    
    void executeQuery(const std::string& sql) {
        connection.executeQuery(sql);
    }
    
    void beginTransaction() {
        connection.beginTransaction();
    }
    
    void commitTransaction() {
        connection.commitTransaction();
    }
    
    void rollbackTransaction() {
        connection.rollbackTransaction();
    }
    
    bool isConnected() const {
        return connection.isConnected();
    }
};

// 另一个中间人的例子
class FileSystem {
public:
    std::string readFile(const std::string& path) { return "content"; }
    void writeFile(const std::string& path, const std::string& content) {}
    bool fileExists(const std::string& path) { return true; }
};

class FileManager {
private:
    FileSystem fs;
    
public:
    std::string read(const std::string& path) {
        return fs.readFile(path);
    }
    
    void write(const std::string& path, const std::string& content) {
        fs.writeFile(path, content);
    }
    
    bool exists(const std::string& path) {
        return fs.fileExists(path);
    }
};
