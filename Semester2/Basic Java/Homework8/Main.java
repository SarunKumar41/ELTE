public class Main 
{
    public static void main(String args[]) 
    {
        Barista b = new Barista();
    
        Adult a1 = new Adult("Adam",27);
        Minor a2 = new Minor("Eva",15);

        Beverage soft = new Beverage("Coke",12);
        Beverage hard = new Beverage("Moris",18);

        System.out.println(b.order(soft,a2));
        System.out.println(b.order(hard,a2));
        System.out.println(b.order(hard,a1));

    }    
}
