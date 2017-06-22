package lineintersection;

import org.junit.Assert;
import org.junit.Test;

/**
 * Provides JUnit test cases for {@link Geometry}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class GeometryTest {

	/**
	 * Test method for
	 * {@link lineintersection.Geometry#lineIntersection(double, double, double, double)}
	 * .
	 */
	@Test
	public void testLineIntersection() {
		Assert.assertTrue(checkIntersection(Geometry.lineIntersection(2, 0, 5, 0), 2, 0, 5, 0, 0.1, 0.1));
		Assert.assertFalse(checkIntersection(Geometry.lineIntersection(2, 0, 2, 1), 2, 0, 2, 1, 0.1, 0.1));

	}

	/**
	 * Checks whether the method
	 * {@link lineintersection.Geometry#lineIntersection(double, double, double, double)}
	 * calculates the correct point by calculating the result aswell and
	 * comparing the two results with each other.
	 * 
	 * @param mResultPoint
	 *            the point of which to check whether its correct with the given
	 *            coordinates.
	 * @param mA1
	 *            component a of first line.
	 * @param mB1
	 *            component b of first line.
	 * @param mA2
	 *            component a of second line.
	 * @param mB2
	 *            component b of second line.
	 * @param mDeltaX
	 *            specifies the margin of when to still accept the given point
	 *            as valid for the x coordinate.
	 * @param mDeltaY
	 *            specifies the margin of when to still accept the given point
	 *            as valid for the y coordinate.
	 * 
	 * @return <tt>True</tt> if the points are equal to each other by the given
	 *         margins, <tt>false</tt> otherwise.
	 */
	@SuppressWarnings("static-method")
	public boolean checkIntersection(final double[] mResultPoint, final double mA1, final double mB1, final double mA2,
			final double mB2, final double mDeltaX, final double mDeltaY) {

		if (mResultPoint == null) {
			return false;

		}

		// calculate the result
		final double[] testResult = Geometry.lineIntersection(mA1, mB1, mA2, mB2);

		// apply the given margin onto them, for a better threshold due to
		// double calculation.
		final double[] thresholdX = { testResult[0] - mDeltaX, testResult[0] + mDeltaX };
		final double[] thresholdY = { testResult[1] - mDeltaY, testResult[1] + mDeltaY };

		// make sure to return true if the real result is within the calculated
		// bounds.
		if ((mResultPoint[0] >= thresholdX[0]) && (mResultPoint[0] <= thresholdX[1])) {
			if ((mResultPoint[1] >= thresholdY[0]) && (mResultPoint[1] <= thresholdY[1])) {
				return true;

			}
		}
		return false;
	}

}
