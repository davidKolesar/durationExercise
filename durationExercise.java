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
      

      switch (seconds) {
        case 1:
          System.out.println("Monday");
          break;
        case 2:
          System.out.println("Tuesday");
          break;
        case 3:
          System.out.println("Wednesday");
          break;
        case 4:
          System.out.println("Thursday");
          break;
        case 5:
          System.out.println("Friday");
          break;
        case 6:
          System.out.println("Saturday");
          break;
        case 7:
          System.out.println("Sunday");
          break;
      }
      
    
    }
    
    
    
}