package formatsi;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

/**
 * Provides JUnit4 Test cases for {@link Format}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class FormatTest {

	/**
	 * Test method for {@link formatsi.Format#formatSI(double, String)}
	 * revealing implementation errors. Numbers aren't always in the format of 3
	 * digits before the decimal point. Basically every negative exponent number
	 * can be of the a format with 4 digits before the decimal point, e.g.
	 * format(1, "g") returns "1000.0mg" instead of "1.0g" which is technically
	 * right, but implementation wise wrong. Continuing format(0.001, "g")
	 * returns "1000.0µg" instead of "1.0mg" Can be fixed by not handling the
	 * case when l is zero with the little letters, but handling it with the big
	 * letters, because they already implemented a fix for their first index.
	 * For any subsequent measure units one has to change the shift variable
	 * accordingly to the new shifting and the letter choosing, so the correct
	 * letter gets displayed with the correct number representation.
	 * 
	 */
	@SuppressWarnings("static-method")
	@Test
	public void formatSIFailing() {
		Assert.assertEquals("1,0g", Format.formatSI(1, "g"));
		Assert.assertEquals("1,0mg", Format.formatSI(0.001, "g"));

	}

	/**
	 * Test method for
	 * {@link formatsi.Format#formatSI(double, java.lang.String)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatSI() {
		Locale.setDefault(new Locale("de", "DE"));
		
		Assert.assertEquals("0.0m", Format.formatSI(0, "m"));
		Assert.assertEquals("1,000E+30s", Format.formatSI(1000000000000000000000000000000f, "s"));
		Assert.assertEquals("1,000E-30s", Format.formatSI(0.000000000000000000000000000001f, "s"));	
		Assert.assertEquals("10,0g", Format.formatSI(10, "g"));
		Assert.assertEquals("10,0mg", Format.formatSI(0.01, "g"));
		Assert.assertEquals("1,0Mm", Format.formatSI(1000000, "m"));
		
	}

}
