package unittest;

import org.junit.Assert;

import org.junit.Test;

import caesarcipher.Main;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class CaesarCipherTest {

	@SuppressWarnings("static-method")
	@Test
	public void testEncode() {
		Assert.assertEquals("okffng-Qwvb", Main.encode("middle-Outz", 2));

		Assert.assertEquals("cDeF", Main.encode("xYzA", 5));

		Assert.assertEquals("", Main.encode("", 0));

		Assert.assertEquals("asdadpg", Main.encode("asdadpg", -1));

		Assert.assertEquals("+\\&%/264", Main.encode("+\\&%/264", 24));

		Assert.assertEquals("abcDEFGhij", Main.encode("abcDEFGhij", 26));

	}
}
