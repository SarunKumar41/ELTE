class Main
{
    public static void main (String args[])
    {
        IntList a = new IntList(10);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        System.out.println(a);

        IntList b = new IntList(8);
        b.add(1);
        b.add(2);
        b.add(3);

        a.concat(b);
        System.out.println(a);

        a.removeItemsGreaterThan(3);
        System.out.println(a);

    }
}