package game;
import game.utils.Vehicle;
import game.Player;

class Main
{
    public static void main(String[] args) 
    {   
        Vehicle bmw = new Vehicle("UP701",123,12,23);
        Vehicle audi = new Vehicle("MG781",342,21,24);
        Vehicle volvo = new Vehicle("DID191",987,54,99);
        Player me = new Player("Sarun","232",98,volvo);
        Player he = new Player("CAN","876",46,null);

        System.out.println(me.toString());
        System.out.println(he.toString());
    }
}