import java.util.*;

class SystemConfig {
    public static String databaseUrl = "localhost:5432";
    public static int connectionTimeout = 30;
    public static boolean isDebugEnabled = false;
    public static Map<String, Object> cache = new HashMap<>();
    public static List<String> errorLog = new ArrayList<>();
}

class UserService {
    public void authenticate(String username, String password) {
        if (SystemConfig.isDebugEnabled) {
            System.out.println("Authenticating user: " + username);
        }
        
        SystemConfig.cache.put("last_login", username);
        SystemConfig.cache.put("login_time", new Date().toString());
    }
    
    public void logError(String message) {
        SystemConfig.errorLog.add("UserService: " + message);
    }
}

class DatabaseManager {
    public void connect() {
        String url = SystemConfig.databaseUrl;
        int timeout = SystemConfig.connectionTimeout;
        
        SystemConfig.connectionTimeout = 60;
        SystemConfig.cache.put("db_status", "connected");
        
        if (SystemConfig.isDebugEnabled) {
            SystemConfig.errorLog.add("Database connected to: " + url);
        }
    }
}

class Logger {
    public void enableDebug() {
        SystemConfig.isDebugEnabled = true;
        SystemConfig.cache.put("debug_enabled_at", System.currentTimeMillis());
    }
    
    public void clearLogs() {
        SystemConfig.errorLog.clear();
        SystemConfig.cache.remove("last_login");
    }
}
