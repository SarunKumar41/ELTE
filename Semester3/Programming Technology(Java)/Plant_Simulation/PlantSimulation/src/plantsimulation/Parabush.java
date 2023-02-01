/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulation;

/**
 *
 * @author sarunkumar
 */
public class Parabush extends Plant {

    public Parabush(String name, int nutrients) {
        super(name, nutrients);
    }

    @Override
    public void changeNutrient(Radiation today)
    {
        today.affectingPlant(this);
    }
    
    
    
    
    
}
