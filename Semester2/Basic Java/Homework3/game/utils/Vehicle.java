package game.utils;
public class Vehicle
{
    int modelId;
    private String registrationNo;
    int color1,color2;

    public Vehicle(String registrationNo,int modelId, int color1,int color2)
    {
        this.modelId=modelId;
        this.registrationNo=registrationNo;
        this.color1=color1;
        this.color2=color2;
    }
    public String getRegi()
    {
        return registrationNo;
    }
    public void setRegi(String s)
    {
        registrationNo=s;
    }
}