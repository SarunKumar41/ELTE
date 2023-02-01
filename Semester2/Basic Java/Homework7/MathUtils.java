/*
Create a class MathUtils containing a static method Increment(),
which increases an integer number by one in a safe way: it only increases its parameter
if it is not the largest representable int value. The result of the computation should
be returned by this method.
Test the Increment() method with white-box testing.
*/

import org.junit.Test; //javac -cp junit-4.12.jar Power.java
import static org.junit.Assert.assertEquals; //java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Power
public class MathUtils
{
    public MathUtils(){}
    @Test

    public void testIncrement()
    {
        assertEquals("Increment not working",13,Increment(12),0.0);
        assertEquals("Increment not working",1000,Increment(999),0.0);
        assertEquals("Increment not working",1,Increment(0),0.0);
        assertEquals("Increment not working",-250,Increment(-251),0.0);
        assertEquals("Increment not working",Integer.MAX_VALUE,Increment(Integer.MAX_VALUE),0.0);
        assertEquals("Increment not working",Integer.MIN_VALUE+1,Increment(Integer.MIN_VALUE),0.0);
    }
    
    public static int Increment(int input)
    {
        if(input < Integer.MAX_VALUE)
        {
            input++;
        }
        //else throw new IllegalArgumentException("Input not suitable for increment ");
        return input;
    }

    /*
    public static void main(String args[])
    {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Increment(12));
    }
    */
    
}