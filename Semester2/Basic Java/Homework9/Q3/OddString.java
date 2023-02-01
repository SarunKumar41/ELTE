import java.util.ArrayList;

/*
Write a function getting an ArrayList of strings and returning a copy which doesn't include
those strings whose length are an even number.
*/

class OddString
{
    static ArrayList<String> OS(ArrayList<String> arrlist)
    {
        ArrayList<String> oddlist = new ArrayList<>();
        for(int i=0; i<arrlist.size();i++)
        {
            if(arrlist.get(i).length()%2!=0)
            {
                oddlist.add(arrlist.get(i));
            }
        }
        return oddlist;
    } 
}