package phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads names and numbers in a specified pattern from stdin and saves them.
 * Identifies every name with a number, like a phonebook.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Main {

	/**
	 * The regex used to check if the input when adding entries is valid
	 */
	private static final String PHONEBOOK_ENTRY_PATTERN = "^([a-zA-Z]+)\\s?([a-zA-Z]+)?\\s([0-9]+)$";

	/**
	 * The regex used to check if the input when asking for names is valid
	 */
	private static final String PHONEBOOK_ACCESS_PATTERN = "^([a-zA-Z]+)\\s?([a-zA-Z]+)?$";

	/**
	 * The message written when a parsing error occured.
	 */
	private static final String PARSING_ERROR_MESSAGE = "Error: cannot parse phone book.";

	/**
	 * The message written when an overwriting error occured.
	 */
	private static final String OVERWRITING_ERROR_MESSAGE = "Warning: overwriting entry for: ";

	/**
	 * The message written when a name couldn't be found.
	 */
	private static final String NAME_NOT_FOUND_ERROR_MESSAGE = "Not found: ";

	/**
	 * The message written when the given name isn't a name.
	 */
	private static final String NOT_A_NAME_ERROR_MESSAGE = "Not a name: ";

	/**
	 * This classes main method
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static final void main(final String[] args) {

		// the pattern used to identify valid entry inputs
		final Pattern entryPattern = Pattern.compile(PHONEBOOK_ENTRY_PATTERN);

		// the pattern used to identify valid name inputs
		final Pattern accessPattern = Pattern.compile(PHONEBOOK_ACCESS_PATTERN);

		try (final Scanner scan = new Scanner(System.in)) {

			// determining whether the first token is a number or not
			boolean isFirstNumber = true;

			// the number of entries in the phonebook
			final int phonebookEntries = scan.nextInt();

			// a hashmap representing the phonebook
			final Map<String, String> phonebook = new HashMap<>();

			// loop counter for adding entries to the phonebook
			int i = 0;

			while (i < phonebookEntries) {

				// get the input of the user
				String input = scan.next().trim();

				// very bad approach, but does its job, checks whether the input
				// can be parsed as integer if it cant, set the flag to false,
				// so the code normally continues, otherwise return, because a
				// phonebook entry beginning with a number cant be parsed
				try {
					Integer.parseInt(input);

				} catch (NumberFormatException e) {
					isFirstNumber = false;

				}

				// if string contains 4 or more entries it cannot be parsed
				if (input.split("\\s").length >= 4 || isFirstNumber) {
					System.out.println(PARSING_ERROR_MESSAGE);
					return;

				}

				// match the input to the given regex
				Matcher matcher = entryPattern.matcher(input);

				int k = 0;

				// try to make the matcher match, by reading the next 2 lines
				while (!matcher.matches() && k < 2) {

					// add the next line to the current input
					input += " " + scan.next().trim();

					// match the new string to the regex
					matcher = entryPattern.matcher(input);
					k++;

				}

				// if the input now matches do the entry add logic
				if (matcher.matches()) {
					final String firstName = matcher.group(1);
					final String secondName = matcher.group(2);
					final String number = matcher.group(3);

					String name = null;

					// second name is null if the capture group couldn't
					// identify it.
					if (secondName != null) {
						name = firstName + " " + secondName;

					} else {
						name = firstName;

					}

					// print the appropriate message if the phonebook already
					// contains the name
					if (phonebook.containsKey(name)) {
						System.out.println(OVERWRITING_ERROR_MESSAGE + name);

					}
					phonebook.put(name, number);

					// if the input does not match, there was a parsing error.
				} else {
					System.out.println(PARSING_ERROR_MESSAGE);
					return;

				}

				// finally increment the counter (one entry added)
				i++;
			}

			// advance the scanner to the next line so the while loop returns
			// fast if a EOF token gets sent here.
			scan.nextLine();

			// now check for name inputs, to ask for their number
			while (scan.hasNextLine() && i > 0) {
				String input = "";
				
				try{
					input = scan.nextLine().trim();
	
					// make sure to ignore whitespace only lines.
					while (input.length() <= 0) {
						input = scan.nextLine().trim();
	
					}
					
				} catch (NoSuchElementException e){
					return;
					
				}

				// if the input actually holds content match it to the regex.
				Matcher matcher = accessPattern.matcher(input);

				// from here on print the appropriate messages for possibles
				// errors.
				if (!matcher.matches()) {
					System.out.println(NOT_A_NAME_ERROR_MESSAGE + input);
					continue;
				}

				if (!phonebook.containsKey(input)) {
					System.out.println(NAME_NOT_FOUND_ERROR_MESSAGE + input);
					continue;
				}

				System.out.println(input + " = " + phonebook.get(input));
			}

		}

	}

}
