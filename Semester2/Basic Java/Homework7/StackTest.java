import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//javac -cp junit-4.12.jar StackTest.java Stack.java 
// java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore StackTest 
public class StackTest 
{
    @Test
    public void push_pop() 
    {
        Stack a = new Stack(3);
        a.push(1);
        a.push(3);

        assertEquals(3, a.pop());
        assertEquals(1, a.pop());
    }

    @Test
    public void empty() 
    {
        Stack a = new Stack(3);
        assertTrue(a.isEmpty());
    }
    @Test
    public void not_empty() 
    {
        Stack a = new Stack(3);
        a.push(2);

        assertFalse(a.isEmpty());
    }
    @Test(expected = NoSuchElementException.class)
    public void exceptionCheck()
    {
        Stack a = new Stack(4);

        a.pop();
    }
    @Test
    public void size() 
    {
        Stack a = new Stack(3);
        a.push(2);
        Stack b = new Stack(2);


        assertEquals(1, a.size());
        assertEquals(0, b.size());
    }
    @Test
    public void pop_empty() 
    {
        Stack a = new Stack(3);
        a.push(2);
        a.pop();
        assertTrue(a.isEmpty());
    }
}
