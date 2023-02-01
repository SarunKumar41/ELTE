import stringutils.IterWord;
import library.Book;
class Main
{
    public static void main(String[] args)
    {
        Kangaroo k1 = new Kangaroo("Joey",11);
        k1.display("Australia"); 
        System.out.println("Above is working of Kangaroo class\n-------------------------------------------------------");
        String s = "Hello again! Just checking if it works";
        IterWord il = new IterWord(s);
        for(int i=0; i<10;i++)
        il.printNext();

        il.restart();
        while(il.hasNext())
        {
            il.printNext();
        }
        s=null;
        try {
             new IterWord(s);
        } catch (IllegalArgumentException e){System.out.println("Caught Exception");}
        System.out.println("Above is working of IterWord class\n-------------------------------------------------");

        Book b1 = new Book("ABC","Me",2020,200,false);
        Book b2 = new Book("ABC","Me",2020,200,true);
        Book b3 = new Book("CBA","Not me",2020,200,false);
        System.out.println(b1.SameAs(b2));
        System.out.println(b1.SameAs(b3));
        System.out.println(b3.toString());
        System.out.println("Above is working of Book class\n-------------------------------------------------------");
    }
}