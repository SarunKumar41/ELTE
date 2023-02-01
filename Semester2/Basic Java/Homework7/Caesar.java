/*
Implement Caesar-chipher (Links to an external site.) for the English alphabet. Create a Caesar class in the following way.

The shift value is passed as parameter (n) to the constructor and is stored;
if n is not between 1 and 25, the constructor should throw IllegalArgumentException
the class should have a cipher() method, which encodes an English text with shifting by n;
this operation throws an exception if it detects a character not in the English alphabet;
The class should have a decipher() method as well (this method need not check for invalid characters).
Test your solution in a data-driven manner, by providing (at least 5) pairs of plaintext and ciphertext.
Use Parameterized tests (Links to an external site.) of JUnit.
Try to use the testing library Hamcrest (Links to an external site.) for assertions instead of 
the more basic JUnit assert* operations!

Extend the set of parameters with the shift value (n), and perform the tests for at least three different values of n.

Prepare negative test cases as well, which check whether illegal parameters are handled properly (by throwing exceptions).
*/

public class Caesar
{
    int n;
    public Caesar (int n)
    {
        if(n<1 || n>25) throw new IllegalArgumentException("The size of n should be greater than 0 and lesser than 26");    
        this.n=n;    
    }

    public static String cipher(String any, int n)
    {
        if(n<1 || n>25) throw new IllegalArgumentException("The size of n should be greater than 0 and lesser than 26");    
        String str="";
        char ciph[] = any.toCharArray();
        for(int i=0;i<ciph.length;i++)
        {
            if((ciph[i]>=65 && ciph[i] <=90) || (ciph[i]>=97 && ciph[i]<=122))
            {
                int cha = ciph[i]+n;
                if(ciph[i] <=90 && cha >90)
                {
                    cha=cha-26;
                }
                if(ciph[i]>=97 && cha >122)
                {
                    cha=cha-26;
                }
                ciph[i]=(char)cha;
                //System.out.println(cha);
                //System.out.println(ciph);
            }
            else throw new IllegalArgumentException("It needs to be letter");  

            str = String.valueOf(ciph);  
            
        }
        return str;
        //System.out.println(ciph);
    }
    public static String decipher(String any, int n)
    {
        String str="";
        char ciph[] = any.toCharArray();
        for(int i=0;i<ciph.length;i++)
        {
            int cha = ciph[i]-n;
            if(ciph[i] <=90 && cha <65)
            {
                cha=cha+26;
            }
            if(ciph[i]>=97 && cha <97)
            {
                cha=cha+26;
            }
            ciph[i]=(char)cha;
            //System.out.println(cha);
            //System.out.println(ciph);

            str = String.valueOf(ciph);  
            
        }
        return str;
        //System.out.println(ciph);
    }
    /*
    public static void main(String args[])
    {
        Caesar c = new Caesar(25);
        System.out.println(c.cipher("abcdefghijklmnopqrstuvwxyz",c.n));
        System.out.println(c.decipher("zabcdefghijklmnopqrstuvwxy",c.n));
    }
    */
}