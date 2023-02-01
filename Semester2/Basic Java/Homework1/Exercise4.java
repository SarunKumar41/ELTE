/*
Write a program which computes the square root of a number using the Babylonian-method.
Given a number 𝑆, its square root can be approximated by the sequence 𝑥𝑛 defined below.
Your program should input the real number 𝑆 and another real number 𝜖. The latter will 
describe the expected precision of the approximation. Use the double precision floating
point type double to store numbers!

Compute the first few elements of the 𝑥𝑛 sequence, until the difference between two 
consecutive elements is smaller then 𝜖.
𝑥0=𝑆2
𝑥𝑛+1=12(𝑥𝑛+𝑆𝑥𝑛)
To convert a string to the double type, the function Double.parseDouble(...) can be used.
 */
class Exercise4
{
    public static double squareroot(double num, double S, double e)
    {
        double x =  (S+(num/S))/2;
       // double y = 1/2 * (x+(num/x));
        return ((S-x) < e) ? x : squareroot(num, x, e); 
    } 
    public static void main (String args[])
    {
        System.out.printf("Enter the number : ");
        String line = System.console().readLine();
        double num = Double.parseDouble(line);
        System.out.printf("Enter the value of ∈ : ");
        line = System.console().readLine();
        double e = Double.parseDouble(line);
        double answer = squareroot(num, num/2, e);
        System.out.println("Approximate square root value of  " + num + " is "+ answer);
    }

}