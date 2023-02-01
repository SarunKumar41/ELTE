/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
public class NoRadiation extends Radiation {
    
    private static NoRadiation instance;
    //private NoRadiation(){}
    public static NoRadiation getInstance() {
    if (instance == null) instance = new NoRadiation();
    return instance; }

    @Override
    public void affectingPlant(Plant affected)
    {
        if(affected.isLiving())
        {
            if(affected instanceof Puffs) {affected.setNutrientChanges(-1);}
            else if(affected instanceof Deltatree) {affected.setNutrientChanges(-1);}
            else {affected.setNutrientChanges(-1);}
        }
    }
    
}
