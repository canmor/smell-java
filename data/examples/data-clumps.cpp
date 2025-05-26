class Rectangle {
private:
    int startX, startY;
    int endX, endY;
public:
    void draw(int startX, int startY, int endX, int endY);
};

class Circle {
private:
    int centerX, centerY;
    int radius;
public:
    void draw(int centerX, int centerY, int radius);
};

class Line {
private:
    int startX, startY;
    int endX, endY;
public:
    void draw(int startX, int startY, int endX, int endY);
};
