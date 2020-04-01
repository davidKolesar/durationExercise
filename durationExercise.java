import java.util.*; // This is bad practicer but just do this for now until you get your tools

public class TimeFormatter {
  
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;
    private static final int WEEK = 604800;
    private static final int MONTH = 2628288;
    private static Map<String,Integer> unitsOfTime = new HashMap<>();
    
  
    public static String formatDuration(int seconds) {
    
    //filling hashmap
    unitsOfTime.put("second", SECOND );
    unitsOfTime.put("minute", MINUTE );
    unitsOfTime.put("hour", HOUR);
    unitsOfTime.put("day", DAY);
    unitsOfTime.put("week", WEEK);
    unitsOfTime.put("month", MONTH);
       
    //edge case 
    if(seconds == 0)
    {
      return "now";
    }
       
		//set seconds to subtract
	 int unitToSubtract = 0;
   int totalUnits = 0;
   
   //determine appropriate unit
   String argumentUnit = determineRemainingUnit(seconds);
  
    if(argumentUnit != "second")
    {
      while(seconds <= unitToSubtract)
      {
    		seconds = seconds - unitToSubtract;
    		totalUnits++;			
    	}
    } 
    else 
    {
      return concatenateReturnValue(int amount, String unit);
    }
      
       int unitToSubtract = unitsOfTime.get(argumentUnit);       
    		
  		}
    
  
  }
  	
       
       return "test";
    }
    
    
    public static String determineRemainingUnit(int seconds)
    {
     //default unit
     String appropriateUnit = "second";
     
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
    
    public static String concatenateReturnValue(int amount, String unit) {
      if(unit == 1) {
        return "1 " + unit;
      } else {
        return amount + " " + units;
      }
    
    }
    
    
}