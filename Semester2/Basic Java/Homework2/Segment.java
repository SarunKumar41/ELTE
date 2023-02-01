/*
Create the class Segment representing line segments on a plane. This class will have four fields of type double:
 the coordinates of the two endpoints of the segment (x1, y1, x2, y2).
Create a method line() which returns a Line object representing the line that covers the segment.
Create a method contains(p) which decides whether the point p lies on the segment.
Create a method orientation(p) in class Segment which decides whether the vector from the first endpoint
of the segment to its second endpoint and the given point p has orientation "clockwise" (right turn),
 "counter-clockwise" (left turn) or "colinear" (no turn).
The method should return zero if the point is on the line covering the segment (colinear), a positive number if the orientation is clockwise,
and a negative number if the orientation is counter-clockwise.
This is actually quite simple.
If we denote the coordinates of p with 𝑥3 and y3, our method should evaluate the following expression.
(y2−y1)(x3−x2)−(y3−y2)(x2−x1). 
Create a method intersect(s) which decides whether a segment intersects with another segment s given as parameter.
You can use the following tutorial.

http://www.dcs.gla.ac.uk/~pat/52233/slides/Geometry1x1.pdf
*/

class Segment
{
    double x1,y1,x2,y2;
    public Segment(double x1,double y1,double x2,double y2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    public Line line()
    {
        return (new Line((y2-y1),(x1-x2),((y2*x1)-(y1*x2))));
    }
    public boolean contains(Point p)
    {
        if((p.x*(y2-y1)+p.y*(x1-x2)) ==((x1*y2)-(x2*y1)))
        {
            double length = Math.sqrt((x2-x1)*(x2-x1)-(y2-y1)*(y2-y1));
            double distance1 = Math.sqrt((x1-p.x)*(x1-p.x)-(y1-p.y)*(y1-p.y));
            double distance2 = Math.sqrt((x2-p.x)*(x2-p.x)-(y2-p.y)*(y2-p.y));
            if ((distance1 <= length)&&(distance2 <=length)){return true;}
        }
        return false;
        /*
        Line check = new Line((y2-y1),(x1-x2),((y2*x1)-(y1*x2)));
        if((check.a*p.x+check.b*p.y)==check.c) //ax+by=c
        {
            return true;
        }
        return false;
        */
    }
    public double orientation(Point p)
    {
        return ((y2-y1)*(p.x-x2)-(p.y-y2)*(x2-x1)); //(𝑦2−𝑦1)(𝑥3−𝑥2)−(𝑦3−𝑦2)(𝑥2−𝑥1)
    }
    public boolean intersect(Segment s)
    {
        double c1=(orientation(new Point(s.x1,s.x2)));
        double c2=(orientation(new Point(s.x1,s.x2)));
        if(c1!=c2)
        {
            if(((c1<0) && (c2>0)) || ((c1>0) && (c2<0)))
            {
                return true;
            }
        }
        return false;
    }
    public static void main (String args[])
    {
        Segment s1 = new Segment(-3,1,5,5);
        Line result = s1.line();
        System.out.println("Line segment (" + result.a +")x + (" + result.b+")y = (" + result.c + ")");
        System.out.println("s1 contains Point :"+s1.contains(new Point(1,3)));
        System.out.println("s1 orientation Point :"+s1.orientation(new Point(1,3)));
        System.out.println("s1 orientation Point :" + s1.orientation(new Point(3,3)));
        Segment s2 = new Segment(1,2,3,4);
        System.out.println("s1 intersect s2 :" + s1.intersect(s2));
    }
}