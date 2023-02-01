/*
Create a TelevisionShop enum. It's values are: SAMSUNG, LG, SKYWORTH, SONY, SHARP .
First parameter in their constructors should be the number in stock, second and third are the minimal
and maximal diagonal sizes available! Create methods that can return / print the minimal and maximal available
television sizes regardless of the type (static) and one, which can print / return every size from a specific type!
 Create a static method which returns every information about the TVs in stock!
Use final whenever possible!
*/
/**
* @author  Sarun Kumar
* @version 1.0
* @since   2022-03-28
*/
public enum TelevisionShop
{
    SAMSUNG(100,15.5,40.5),
    LG(200,30.5,75.5),
    SKYWORTH(150,25.0,50.0),
    SONY(75,20.0,80.0),
    SHARP(250,10.0,45.0);

    int number;
    double minSize, maxSize;

    TelevisionShop(int number, double minSize, double maxSize)
    {
        this.number=number;
        this.minSize=minSize;
        this.maxSize=maxSize;
    }
    public void getSize()
    {
        System.out.println("Minimum size is " + this.minSize + " Maxixmum size is " + this.maxSize);
    }
    static String listAll()
    {
        StringBuilder sb = new StringBuilder();
        for(TelevisionShop t : TelevisionShop.values())
        {
            sb.append(t.ordinal()).append(": ").append(t.name()).append(" Number: ").append(t.number).append(" minimun size: ").append(t.minSize).append(" maximum size ").append(t.maxSize).append(System.lineSeparator());
        }
        return sb.toString();
    }
}