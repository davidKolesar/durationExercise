public class TimeFormatter {
    PUBLIC STATIC FINAL INT HOUR = 3600;
    PUBLIC STATIC FINAL INT DAY = 86400;


    public static String formatDuration(int seconds) {
       //edge case 
       if(seconds == 0)
       {
         return "now";
       }
       
       //this should probably be an enum
       int argumentUnit = evaluateArgumentUnit(seconds);
       
       //switch statement
       
       return "test";
    }
    
    
    public static String evaluateArgumentUnit(seconds)
    {
    
    
    }
    
    
    
}