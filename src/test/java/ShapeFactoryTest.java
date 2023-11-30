import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ShapeFactoryTest {

    @Test
    public void whenCreatingSquareMultipleTimes_ShouldUseCache() {
        Square square1 = ShapeFactory.createSquare(10);
        Square square2 = ShapeFactory.createSquare(10);

        assertSame(square1, square2, "Should return the same Square instance from cache");
    }

    @Test
    public void whenCreatingCircleMultipleTimes_ShouldUseCache() {
        Circle circle1 = ShapeFactory.createCircle(5);
        Circle circle2 = ShapeFactory.createCircle(5);

        assertSame(circle1, circle2, "Should return the same Circle instance from cache");
    }

    @Test
    public void whenCreatingRectangleMultipleTimes_ShouldUseCache() {
        Rectangle rectangle1 = ShapeFactory.createRectangle(4, 5);
        Rectangle rectangle2 = ShapeFactory.createRectangle(4, 5);

        assertSame(rectangle1, rectangle2, "Should return the same Rectangle instance from cache");
    }
}