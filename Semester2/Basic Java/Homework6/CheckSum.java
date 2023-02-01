import java.io.*;


class CheckSum
{
    static String SumCheck(int a,int b,int compareVal)
    {
        String result ="";
        if(compareVal == a+b)
        {
            result =Integer.toString(a)+" "+Integer.toString(b); 
        }
        return result;
    }
    public static void main(String args[])
    {
        try (
            FileReader fr = new FileReader(new File("input.txt"));
            BufferedReader br = new BufferedReader(fr);
            PrintWriter pw = new PrintWriter(new File("output.txt"));
            )
        {
            String line;
            while((line = br.readLine())!= null)
            {
                String values[] = line.split(",");
                if(values.length<2) throw new IllegalAccessException("Ye kuch sahi nahi ho rha hai");
                StringBuilder sb = new StringBuilder();
                String initVal = values[0];
                String firstVal[] = initVal.split(" ");
                int compareVal = Integer.parseInt(firstVal[0]);
                int secondVal = Integer.parseInt(firstVal[1]);
                int count=0;
                //System.out.println(firstVal[0]);
                //System.out.println(firstVal[1]);
                //for(int i=1;i<values.length;i++)
                //{
                    sb.append(compareVal).append(" ");
                    String inSb = SumCheck(secondVal, Integer.parseInt(values[1]), compareVal);
                    if(inSb!=""){sb.append(inSb).append(" ");count++;}
                //} 
                for(int i=1;i<values.length-1;i++)
                {
                    inSb = SumCheck(Integer.parseInt(values[i]), Integer.parseInt(values[i+1]), compareVal);
                    if(inSb!=""){sb.append(inSb).append(" ");count++;}
                    //System.out.println(values[i]);
                }
                if(count==0) sb.append("none");
                pw.println(sb); 
            }
        }catch (FileNotFoundException | IllegalAccessException e){System.out.println("Nahi" + e.getMessage());}
        catch (IOException e){System.out.println("Nahi" + e.getMessage());}
    }
}