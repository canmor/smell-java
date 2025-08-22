class DatabaseConnection {
    public void connect() { 
        System.out.println("Connecting to database...");
    }
    
    public void disconnect() { 
        System.out.println("Disconnecting from database...");
    }
    
    public void executeQuery(String sql) { 
        System.out.println("Executing: " + sql);
    }
    
    public void beginTransaction() { 
        System.out.println("Beginning transaction...");
    }
    
    public void commitTransaction() { 
        System.out.println("Committing transaction...");
    }
    
    public void rollbackTransaction() { 
        System.out.println("Rolling back transaction...");
    }
    
    public boolean isConnected() { 
        return true; 
    }
    
    public void setConnectionTimeout(int timeout) {
        System.out.println("Setting timeout to: " + timeout);
    }
    
    public String getConnectionString() {
        return "jdbc:mysql://localhost:3306/mydb";
    }
}

// This class simply delegates to DatabaseConnection
class DatabaseManager {
    private DatabaseConnection connection;
    
    public DatabaseManager() {
        this.connection = new DatabaseConnection();
    }
    
    // All methods are simple delegations
    public void connect() {
        connection.connect();
    }
    
    public void disconnect() {
        connection.disconnect();
    }
    
    public void executeQuery(String sql) {
        connection.executeQuery(sql);
    }
    
    public void beginTransaction() {
        connection.beginTransaction();
    }
    
    public void commitTransaction() {
        connection.commitTransaction();
    }
    
    public void rollbackTransaction() {
        connection.rollbackTransaction();
    }
    
    public boolean isConnected() {
        return connection.isConnected();
    }
    
    public void setConnectionTimeout(int timeout) {
        connection.setConnectionTimeout(timeout);
    }
    
    public String getConnectionString() {
        return connection.getConnectionString();
    }
}

// Another middle man example
class FileSystem {
    public String readFile(String path) { 
        return "file content from " + path; 
    }
    
    public void writeFile(String path, String content) {
        System.out.println("Writing to " + path + ": " + content);
    }
    
    public boolean fileExists(String path) { 
        return true; 
    }
    
    public long getFileSize(String path) {
        return 1024;
    }
    
    public void deleteFile(String path) {
        System.out.println("Deleting file: " + path);
    }
}

class FileManager {
    private FileSystem fs;
    
    public FileManager() {
        this.fs = new FileSystem();
    }
    
    // Simple delegations that add no value
    public String read(String path) {
        return fs.readFile(path);
    }
    
    public void write(String path, String content) {
        fs.writeFile(path, content);
    }
    
    public boolean exists(String path) {
        return fs.fileExists(path);
    }
    
    public long size(String path) {
        return fs.getFileSize(path);
    }
    
    public void delete(String path) {
        fs.deleteFile(path);
    }
}

// Yet another example of unnecessary middle man
class Logger {
    public void info(String message) {
        System.out.println("[INFO] " + message);
    }
    
    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
    
    public void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
    
    public void warn(String message) {
        System.out.println("[WARN] " + message);
    }
}

class LoggingService {
    private Logger logger;
    
    public LoggingService() {
        this.logger = new Logger();
    }
    
    // Pure delegation without adding value
    public void logInfo(String message) {
        logger.info(message);
    }
    
    public void logError(String message) {
        logger.error(message);
    }
    
    public void logDebug(String message) {
        logger.debug(message);
    }
    
    public void logWarning(String message) {
        logger.warn(message);
    }
}

// Example showing how middle man can be overused
class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) { return (double) a / b; }
}

class MathService {
    private Calculator calc;
    
    public MathService() {
        this.calc = new Calculator();
    }
    
    // Unnecessary delegation for simple operations
    public int performAddition(int x, int y) {
        return calc.add(x, y);
    }
    
    public int performSubtraction(int x, int y) {
        return calc.subtract(x, y);
    }
    
    public int performMultiplication(int x, int y) {
        return calc.multiply(x, y);
    }
    
    public double performDivision(int x, int y) {
        return calc.divide(x, y);
    }
}
