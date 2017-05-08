package convertunits;

/**
 * Utility class for converting the USA standard unit of measurements to
 * worldwide known ones and vice versa.
 * 
 * @see Conversions#km2miles(double)
 * @see Conversions#miles2km(double)
 * @see Conversions#celsius2fahrenheit(double)
 * @see Conversions#fahrenheit2celsius(double)
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 */
public class Conversions {

	/**
	 * The factor at which kilometers are less than miles.
	 */
	private static final float KM_TO_MILES_FACTOR = 0.62137f;
	
	/**
	 * Converts the given kilometers into miles.
	 * 
	 * @param x
	 *            The kilometers to be converted.
	 * 
	 * @return The corresponding miles.
	 */
	public static double km2miles(final double x) {
		return x * KM_TO_MILES_FACTOR;
	}

	/**
	 * Converts the given miles into kilometers.
	 * 
	 * @param x
	 *            The miles to be converted.
	 * 
	 * @return The corresponding kilometers.
	 */
	public static double miles2km(final double x) {
		return x / KM_TO_MILES_FACTOR;
	}

	/**
	 * Converts the given temperature in celsius to fahrenheit.
	 * 
	 * @param x
	 *            The temperature in celsius.
	 * 
	 * @return The converted temperature in fahrenheit.
	 */
	public static double celsius2fahrenheit(final double x) {
		return ((x * 9)/5) + 32;
	}

	/**
	 * Converts the given temperature in fahrenheit to celsius.
	 * 
	 * 
	 * @param x
	 *            The temperature in fahrenheit.
	 * 
	 * @return The converted temperature in celsius.
	 */
	public static double fahrenheit2celsius(final double x) {
		return ((x - 32) * 5) / 9;
	}

}
