/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
public class Puffs extends Plant
{

    public Puffs(String name, int nutrients)
    {
        super(name, nutrients);
    }
    
    
    @Override
    public void changeNutrient(Radiation today)
    {
        today.affectingPlant(this);
    }
    
    public boolean isLiving()
    {
        living = living && getNutrients()>0 && 11>getNutrients();
        return living && getNutrients()>0 && 11>getNutrients();
    }
    
    public int getAlphaDemand()
    {
        if(this.isLiving()) {return (10 - getNutrients());} 
        return super.getAlphaDemand();
    } 
    //public int getDeltaDemand(){ return (10 - getNutrients()); } 
    
}
