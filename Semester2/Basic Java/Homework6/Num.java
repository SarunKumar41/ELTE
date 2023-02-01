import java.io.*;

class nio{
    public static void main(String args[]){
    try{
    File f = new File("inp.txt");
    File w = new File("out.txt");
    FileReader fr = new FileReader(f);
    PrintWriter pw = new PrintWriter(w);
    try (BufferedReader br = new BufferedReader(fr)) {
        try (BufferedWriter bw = new BufferedWriter(pw)) {
            String ln;
            while((ln = br.readLine()) != null){
                int k = Integer.parseInt(ln);
                if(k%2 == 0){
                    bw.write(k+ "is even number");
                    bw.newLine();
                } else {
                    bw.write(k+ "is odd number");
                    bw.newLine();
                }
        }
    }}
}
    catch(FileNotFoundException e){}
    catch(IOException e){}
    catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
