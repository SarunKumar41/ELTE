/*Create the method conjugate() in class Complex, which turns a complex number to its conjugate.
Create the method reciprocate() as well, which turns the complex number to its reciprocal.
Implement the div(c) method, which divides the complex number with the other complex number c provided as parameter. */

class Complex
{
    double real, imaginary;
    public Complex(double re, double im)
    {
        real = re;
        imaginary = im;
    }
    public void conjugate()
    {
        imaginary= -1*imaginary;
    }
    public void reciprocal()
    {
        double deno = (real*real) + (imaginary*imaginary);
        real = real/deno;
        imaginary = imaginary/deno;
       // return new Complex (real/deno, imaginary/deno); 
    }
    // a + bi/c+ di = (a+bi)(c-di)/(c+di)(c-di) = (ac+bd)+(bc-ad)i/(c*c)+(d*d) = ((ac+bd)/(c*c)+(d*d))+((bc-ad)i/(c*c)+(d*d))
    public Complex div(Complex c)
    {
        double numReal = (real*c.real+imaginary*c.imaginary); double numImag = (imaginary*c.real-real*c.imaginary);
        double denoReal = (c.real*c.real)+(c.imaginary*c.imaginary); double denoImag =(c.real*c.real)+(c.imaginary*c.imaginary);
        return new Complex(numReal/denoReal,numImag/denoImag );
    }

    public static void main(String args[])
    {
        Complex c1 = new Complex(3,-4);
        Complex c2 = new Complex(3,-2);
        Complex c3 = new Complex(8,-2);
        System.out.println("c1 =" + c1.real + " + (" + c1.imaginary + ")i " );
        c1.conjugate();
        System.out.println("c1 =" + c1.real + " + (" + c1.imaginary + ")i " );
        System.out.println("c2 =" + c2.real + " + (" + c2.imaginary + ")i " );
        c2.reciprocal();
        System.out.println("c2 =" + c2.real + " + (" + c2.imaginary + ")i " );
        Complex result = c1.div(c3);
        System.out.println("Division result =" + result.real + "+" + result.imaginary + "i");
    }
}