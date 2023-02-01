import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CaesarTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]
        {     
                 { 1, "cde","bcd" } ,{25, "wxy", "xyz" }, { -1,"The size of n should be greater than 0 and lesser than 26","abc" }
        });
    }

    private int CInput;
    private String CsInput;
    private String CExpected;

    public CaesarTest(int input, String expected, String csInput ) {
        this.CInput = input;
        this.CExpected = expected;
        this.CsInput = csInput;
    }

    @Test
    public void testCipher() {
        assertEquals(CExpected, Caesar.cipher(CsInput,CInput));
    }

    public void testdecipher()
    {
        assertEquals(CExpected, Caesar.decipher(CsInput,CInput));
    }
}
