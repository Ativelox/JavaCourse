package maximumhourglass;

/**
 * Provides a utility function to calculate sums of hourglass forms in matrices.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 * 
 * @see Main#maxHourglass(int[][])
 *
 */
public class Main {

	/**
	 * Holds the value of the height an hourglass has.
	 */
	private static final int HOURGLASS_HEIGHT = 3;

	/**
	 * Holds the value of the width an hourglass has.
	 */
	private static final int HOURGLASS_WIDTH = 3;

	/**
	 * Holds the size of each dimension the matrix has.
	 */
	public static final int MATRIX_SIZE = 6;

	/**
	 * Returns the hourglass with the highest sum of its components. The array
	 * given has to have the Size as in {@link Main#MATRIX_SIZE}. Be the
	 * following interpreted as matrix:<br>
	 * <br>
	 * 1 1 1 0<br>
	 * 0 1 0 1<br>
	 * 1 0 1 0<br>
	 * 0 0 0 0<br>
	 * <br>
	 * then the hourglass with the highest sum would be the following part: <br>
	 * <br>
	 * 1 1 1<br>
	 * &nbsp&nbsp 1 <br>
	 * 1 0 1<br>
	 * <br>
	 * So the returned value would be 1 + 1 + 1 + 1 + 1 + 0 + 1 = 6.
	 * 
	 * 
	 * @param mMatrix
	 *            The matrix of which to get the highest sum hourglass.
	 * @return The sum calculated.
	 */
	public static int maxHourglass(final int[][] mMatrix) {

		// the number of times we have to shift the hourglass to the right in
		// the matrix, given we start from the top left of the matrix.
		final int length_iterations = MATRIX_SIZE - HOURGLASS_WIDTH + 1;

		// the number of times we have to shift the hourglass to the bottom in
		// th matrix, given we start from the top left of the matrix.
		final int height_iterations = MATRIX_SIZE - HOURGLASS_HEIGHT + 1;

		// holds per iteration the highest sum yet calculated.
		int resultSum = 0;

		// start shifting the hourglass pattern per iteration by 1 position to
		// the right, starting at a xshift of 0.
		for (int x = 0; x < length_iterations; x++) {

			// start shifting the hourglass pattern per iteration by 1 position
			// to the bottom, starting at a yshift of 0.
			for (int y = 0; y < height_iterations; y++) {
				// holds the temporary sum calculated of the current hourglass
				// pattern, resets every shift.
				int tempSum = 0;

				// calculate the sum of the hourglass pattern.
				tempSum += mMatrix[x][y];
				tempSum += mMatrix[x][y + 1];
				tempSum += mMatrix[x][y + 2];
				tempSum += mMatrix[x + 1][y + 1];
				tempSum += mMatrix[x + 2][y];
				tempSum += mMatrix[x + 2][y + 1];
				tempSum += mMatrix[x + 2][y + 2];

				// if the current iterations hourglass sum is greater than the
				// final hourglass sum, assign it accordingly.
				if (tempSum > resultSum) {
					resultSum = tempSum;

				}
			}
		}
		// finally return the greatest hourglass sum.
		return resultSum;

	}
}
