/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
abstract public class Plant
{
    protected String name;
    protected int nutrients;
    protected boolean living;

    public Plant(String name, int nutrients)
    {
        this.name = name;
        this.nutrients = nutrients;
        living = true;
    }

    public String getName()
    {
        return name;
    }

    public void setNutrientChanges(int changeLevel) {
        nutrients += changeLevel;
    }

    public int getNutrients()
    {
        return nutrients;
    }

    public boolean isLiving()
    {
        living = living && getNutrients()>0; /// It modifies the attribute living and then return if it's alive
        return living && getNutrients()>0;
    }
    
    public int getAlphaDemand() {return 0;}
    public int getDeltaDemand() {return 0;}
    
    /**
     * It takes radiation and changes nutrient value of a plant
     * @param today 
     */
    abstract protected void changeNutrient(Radiation today);
    
    
            
    
}
