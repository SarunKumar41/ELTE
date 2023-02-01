import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Logger{
    public void log(String str){
    }
}
class ConsoleLogger extends Logger{
    public void log(String str){
        System.out.println(str);
    }
}
class ConsoleCipherLogger extends Logger{
    public void log(String str){
        StringBuilder strb = new StringBuilder();
        for(int i = 0; i < str.length();i++){
            //shift each character with 2
            strb.append(Character.toString((char)(((int)(str.charAt(i)))+2)));
        }
        System.out.println(strb);
    }
    
}
class FileLogger extends Logger{
    public void log(String str){
        String filename = "out.txt";
        try(FileWriter fw = new FileWriter(filename,true)){
            fw.write(str+"\n");
        }
        catch(IOException e){
            System.err.println("Ooooops!!! we got an IOException");
        }
    }
}
