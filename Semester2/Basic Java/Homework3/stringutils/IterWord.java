package stringutils;
public class IterWord
{
    private String[] str;
    private int counter;
    public IterWord(String str)
    {
        if(str == null) throw new IllegalArgumentException("Just checking if it works :)");
        this.str=str.split(" ");
        this.counter=0;
    }
    public void printNext()
    {
        if(hasNext())
        System.out.println(str[counter++]);
    }
    public void restart()
    {
        counter=0;
    }
    public boolean hasNext() {
        return counter < str.length;
    }
    /*
    public static void main(String args[])
    {
        IterWord iw = new IterWord("Sarun Kumar is my name");
        iw.printNext(); 
    }
    */
}