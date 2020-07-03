package app;

import java.util.HashMap;
import java.util.Map;

public class Main {
	private static final int MINUTE = 60;
	private static final int HOUR = 3600;
	private static final int DAY = 86400;
	private static final int WEEK = 604800;
	private static final int MONTH = 2628288;
	private static Map<String, Integer> unitsOfTime = new HashMap<>();

	public static String formatDuration(int seconds) {

		// filling hashmap
		unitsOfTime.put("minute", MINUTE);
		unitsOfTime.put("hour", HOUR);
		unitsOfTime.put("day", DAY);
		unitsOfTime.put("week", WEEK);
		unitsOfTime.put("month", MONTH);

		// edge case
		if (seconds == 0) {
			return "now";
		}

		// set seconds to subtract
		int unitToSubtract = 0;
		int totalUnits = 0;

		// determine appropriate unit
		String argumentUnit = determineRemainingUnit(seconds);

		if (argumentUnit != "second") {
			unitToSubtract = unitsOfTime.get(argumentUnit);
			while (seconds <= unitToSubtract) {
				seconds = seconds - unitToSubtract;
				totalUnits++;
			}
			String returnValue = concatenateReturnValue(totalUnits, argumentUnit);
		} else {
			totalUnits = seconds;
			return concatenateReturnValue(totalUnits, argumentUnit);
		}

		return "test";

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
			return appropriateUnit;
		}
		return appropriateUnit;
	}

	public static String concatenateReturnValue(int totalUnits, String unitToSubtract) {
		if (totalUnits == 1) {
			return "1 " + unitToSubtract;
		} else {
			return totalUnits + " " + unitToSubtract;
		}

	}

}
