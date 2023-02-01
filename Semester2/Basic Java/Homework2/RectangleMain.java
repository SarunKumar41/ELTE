class RectangleMain
{
    Point mainTopLeft,mainTopRight,mainBottomLeft,mainBottomRight;
    
    public RectangleMain(Point a,Point b,Point c,Point d)
    {
        mainTopLeft = a;
        mainTopRight = b;
        mainBottomLeft = c;
        mainBottomRight = d;
    }

    public static void main(String args[])
    {
        if(args.length%4!=0 || args.length<4)
        {
            System.out.println("We need sufficient parameters");
            System.exit(1);
        }
        Rectangle r1= new Rectangle(new Point(Double.parseDouble(args[0]),Double.parseDouble(args[1])),Double.parseDouble(args[2]),Double.parseDouble(args[3])); // To use multiple input triangle program try commenting rectangle r1 and r2(also open precommented section) and method related to it :) 
        Rectangle r2 = new Rectangle(new Point(Double.parseDouble(args[4]),Double.parseDouble(args[5])),Double.parseDouble(args[6]),Double.parseDouble(args[7]));
        /*
        Rectangle Rectarr[] = new Rectangle[args.length/4]; // For multiple rectangle input and also this is part of A part of exercise 4
        //System.out.println(Rectarr.length);
        int i=0; 
        for(int j=0;j<Rectarr.length;j++)
        {
            
            //for(int i=0;i<args.length;i+=4)
            //{
                //Rectarr[j].p = new Point(Double.parseDouble(args[i]),Double.parseDouble(args[i+1]));
                double recx = Double.parseDouble(args[i]);
                double recy= Double.parseDouble(args[i+1]);
                double recwidth = Double.parseDouble(args[i+2]);
                double recheight = Double.parseDouble(args[i+3]);
                Rectarr[j] = new Rectangle(new Point(recx,recy),recwidth,recheight);
                i+=4;
            //}
        }
        double topLeft_X=Rectarr[0].topLeft().x,topLeft_Y=Rectarr[0].topLeft().y,topRight_X=Rectarr[0].topRight().x,topRight_Y=Rectarr[0].topRight().y;
        double bottomLeft_X=Rectarr[0].bottomLeft().x,bottomLeft_Y=Rectarr[0].bottomLeft().y,bottomRight_X=Rectarr[0].bottomRight().x,bottomRight_Y=Rectarr[0].bottomRight().y;
        for(i=0;i<Rectarr.length;i++)
        {
            if(Rectarr[i].topLeft().x<topLeft_X)
            {
                topLeft_X=Rectarr[i].topLeft().x;
            }
            if(Rectarr[i].topLeft().y>topLeft_Y)
            {
                topLeft_Y=Rectarr[i].topLeft().y;
            }
            if(Rectarr[i].topRight().x>topRight_X)
            {
                topRight_X=Rectarr[i].topRight().x;
            }
            if(Rectarr[i].topRight().y>topRight_Y)
            {
                topRight_Y=Rectarr[i].topRight().y;
            }
            if(Rectarr[i].bottomLeft().x<bottomLeft_X)
            {
                bottomLeft_X=Rectarr[i].bottomLeft().x;
            }
            if(Rectarr[i].bottomLeft().y<bottomLeft_Y)
            {
                bottomLeft_Y=Rectarr[i].bottomLeft().y;
            }
            if(Rectarr[i].bottomRight().x>bottomRight_X)
            {
                bottomRight_X=Rectarr[i].bottomRight().x;
            }
            if(Rectarr[i].bottomRight().y<bottomRight_Y)
            {
                bottomRight_Y=Rectarr[i].bottomRight().y;
            }
        }
        */
        // B part of exercise 4
        double topLeft_X=Double.min(r1.topLeft().x,r2.topLeft().x),
        topLeft_Y=Double.max(r1.topLeft().y,r2.topLeft().y),
        topRight_X=Double.max(r1.topRight().x,r2.topRight().x),
        topRight_Y=Double.max(r1.topRight().y,r2.topRight().y);
        double bottomLeft_X=Double.min(r1.bottomLeft().x,r2.bottomLeft().x),
        bottomLeft_Y=Double.min(r1.bottomLeft().y,r2.bottomLeft().y),
        bottomRight_X=Double.max(r1.bottomRight().x,r2.bottomRight().x),
        bottomRight_Y=Double.min(r1.bottomRight().y,r2.bottomRight().y);


        RectangleMain result = new RectangleMain(new Point(topLeft_X,topLeft_Y),new Point(topRight_X,topRight_Y),new Point(bottomLeft_X,bottomLeft_Y),new Point(bottomRight_X,bottomRight_Y));
        System.out.println("Main rectangle\n Top Left vertex : ("+result.mainTopLeft.x+","+result.mainTopLeft.y+")\n Top Right vertex : ("+result.mainTopRight.x+","+result.mainTopRight.y+")\n Bottom Left vertex : ("+result.mainBottomLeft.x+","+result.mainBottomLeft.y+")\n Bottom Right vertex : ("+result.mainTopRight.x+","+result.mainTopRight.y+")");
    }
}