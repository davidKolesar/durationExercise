import java.util.*; // This is bad practicer but just do this for now until you get your tools

public class TimeFormatter {
  
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;
    private static final int WEEK = 604800;
    private static final int MONTH = 2628288;
    private static Map<String,Integer> unitsOfTime = new HashMap<>();
    
  
    public static String formatDuration(int seconds) {
    
    //variables
  	unitsOfTime.put("Minute", MINUTE );
    unitsOfTime.put("Hour", HOUR);
    unitsOfTime.put("Day", DAY);
    unitsOfTime.put("Week", WEEK);
    unitsOfTime.put("Month", MONTH);
       
       //edge case 
       if(seconds == 0)
       {
         return "now";
       }
       
       //this should probably be an enum
       String argumentUnit = evaluateArgumentUnit(seconds);
		
		//set seconds to subtract
		int unitToSubtract = unitsOfTime.get(argumentUnit); 
		int totalUnits = 0;
  
		while(seconds <= unitToSubtract){
			seconds = seconds - unitToSubtract;
			totalUnits++;			
		}
		
       //handle remainder
       
       return "test";
    }
    
    
    public static String evaluateArgumentUnit(int seconds)
    {
     //default unit
     String appropriateUnit = "Seconds";
     
    //handle < 1 minute
    if(seconds < 60){
      return appropriateUnit;
    }


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