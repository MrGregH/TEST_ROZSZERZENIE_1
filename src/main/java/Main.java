import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Square square = ShapeFactory.createSquare(5.0);
        Circle circle = ShapeFactory.createCircle(5.0);
        Rectangle rectangle = ShapeFactory.createRectangle(10.0, 5.0);
        Square square1 = ShapeFactory.createSquare(5.0);

        System.out.println(square == square1);

        ShapeService shapeService = new ShapeService();
        List<Shape> shapes = Arrays.asList(square, rectangle, circle);

        Shape largestAreaShape = shapeService.findShapeWithLargestArea(shapes);
        System.out.println("Figure with the largest area: " + largestAreaShape.getClass().getSimpleName());

        Shape largestPerimeterCircle = shapeService.findShapeWithLargestPerimeter(shapes, Circle.class);
        System.out.println("Circle with the largest circumference: " + largestPerimeterCircle.getClass().getSimpleName());



        String jsonPath = "src/main/resources/shapes.json";
        shapeService.exportShapesToJson(shapes, jsonPath);


        List<Shape> importedShapes = shapeService.importShapesFromJson(jsonPath);
        importedShapes.forEach(shape -> System.out.println(shape.getClass().getSimpleName()));
    }
}
