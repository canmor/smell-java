enum ShapeType {
    RECTANGLE, CIRCLE, TRIANGLE, SQUARE
}

class Shape {
    public ShapeType type;
    public double width, height;  // for rectangle
    public double radius;         // for circle
    public double base;          // for triangle
    public double side;          // for square
}

class ShapeProcessor {
    
    public double calculateArea(Shape shape) {
        switch (shape.type) {
            case RECTANGLE:
                return shape.width * shape.height;
            case CIRCLE:
                return Math.PI * shape.radius * shape.radius;
            case TRIANGLE:
                return 0.5 * shape.base * shape.height;
            case SQUARE:
                return shape.side * shape.side;
            default:
                return 0;
        }
    }
    
    public void draw(Shape shape) {
        switch (shape.type) {
            case RECTANGLE:
                drawRectangle(shape);
                break;
            case CIRCLE:
                drawCircle(shape);
                break;
            case TRIANGLE:
                drawTriangle(shape);
                break;
            case SQUARE:
                drawSquare(shape);
                break;
        }
    }
    
    public double calculatePerimeter(Shape shape) {
        switch (shape.type) {
            case RECTANGLE:
                return 2 * (shape.width + shape.height);
            case CIRCLE:
                return 2 * Math.PI * shape.radius;
            case TRIANGLE:
                // Simplified: assuming equilateral triangle
                return 3 * shape.base;
            case SQUARE:
                return 4 * shape.side;
            default:
                return 0;
        }
    }
    
    public String getDescription(Shape shape) {
        switch (shape.type) {
            case RECTANGLE:
                return "Rectangle with width " + shape.width + " and height " + shape.height;
            case CIRCLE:
                return "Circle with radius " + shape.radius;
            case TRIANGLE:
                return "Triangle with base " + shape.base + " and height " + shape.height;
            case SQUARE:
                return "Square with side " + shape.side;
            default:
                return "Unknown shape";
        }
    }
    
    private void drawRectangle(Shape shape) {
        System.out.println("Drawing rectangle: " + shape.width + "x" + shape.height);
    }
    
    private void drawCircle(Shape shape) {
        System.out.println("Drawing circle with radius: " + shape.radius);
    }
    
    private void drawTriangle(Shape shape) {
        System.out.println("Drawing triangle with base: " + shape.base);
    }
    
    private void drawSquare(Shape shape) {
        System.out.println("Drawing square with side: " + shape.side);
    }
}
