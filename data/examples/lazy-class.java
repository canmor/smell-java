class Point {
    private int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}

// This class is too simple and may not need to exist separately
class PointPrinter {
    public void print(Point point) {
        System.out.println("(" + point.getX() + ", " + point.getY() + ")");
    }
}

// Another example of a lazy class
class MathConstants {
    public static final double PI = 3.14159;
    public static final double E = 2.71828;
}

// This class is also very simple, maybe direct constants would suffice
class StringValidator {
    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

// Yet another lazy class example
class NumberWrapper {
    private int value;
    
    public NumberWrapper(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

// Simple utility class that might not justify its existence
class ArrayChecker {
    public boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
}

// Class that just delegates to another class
class SimplePrinter {
    public void printMessage(String message) {
        System.out.println(message);
    }
}
