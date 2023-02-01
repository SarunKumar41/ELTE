import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IntList
{
    private int maxSize;
    private ArrayList<Integer> array;

    public IntList()
    {
        array = new ArrayList<Integer>();
    }
    public IntList(int maxSize)
    {
        this.maxSize=maxSize;
        array = new ArrayList<Integer>(maxSize);
    }
    public IntList(int[] aa)
    {
        array = new ArrayList<Integer>();
        for(int i =0;i<aa.length;i++)
            {
		    array.add(aa[i]);
	        }
    }
    public IntList(Integer[] aa)
    {
        array = new ArrayList<Integer>();
        Collections.addAll(array, aa);
    }
    //getters
    public int getCurrentSize()
    {
        return array.size();
    }
    public int getMaxSize()
    {
        return maxSize;
    }


    public ArrayList<Integer> getData()
    {
        return array;
    }

    public void add(int a)
    {
        array.add(a);
    }
    public void concat(IntList a)
    {
        if (a.getData().size() > (maxSize-array.size()))
        {
            throw new IllegalStateException();
        }
        else
        {
            array.addAll(a.getData());
        }
    }
    public void removeItemsGreaterThan(int limit)
    {
      array.removeIf(n -> (n > limit));
    }
    public String toString()
    {
        if (array.size()==0)
        {
            String h = "EMPTY";
            return h;
        }
        else
        {
            return array.toString();
        }
    }

}