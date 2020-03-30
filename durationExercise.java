import java.util.*; // This is bad practicer but just do this for now until you get your tools

public class TimeFormatter {
  
    private static final int MINUTE = 60;
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
       String argumentUnit = evaluateArgumentUnit(seconds);
       
       //switch statement
       
       return "test";
    }
    
    
    public static String evaluateArgumentUnit(int seconds)
    {
     
     //Hashmaps don't maintain order smart guy
     Map<Integer, String> unitsOfTime = new HashMap<>();
     unitsOfTime.put(MINUTE, "Minute");
     unitsOfTime.put(HOUR, "Hour");
     unitsOfTime.put(DAY, "Day");
     unitsOfTime.put(WEEK, "Week");
     unitsOfTime.put(MONTH, "Month");

     //default unit
     String appropriateUnit = "Seconds";

    for(int unit : unitsOfTime.keySet()) 
    {
      
      if(seconds >= unit)
      {
        System.out.println(seconds + " seconds is greater than one " + unitsOfTime.get(unit));
        appropriateUnit = unitsOfTime.get(unit);
      }
    
    }
     return appropriateUnit; 
    
    }
    
    
    
}