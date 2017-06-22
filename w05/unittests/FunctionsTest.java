package unittests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Provides JUnit test cases for the class {@link Functions}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class FunctionsTest {

	/**
	 * Test method for {@link unittests.Functions#turbineControl(double)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testTurbineControl() {
		final int disconnectValues[] = { 49, 51, 20, 60 };
		final double moreWaterValues[] = { 49.5, 49.9, 49.2 };
		final double lessWaterValues[] = { 50.5, 50.1, 50.2 };
		final double steadyValues[] = { 49.999, 50.001, 50.00001, 49.99999 };

		for (int i = 0; i < disconnectValues.length; i++) {
			Assert.assertEquals("DISCONNECT", Functions.turbineControl(disconnectValues[i]));

		}

		for (int i = 0; i < moreWaterValues.length; i++) {
			Assert.assertEquals("MORE_WATER", Functions.turbineControl(moreWaterValues[i]));

		}

		for (int i = 0; i < lessWaterValues.length; i++) {
			Assert.assertEquals("LESS_WATER", Functions.turbineControl(lessWaterValues[i]));

		}

		for (int i = 0; i < steadyValues.length; i++) {
			Assert.assertEquals("STEADY", Functions.turbineControl(steadyValues[i]));

		}

	}

}
