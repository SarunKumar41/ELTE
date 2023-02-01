/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
public class DeltaRadiation extends Radiation
{
    private static DeltaRadiation instance;
    //private DeltaRadiation(){}
    public static DeltaRadiation getInstance() {
    if (instance == null) instance = new DeltaRadiation();
    return instance; }
    @Override
    public void affectingPlant(Plant affected)
    {
        if(affected.isLiving())
        {
            if(affected instanceof Puffs) {affected.setNutrientChanges(-2);}
            else if(affected instanceof Deltatree) {affected.setNutrientChanges(+4);}
            else {affected.setNutrientChanges(+1);}
        }
    }
    
    
    
}

/*
4
Piggy p 7
Slender d 5
Dumpy b 4
Willowy d 3
10
*/