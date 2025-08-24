import java.util.*;
import java.util.function.Consumer;

abstract class AbstractLogStrategy {
    public abstract void log(String message, int level);
    public void initialize() {}
    public void cleanup() {}
    public boolean isEnabled() { return true; }
    public void setFormat(String format) {}
    public String getLastLog() { return ""; }
    public void setThreshold(int threshold) {}
    public Map<String, Object> getMetrics() { return new HashMap<>(); }
}

interface LogFilter {
    boolean shouldLog(String message, int level);
}

interface LogFormatter {
    String format(String message, int level, Date timestamp);
}

class LogManager {
    private List<AbstractLogStrategy> strategies;
    private Map<String, Integer> logLevels;
    private Map<String, Consumer<String>> customHandlers;
    private List<String> logBuffer;
    private boolean enableBuffering;
    private int maxBufferSize;
    private String defaultFormat;
    private List<LogFilter> filters;
    private LogFormatter formatter;
    private boolean enableAsync;
    private int asyncQueueSize;
    private Map<String, Object> configuration;
    
    public LogManager() {
        this.strategies = new ArrayList<>();
        this.logLevels = new HashMap<>();
        this.customHandlers = new HashMap<>();
        this.logBuffer = new ArrayList<>();
        this.enableBuffering = false;
        this.maxBufferSize = 100;
        this.filters = new ArrayList<>();
        this.enableAsync = false;
        this.asyncQueueSize = 1000;
        this.configuration = new HashMap<>();
        
        initializeLogLevels();
        this.defaultFormat = "[%time%] [%level%] %message%";
    }
    
    private void initializeLogLevels() {
        logLevels.put("DEBUG", 0);
        logLevels.put("INFO", 1);
        logLevels.put("WARNING", 2);
        logLevels.put("ERROR", 3);
        logLevels.put("CRITICAL", 4);
    }
    
    public void addStrategy(AbstractLogStrategy strategy) {
        strategies.add(strategy);
    }
    
    public void removeStrategy(AbstractLogStrategy strategy) {
        strategies.remove(strategy);
    }
    
    public void setBuffering(boolean enable, int size) {
        this.enableBuffering = enable;
        this.maxBufferSize = size;
    }
    
    public void addCustomHandler(String name, Consumer<String> handler) {
        customHandlers.put(name, handler);
    }
    
    public void removeCustomHandler(String name) {
        customHandlers.remove(name);
    }
    
    public void addFilter(LogFilter filter) {
        filters.add(filter);
    }
    
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }
    
    public void setAsyncMode(boolean enable, int queueSize) {
        this.enableAsync = enable;
        this.asyncQueueSize = queueSize;
    }
    
    public void setConfiguration(String key, Object value) {
        configuration.put(key, value);
    }
    
    public Object getConfiguration(String key) {
        return configuration.get(key);
    }
    
    public void log(String message, String level) {
        Integer logLevel = logLevels.get(level);
        if (logLevel == null) logLevel = 1;
        
        for (LogFilter filter : filters) {
            if (!filter.shouldLog(message, logLevel)) {
                return;
            }
        }
        
        if (enableBuffering) {
            logBuffer.add(message);
            if (logBuffer.size() > maxBufferSize) {
                logBuffer.remove(0);
            }
        }
        
        for (AbstractLogStrategy strategy : strategies) {
            if (strategy.isEnabled()) {
                strategy.log(message, logLevel);
            }
        }
        
        for (Consumer<String> handler : customHandlers.values()) {
            handler.accept(message);
        }
    }
    
    public void log(String message) {
        log(message, "INFO");
    }
    
    public void flushBuffer() {
        logBuffer.clear();
    }
    
    public List<String> getBufferedLogs() {
        return new ArrayList<>(logBuffer);
    }
    
    public void shutdown() {
        for (AbstractLogStrategy strategy : strategies) {
            strategy.cleanup();
        }
    }
    
    public Map<String, Object> getSystemMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("bufferSize", logBuffer.size());
        metrics.put("strategiesCount", strategies.size());
        metrics.put("handlersCount", customHandlers.size());
        return metrics;
    }
}

// In practice, only this simple console log implementation is used
class ConsoleLogStrategy extends AbstractLogStrategy {
    @Override
    public void log(String message, int level) {
        System.out.println("LOG [Level " + level + "]: " + message);
    }
}

class ClientCode {
    public void demonstrateUsage() {
        LogManager logManager = new LogManager();
        ConsoleLogStrategy consoleLog = new ConsoleLogStrategy();
        logManager.addStrategy(consoleLog);
        
        logManager.log("Application started", "INFO");
        logManager.log("Operation completed", "INFO");
    }
}
