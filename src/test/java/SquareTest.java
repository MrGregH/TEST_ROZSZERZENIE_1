import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {
    @Test
    public void testArea() {
        Square square = new Square(4);
        assertEquals(16, square.area(), 0.001);
    }

    @Test
    public void testPerimeter() {
        Square square = new Square(4);
        assertEquals(16, square.perimeter(), 0.001);
    }

    @Test
    public void testGetType() {
        Square square = new Square(4);
        assertEquals("square", square.getType());
    }
}
