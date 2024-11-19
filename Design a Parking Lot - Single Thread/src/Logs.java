import java.util.*;
public class Logs {
    private static Map<String, ParkingDetails> logger;
    public static  Map<String, ParkingDetails> createInstance(){
       if(logger == null){
           logger = new HashMap<>();
       }
       return logger;
    }

}
