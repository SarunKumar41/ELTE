class Rectangle
{
    Point p ;
    double width, height;
    public Rectangle(Point p, double width, double height)
    {
        this.p=p;
        this.width=width;
        this.height=height;
    } 
    public Point topLeft()
    {
        if(width>=0 && height<=0)
        {
            return p;
        }
        else if(width<=0 && height<=0)
        {
            return new Point(p.x+width,p.y);
        }
        else if(width>=0 && height>=0)
        {
            return new Point(p.x,p.y+height);
        }
        else
        {
            return new Point(p.x+width,p.y+height);
        }
    }

    public Point topRight()
    {
        if(width>=0 && height<=0)
        {
            return new Point(p.x+width,p.y);
        }
        else if(width<=0 && height<=0)
        {
            return p;
        }
        else if(width>=0 && height>=0)
        {
            return new Point(p.x+width,p.y+height);
        }
        else
        {
            return new Point(p.x,p.y+height);
        }   
    }
    public Point bottomLeft()
    {       
        if(width>=0 && height<=0)
        {
            return new Point(p.x,p.y+height);
        }
        else if(width<=0 && height<=0)
        {
            return new Point(p.x+width,p.y+height);
        }
        else if(width>=0 && height>=0)
        {
            return p;
        }
        else
        {
            return new Point(p.x+width,p.y);
        }
    }

    public Point bottomRight()
    {
        if(width>=0 && height<=0)
        {
            return new Point(p.x+width,p.y+height);
        }
        else if(width<=0 && height<=0)
        {
            return new Point(p.x,p.y+height);
        }
        else if(width>=0 && height>=0)
        {
            return new Point(p.x+width,p.y);
        }
        else
        {
            return p;
        }
    } 
    
    public static void main(String args[])
    {
        Rectangle r1= new Rectangle(new Point(3,5),1,-7);
        Rectangle r2 = new Rectangle(new Point(2,5),8,8);
        Point result = r1.topLeft();
        System.out.println("Top Left Point  x:" + result.x + "  y:" + result.y);
        result = r1.topRight();
        System.out.println("Top Right Point  x:" + result.x + "  y:" + result.y);
        result = r1.bottomLeft();
        System.out.println("Bottom Left Point  x:" + result.x + "  y:" + result.y);
        result = r1.bottomRight();
        System.out.println("Bottom Right Point  x:" + result.x + "  y:" + result.y);
        System.out.println("-----------------For r2---------------");
        result = r2.topLeft();
        System.out.println("Top Left Point  x:" + result.x + "  y:" + result.y);
        result = r2.topRight();
        System.out.println("Top Right Point  x:" + result.x + "  y:" + result.y);
        result = r2.bottomLeft();
        System.out.println("Bottom Left Point  x:" + result.x + "  y:" + result.y);
        result = r2.bottomRight();
        System.out.println("Bottom Right Point  x:" + result.x + "  y:" + result.y);
    }
    
}