/*
Create a program that prints characters to the standard output from some text file (in.txt)!
Read the number of characters to be printed from the standard input! An integer value can be
provided as command line argument that specifies how many lines shall be skipped after each
read character (use the skip() method of the BufferedReader class).
Use the BufferedReader class's read() method to read a file character-by-character!
Handle exceptions arising during reading, or parsing of the command line argument,
and during reading from console (NoSuchElementException, InputMismatchException)!
*/

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
public class PrintChar
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = null;
        try {
        int sV = Integer.parseInt(args[0]);

        File input = new File("inp.txt");
        System.out.println("Enter number of characters to be printed");
        int limit = Integer.parseInt(System.console().readLine());

            br = new BufferedReader(new FileReader(input));
            int counter =0;
            int i;
            while (((i=br.read())!=-1) && counter <limit)
            {
                System.out.println((char)i);
                ++counter;
                br.skip(sV-1);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Input Mismatch Exception");
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e)  
        {
            System.out.println("Unable to access file: "+args[0]);
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("NoSuchElementException");
            System.out.println(e.getMessage());
        }
        catch (IOException e) 
        {
            System.out.println(" IO Exception!");
        }
        catch (IllegalArgumentException e)  
        {
            System.out.println("Illegal Argument");
        } 
        finally 
        {
            br.close();
        }
   }
}


