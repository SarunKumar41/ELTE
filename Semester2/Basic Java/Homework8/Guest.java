public class Guest 
{
    protected String name;
    protected int age;
    
    public Guest()
    {}
    public Guest(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }

}
class Adult extends Guest
{
    public Adult(String name,int age)
    {
        if (age>=18)
        {
            this.age=age;
            this.name=name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
class Minor extends Guest
{
    public Minor(String name,int age)
    {
        if (age<18)
        {
            this.age=age;
            this.name=name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}

