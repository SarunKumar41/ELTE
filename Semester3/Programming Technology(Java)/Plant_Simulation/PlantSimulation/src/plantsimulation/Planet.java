/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sarunkumar
 */
public class Planet {
    private ArrayList<Plant> plants;

    public Planet() {}
    
    
    
     private int read(String fileName,ArrayList<Plant> plants) throws FileNotFoundException, InvalidInputException
    {
            
            File f = new File(fileName);
            if(f.exists())
            {
                Scanner sc = new Scanner(f);

                //ArrayList<Plant> plants = new ArrayList<>();

                    int plantCount = sc.nextInt();
                    sc.nextLine();
                    for(int i=0;i<plantCount;i++)
                    {
                          //System.out.println(sc.next());
                        String plantDetails[] = sc.nextLine().split(" ");
                        String plantName = plantDetails[0];
                        int plantNutrients = Integer.parseInt(plantDetails[2]);
                        char plantType = plantDetails[1].charAt(0);

                        switch(plantType)
                        {
                            case 'p': plants.add(new Puffs(plantName,plantNutrients)); break;
                            case 'd': plants.add(new Deltatree(plantName,plantNutrients)); break;
                            case 'b': plants.add(new Parabush(plantName,plantNutrients)); break;
                            default: throw new InvalidInputException();

                        }
                    }
                    int simulationDaysCount = sc.nextInt();
                    return simulationDaysCount;
            }
            
            return -1;
                
    }
            
    private void simulationFunc(ArrayList<Plant> plants, int simulationDaysCount) throws InvalidInputException
    {
        if(simulationDaysCount<1) {throw new InvalidInputException(); }
        else
        {
            Radiation radiations[] = new Radiation[simulationDaysCount];
            radiations[0] = NoRadiation.getInstance() ;

        
        
            for(int i=0;i<simulationDaysCount;i++)
            {
                int totalAlphaDem=0, totalDeltaDem=0, dayCount=i+1;

                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Radiation on Day " + dayCount + ": " + radiations[i].getClass().getName().split("\\.")[1] );
                for(Plant p : plants)
                {
                    p.changeNutrient(radiations[i]);
                    totalAlphaDem += p.getAlphaDemand();
                    totalDeltaDem += p.getDeltaDemand();
                    //if(p.isLiving())
                    System.out.println("Behaviour of plant on Day " + dayCount + ": Name: " + p.getName() + ", Alive: " + p.isLiving() + ", Nutrient: " + p.getNutrients() );
                }
                if(dayCount<simulationDaysCount)
                {
                    if(totalAlphaDem - totalDeltaDem >=3) radiations[dayCount] = AlphaRadiation.getInstance();
                    else if(totalDeltaDem - totalAlphaDem >=3) radiations[dayCount] = DeltaRadiation.getInstance();
                    else radiations[dayCount] = NoRadiation.getInstance();
                }

            }
        }
    }
    
    private void printResult(ArrayList<Plant> plants)
    {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("List of alive plants: ");
       for(Plant p : plants)
       {
           if(p.living){System.out.println(p.getName());}
       }
    }
    
    private void clearPlants(){ plants.clear();}
    
    public void simulate() throws FileNotFoundException, InvalidInputException 
    {
        System.out.println("Please, enter the name of the file");
            Scanner scf = new Scanner(System.in);
            String fileName = scf.next();
            

                plants = new ArrayList<>();
                
                int simulationDaysCount = read(fileName, plants);
                if(simulationDaysCount==-1)
                {
                    throw new FileNotFoundException();
                }
                simulationFunc(plants,simulationDaysCount);
                printResult(plants);
                clearPlants();
            
            
    }
    
    
    
}
