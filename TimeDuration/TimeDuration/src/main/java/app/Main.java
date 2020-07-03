package app;

import java.util.HashMap;
import java.util.Map;

public class Main {
	private static final int MINUTE = 60;
	private static final int HOUR = 3600;
	private static final int DAY = 86400;
	private static final int WEEK = 604800;
	private static final int MONTH = 2628288;
	private static final Integer SECOND = 59;
	private static Map<String, Integer> unitsOfTime = new HashMap<>();

	public static String formatDuration(int seconds) {
		// handle edge case (now)
		if (seconds == 0) {
			return "now";
		}

		// handle edge case (1 second)
		if (seconds == 1) {
			return "1 second";
		}

		int unitToSubtract = 0;
		int totalUnits = 0;
		unitsOfTime.put("second", SECOND);
		unitsOfTime.put("minute", MINUTE);
		unitsOfTime.put("hour", HOUR);
		unitsOfTime.put("day", DAY);
		unitsOfTime.put("week", WEEK);
		unitsOfTime.put("month", MONTH);

		String argumentUnit = determineRemainingUnit(seconds);

		// subtract exact values
		unitToSubtract = unitsOfTime.get(argumentUnit);
		while (seconds >= unitToSubtract) {
			seconds = seconds - unitToSubtract;
			totalUnits++;
		}
		return concatenateReturnValue(totalUnits, argumentUnit, 0);
	}

	public static String determineRemainingUnit(int seconds) {
		// default unit
		String appropriateUnit = "second";

		// handle < 1 minute
		if (seconds < 60) {
			return appropriateUnit;
		}

		for (String unit : unitsOfTime.keySet()) {
			if (seconds >= unitsOfTime.get(unit)) {
				System.out.println(seconds + " seconds is greater than or equal to one " + unit);
				if (unitsOfTime.get(appropriateUnit) < unitsOfTime.get(unit)) {
					appropriateUnit = unit;
				}
			}
		}
		return appropriateUnit;
	}

	public static String concatenateReturnValue(int totalUnits, String unitToSubtract, int secondsRemaining) {

		if (totalUnits == 1 && secondsRemaining == 0) {
			return "1 " + unitToSubtract;
		}

		if (totalUnits == 1 && secondsRemaining > 0) {

			return totalUnits + " " + unitToSubtract + " and " + secondsRemaining + " seconds";
		}

		if (totalUnits > 1 && secondsRemaining == 0) {

			return totalUnits + " " + unitToSubtract + "s";
		}

		
		if (totalUnits > 1 && secondsRemaining > 0) {

			return totalUnits + " " + unitToSubtract + "s and " + secondsRemaining + " seconds";
		}

		
		return secondsRemaining + " seconds";
	}
}