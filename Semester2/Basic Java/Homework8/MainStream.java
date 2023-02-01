public class MainStream {
    public static void main(String[] args) {
        Logger log1 = new Logger();
        Stream stream = new Stream(7,4,log1);
        stream.startStreaming();

        Logger log2 = new ConsoleLogger();
        Stream st2 = new Stream(6,3,log2);
        st2.startStreaming();
      
        Logger lg3 = new ConsoleCipherLogger();
        Stream st3 = new Stream(11,4,lg3);
        st3.startStreaming();

        Logger lg4 = new FileLogger();
        Stream st4 = new Stream(11,4,lg4);
        st4.startStreaming();
    }
}
