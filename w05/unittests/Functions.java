package unittests;

import static unittests.Util.log;

/**
 * Some functions whose result depends on conditionals.
 */
public class Functions {

	/**
	 * Returns the turbine command that is appropiate for the given frequency.
	 *
	 * @param f
	 *            The frequency.
	 * @return The command.
	 */
	public static String turbineControl(double f) {
		String res = "";
		if (f <= 49.0 || f >= 51.0) {
			log("turbineControl:DISCONNECT:" + (f <= 49));
			res = "DISCONNECT";
		} else if (Math.abs(f - 50) < 0.001) {
			log("turbineControl:STEADY");
			res = "STEADY";
		} else if (f < 50.0) {
			log("turbineControl:MORE_WATER");
			res = "MORE_WATER";
		} else if (f > 50.0) {
			log("turbineControl:LESS_WATER");
			res = "LESS_WATER";
		}
		return res;
	}
}
