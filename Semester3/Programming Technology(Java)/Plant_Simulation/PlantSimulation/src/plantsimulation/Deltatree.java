/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
public class Deltatree extends Plant
{

    public Deltatree(String name, int nutrients)
    {
        super(name, nutrients);
    }
   

    @Override
    
    public void changeNutrient(Radiation today)
    {
        today.affectingPlant(this);
    }
    
    public int getDeltaDemand() {
        if(this.isLiving())
        {
            if(getNutrients()< 5){return 4;}
            else if(5 <= getNutrients() || getNutrients()<=10){return 1;}
            else return super.getDeltaDemand();
        }
        return super.getDeltaDemand();
    }
    
    
}
