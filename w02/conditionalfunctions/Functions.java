package conditionalfunctions;

/**
 * Utility class to get commands for the turbine.
 * @see Functions#turbineControl(double)
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Functions {

	/**
	 * The threshold at which {@literal <}, {@literal >} and = are still
	 * tolerated.
	 */
	private static final float THRESHOLD = 0.001f;

	/**
	 * Returns commands for the turbine, dependent on the given frequency.
	 * 
	 * @param f
	 *            The frequency mentioned.
	 * 
	 * @return The command for the turbine.
	 */
	public static String turbineControl(final double f) {

		// return disconnect if the frequency isn't in the bounds of 49 and 51
		if (f <= 49 || f >= 51) {
			return EMessage.DISCONNECT.toString();

		}

		double difference = f - 50;

		if (difference > THRESHOLD) {
			return EMessage.LESS_WATER.toString();

		} else if (difference < -THRESHOLD) {
			return EMessage.MORE_WATER.toString();

		} else {
			return EMessage.STEADY.toString();

		}
	}

}
