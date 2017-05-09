package unittest;

import org.junit.Assert;

import org.junit.Test;

import maximumhourglass.Main;

/**
 * Provides JUnitTests to check the validity of the maxHourglass method.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 * 
 * @see Main#maxHourglass(int[][])
 *
 */
public class MaximumHourglassTest {

	/**
	 * Checks the method {@link Main#maxHourglass(int[][])}}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMaxHourglass() {
		
		Assert.assertEquals(21, Main.maxHourglass(new int[][]{
													{3, 3, 3, 2, 2, 2},
													{2, 3, 2, 2, 2, 2},
													{3, 3, 3, 2, 2, 2},
													{2, 2, 2, 2, 2, 2},
													{2, 2, 2, 2, 2, 2},
													{2, 2, 2, 2, 2, 2},
																	}));
	}

}
