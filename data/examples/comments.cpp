class Calculator {
public:
    // 这个方法计算两个数的和
    int add(int a, int b) {
        // 将第一个数和第二个数相加
        int result = a + b;
        // 返回结果
        return result;
    }
    
    // 这个方法计算圆的面积
    // 参数r是半径
    // 返回值是面积
    double calculateCircleArea(double r) {
        // 使用公式 π * r * r
        double pi = 3.14159; // π的值
        double area = pi * r * r; // 计算面积
        return area; // 返回计算结果
    }
    
    // 这个方法检查数字是否为偶数
    bool isEven(int number) {
        // 如果数字除以2的余数为0，则为偶数
        if (number % 2 == 0) {
            return true; // 返回真
        } else {
            return false; // 返回假
        }
    }
    
    // 计算阶乘
    // 输入：一个正整数n
    // 输出：n的阶乘
    int factorial(int n) {
        // 如果n等于0或1，返回1
        if (n <= 1) {
            return 1;
        }
        // 否则返回n乘以(n-1)的阶乘
        return n * factorial(n - 1);
    }
};
