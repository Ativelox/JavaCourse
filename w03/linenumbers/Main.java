package linenumbers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static void main(String[] args) {

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

					return;

				}
			}

			// the string builder used to create the string needed. Way more
			// efficient for big inputs.
			StringBuilder builder = new StringBuilder();

			int i = 0;

			// iterate over all the scanner inputs and add it to a string. get
			// out of loop by sending an EOF token
			while (scan.hasNextLine()) {
				builder.append((i + 1) + " " + scan.nextLine() + System.lineSeparator());
				i++;
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

			// the regex pattern used to identify correct row-patterns.
			Pattern pattern = Pattern.compile("^(\\d+)\\s.*$");

			// iterate over the rows and append the appropriate rows to the new
			// builder object.
			for (String row : tempResult.split(System.lineSeparator())) {

				// the matcher object trying to match the given regex pattern
				// onto the current row.
				Matcher matcher = pattern.matcher(row);

				// if the regex doesn't apply to the row, continue with the next
				// iteration
				if (!matcher.matches()) {
					continue;

				}

				// holds the value of the row number of the current row.
				final int rowNumber = Integer.parseInt(matcher.group(1));

				// make sure to only display rows which are in the given bounds.
				if (rowNumber >= n && rowNumber <= m) {
					builder.append(row + System.lineSeparator());

				}
			}
			// finally print the new built string.
			System.out.println(builder.toString());

		}
	}
}
