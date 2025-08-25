import java.util.*;

// Example of problematic mutable data
class UserAccount {
    public String name;
    public double balance;
    public List<String> permissions;
    public Map<String, Object> metadata;
    
    public UserAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.permissions = new ArrayList<>();
        this.metadata = new HashMap<>();
    }
}

// Shared mutable state causing problems
class AccountManager {
    private static List<UserAccount> accounts = new ArrayList<>();
    private static Map<String, UserAccount> accountCache = new HashMap<>();
    
    public static void addAccount(UserAccount account) {
        accounts.add(account);
        accountCache.put(account.name, account);
    }
    
    public static UserAccount getAccount(String name) {
        return accountCache.get(name); // Returns mutable reference
    }
    
    public static List<UserAccount> getAllAccounts() {
        return accounts; // Direct access to mutable list
    }
}

// Multiple classes modifying the same mutable data
class PaymentService {
    public void processPayment(String accountName, double amount) {
        UserAccount account = AccountManager.getAccount(accountName);
        if (account != null) {
            // Direct modification of shared mutable data
            account.balance -= amount;
            account.metadata.put("lastPayment", amount);
            account.metadata.put("lastPaymentTime", new Date());
        }
    }
    
    public void addBonus(String accountName, double bonus) {
        UserAccount account = AccountManager.getAccount(accountName);
        if (account != null) {
            account.balance += bonus; // Another place modifying balance
            account.metadata.put("bonusReceived", true);
        }
    }
}

class SecurityService {
    public void grantPermission(String accountName, String permission) {
        UserAccount account = AccountManager.getAccount(accountName);
        if (account != null) {
            // Modifying shared mutable list
            account.permissions.add(permission);
            account.metadata.put("permissionGrantedAt", System.currentTimeMillis());
        }
    }
    
    public void revokeAllPermissions(String accountName) {
        UserAccount account = AccountManager.getAccount(accountName);
        if (account != null) {
            account.permissions.clear(); // Clearing shared data
            account.metadata.remove("permissionGrantedAt");
        }
    }
}

// Problematic derived data that could be calculated
class ReportService {
    private double totalBalance = 0.0; // Derived data stored as mutable state
    private int activeUserCount = 0;
    
    public void updateTotals() {
        // Manually updating derived values
        totalBalance = 0.0;
        activeUserCount = 0;
        
        for (UserAccount account : AccountManager.getAllAccounts()) {
            totalBalance += account.balance;
            if (!account.permissions.isEmpty()) {
                activeUserCount++;
            }
        }
    }
    
    public double getTotalBalance() {
        return totalBalance; // Could be calculated instead of stored
    }
    
    public int getActiveUserCount() {
        return activeUserCount; // Could be calculated instead of stored
    }
}

// Variable used for different purposes (violates single responsibility)
class DataProcessor {
    public void processUserData(List<UserAccount> accounts) {
        String temp = ""; // Variable reused for different purposes
        
        // First usage: building user names
        for (UserAccount account : accounts) {
            temp += account.name + ",";
        }
        System.out.println("Users: " + temp);
        
        // Second usage: building permission list (dangerous reuse)
        temp = "";
        for (UserAccount account : accounts) {
            for (String permission : account.permissions) {
                temp += permission + ";";
            }
        }
        System.out.println("Permissions: " + temp);
        
        // Third usage: completely different purpose
        temp = String.valueOf(accounts.size());
        System.out.println("Count: " + temp);
    }
}
