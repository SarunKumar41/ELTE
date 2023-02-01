import java.util.HashMap;
import java.util.Collections;
class Main2 
{
     public static HashMap<Character,Integer> statistics (String letter)
    {
        HashMap<Character,Integer> data = new HashMap<Character, Integer>();
        for (int j = 0 ; j<letter.length();j++)
        {
            char temp = letter.charAt(j);
            int tc = 0;
            for (int i =0 ; i< letter.length();i++)
            {
                if (temp == letter.charAt(i))
                {
                    tc++;
                }
            }
            data.put(temp,tc);
        }
        return data;
    }

    public static void main(String[] args)
    {
        HashMap<Character,Integer> a = new HashMap<Character, Integer>(statistics("HelloWorld"));
    System.out.println(a);
    }
}