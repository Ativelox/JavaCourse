package inttostring;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is able to read {@link Main#INPUTS_TO_READ} times the systems
 * input stream and detect whether the input is an integer or not, printing an
 * appropriate message to the systems output stream.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 */
public class Main {

	/**
	 * An integer constant holding the amount of times to read from the systems
	 * input stream.
	 */
	private static final int INPUTS_TO_READ = 1;

	/**
	 * This classes main method.
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] args) {

		// create a new scanner object
		try (final Scanner scan = new Scanner(System.in)) {
			// reads per iteration the next token and tries to parse it to an
			// integer,
			// if the token isn't an integer print appropriate message
			for (int i = 0; i < INPUTS_TO_READ; i++) {
				String inputAsString = "";
				try {
					inputAsString = scan.next();

				} catch (NoSuchElementException e) {
					System.out.println("No int");
					break;

				}
				try {
					int inputAsInt = Integer.parseInt(inputAsString);
					System.out.println("Found int: " + inputAsInt);

				} catch (NumberFormatException e) {
					System.out.println("No int");

				}
			}
		}
	}
}
