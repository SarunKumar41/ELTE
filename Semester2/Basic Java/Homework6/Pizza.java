/*
Create a Pizza class where every field is private and final .
It has a total of four fields: one for its diameter ( double ), one for the toppings ( String[] ),
one for the time it needs to be baked ( Time ) and another one for the delivery time ( Time ).
Create a constructor which can calculate the baking time based on the diameter and the toppings by the following formula:
For every topping the sum of: - length of the topping multiplied by the diameter of the pizza (one second for each character
in the topping and one second for each centimeter).
Example: A 32cm pizza with "cheese" toppings: 32*6 = 192 , which should be rounded upwards to 4 minutes.
Constructor should throw an exception if a paramater is not valid. TypeNoePresentException should be thrown if the topping
is not one of these: beef, cheese, corn, fish, ham, mushroom, salami, tomato . The TypeNotPresentException is a checked
exception that should be handled by the caller. Use the throws keyword for this.
*/
public class Pizza
{
    private final double diameter;
    private final String toppings[];
    private final Time bake;
    private final Time delivery;

    public Pizza(double diameter, String[] toppings, Time delivery)
    {
        this.diameter=diameter;
        this.toppings=toppings;
        double sum =0;
        for(int i=0;i<toppings.length;i++)
        {
            if(toppings[i]=="beef" || toppings[i]=="cheese" || toppings[i]=="corn" || toppings[i]=="fish" || toppings[i]=="ham" || toppings[i]=="mushroom" || toppings[i]=="salammi" || toppings[i]=="tomato")
            {
                sum+= diameter*(toppings[i].length());
            }
            else
            throw new TypeNotPresentException(null, null);
            
        }
        int hour,min,sec;
        if( sum<=3600)
        {
            hour=00;
            min=(int) Math.ceil(sum/60);
            sec=00;
        }
        else
        {
            hour=(int) Math.ceil(sum/3600);
            min=00;
            sec=00;
        }
        this.bake= new Time(hour, min, sec);
        this.delivery=delivery;

    }
    /*
    public static void main(String args[])
    {
        try
        {
        String top[] = {"cheese","beef"};
        Pizza p= new Pizza(32,top,new Time(00,30,00));
        System.out.println(p.diameter);
        for(int i=0;i<(p.toppings.length);i++)
        {
            System.out.println(p.toppings[i]);
        }
        System.out.println(p.bake.curTime());
        System.out.println(p.delivery.curTime());
        }
        catch(TypeNotPresentException e)
        {
            System.out.println("Provide available topppings :" + e.getMessage());
        }
    }
    */
}
