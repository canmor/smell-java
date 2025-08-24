// Shape inheritance hierarchy
abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

abstract class ShapeRenderer {
    public abstract void render();
}

class CircleRenderer extends ShapeRenderer {
    @Override
    public void render() {
        System.out.println("Rendering Circle with advanced graphics");
        // Circle-specific rendering code
    }
}

class SquareRenderer extends ShapeRenderer {
    @Override
    public void render() {
        System.out.println("Rendering Square with advanced graphics");
        // Square-specific rendering code
    }
}

class TriangleRenderer extends ShapeRenderer {
    @Override
    public void render() {
        System.out.println("Rendering Triangle with advanced graphics");
        // Triangle-specific rendering code
    }
}

// Shape factory for creating shapes and corresponding renderers
abstract class ShapeFactory {
    public abstract Shape createShape();
    public abstract ShapeRenderer createRenderer();
}

class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
    
    @Override
    public ShapeRenderer createRenderer() {
        return new CircleRenderer();
    }
}

class SquareFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
    
    @Override
    public ShapeRenderer createRenderer() {
        return new SquareRenderer();
    }
}

class TriangleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
    
    @Override
    public ShapeRenderer createRenderer() {
        return new TriangleRenderer();
    }
}

class ClientCode {
    public void demonstrateParallelHierarchies() {
        CircleFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        ShapeRenderer circleRenderer = circleFactory.createRenderer();
        
        circle.draw();
        circleRenderer.render();
        
        SquareFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        ShapeRenderer squareRenderer = squareFactory.createRenderer();
        
        square.draw();
        squareRenderer.render();
    }
}
