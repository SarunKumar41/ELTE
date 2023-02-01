public class NamedIntList extends IntList
{
    private String name;

    public NamedIntList(int maxSize,String name)
    {
        super(maxSize);
        this.name=name;
    }
    public NamedIntList(int[] aa,String name)
    {
        super(aa);
        this.name=name;
    }
    public NamedIntList(Integer[] aa,String name)
    {
        super(aa);
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        if (getData().size()==0)
        {
            String h = "EMPTY";
            return h;
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            sb.append(name+" ");
            sb.append(getData().toString());

            return sb.toString();
        }
    }
}