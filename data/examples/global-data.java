import java.util.*;

// Typical example of global data
class GlobalConfig {
    // Global variables - can be accessed and modified from anywhere
    public static String DATABASE_URL = "localhost:3306";
    public static int MAX_CONNECTIONS = 100;
    public static boolean DEBUG_MODE = false;
    public static Map<String, String> CACHE = new HashMap<>();
    public static List<String> ERROR_MESSAGES = new ArrayList<>();
}

// Singleton pattern can also cause global data problems
class UserManager {
    private static UserManager instance;
    public static List<String> currentUsers = new ArrayList<>(); // Global mutable state
    public static int totalLogins = 0;
    
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    
    public void addUser(String username) {
        currentUsers.add(username);
        totalLogins++; // Global state is modified
    }
}

// Classes using global data - the problem is that it can be modified anywhere
class DatabaseService {
    public void connect() {
        // Direct access to global variables
        String url = GlobalConfig.DATABASE_URL;
        int maxConn = GlobalConfig.MAX_CONNECTIONS;
        
        // Modify global state
        GlobalConfig.CACHE.put("last_connection", new Date().toString());
        
        if (GlobalConfig.DEBUG_MODE) {
            System.out.println("Connecting to: " + url);
        }
    }
    
    public void logError(String error) {
        // Global error list is modified
        GlobalConfig.ERROR_MESSAGES.add(error);
    }
}

class UserService {
    public void login(String username) {
        // Modify global data
        UserManager.getInstance().addUser(username);
        
        // Direct modification of global state
        UserManager.totalLogins++;
        UserManager.currentUsers.add(username + "_session");
    }
    
    public void processUser() {
        // Depend on global state
        if (UserManager.totalLogins > 1000) {
            GlobalConfig.DEBUG_MODE = true; // Modify global state here
        }
        
        // Modify global cache
        GlobalConfig.CACHE.put("last_user_count", 
                              String.valueOf(UserManager.currentUsers.size()));
    }
}

// Another class also modifying the same global data
class AdminService {
    public void resetSystem() {
        // Clear global data
        GlobalConfig.CACHE.clear();
        GlobalConfig.ERROR_MESSAGES.clear();
        UserManager.currentUsers.clear();
        UserManager.totalLogins = 0;
        
        // Modify configuration
        GlobalConfig.MAX_CONNECTIONS = 50;
        GlobalConfig.DEBUG_MODE = false;
    }
    
    public void updateConfig(String dbUrl) {
        // Modify global configuration from another place
        GlobalConfig.DATABASE_URL = dbUrl;
        GlobalConfig.CACHE.put("config_updated", "true");
    }
}
