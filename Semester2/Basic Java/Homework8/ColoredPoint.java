public class ColoredPoint extends Point 
{
    private Color color;
    public ColoredPoint(int x,int y,Color color)
    {
        super(x,y);
        this.color=color;
    }
    public Color getColor()
    {
        return color;
    }
}