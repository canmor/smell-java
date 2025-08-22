class Calculator {
    // This method calculates the sum of two numbers
    public int add(int a, int b) {
        // Add the first number and the second number
        int result = a + b;
        // Return the result
        return result;
    }
    
    // This method calculates the area of a circle
    // Parameter r is the radius
    // Return value is the area
    public double calculateCircleArea(double r) {
        // Use the formula π * r * r
        double pi = 3.14159; // Value of π
        double area = pi * r * r; // Calculate area
        return area; // Return the calculation result
    }
    
    // This method checks if a number is even
    public boolean isEven(int number) {
        // If the remainder of number divided by 2 is 0, then it's even
        if (number % 2 == 0) {
            return true; // Return true
        } else {
            return false; // Return false
        }
    }
    
    // Calculate factorial
    // Input: a positive integer n
    // Output: factorial of n
    public int factorial(int n) {
        // If n equals 0 or 1, return 1
        if (n <= 1) {
            return 1;
        }
        // Otherwise return n multiplied by factorial of (n-1)
        return n * factorial(n - 1);
    }
}
