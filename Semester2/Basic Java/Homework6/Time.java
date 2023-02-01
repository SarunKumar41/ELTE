public class Time
{
    int hour,min,sec;
    
    public Time(int hour, int min, int sec )
    {
        
        if(0 <= hour && hour <=23 && 0 <=min && min <=60 && 0 <=sec && sec <=60)
        {
            this.hour=hour;
            this.min=min;
            this.sec=sec;
        }
        else{
            throw new IllegalArgumentException("Invalid hour!");
        }
    }

    public String curTime()
    {
        return (hour+" :"+min+" :"+sec+" ");
    }

    /*public static void main(String args[])
    {
        try
        {
            Time t =new Time(12, 15, 00);
            System.out.println(t.curTime());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
    */
}