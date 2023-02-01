
import java.util.ArrayList;

class Main1
{
    public static ArrayList<String> geteven(ArrayList<String> list)
    {
        ArrayList<String> result = new ArrayList<String>();
        for (String element : list)
        {
            final int len = element.length();
            if (len % 2 == 1)
            {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();

        list.add("java");
        list.add("c++");
        list.add("ada");
        list.add("hello world");
        list.add("add________hghjAa");

        System.out.println(list);
        System.out.println(geteven(list));
    }
}