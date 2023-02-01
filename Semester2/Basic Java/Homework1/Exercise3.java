/*
Compute the greatest common divisor of the (positive or negative) integer numbers provided
as command-line arguments! Your program should convert all of its command-line arguments 
into integer numbers, and compute their greatest common divisors.
The command-line arguments and the result should be represented with long values.
This type is a 64-bits signed integer type. To convert a string to this type, use
the Long.parseLong(...) function!
 */
class Exercise3
{
    public static void main(String args[])
    {
        long num1 = Long.parseLong(args[0]); //Integer.parseInt(args[0]);
        long num2 = Long.parseLong(args[1]); //Integer.parseInt(args[1]);
        long gcd=1;
        for(int i=1;i<=num1;i++)
        {
            if((num1%i==0) && (num2%i==0))
            {
                gcd=i;
            }
        }
        System.out.println("Gcd value is " + gcd);
    }
}