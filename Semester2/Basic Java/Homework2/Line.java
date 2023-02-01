/*
Create class Line, which can represent lines on a plane. A line is characterized by its points (𝑥,𝑦)
, which satisfy the equality ax+by=c. The fields of the Line class will be a, b and c, all of type double.
Create a method contains(p), which decides whether the point p lies on the line.
Create the methods isParallelWith(l) and isOrthogonalTo(l), which decide, respectively, whether a line is parallel to,
and orthogonal (perpendicular) to the line l provided as a parameter.
*/
class Line 
{
    double a,b,c;
    public Line(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public boolean contains(Point p)
    {
        if((a*p.x+b*p.y)==c) //ax+by=c
        {
            return true;
        }
        return false;
    }
    public boolean isParallelWith(Line l)
    {
        if((-a/b) == (-l.a/l.b))
        {
            return true;
        }
        return false;
    }

    public boolean isOrthogonalTo(Line l)
    {
        if((-a/b)*(-l.a/l.b)==-1)
        {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        Line l1 = new Line(2,7,0);
        Line l2 = new Line(4,14,6);
        Line l3 = new Line(7,-2,10);
        System.out.println("Point is on line: "+ l1.contains(new Point(7,-2)));
        System.out.println("Point is on line: "+l1.contains(new Point(13,-17)));
        System.out.println("Line l1 parallel with line l2: " + l1.isParallelWith(l2));
        System.out.println("Line l1 parallel with line l3: " + l1.isParallelWith(l3));
        System.out.println("Line l1 Orthogonal with line l2: " +l1.isOrthogonalTo(l3));
        System.out.println("Line l2 Orthogonal with line l3: " +l2.isOrthogonalTo(l3));
    }
}


class Point
{
    double x,y;
    public Point(double x, double y)
    {
        this.x = x;
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
    public void mirrorRe(Point p)
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
