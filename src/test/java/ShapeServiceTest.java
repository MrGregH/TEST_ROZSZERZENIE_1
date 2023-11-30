import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class ShapeServiceTest {
    private static final String TEMPORARY_PATH = "src/test/temporary.json";
    private ShapeService shapeService;
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    @AfterAll
    public static void afterAll() {
        new File(TEMPORARY_PATH).delete();
    }

    @BeforeEach
    public void setUp() {
        shapeService = new ShapeService();
        circle = new Circle(2);
        rectangle = new Rectangle(2, 3);
        square = new Square(4);
    }

    @Test
    public void shouldFindShapeWithLargestArea() {
        List<Shape> shapes = Arrays.asList(circle, rectangle, square);
        Shape largestShape = shapeService.findShapeWithLargestArea(shapes);
        assertEquals(square, largestShape);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenShapeListIsNull() {
        assertThrows(IllegalArgumentException.class, () -> shapeService.findShapeWithLargestArea(null));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForEmptyList() {
        assertThrows(NoSuchElementException.class, () -> shapeService.findShapeWithLargestArea(Collections.emptyList()));
    }

    @Test
    public void shouldFindShapeWithLargestPerimeter() {
        List<Shape> shapes = Arrays.asList(circle, rectangle, square);
        Shape largestPerimeterShape = shapeService.findShapeWithLargestPerimeter(shapes, Rectangle.class);
        assertEquals(rectangle, largestPerimeterShape);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullArgumentsInLargestPerimeter() {
        assertThrows(IllegalArgumentException.class, () -> shapeService.findShapeWithLargestPerimeter(null, null));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForNoMatchingTypeInLargestPerimeter() {
        List<Shape> shapes = Arrays.asList(circle, square);
        assertThrows(NoSuchElementException.class, () -> shapeService.findShapeWithLargestPerimeter(shapes, Rectangle.class));
    }

    @Test
    public void shouldWriteShapesToJson() {
        List<Shape> shapes = Arrays.asList(circle, square, rectangle);
        shapeService.exportShapesToJson(shapes, TEMPORARY_PATH);
        var file = new File(TEMPORARY_PATH);

        List<Shape> importedShapes = shapeService.importShapesFromJson(TEMPORARY_PATH);

        assertTrue(file.exists(), "File should be created");
        assertEquals(shapes.size(), importedShapes.size(), "Shapes size should be equal as in file");
    }
}
