import java.util.HashMap;

/*
Write a function returning the letter statistics of the parameter string:
contains the number of occurrences for each letter in the string.
Use Java's HashMap data structure where the keys are the string's characters,
values are the key's occurrences. For example for the input string "Helloworld" 
one possible ouput is "r(1)d(1)e(1)w(1)H(1)l(3)o(2)" (the order doesn't matter now).
*/

class LetterStatistics
{
    static HashMap<Character,Integer> LS(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            int count=0;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j)) count++;
            }
            if(map.containsKey(s.charAt(i))==false)
            {
                map.put(s.charAt(i), count);
            }
        }
        return map;
    }
}