package subsequence;

import org.junit.Assert;
import org.junit.Test;

import subsequence.Main;
import subsequence.PartialOrdering;

/**
 * Provides JUnit4 Test cases for {@link subsequence.Main}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class MainTest {

	/**
	 * Test method for
	 * {@link subsequence.Main#subsequenceCompare(java.lang.String, java.lang.String)}
	 * .
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testSubsequenceCompare() {
		Assert.assertEquals(PartialOrdering.EQUAL, Main.subsequenceCompare("Hello World", "Hello World"));
		Assert.assertEquals(PartialOrdering.INCOMPARABLE, Main.subsequenceCompare("Hello World", "World Hello"));
		Assert.assertEquals(PartialOrdering.INCOMPARABLE, Main.subsequenceCompare("World Hello", "Hello World"));
		Assert.assertEquals(PartialOrdering.INCOMPARABLE, Main.subsequenceCompare("abx", "aby"));
		Assert.assertEquals(PartialOrdering.LESS, Main.subsequenceCompare("i m ls", "i am less"));
		Assert.assertEquals(PartialOrdering.GREATER,
				Main.subsequenceCompare("I'm definitely greater than him dude!", "i lie!"));

		Assert.assertEquals(PartialOrdering.INCOMPARABLE,
				Main.subsequenceCompare("out of context", "nice weather today"));
		
		Assert.assertEquals(PartialOrdering.LESS, Main.subsequenceCompare("", "any string"));
		Assert.assertEquals(PartialOrdering.INCOMPARABLE, Main.subsequenceCompare("\"\"", "any string"));
	}
}
