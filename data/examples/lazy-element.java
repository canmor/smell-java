// Lazy class - only one meaningful method
class Logger {
    public void log(String message) {
        System.out.println(message); // Only one line of meaningful code
    }
}

// Lazy function - name is the same as implementation
class MathUtils {
    public static int add(int a, int b) {
        return a + b; // Function name says exactly what the code does
    }
    
    public static boolean isPositive(int number) {
        return number > 0; // Obvious implementation
    }
}

// Simplified class after refactoring - now too simple
class Logger {
    public void log(String message) {
        System.out.println(message); // Only one line of meaningful code
    }
}

// Lazy utility class with obvious methods
class StringHelper {
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty(); // Could be inlined
    }
    
    public static String toUpperCase(String str) {
        return str.toUpperCase(); // No additional logic
    }
}

// Service class with only one method
class PasswordHasher {
    public String hash(String password) {
        return "hashed_" + password; // Simplified implementation
    }
    // Single responsibility, but maybe too simple to warrant a separate class
}