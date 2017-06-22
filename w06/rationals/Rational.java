package rationals;

/**
 * Provides a class which resembles rational numbers, by having its own
 * nominator and denominator. Thus is able to display numbers more accurate than
 * doubles or floats.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Rational {

	/**
	 * The nominator of this rational
	 */
	private final long nominator;

	/**
	 * The denominator of this rational
	 */
	private final long denominator;

	/**
	 * Represents a rational number by having its own nominator and denominator.
	 * If there are two numbers which are equal but have different
	 * representations, they get normed to a normalized rational number.
	 * 
	 * @param mNominator
	 *            The nominator of this rational.
	 * 
	 * @param mDenominator
	 *            The denominator of this rational.
	 * 
	 * @throws IllegalArgumentException
	 *             if the denominator is 0.
	 * 
	 */
	public Rational(final long mNominator, final long mDenominator) {
		if (mDenominator == 0) {
			throw new IllegalArgumentException("Denominator cannot be 0!");

		}

		// make sure to normalize the given rational if necessary.
		long m = greatestCommonDivisor(mNominator, mDenominator);

		this.nominator = mNominator / m;
		this.denominator = mDenominator / m;

	}

	/**
	 * Adds two rational numbers up.
	 * 
	 * @param mRational
	 *            The rational number which to add to this rational.
	 * 
	 * @return A new rational representing the addition.
	 */
	public Rational add(final Rational mRational) {
		long mDenominator = mRational.getDenominator();
		long mNominator = mRational.getNominator();

		// if both denominators are the same we can just add up the
		// nominators
		// for the new rational.
		if (this.denominator == mDenominator) {
			checkForAdditiveOverflow(this.nominator, mNominator);
			return new Rational(this.nominator + mNominator, this.denominator);

		}

		// calculate the least common multiplier
		long lcm = (this.denominator * mDenominator) / greatestCommonDivisor(this.denominator, mDenominator);

		checkForAdditiveOverflow((this.nominator * (lcm / this.denominator)), (mNominator * (lcm / mDenominator)));

		// calculate the correct rational and return it
		return new Rational((this.nominator * (lcm / this.denominator)) + (mNominator * (lcm / mDenominator)), lcm);

	}

	/**
	 * Multiplies two rational numbers.
	 * 
	 * @param mRational
	 *            The rational number which to multiply to this rational.
	 * 
	 * @return A new rational representing the multiplication.
	 */
	public Rational multiply(final Rational mRational) {
		long thisReducedNominator = this.getNominator();
		long thisReducedDenominator = this.getDenominator();

		long callerReducedNominator = mRational.getNominator();
		long callerReducedDenominator = mRational.getDenominator();

		final long firstGCD = Rational.greatestCommonDivisor(this.nominator, mRational.getDenominator());

		// make sure to reduce the fractions before multiplying them to prevent
		// possible overflows.
		if (firstGCD <= this.nominator && firstGCD <= mRational.getDenominator()) {
			thisReducedNominator = this.getNominator() / firstGCD;
			callerReducedDenominator = mRational.getDenominator() / firstGCD;

		}

		final long secondGCD = Rational.greatestCommonDivisor(this.denominator, mRational.getNominator());

		if (secondGCD <= this.denominator && secondGCD <= mRational.getNominator()) {
			thisReducedDenominator = this.getDenominator() / secondGCD;
			callerReducedNominator = mRational.getNominator() / secondGCD;

		}

		checkForMultiplicativeOverflow(thisReducedNominator, callerReducedNominator);
		checkForMultiplicativeOverflow(thisReducedDenominator, callerReducedDenominator);

		return new Rational(thisReducedNominator * callerReducedNominator, thisReducedDenominator * callerReducedDenominator);

	}

	/**
	 * Gets the inverse element to this rational object.
	 * 
	 * @return The mentioned inverse element.
	 */
	public Rational invert() {
		return new Rational(this.denominator, this.nominator);

	}

	/**
	 * Returns this rational as a double value.
	 * 
	 * @return The mentioned value.
	 */
	public double toDouble() {
		return (double) this.nominator / this.denominator;

	}

	/**
	 * Gets the nominator of this rational number.
	 * 
	 * @return The nominator.
	 */
	public long getNominator() {
		return this.nominator;

	}

	/**
	 * Gets the denominator of this rational number.
	 * 
	 * @return The denominator.
	 */
	public long getDenominator() {
		return this.denominator;

	}

	/**
	 * Calculates the greatest common divisor of the two given numbers by
	 * utilizing the euclidean algorithm.
	 * 
	 * @param mFirstNum
	 *            The first number of which to get the gcd from.
	 * @param mSecondNum
	 *            The second number of which to get the gcd from.
	 * 
	 * @return The greatest common divisor of the two numbers mentioned.
	 */
	public static long greatestCommonDivisor(final long mFirstNum, final long mSecondNum) {
		long h = 0;
		long n = mFirstNum;
		long m = mSecondNum;

		while (n != 0) {
			h = m % n;
			m = n;
			n = h;

		}

		return m;
	}

	/**
	 * Checks for an multiplicative overflow between the two given numbers. If
	 * one occurs, throws {@link ArithmeticException}.
	 * 
	 * @param mFirstNumber
	 *            The first number
	 * @param mSecondNumber
	 *            The second number
	 * 
	 * @throws ArithmeticException
	 *             if an overflow occured while multiplying both numbers.
	 */
	public static void checkForMultiplicativeOverflow(final long mFirstNumber, final long mSecondNumber)
			throws ArithmeticException {

		long maximum = 0;

		if (Long.signum(mFirstNumber) == Long.signum(mSecondNumber)) {
			maximum = Long.MAX_VALUE;

		} else {
			maximum = Long.MIN_VALUE;

		}

		if (mFirstNumber != 0 && (mSecondNumber > 0 && mSecondNumber > maximum / mFirstNumber
				|| mSecondNumber < 0 && mSecondNumber < maximum / mFirstNumber)) {
			throw new ArithmeticException();
		}

	}

	/**
	 * Checks for an additive overflow between the two given numbers. If one
	 * occurs, throws {@link ArithmeticException}.
	 * 
	 * @param mFirstNumber
	 *            The first number
	 * @param mSecondNumber
	 *            The second number
	 * 
	 * @throws ArithmeticException
	 *             if an overflow occured while adding both numbers.
	 */
	public static void checkForAdditiveOverflow(final long mFirstNumber, final long mSecondNumber)
			throws ArithmeticException {

		long maximum = 0;

		if (Long.signum(mFirstNumber) == Long.signum(mSecondNumber)) {
			if (Long.signum(mFirstNumber) == 1) {
				maximum = Long.MAX_VALUE;

			} else {
				maximum = Long.MIN_VALUE;

			}
		} else {
			return;

		}

		if (mFirstNumber != 0 && (mSecondNumber > 0 && mSecondNumber > maximum - mFirstNumber
				|| mSecondNumber < 0 && mSecondNumber < maximum - mFirstNumber)) {
			throw new ArithmeticException();
		}

	}

	@Override
	public String toString() {
		return this.nominator + "/" + this.denominator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.denominator ^ (this.denominator >>> 32));
		result = prime * result + (int) (this.nominator ^ (this.nominator >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		if (this.denominator != other.denominator)
			return false;
		if (this.nominator != other.nominator)
			return false;
		return true;
	}

}
