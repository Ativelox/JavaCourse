package integerprimitives;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is able to read {@link Main#INPUTS_TO_READ} times the systems
 * input stream and check whether the input fits into a byte, short, int or long
 * and prints an appropriate message for each fit or if it doesn't fit into any
 * of the mentioned types.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Main {

	/**
	 * An integer constant holding the value of how many inputs to read from the
	 * systems input stream.
	 */
	private static final int INPUTS_TO_READ = 1;

	/**
	 * @see System#lineSeparator()
	 */
	private static final String SEPERATOR = System.lineSeparator();

	/**
	 * The message to print if the token fits into a byte.
	 */
	private static final String FITS_IN_BYTE = SEPERATOR + "* byte";

	/**
	 * The message to print if the token fits into a short.
	 */
	private static final String FITS_IN_SHORT = SEPERATOR + "* short";

	/**
	 * The message to print if the token fits into an int.
	 */
	private static final String FITS_IN_INT = SEPERATOR + "* int";

	/**
	 * The message to print if the token fits into a long.
	 */
	private static final String FITS_IN_LONG = SEPERATOR + "* long";

	/**
	 * This classes main method.
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] args) {

		// create a new scanner object
		try (final Scanner scan = new Scanner(System.in)) {
			// check for the next token per iteration and save it
			for (int i = 0; i < INPUTS_TO_READ; i++) {

				String inputAsString = "";

				try {
					// the token per iteration as string
					inputAsString = scan.next();

				} catch (NoSuchElementException e) {
					System.out.println('"' + inputAsString + '"' + " doesn't fit anywhere.");
					break;

				}
				try {
					// try to parse the input to a long
					long inputAsLong = Long.parseLong(inputAsString);

					// check whether the input only fits into a long
					if (inputAsLong > Integer.MAX_VALUE || inputAsLong < Integer.MIN_VALUE) {
						System.out.println(inputAsLong + " fits in:" + FITS_IN_LONG);

						// check whether the input fits into an int and above.
					} else if (inputAsLong > Short.MAX_VALUE || inputAsLong < Short.MIN_VALUE) {
						System.out.println(inputAsLong + " fits in:" + FITS_IN_INT + FITS_IN_LONG);

						// check whether the input fits into a short and above.
					} else if (inputAsLong > Byte.MAX_VALUE || inputAsLong < Byte.MIN_VALUE) {
						System.out.println(inputAsLong + " fits in:" + FITS_IN_SHORT + FITS_IN_INT + FITS_IN_LONG);

						// if it doesn't fit anywhere but could be parsed as a
						// long
						// it has to fit everywhere (last case)
					} else {
						System.out.println(
								inputAsLong + " fits in:" + FITS_IN_BYTE + FITS_IN_SHORT + FITS_IN_INT + FITS_IN_LONG);

					}

					// thrown if the token couldn't be parsed to a long, thus it
					// doesn't fit, because long has the highest capacity out of
					// the
					// integer primitives.
				} catch (NumberFormatException e) {
					System.out.println('"' + inputAsString + '"' + " doesn't fit anywhere.");

				}
			}
		}
	}
}
