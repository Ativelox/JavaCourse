package weirdnumbers;

import java.util.Scanner;

/**
 * This class is able read {@link Main#INPUTS_TO_READ} times the systems input
 * stream and determines whether the number is weird or not and is printing the
 * appropriate message onto the systems output stream. See
 * {@link Main#WEIRD_MESSAGE} and {@link Main#NOT_WEIRD_MESSAGE}. Whether a
 * number is weird or not is determined as follows: <br>
 * <br>
 * The number is odd -> weird. <br>
 * The number is even and in the bounds of 2 and 5 -> not weird. <br>
 * The number is even and in the bounds of 6 and 20 -> weird. <br>
 * The number is even and bigger than 20 -> not weird. <br>
 * In every other case a number is weird when it's negative.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Main {

	/**
	 * An integer constant holding the value of how many times to read from the
	 * systems input stream.
	 */
	private static final int INPUTS_TO_READ = 1;

	/**
	 * The message printed if the number is weird.
	 */
	private static final String WEIRD_MESSAGE = "Weird";

	/**
	 * The message printed if the number isn't weird.
	 */
	private static final String NOT_WEIRD_MESSAGE = "Not Weird";

	/**
	 * The main method of this class
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] args) {

		// create a new scanner object
		try (final Scanner scan = new Scanner(System.in)) {

			// read the next token per iteration and save it
			for (int i = 0; i < INPUTS_TO_READ; i++) {

				// the next token read
				String input = scan.next();

				try {
					// try parsing the input to an integer
					int inputAsInt = Integer.parseInt(input);

					// the number is even
					if (inputAsInt % 2 == 0) {

						if ((inputAsInt >= 2) && (inputAsInt <= 5)) {
							System.out.println(NOT_WEIRD_MESSAGE);

						} else if ((inputAsInt >= 6) && (inputAsInt <= 20)) {
							System.out.println(WEIRD_MESSAGE);

						} else if (inputAsInt > 20) {
							System.out.println(NOT_WEIRD_MESSAGE);

						} else {
							if (inputAsInt < 0) {
								System.out.println(WEIRD_MESSAGE);

							} else {
								System.out.println(NOT_WEIRD_MESSAGE);

							}
						}

						// the number is odd
					} else if (inputAsInt % 2 != 0) {
						System.out.println(WEIRD_MESSAGE);

					}
					// thrown if the input couldn't be parsed to an integer
				} catch (NumberFormatException e) {
					System.err.println("Input couldn't be parsed to an integer value.");
				}
			}
		}
	}
}
