package averageroundednumber;

import java.util.Scanner;

/**
 * This class is able to get the average value of {@link Main#NUMBERS_TO_READ}
 * float values read from the Systems input stream. Formatting the result in a
 * way that only 2 decimals are shown.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 */
public class Main {

	/**
	 * An Integer constant holding the value of how many numbers to read from
	 * the Systems input stream.
	 */
	private static final int NUMBERS_TO_READ = 3;

	/**
	 * The main method of this class
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] args) {

		// Creates a new Scanner object reading from the Systems default input
		// stream.
		try (final Scanner scan = new Scanner(System.in)) {

			// The average of the numbers read from the input stream.
			float average = 0;

			// Adds every input given to the value of average.
			for (int i = 0; i < NUMBERS_TO_READ; i++) {
				average += scan.nextFloat();
			}

			// Calculating the average of the current value by dividing by all
			// the
			// numbers added to this value.
			average /= NUMBERS_TO_READ;

			// Prints a formatted float value onto the systems output stream
			// showing
			// 2 decimals.
			System.out.printf("%.2f", Float.valueOf(average));
		}
	}
}
