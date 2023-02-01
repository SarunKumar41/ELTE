/*
Change the previous program in such a way that it computes how many perfect numbers
are in the range between 1 and the number given as the first command-line argument!
 */
class Exercise2
{
    public static void main(String args[])
    {
        int num = Integer.parseInt(args[0]);
        int count=0;
        int divisorSum=0;
        for(int j=2;j<=num;j++)
        {
            for(int i=(j/2);i>=1;i--)
            {
                if(j%i==0)
                {
                    divisorSum+=i;
                }
            }
            if(divisorSum==j || divisorSum==(j*2))
            {
                count++;
            }
            divisorSum=0;
        }
        System.out.println("There are " + count +  " perfect numbers in the range ");
 
    }
}