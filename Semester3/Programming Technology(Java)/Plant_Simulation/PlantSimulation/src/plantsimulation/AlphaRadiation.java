/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
public class AlphaRadiation extends Radiation
{
    
    private static AlphaRadiation instance;
    //private AlphaRadiation(){}
    public static AlphaRadiation getInstance() {
    if (instance == null) instance = new AlphaRadiation();
    return instance; }

    @Override
    public void affectingPlant(Plant affected)
    {
        if(affected.isLiving())
        {
            if(affected instanceof Puffs) {affected.setNutrientChanges(+2);}
            else if(affected instanceof Deltatree) {affected.setNutrientChanges(-3);}
            else {affected.setNutrientChanges(+1);}
        }
    }
    
    
    
}
