package onedgame;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class MainTest {

	/**
	 * Test method for {@link onedgame.Main#isWinnable(int, boolean[])}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testIsWinnable() {
		Assert.assertTrue(Main.isWinnable(3, new boolean[] { false, false, false, true, true, true }));
		//TODO: Remove Debug Print!
		System.out.println();

		Assert.assertFalse(Main.isWinnable(3, new boolean[] { false, false, true, true, true, false }));
		//TODO: Remove Debug Print!
		System.out.println();
		Assert.assertTrue(Main.isWinnable(5, new boolean[] {false, false, true, true, false, false, true, true, true, false}));
		
		//TODO: Remove Debug Print!
		System.out.println();
		Assert.assertFalse(Main.isWinnable(1, new boolean[] {false, false, false, true, true, true}));
		
		Assert.assertFalse(Main.isWinnable(1, new boolean[] {false, true, true, true, false}));
		
	}

}
