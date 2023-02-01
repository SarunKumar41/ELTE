/*
Create a program which takes its first command-line argument as an integer number,
and decides whether this number is a perfect number. In number theory, a natural number
is called perfect, if the sum of its positive divisors (excluding the number itself) is
equal to the number. (Or, equivalently, the sum of the positive divisors equals to two 
times the number.) The first four perfect numbers are: 6, 28, 496 and 8128. For example, 6=1+2+3.
 */
class Exercise1
{
    public static void main(String args[])
    {
        int num = Integer.parseInt(args[0]);
        Boolean isPerfect=false;
        
        int divisorSum=0;
        for(int i=(num/2);i>=1;i--)
        {
            if(num%i==0)
            {
                divisorSum+=i;
            }
        }
        if(divisorSum==num || divisorSum==(num*2))
        {
            isPerfect=true;
        }
        if(isPerfect==true)
        {
            System.out.println(num + " is a perfect number ");
        }
        else
        {
           System.out.println(num + " is not a perfect number "); 
        } 
    }
}