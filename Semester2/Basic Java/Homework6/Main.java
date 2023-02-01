/*
Create a Main class with a static method that can read orders from the file which name was given as a parameter.
It should create every possible pizza, then calculates how long should the chefs cook that day.
Handle the exceptions which can raise during Pizza creation.
Demonstrate the static methods in the main() function of the Main class!
*/
import java.io.*;
public class Main
{
    public static Time OrderReader(File in)
    {
        try
        {
            //FileReader fr = new FileReader(new File("input.txt"));
            BufferedReader br = new BufferedReader(new FileReader(in));
            int hour=00,min=00,sec=00;
            String line;
            while((line = br.readLine())!= null)
            {
                String values[] = line.split(",");
                int diameter = Integer.parseInt(values[0]);
                String top= values[1];
                int size = values.length-2;
                String toppings[] = new String[size]; 
            }
        }
        return new Time(00, 00, 00);
    }
}
