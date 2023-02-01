/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plantsimulation;

import java.io.FileNotFoundException;



/**
 *
 * @author sarunkumar
 */
public class PlantSimulation 
{

    public static void main(String[] args) 
    {
        try
        {
            
            Planet p = new Planet();
            p.simulate();
        }
         catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        } catch (Exception e){System.out.println(e.getMessage());}
        
        
    }
    
}









