package app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	private static final int MINUTE = 60;
	private static final int HOUR = 3600;
	private static final int DAY = 86400;
	private static final int WEEK = 604800;
	private static final int MONTH = 2628288;
	private static final Integer SECOND = 59;
	private static Map<String, Integer> unitsOfTime = new HashMap<>();
	private static Map<String, Integer> resultsPairs = new LinkedHashMap<String, Integer>();

	/**
	 * Method that takes seconds and breaks them into months, weeks, days, hours,
	 * minutes, and seconds.
	 * 
	 * @param seconds [int] -- The number of seconds to convert.
	 * @return [String] -- The value of seconds broken down into units.
	 */
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

		/**
		 * While seconds is still greater than 1 minute (the smallest possible unit to
		 * divide), find the greatest unit applicable and divide it
		 */
		while (seconds > 59) {
			String argumentUnit = determineRemainingUnit(seconds);
			seconds = reduceToLowestAmount(seconds, argumentUnit);
		}
		// format return statement
		String concatenatedValue = concatenateReturnValue(seconds);
		return formatReturnString(concatenatedValue);
	}

	/**
	 * Takes seconds (dividend) and divides them into the greatest possible unit of
	 * time (divisor)
	 * 
	 * @param seconds [int] Seconds to divide (dividend)
	 * @return [String] the greatest unit that amount of seconds breaks up into
	 *         (divisor)
	 */
	private static String determineRemainingUnit(int seconds) {
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

	/**
	 * Takes seconds and the highest unit of time it will divide into and returns
	 * the amount of units with remaining seconds.
	 * 
	 * @param seconds      [int] Seconds left to divide (dividend)
	 * @param argumentUnit [String] unit of time as (divisor)
	 * @return remained of seconds
	 */
	private static int reduceToLowestAmount(int seconds, String argumentUnit) {
		int totalUnits = 0;
		Integer unitToSubtract = unitsOfTime.get(argumentUnit);
		while (seconds >= unitToSubtract) {
			seconds = seconds - unitToSubtract;
			totalUnits++;
		}
		resultsPairs.put(argumentUnit, totalUnits);
		return seconds;
	}

	/**
	 * Creates a string of values to units into an unformatted String
	 * 
	 * @param seconds [int] -- amount of seconds
	 * @return concatenatedString [String] -- String containing values to units.
	 */
	private static String concatenateReturnValue(int seconds) {
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
					break;

				case "week":
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " months";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " month";
					}
					break;

				case "day":
					isPreviousUnit = true;
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " days";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " day";
					}
					break;

				case "hour":
					isPreviousUnit = true;
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " hourss";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " hour";
					}
					break;

				case "minute":
					isPreviousUnit = true;
					if (resultsPairs.get(unit) > 1) {
						returnValue = returnValue + resultsPairs.get(unit) + " minutes";
					} else {
						returnValue = returnValue + resultsPairs.get(unit) + " minute";
					}
					break;
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
	
	
	/**
	 * Takes a string of units and numbers to format them into a proper string.
	 * 
	 * @param concatenatedValue [String] Value of all units concatenated into an
	 *                          unformatted string.
	 * @return [String] final value to return.
	 */
	private static String formatReturnString(String concatenatedValue) {
		boolean isFormattingNeeded = false;

		// count digits in string
		int digitsInString = 0;
		for (int i = 0, len = concatenatedValue.length(); i < len; i++) {
			if (Character.isDigit(concatenatedValue.charAt(i))) {
				digitsInString++;
				if (digitsInString >= 3) {
					isFormattingNeeded = true;
				}
			}
		}

		if (isFormattingNeeded) {
			return concatenatedValue.replaceAll("(?<=[a-z]) ?(?<! and )(\\d+)", ", $1");
		}

		return concatenatedValue;
	}

}