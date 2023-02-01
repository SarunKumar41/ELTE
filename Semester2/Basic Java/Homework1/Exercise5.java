/*
Compute an approximation of 2‾√ using the following continued fraction.
 */
class Exercise5
{
    public static double calc(int depth)
    {
        //x[0] = 0
        //x[n+1]=1/(2+x[n]) - recurrence relation
        //x[depth]=0 - termination case
        return (depth==0) ? 0 : (1/(2+(calc(depth-1))));
    }

    public static void main(String args[])
    {
        System.out.printf("Enter the depth : ");
        String line = System.console().readLine();
        int depth = Integer.parseInt(line);
        double result= calc(depth)+1;
        System.out.println(result);
    }
}