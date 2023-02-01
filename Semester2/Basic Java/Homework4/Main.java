
import utils.DoubleVector;

class Main
{
    public static void main (String[] args)
    {
        double[] array1 = {1,2,4};
        double[] array2 = {3,4,6};
        DoubleVector a = new DoubleVector(array1);
        DoubleVector b = new DoubleVector(array2);

        DoubleVector product = new DoubleVector();
        product = b.prod(4);
        double sCproduct;
        sCproduct = a.scalarProd(b);
        DoubleVector sum = new DoubleVector();
        sum = a.sumV(b);
        DoubleVector diff = new DoubleVector();
        diff = a.difV(b);

        System.out.println("\nThe Scalar product is "+sCproduct);
        System.out.println("\nThe Sum is "+sum.toString());
        System.out.println("\nThe Difference is "+diff.toString());
        System.out.println("\nThe product of a vector with a scalar is "+product.toString()+"\n");
    }
}