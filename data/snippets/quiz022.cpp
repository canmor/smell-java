// 形状继承体系
class Shape {
public:
    virtual void draw() = 0;
    virtual ~Shape() = default;
};

class Circle : public Shape {
public:
    void draw() override {
        std::cout << "Drawing Circle" << std::endl;
    }
};

class Square : public Shape {
public:
    void draw() override {
        std::cout << "Drawing Square" << std::endl;
    }
};

class Triangle : public Shape {
public:
    void draw() override {
        std::cout << "Drawing Triangle" << std::endl;
    }
};

// 形状渲染器继承体系 - 平行于形状继承体系
class ShapeRenderer {
public:
    virtual void render() = 0;
    virtual ~ShapeRenderer() = default;
};

class CircleRenderer : public ShapeRenderer {
public:
    void render() override {
        std::cout << "Rendering Circle" << std::endl;
        // 渲染圆形的特定代码
    }
};

class SquareRenderer : public ShapeRenderer {
public:
    void render() override {
        std::cout << "Rendering Square" << std::endl;
        // 渲染正方形的特定代码
    }
};

class TriangleRenderer : public ShapeRenderer {
public:
    void render() override {
        std::cout << "Rendering Triangle" << std::endl;
        // 渲染三角形的特定代码
    }
};

// 形状工厂，用于创建形状和对应的渲染器
class ShapeFactory {
public:
    virtual Shape* createShape() = 0;
    virtual ShapeRenderer* createRenderer() = 0;
    virtual ~ShapeFactory() = default;
};

class CircleFactory : public ShapeFactory {
public:
    Shape* createShape() override {
        return new Circle();
    }
    
    ShapeRenderer* createRenderer() override {
        return new CircleRenderer();
    }
};

class SquareFactory : public ShapeFactory {
public:
    Shape* createShape() override {
        return new Square();
    }
    
    ShapeRenderer* createRenderer() override {
        return new SquareRenderer();
    }
};

class TriangleFactory : public ShapeFactory {
public:
    Shape* createShape() override {
        return new Triangle();
    }
    
    ShapeRenderer* createRenderer() override {
        return new TriangleRenderer();
    }
};

// 客户端代码
void clientCode() {
    // 每次添加新的形状，都需要添加对应的渲染器和工厂
    CircleFactory circleFactory;
    Shape* circle = circleFactory.createShape();
    ShapeRenderer* circleRenderer = circleFactory.createRenderer();
    
    circle->draw();
    circleRenderer->render();
    
    delete circle;
    delete circleRenderer;
}
