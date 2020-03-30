public class TimeFormatter {
private static final int HOUR = 3600;
private static final int DAY = 86400;
private static final int WEEK = 604800;
private static final int MONTH = 2628288;

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