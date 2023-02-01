import java.io.*;
import car.utils.Color;
import car.Car;

public class MainCar 
{
    public static void main(String[] args) 
    {
        
        BufferedReader br = null;
        BufferedReader reader=null;
        try
        {

            reader = new BufferedReader(new FileReader("inputCar.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
        
            Car[] arr = new Car[lines];

            File input = new File("inputCar.txt");
            br = new BufferedReader(new FileReader(input));
            String line;
            int c=0;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(",");
                    arr[c]=new Car(parts[0],Color.valueOf(parts[1]),Integer.parseInt(parts[2]));
                    c++;
            }
            for (int i =0 ;i<lines;i++)
            {
            System.out.println(arr[i]);
            }
            System.out.println(Car.compare(arr[1],arr[0]));
        }
        catch (FileNotFoundException e)  
        {
            System.out.println("Unable to access file: "+args[0]);
        }
        catch (IOException e) 
        {
            System.out.println(" IO Exception!");
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
