import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {

    @Test
    public void testArea() {
        Circle circle = new Circle(2);
        assertEquals(Math.PI * 4, circle.area(), 0.001);
    }

    @Test
    public void testPerimeter() {
        Circle circle = new Circle(2);
        assertEquals(2 * Math.PI * 2, circle.perimeter(), 0.001);
    }

    @Test
    public void testGetType() {
        Circle circle = new Circle(2);
        assertEquals("circle", circle.getType());
    }
}

