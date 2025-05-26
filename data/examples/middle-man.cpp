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
