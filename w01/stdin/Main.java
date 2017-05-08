package stdin;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class is able to read {@link Main#NUMBERS_TO_READ} Integer values of the
 * Systems input stream and printing them to the Systems default output stream.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 */
public class Main {

	/**
	 * A constant holding the number of how many inputs to read from the stream
	 * until terminating.
	 */
	private static final int NUMBERS_TO_READ = 3;

	/**
	 * Main method of this class.
	 * 
	 * @param args
	 *            The command-line arguments
	 */
	public static void main(String[] args) {

		// Create a new scanner object on the systems input stream.
		try (Scanner scan = new Scanner(System.in)) {

			// A List holding the inputs of the user as Integer values.
			LinkedList<Integer> inputs = new LinkedList<>();

			// Add the Integer values of the stream to a list. As many as stated
			// in
			// NUMBERS_TO_READ.
			for (int i = 0; i < NUMBERS_TO_READ; i++) {
				inputs.add(Integer.valueOf(scan.nextInt()));
			}

			// Print all the inputs gathered in the list onto the systems
			// output stream.
			for (int entry : inputs) {
				System.out.println(entry);

			}
		}
	}
}
