public class IntList
{
    private int currentSize=0;
    private int maxSize;
    private int[] array;

    public IntList(int maxSize)
    {
        this.maxSize=maxSize;
        array = new int[maxSize];
    }
    //getters
    public int getCurrentSize()
    {
        return currentSize;
    }
    public int getMaxSize()
    {
        return maxSize;
    }
    public int[] getArray()
    {
        return array;
    }

    public void add(int a)
    {
        array[currentSize]=a;
        currentSize++;
    }
    public void concat(IntList a)
    {
        if (a.getCurrentSize() > (maxSize-currentSize))
        {
            throw new IllegalStateException();
        }
        else
        {
            int k=0;
            for (int i = currentSize; i<=currentSize+a.getCurrentSize(); i++)
            {
                array[i] = a.getArray()[k];
                k++;
            }
            currentSize=currentSize+a.getCurrentSize();
        }
    }
    public void removeItemsGreaterThan(int limit)
    {
        int i = 0;
        while (i<=currentSize)
        {
            if (array[i] > limit)
            {
                for (int k=i;k<=currentSize;k++)
                {
                    array[k] = array[k+1];
                }
                currentSize--;
            }
            else
            {
                i++;
            }
        }
    }
    public String toString()
    {
        if (currentSize==0)
        {
            String h = "EMPTY";
            return h;
        }
        else
        {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<currentSize-1;i++)
        {
            sb.append(array[i]);
            sb.append(",");
        }
        sb.append(array[currentSize-1]);
        sb.append("]");

        return sb.toString();
        }
    }

}