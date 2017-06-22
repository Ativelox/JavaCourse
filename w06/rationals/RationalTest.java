package rationals;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class RationalTest {

	private static final double ACCURACY = 1e-5;

	/**
	 * Test method for {@link rationals.Rational#add(rationals.Rational)}.
	 */
	@SuppressWarnings("static-method")
	@Test(expected = ArithmeticException.class)
	public void testAddTooBig() {
		Rational r1 = new Rational(9223372036854775805l, 1);
		Rational r2 = new Rational(9223372036854775728l, 1);

		r1.add(r2);
	}

	/**
	 * Test method for {@link rationals.Rational#multiply(rationals.Rational)}.
	 */
	@SuppressWarnings("static-method")
	@Test(expected = ArithmeticException.class)
	public void testMultiplyTooBig() {
		Rational r1 = new Rational(923232942074204202l, 1);
		Rational r2 = new Rational(2309481094821904l, 1);

		r1.multiply(r2);

	}

	/**
	 * Test method for {@link rationals.Rational#add(rationals.Rational)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testAdd() {
		Rational r1 = new Rational(1000000000000l, 1);
		Rational r2 = new Rational(1, 2);

		Assert.assertEquals(new Rational(2000000000001l, 2), r1.add(r2));

		r1 = new Rational(10, 2);
		r2 = new Rational(20, 2);

		Assert.assertEquals(new Rational(30, 2), r1.add(r2));

		r1 = new Rational(9223372036854775805l, 1);
		r2 = new Rational(9223372036854775728l, 1);
	}

	/**
	 * Test method for {@link rationals.Rational#multiply(rationals.Rational)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMultiply() {
		Rational r1 = new Rational(5, 3);
		Rational r2 = new Rational(2, 6);

		Assert.assertEquals(new Rational(10, 18), r1.multiply(r2));

		r1 = new Rational(1, 1);
		r2 = new Rational(1, 1);

		Assert.assertEquals(new Rational(1, 1), r1.multiply(r2));
		
		r1 = new Rational(9223372036854775786l, 1);
		r2 = new Rational(2, 4611686018427387893l);
		
		Assert.assertEquals(new Rational(4, 1), r1.multiply(r2));

	}

	/**
	 * Test method for {@link rationals.Rational#invert()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testInvert() {
		Rational r1 = new Rational(1, 5);

		Assert.assertEquals(new Rational(5, 1), r1.invert());

		r1 = new Rational(1, 1);

		Assert.assertEquals(new Rational(1, 1), r1.invert());
	}

	/**
	 * Test method for {@link rationals.Rational#toDouble()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testToDouble() {
		Rational r1 = new Rational(5, 3);
		Assert.assertEquals(1.666666f, r1.toDouble(), ACCURACY);

		r1 = new Rational(1, 10);
		Assert.assertEquals(0.1f, r1.toDouble(), ACCURACY);

		r1 = new Rational(1, 1);
		Assert.assertEquals(1f, r1.toDouble(), ACCURACY);
	}

	/**
	 * Test method for {@link rationals.Rational#getNominator()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testGetNominator() {
		Rational r1 = new Rational(5, 3);
		Assert.assertEquals(5, r1.getNominator());

		r1 = new Rational(125, 23);
		Assert.assertEquals(125, r1.getNominator());

		r1 = new Rational(2, 4);
		Assert.assertEquals(1, r1.getNominator());
	}

	/**
	 * Test method for {@link rationals.Rational#getDenominator()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testGetDenominator() {
		Rational r1 = new Rational(5, 3);
		Assert.assertEquals(3, r1.getDenominator());

		r1 = new Rational(125, 23);
		Assert.assertEquals(23, r1.getDenominator());

		r1 = new Rational(2, 4);
		Assert.assertEquals(2, r1.getDenominator());
	}

	/**
	 * Test method for
	 * {@link rationals.Rational#greatestCommonDivisor(long, long)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testGreatestCommonDivisor() {
		Assert.assertEquals(2, Rational.greatestCommonDivisor(2, 4));
		Assert.assertEquals(1, Rational.greatestCommonDivisor(5, 6));
		Assert.assertEquals(4, Rational.greatestCommonDivisor(16, 4));
	}

	/**
	 * Test method for {@link rationals.Rational#equals(java.lang.Object)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testEqualsObject() {
		Rational r1 = new Rational(2, 4);
		Rational r2 = new Rational(1, 2);

		Assert.assertTrue(r1.equals(r2));

		r1 = new Rational(2, 5);

		Assert.assertFalse(r1.equals(r2));

		r2 = new Rational(2, 5);

		Assert.assertTrue(r1.equals(r2));
	}

	@SuppressWarnings({ "unused", "static-method" })
	@Test(expected = IllegalArgumentException.class)
	public void testThrowingWithDenominatorZero() {
		new Rational(1, 0);

	}
}
