class Exercise7
{
    public static void main( String[] args )
        {
            if( args.length != 1 )
            {
                System.err.println("Give exactly one integer number as an argument!");
            }
            else
            {
                int num = Integer.parseInt(args[0]);
                String answer = (num % 2 == 0) ? "even" : "odd";
                System.out.println( answer );
            }
        }
}
