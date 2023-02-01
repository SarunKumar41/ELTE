class Segment
{
    private double x1,y1,x2,y2;
    public Segment(){};
    public Segment(double x1,double y1,double x2,double y2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    } 
    public Point midPoint()
    {
        return new Point((x1+x2)/2,(y1+y2)/2);
    }

    public void setSegment(double x1,double y1,double x2,double y2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    public static void main(String args[])
    {
        Segment s1 = new Segment();
        System.out.println("Points of s1 Segement x1: "+ s1.x1 + "x2: "+s1.x2 + "y1: "+ s1.y1 + "y2: "+ s1.y2);
        Segment s2 = new Segment(1,2,3,4);
        System.out.println("Points of s2 Segement x1: "+ s2.x1 + "x2: "+s2.x2 + "y1: "+ s2.y1 + "y2: "+ s2.y2);
        s1.setSegment(-2.0,1.0,5.0,3.0);
        System.out.println("Points of s1 Segement x1: "+ s1.x1 + "x2: "+s1.x2 + "y1: "+ s1.y1 + "y2: "+ s1.y2);
        Point m = s1.midPoint();
        System.out.println("Midpoints of s1  x: "+ m.x + " y: "+m.y);
    }
}