package addtwoints;

import java.util.Scanner;

/**
 * This class is able to sum {@link Main#NUMBERS_TO_SUM} Integer values up,
 * reading them from the Systems input stream and printing the result onto the
 * Systems output stream.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Main {

	/**
	 * An Integer value constant holding the value of how many numbers to sum
	 * up.
	 */
	private static final int NUMBERS_TO_SUM = 2;

	/**
	 * Main method of this class.
	 * 
	 * @param args
	 *            The command-line arguments
	 */
	public static void main(String[] args) {

		// Creates a new Scanner object reading from the Systems default input
		// stream.
		try (final Scanner scan = new Scanner(System.in)) {

			// The result of the addition.
			int result = 0;

			// Sums NUMBERS_TO_SUM times the numbers from the input stream up.
			for (int i = 0; i < NUMBERS_TO_SUM; i++) {
				// Adds the current iterations value of the scanner to the value
				// of
				// result.
				result += scan.nextInt();

			}

			// Printing the result calculated.
			System.out.println(result);

		}
	}
}
