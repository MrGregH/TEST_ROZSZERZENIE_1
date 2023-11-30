import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(6, rectangle.area(), 0.001);
    }

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(10, rectangle.perimeter(), 0.001);
    }

    @Test
    public void testGetType() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals("rectangle", rectangle.getType());
    }
}
