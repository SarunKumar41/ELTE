public class Barista 
{
    Beverage drink;
    Guest person;

    public Barista()
    {}
 public Boolean order(Beverage bs,Guest g)
 {
     return bs.getLegalAge() <=g.age;
 }
}
