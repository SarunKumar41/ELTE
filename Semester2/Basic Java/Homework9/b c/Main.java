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

        IntList b = new IntList();
        b.add(1);
        b.add(2);
        b.add(3);

        a.concat(b);
        System.out.println(a);

        a.removeItemsGreaterThan(3);
        System.out.println(a);
        IntList c = new IntList();
        System.out.println(c);

        Integer[] nameArr= new Integer[2];
        nameArr[0] = 1;
        nameArr[1] = 2;
        IntList d = new IntList(nameArr);
        System.out.println(d);

        int name[] = {1,2,3,4,5,6,7,8,9};
        IntList e = new IntList(name);
        System.out.println(e);

        NamedIntList f = new NamedIntList(name,"First");
        System.out.println(f);

    }
}