// import Point;
// import Circle;


public class ColoredCircle extends Circle
{
    private Color centre;
    public ColoredCircle(double x,double y,double r,Color color)
    {
        super(x,y,r);
        this.centre=color;
    }
    public Color getColor()
    {
        return centre;
    }
}

