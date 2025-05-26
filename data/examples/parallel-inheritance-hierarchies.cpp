// 每当添加新的Shape时，也需要添加对应的ShapeRenderer

class Shape {
public:
    virtual ~Shape() = default;
    virtual std::string getType() const = 0;
};

class Circle : public Shape {
public:
    std::string getType() const override { return "Circle"; }
    double radius;
};

class Rectangle : public Shape {
public:
    std::string getType() const override { return "Rectangle"; }
    double width, height;
};

class Triangle : public Shape {
public:
    std::string getType() const override { return "Triangle"; }
    double base, height;
};

// 平行的渲染器层次结构
class ShapeRenderer {
public:
    virtual void render(Shape* shape) = 0;
    virtual ~ShapeRenderer() = default;
};

class CircleRenderer : public ShapeRenderer {
public:
    void render(Shape* shape) override {
        std::cout << "Rendering circle" << std::endl;
    }
};

class RectangleRenderer : public ShapeRenderer {
public:
    void render(Shape* shape) override {
        std::cout << "Rendering rectangle" << std::endl;
    }
};

class TriangleRenderer : public ShapeRenderer {
public:
    void render(Shape* shape) override {
        std::cout << "Rendering triangle" << std::endl;
    }
};

// 每次添加新形状都需要添加对应的渲染器
