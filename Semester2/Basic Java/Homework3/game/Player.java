package game;
import game.utils.Vehicle;
public class Player
{
    String name, ipAddress;
    int health;
    Vehicle veh;
    public Player (String name,String ipAddress,int health,Vehicle veh) 
        {
            this.name=name;
            this.ipAddress=ipAddress;
            this.health=health;
        if (veh == null)
        {
            this.veh = null;
        }
        else
        {
            this.veh=veh;
        }
        }

        public String toString()
        {
            if (veh == null)
            {
                return (name+" "+ipAddress+" "+Integer.toString(health)+" "+"No vehicle");
            }
            else
            {
            return (name+" "+ipAddress+" "+Integer.toString(health)+" "+veh.getRegi());
            }
        }
}