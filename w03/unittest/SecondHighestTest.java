package unittest;

import org.junit.Assert;

import org.junit.Test;

import secondhighest.Main;

/**
 * Provides JUnitTests to check the validity of the secondHighest method.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 * @see Main#secondHighest(int[])
 */
public class SecondHighestTest {

	/**
	 * Checks the validity of {@link Main#secondHighest(int[])}
	 */
	@SuppressWarnings("static-method")
	@Test
	public void secondHighestTest() {
		Assert.assertEquals(5, Main.secondHighest(new int[] { 1, 5, 2, 2, 4, 8 }));

		Assert.assertEquals(1, Main.secondHighest(new int[] { 1, 6 }));

		Assert.assertEquals(1, Main.secondHighest(new int[] { 1 }));

		Assert.assertEquals(Integer.MIN_VALUE, Main.secondHighest(new int[] {}));

	}

}
