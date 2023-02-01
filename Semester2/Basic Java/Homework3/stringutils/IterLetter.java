package stringutils;
public class IterLetter
{
    private String s;
    private int pos=0;
    public IterLetter(String s)
    {
        if(s==null) throw new IllegalArgumentException("Inavalid");
        this.s=s;
    }
    
    public void printNext()
    {
        if(hasNext())
        {
            System.out.println(s.charAt(pos++));
        }     
    }
    public void restart()
    {
        pos=0;
    }
    public boolean hasNext()
    {
        return pos < s.length();
    }
}