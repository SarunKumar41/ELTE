package utils;
public class DoubleVector
{
    private double x,y,z;

    public DoubleVector()
    {
    }

    public DoubleVector(double[] arr)
    {
        x = arr[0];
        y = arr[1];
        z = arr[2];
    }

    public double scalarProd(DoubleVector b)
    {
        return ((x*b.x)+(y*b.y)+(z*b.z));
    }

    public DoubleVector sumV(DoubleVector b)
    {
        double array[] = {x+b.x,y+b.y,z+b.z};
        return new DoubleVector(array);
    }

    public DoubleVector difV(DoubleVector b)
    {
        double array[] = {x-b.x,y-b.y,z-b.z};
        return new DoubleVector(array);
    }
    public DoubleVector prod(double value)
    {
        double array[] = {x*value,y*value,z*value};
        return new DoubleVector(array);
    }

    public String toString()
    {
        return ("<"+x+","+y+","+z+">");
    }

}
/*
[Yesterday 16:15] Morse
    The last task commands needed are (you can do the same with specifying a manifest e.g. Manifest.MF with Main-Class: mass.PointMain only inside it but you must put a newline at the end of the file or it will not work!):

%JAVAPATH%\jar.exe --create --file mass-deploy.jar --main-class mass.PointMain mass/util/Point.class mass/PointMain.class
%JAVAPATH%\jar.exe --create --file mass-deploy.jar --manifest=Manifest.MF mass/util/Point.class mass/PointMain.class
REM %JAVAPATH%\java.exe mass.PointMain
%JAVAPATH%\java.exe -jar mass-deploy.jar
*/