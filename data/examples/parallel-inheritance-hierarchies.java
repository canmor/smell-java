// Whenever adding a new Shape, we must also add a corresponding ShapeRenderer

abstract class Shape {
    public abstract String getType();
}

class Circle extends Shape {
    private double radius;
    
    @Override
    public String getType() { 
        return "Circle"; 
    }
    
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
}

class Rectangle extends Shape {
    private double width, height;
    
    @Override
    public String getType() { 
        return "Rectangle"; 
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
}

class Triangle extends Shape {
    private double base, height;
    
    @Override
    public String getType() { 
        return "Triangle"; 
    }
    
    public double getBase() { return base; }
    public double getHeight() { return height; }
    public void setBase(double base) { this.base = base; }
    public void setHeight(double height) { this.height = height; }
}

// Parallel renderer hierarchy
abstract class ShapeRenderer {
    public abstract void render(Shape shape);
}

class CircleRenderer extends ShapeRenderer {
    @Override
    public void render(Shape shape) {
        System.out.println("Rendering circle with SVG");
    }
}

class RectangleRenderer extends ShapeRenderer {
    @Override
    public void render(Shape shape) {
        System.out.println("Rendering rectangle with SVG");
    }
}

class TriangleRenderer extends ShapeRenderer {
    @Override
    public void render(Shape shape) {
        System.out.println("Rendering triangle with SVG");
    }
}

// Another parallel hierarchy for calculations
abstract class ShapeCalculator {
    public abstract double calculateArea(Shape shape);
}

class CircleCalculator extends ShapeCalculator {
    @Override
    public double calculateArea(Shape shape) {
        Circle circle = (Circle) shape;
        return Math.PI * circle.getRadius() * circle.getRadius();
    }
}

class RectangleCalculator extends ShapeCalculator {
    @Override
    public double calculateArea(Shape shape) {
        Rectangle rect = (Rectangle) shape;
        return rect.getWidth() * rect.getHeight();
    }
}

class TriangleCalculator extends ShapeCalculator {
    @Override
    public double calculateArea(Shape shape) {
        Triangle triangle = (Triangle) shape;
        return 0.5 * triangle.getBase() * triangle.getHeight();
    }
}

// Yet another parallel hierarchy for validation
abstract class ShapeValidator {
    public abstract boolean isValid(Shape shape);
}

class CircleValidator extends ShapeValidator {
    @Override
    public boolean isValid(Shape shape) {
        Circle circle = (Circle) shape;
        return circle.getRadius() > 0;
    }
}

class RectangleValidator extends ShapeValidator {
    @Override
    public boolean isValid(Shape shape) {
        Rectangle rect = (Rectangle) shape;
        return rect.getWidth() > 0 && rect.getHeight() > 0;
    }
}

class TriangleValidator extends ShapeValidator {
    @Override
    public boolean isValid(Shape shape) {
        Triangle triangle = (Triangle) shape;
        return triangle.getBase() > 0 && triangle.getHeight() > 0;
    }
}

// Example of the problem: Adding a new shape requires multiple classes
class Pentagon extends Shape {
    private double sideLength;
    
    @Override
    public String getType() { 
        return "Pentagon"; 
    }
    
    public double getSideLength() { return sideLength; }
    public void setSideLength(double sideLength) { this.sideLength = sideLength; }
}

// Now we MUST create corresponding classes in all parallel hierarchies:

class PentagonRenderer extends ShapeRenderer {
    @Override
    public void render(Shape shape) {
        System.out.println("Rendering pentagon with SVG");
    }
}

class PentagonCalculator extends ShapeCalculator {
    @Override
    public double calculateArea(Shape shape) {
        Pentagon pentagon = (Pentagon) shape;
        double side = pentagon.getSideLength();
        return 0.25 * Math.sqrt(25 + 10 * Math.sqrt(5)) * side * side;
    }
}

class PentagonValidator extends ShapeValidator {
    @Override
    public boolean isValid(Shape shape) {
        Pentagon pentagon = (Pentagon) shape;
        return pentagon.getSideLength() > 0;
    }
}

// Demonstration of the problem in usage
class ShapeProcessor {
    public void processShape(Shape shape) {
        // Need to determine which specific renderer/calculator/validator to use
        ShapeRenderer renderer;
        ShapeCalculator calculator;
        ShapeValidator validator;
        
        // This switch statement grows every time we add a new shape!
        switch (shape.getType()) {
            case "Circle":
                renderer = new CircleRenderer();
                calculator = new CircleCalculator();
                validator = new CircleValidator();
                break;
            case "Rectangle":
                renderer = new RectangleRenderer();
                calculator = new RectangleCalculator();
                validator = new RectangleValidator();
                break;
            case "Triangle":
                renderer = new TriangleRenderer();
                calculator = new TriangleCalculator();
                validator = new TriangleValidator();
                break;
            case "Pentagon":
                renderer = new PentagonRenderer();
                calculator = new PentagonCalculator();
                validator = new PentagonValidator();
                break;
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shape.getType());
        }
        
        if (validator.isValid(shape)) {
            renderer.render(shape);
            double area = calculator.calculateArea(shape);
            System.out.println("Area: " + area);
        }
    }
}
