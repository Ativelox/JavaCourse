package unittest;

import org.junit.Assert;

import org.junit.Test;

import caesarcipher.Main;

/**
 * Provides JUnitTests to check the encoding of the caesar cipher.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 * 
 * @see Main#encode(String, int)
 *
 */
public class CaesarCipherTest {

	/**
	 * Testing encoding method for the caesar cipher.
	 * 
	 * @see Main#encode(String, int)
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testEncode() {
		Assert.assertEquals("okffng-Qwvb", Main.encode("middle-Outz", 2));

		Assert.assertEquals("cDeF", Main.encode("xYzA", 5));

		Assert.assertEquals("", Main.encode("", 0));

		Assert.assertEquals("asdadpg", Main.encode("asdadpg", -1));

		Assert.assertEquals("+\\&%/264", Main.encode("+\\&%/264", 24));

		Assert.assertEquals("abcDEFGhij", Main.encode("abcDEFGhij", 26));
		
		Assert.assertEquals("bcdEFGHijk", Main.encode("abcDEFGhij", 27));
		
		Assert.assertEquals("abcDEFGhij", Main.encode("abcDEFGhij", 52));
		
		Assert.assertEquals("ajynulp", Main.encode("encrypt", 256));
	}
}
