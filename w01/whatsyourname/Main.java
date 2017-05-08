package whatsyourname;

import java.util.Scanner;

/**
 * This class is able to read a name (first and last name) from the Systems
 * input stream and printing a "welcome message" onto the Systems output stream.
 * Can read {@link Main#AMOUNT_OF_NAMES} names from the Input Stream.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Main {

	/**
	 * An Integer constant holding the value of how many names to read from the
	 * Systems input stream.
	 */
	private static final int AMOUNT_OF_NAMES = 1;

	/**
	 * The main method of this class.
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(String[] args) {

		// Creates a new Scanner object on the Systems default input stream.
		try (Scanner scan = new Scanner(System.in)) {

			// Prints all the names written onto the systems input stream
			// considering the limit at AMOUNT_OF_NAMES.
			for (int i = 0; i < AMOUNT_OF_NAMES; i++) {

				// The first name of the current full name.
				String firstName = scan.next();

				// The last name of the current full name.
				String lastName = scan.next();

				// Prints the first line in the given format.
				System.out.println("Hello " + firstName + "! You just delved into Java.");

				// Prints the second line in the given format.
				System.out.println("Your full name: " + firstName + " " + lastName + ".");
			}
		}
	}
}
