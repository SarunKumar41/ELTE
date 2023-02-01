/*
Compute an approximation of 𝑒 using the following continued fraction.
 */
class Exercise6
{
    public static double calc(int n, int depth)
    {
        //x[n]=1+1/(1+1/(2n+x[n+1])) - recurrence relation
        //x[depth+1]=0 - termination case
        return  (depth==n) ? 0 : 1+1/(1+(1/(2*n+calc(n+1, depth)))) ; 
    }
    public static void main(String args[])
    {
        System.out.printf("Enter the depth : ");
        String line = System.console().readLine();
        int depth = Integer.parseInt(line);
        double result= calc(1, depth+1)+1;
        System.out.println(result);
    }
}
