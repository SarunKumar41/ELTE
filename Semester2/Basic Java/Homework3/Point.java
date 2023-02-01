public class Point
{
    public double x,y;
    public Point(double X, double y)
    {
        this.x = X;
        this.y = y;
    }
    public void move(double dx, double dy)
    {
        x += dx;
        y += dy;
    }
    public void mirror(double cx, double cy)
    {
        x=2*cx-x;
        y=2*cy-y;
        // cx - (x - cx) ==  2*cx-x
        //return new Point(2*cx-x, 2*cy-y);
    }
    public void MirrorRe(Point p)
    {
        x=2*p.x-x;
        y=2*p.y-y;
    }
    public double distance(Point p)
    {
        double cx = p.x - x;
        double cy = p.y - y;
        return Math.sqrt(cx * cx + cy * cy);
    }
}