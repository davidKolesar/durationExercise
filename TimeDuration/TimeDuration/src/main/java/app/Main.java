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
	private static Map<String, Integer> resultsPairs = new HashMap<>();
	private static int totalNumeratedUnits = 0;

	public static String formatDuration(int seconds) {
		// handle edge case (now)
		if (seconds == 0) {
			return "now";
		}

		// handle edge case (1 second)
		if (seconds == 1) {
			return "1 second";
		}

		unitsOfTime.put("second", SECOND);
		unitsOfTime.put("minute", MINUTE);
		unitsOfTime.put("hour", HOUR);
		unitsOfTime.put("day", DAY);
		unitsOfTime.put("week", WEEK);
		unitsOfTime.put("month", MONTH);

		// break down into each smallest unit
		while (seconds > 59) {
			String argumentUnit = determineRemainingUnit(seconds);
			seconds = reduceToLowestAmount(seconds, argumentUnit);
		}
		// format return statement
		return concatenateReturnValue(seconds);

	}

	public static int reduceToLowestAmount(int seconds, String argumentUnit) {
		int totalUnits = 0;
		Integer unitToSubtract = unitsOfTime.get(argumentUnit);
		while (seconds >= unitToSubtract) {
			seconds = seconds - unitToSubtract;
			totalUnits++;
		}
		resultsPairs.put(argumentUnit, totalUnits);
		return seconds;
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

	public static String concatenateReturnValue(int seconds) {
		boolean isThreeUnits = false;
		boolean isPreviousUnit = false;
		String returnValue = "";

		for (String unit : resultsPairs.keySet()) {
			if (resultsPairs.get(unit) >= 1) {
				switch (unit) {
				case "month":
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " months";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " month";
					}
					isPreviousUnit = true;
					totalNumeratedUnits++;
					break;

				case "week":
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " months";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " month";
					}
					totalNumeratedUnits++;
					break;

				case "day":
					isPreviousUnit = true;
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " days";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " day";
					}
					totalNumeratedUnits++;
					break;

				case "hour":
					isPreviousUnit = true;
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " hourss";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " hour";
					}
					totalNumeratedUnits++;
					break;

				case "minute":
					isPreviousUnit = true;
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " minutes";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " minute";
					}
					totalNumeratedUnits++;
					break;
				}
				if (isPreviousUnit) {

				} else {

				}

			}
		}
		// handle seconds outside of loop
		if (seconds > 0) {
			if (isPreviousUnit) {
				if (seconds > 1) {
					returnValue = returnValue + " and " + seconds + " seconds";
				} else {
					returnValue = returnValue + " and 1 second";
				}
			} else {
				if (seconds > 1) {
					returnValue = returnValue + seconds + " seconds";
				} else {
					returnValue = returnValue + " 1 second";
				}
			}
		}

		resultsPairs.clear();
		return returnValue;
	}
}