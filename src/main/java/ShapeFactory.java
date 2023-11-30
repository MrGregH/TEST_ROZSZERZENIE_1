import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeFactory {
    private static final Map<String, Shape> shapesCache = new ConcurrentHashMap<>();

    private ShapeFactory() {
    }

    public static Square createSquare(double side) throws IllegalArgumentException {
        if (side <= 0) {
            throw new IllegalArgumentException("The length of the side of the square must be greater than 0");
        }
        String key = "Square" + side;
        return (Square) shapesCache.computeIfAbsent(key, k -> new Square(side));
    }

    public static Circle createCircle(double radius) throws IllegalArgumentException {
        if (radius <= 0) {
            throw new IllegalArgumentException("The radius of the circle must be greater than 0");
        }
        String key = "Circle" + radius;
        return (Circle) shapesCache.computeIfAbsent(key, k -> new Circle(radius));
    }

    public static Rectangle createRectangle(double width, double height) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("The width and height of the rectangle must be greater than 0");
        }
        String key = "Rectangle" + width + "-" + height;
        return (Rectangle) shapesCache.computeIfAbsent(key, k -> new Rectangle(width, height));
    }
}
