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
     
     //Adding all units
     Map<Integer, String> unitsOfTime = new HashMap<>();
     unitsOfTime.put(MINUTE, "Minute");
     unitsOfTime.put(HOUR, "Hour");
     unitsOfTime.put(DAY, "Day");
     unitsOfTime.put(WEEK, "Week");
     unitsOfTime.put(MONTH, "Month");
     
    for(int unit : unitsOfTime.keySet()) 
    {
      if(seconds >= unit)
      {
        System.out.println(seconds + " seconds is greater than one " + unitsOfTime.get(unit));
        //this is x unit
      }
    
    
    }



      if(seconds >= MINUTE)
      {
        return "Minutes";
      }
      
      switch (seconds) {
        case 1:
          System.out.println("Seconds");
          break;
        case 2:
          System.out.println("Minutes");
          break;
        case 3:
          System.out.println("Hours");
          break;
        case 4:
          System.out.println("Days");
          break;
        case 5:
          System.out.println("Weeks");
          break;
        case 6:
          System.out.println("Months");
          break;
        case 7:
          System.out.println("Years");
          break;
      }
      
    
    }
    
    
    
}