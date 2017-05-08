package linenumbers;

import java.util.Scanner;

/**
 * Reads from the systems input stream and prints the result to the systems
 * output stream and adds the row number at the beginning. The output can be
 * modified with the command-line arguments as follows: [start-number
 * [end-number]], where the numbers indicate the row numbers.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Main {

	/**
	 * The main method of this class.
	 * 
	 * @param args
	 *            The command-line arguments
	 */
	public static void main(final String[] args) {

		// try resource for efficiency
		try (final Scanner scan = new Scanner(System.in)) {

			// holds the value from what row to start printing the rows
			// throughout this method.
			long n = 1;

			// holds the value up to which row to print rows throughout this
			// method.
			long m = -1;

			// check for command-line arguments.
			if (args.length >= 1) {
				try {
					n = Long.parseLong(args[0]);

					if (args.length == 2) {
						m = Long.parseLong(args[1]);

					}

				} catch (NumberFormatException e) {
					System.out.println("Bad arguments." + System.lineSeparator()
							+ "Usage: line-numbers [start-number [end-number]]");

					System.exit(0);

				}
			}

			// ask the user how many rows to read so the scanner can stop
			// reading input after the given number of rows.
			System.out.println("How many rows to read?");

			// the number of rows to read
			final int numberOfRows = scan.nextInt();

			// set the cursor of the buffer to the start of the next line.
			scan.nextLine();

			// the string builder used to create the string needed. Way more
			// efficient for big inputs.
			StringBuilder builder = new StringBuilder();

			int i = 0;

			// iterate over every row and add the row number to the left hand
			// side of each row.
			for (i = 0; i < numberOfRows; i++) {
				builder.append((i + 1) + " " + scan.nextLine() + System.lineSeparator());

			}

			// if m didn't get assigned through the command line arguments set
			// it to the last row, so everything gets printed.
			if (m < 0) {
				m = i;

			}

			// if there are less rows than should be displayer or (m - n) is
			// negative don't do anything.
			if (i < n || m < n) {
				return;

			}

			// get the built string and assign it.
			String tempResult = builder.toString();

			// re-initialize the builder so it can be used again.
			builder = new StringBuilder();

			// iterate over the rows and append the appropriate rows to the new
			// builder object.
			for (String row : tempResult.split(System.lineSeparator())) {
				if (Character.getNumericValue(row.charAt(0)) >= n && Character.getNumericValue(row.charAt(0)) <= m) {
					builder.append(row + System.lineSeparator());

				}

			}
			// finally print the new built string.
			System.out.println(builder.toString());

		}
	}
}
