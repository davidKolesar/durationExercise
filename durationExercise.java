import java.util.*; // This is bad practicer but just do this for now until you get your tools

public class TimeFormatter {
  
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;
    private static final int WEEK = 604800;
    private static final int MONTH = 2628288;
	
	private static final Map<String,Integer> unitsOfTime = new HashMap<>();
    private static final unitsOfTime.put("Minute", MINUTE );
    private static final unitsOfTime.put("Hour", HOUR);
    private static final unitsOfTime.put("Day", DAY);
    private static final unitsOfTime.put("Week", WEEK);
    private static final unitsOfTime.put("Month", MONTH);
  
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
     // can we use modulus here? I don't think you can because it won't always == 0
		
		
     //Hashmaps don't maintain order smart guy


     //default unit
     String appropriateUnit = "Seconds";

    for(String unit : unitsOfTime.keySet()) 
    {   
      if(seconds >=  unitsOfTime.get(unit))
      {
        System.out.println(seconds + " seconds is greater than one " + unit);
        if(unitsOfTime.get(appropriateUnit) < unitsOfTime.get(unit))
        	appropriateUnit = unit;
      }
    
    }
     return appropriateUnit; 
    }
    
    
    
}