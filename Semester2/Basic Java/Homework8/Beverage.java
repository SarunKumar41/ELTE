public class Beverage
{
    private String name;
    private int legalAge;

    public Beverage(String name,int legalAge)
    {
        if (name.length()>0 && legalAge > 0)
        {
            this.name=name;
            this.legalAge=legalAge;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public String getName()
    {
        return name;
    }
    public int getLegalAge()
    {
        return legalAge;
    }

}