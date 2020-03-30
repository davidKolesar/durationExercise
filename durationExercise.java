import java.util.List; // import just the List interface
import java.util.ArrayList; // import just the ArrayList class

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
     
     List<Integer> x = new ArrayList<>();
     
      for(int i = 0; i < 0; i++) {
      
      
      
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