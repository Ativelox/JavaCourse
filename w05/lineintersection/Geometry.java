package lineintersection;

import static lineintersection.Util.log;

/**
 * Some functions whose result depends on conditionals.
 */
public class Geometry {

	/**
	 * Calculate the intersection of two lines. Lines are given by the parameter
	 * to their linear equations (y = ax+b).
	 *
	 * @param a1
	 *            Component a of first line
	 * @param b1
	 *            Component b of first line
	 * @param a2
	 *            Component a of second line
	 * @param b2
	 *            Component b of second line
	 * 
	 * @return An array of length 2 with the x and y coordinates of the
	 *         intersection point, or null if no intersection exists (i.e., the
	 *         lines are parallel)
	 */
	public static double[] lineIntersection(double a1, double b1, double a2, double b2) {
		if (a1 == a2) {
			log("lineIntersection:parallel");
			return null;
		}

		log("lineIntersection:intersect");
		double xResult = (b2 - b1) / (a1 - a2);
		double[] res = new double[] { xResult, a1 * xResult + b1 };
		return res;
	}

}
