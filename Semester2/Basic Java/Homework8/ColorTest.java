import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ColorTest
{
    @Test
    public void Color_Point() {
        ColoredPoint p1 = new ColoredPoint(2, 4, Color.RED);
        ColoredPoint p2 = new ColoredPoint(3, 7, Color.BLUE);

        assertTrue(p1.getColor()==Color.RED);
        assertTrue(p2.getColor()==Color.BLUE);
        assertFalse(p1.getColor()==p2.getColor());
    }
    
    @Test
    public void Color_Circle() {
        ColoredCircle c1 = new ColoredCircle(2, 4, 5, Color.RED);
        ColoredCircle c2 = new ColoredCircle(3, 7, 9, Color.BLUE);

        assertTrue(c1.getColor()==Color.RED);
        assertTrue(c2.getColor()==Color.BLUE);
        assertFalse(c1.getColor()==c2.getColor());
    }
}