class Rectangle {
    private int startX, startY;
    private int endX, endY;
    
    public void draw(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    
    public int getArea() {
        return Math.abs((endX - startX) * (endY - startY));
    }
}

class Circle {
    private int centerX, centerY;
    private int radius;
    
    public void draw(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Line {
    private int startX, startY;
    private int endX, endY;
    
    public void draw(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    
    public double getLength() {
        return Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }
}
