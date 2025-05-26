double calculateArea(Shape shape) {
    switch (shape.type) {
        case RECTANGLE:
            return shape.width * shape.height;
        case CIRCLE:
            return 3.14159 * shape.radius * shape.radius;
        case TRIANGLE:
            return 0.5 * shape.base * shape.height;
        case SQUARE:
            return shape.side * shape.side;
        default:
            return 0;
    }
}

void draw(Shape shape) {
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
