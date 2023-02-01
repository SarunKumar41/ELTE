import java.util.Random;
public class Stream {
    private int maxStringLength;
    private int stringNumber;
    Logger logg;
    
    private String upperCaseChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String lowerCaseString="abcdefghijklmnopqrstuvwxyz";
    private String allChars = upperCaseChars + lowerCaseString;

    public Stream(int maxStringLength, int stringNumber, Logger logg){
        if( maxStringLength >= 0 && maxStringLength < Integer.MAX_VALUE && stringNumber >= 0 && stringNumber < Integer.MAX_VALUE && logg != null){
            this.maxStringLength = maxStringLength;
            this.stringNumber = stringNumber;
            this.logg = logg;
        }else{
            throw new IllegalArgumentException();
        }

    }

    public void startStreaming(){
        int count = stringNumber;
        while(count > 0)
        {
            String randomString = generateRandomString(maxStringLength);
            logg.log(randomString);
            count--;    
        }  
    }

    public String generateRandomString(int maxStringLength){
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < maxStringLength; i ++){
            int index = random.nextInt(allChars.length());
            randomString.append(allChars.charAt(index));
        }
        return randomString.toString();
    }
}
