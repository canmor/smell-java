class Point {
private:
    int x, y;
    
public:
    Point(int x, int y) : x(x), y(y) {}
    
    int getX() const { return x; }
    int getY() const { return y; }
    void setX(int x) { this->x = x; }
    void setY(int y) { this->y = y; }
};

// 这个类太简单了，可能不需要单独存在
class PointPrinter {
public:
    void print(const Point& point) {
        std::cout << "(" << point.getX() << ", " << point.getY() << ")" << std::endl;
    }
};

// 另一个懒惰类的例子
class MathConstants {
public:
    static const double PI;
};

const double MathConstants::PI = 3.14159;

// 这个类也很简单，可能直接用常量就够了
class StringValidator {
public:
    bool isEmpty(const std::string& str) {
        return str.empty();
    }
};
