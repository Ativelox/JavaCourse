package secondhighest;

/**
 * Utility class which provides a function to calculate the second highest
 * Integer value in an array.
 * 
 * @see Main#secondHighest(int[])
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Main {

	/**
	 * Calculates the second highest number in the given array in O(n). Iterates
	 * over every element in the list once. If the array only contains one
	 * element returns that element. Also returns {@link Integer#MIN_VALUE} if
	 * the the array is empty.
	 * 
	 * @param mNumbers
	 *            The array to get the second highest value of.
	 * @return The second highest number mentioned.
	 */
	public static int secondHighest(final int[] mNumbers) {

		// if the array is empty or only has one element, return the minimum value an integer can hold,
		// as expected.
		if (mNumbers.length <= 1) {
			return Integer.MIN_VALUE;
		}

		// holds the greatest number up to the iteration it is at.
		int greatestNumber = Integer.MIN_VALUE;

		// holds the second greatest number up to the iteration is is at.
		int secondGreatestNumber = Integer.MIN_VALUE;

		// iterates over the array and sets the greatest and second greatest
		// numbers accordingly
		for (int i = 0; i < mNumbers.length; i++) {

			// the current iterations number in the array
			final int currentNumber = mNumbers[i];

			// if the greatest value is less than the current iterations number
			// set it as the new greatest number and set the second greatest
			// number as the last greatest number
			if (greatestNumber < currentNumber) {
				secondGreatestNumber = greatestNumber;
				greatestNumber = currentNumber;

			}

			// happens if greatest number already holds the greatest value there
			// is in the array, second greatest number is not always the second
			// greatest number then. Set it accordingly.
			if ((currentNumber < greatestNumber) && (currentNumber > secondGreatestNumber)) {
				secondGreatestNumber = currentNumber;
			}

		}

		// Finally return the second greatest number
		return secondGreatestNumber;
	}

}
