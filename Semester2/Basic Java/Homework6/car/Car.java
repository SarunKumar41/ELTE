package car;

import car.utils.Color;

public class Car 
{
    private String rc;
    private Color col;
    private int maxSpeed;
    private int counter=0;

    public Car(String r,Color c,int max)
    {  
        rc=r;
        col=c;
        maxSpeed=max;
        counter++;
    }
    public Car()
    {
        rc="AAA-000";
        col=Color.BLUE;
        maxSpeed=120;
        counter++;
    }
    public static Boolean compare(Car a,Car b)
    {
        return a.maxSpeed>b.maxSpeed;
    }
    public String toString()
    {
        return (rc + " " +col+ " " +maxSpeed); 
    } 
}
