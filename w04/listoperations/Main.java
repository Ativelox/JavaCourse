package listoperations;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads different commands (append, pop, set, remove, print, sort, reverse)
 * from stdin and applies them to an intern list.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Main {

	/**
	 * The Regex used to identify if the given command is valid or not.
	 */
	private static final String COMMAND_PATTERN = "^([a-z\\-]+)\\s?([a-zA-Z0-9]*)?\\s?([a-zA-Z0-9]*)?$";

	/**
	 * The expected form of the append command.
	 */
	private static final String APPEND_COMMAND = "append";

	/**
	 * The expected form of the pop command.
	 */
	private static final String POP_COMMAND = "pop";

	/**
	 * The expected form of the set command.
	 */
	private static final String SET_COMMAND = "set";

	/**
	 * The expected form of the remove-first command.
	 */
	private static final String REMOVE_FIRST_COMMAND = "remove-first";

	/**
	 * The expected form of the remove-all command.
	 */
	private static final String REMOVE_ALL_COMMAND = "remove-all";

	/**
	 * The expected form of the print command.
	 */
	private static final String PRINT_COMMAND = "print";

	/**
	 * The expected form of the sort command.
	 */
	private static final String SORT_COMMAND = "sort";

	/**
	 * The expected form of the reverse command.
	 */
	private static final String REVERSE_COMMAND = "reverse";

	/**
	 * The expected form of the error message when given an unsupported command.
	 */
	private static final String ERROR_MESSAGE = "INVALID COMMAND";

	/**
	 * The expected form of an error written, if there's a runtime error while
	 * handling the list.
	 */
	private static final String RUNTIME_ERROR_MESSAGE = "DOES NOT COMPUTE";

	/**
	 * This classes main method.
	 * 
	 * @param args
	 *            The command-line arguments (unsupported).
	 */
	public final static void main(final String[] args) {

		// the intern list holding the elements needed.
		final List<String> words = new LinkedList<>();

		// the pattern used to identify appropriate commands
		final Pattern pattern = Pattern.compile(COMMAND_PATTERN);

		try (final Scanner scan = new Scanner(System.in)) {

			// scan for infinite inputs until EOF token is sent.
			while (scan.hasNextLine()) {

				// the current input given by the user
				final String commandInput = scan.nextLine();

				// the matcher object applied to the input with the given regex
				final Matcher matcher = pattern.matcher(commandInput);

				// check if the given user input is a command
				if (matcher.matches()) {

					// holds the identifier of the command.
					final String command = matcher.group(1);

					// from here on check which command got inputted.
					if (command.equals(APPEND_COMMAND)) {
						final String word = matcher.group(2);

						words.add(word);

					} else if (command.equals(POP_COMMAND)) {

						// if there are no elements in the list print the
						// runtime error message
						if (words.size() <= 0) {
							System.out.println(RUNTIME_ERROR_MESSAGE);
							continue;

						}

						// remove the last element from the list.
						words.remove(words.size() - 1);

					} else if (command.equals(SET_COMMAND)) {
						int index = -1;

						// if theres an out of bounds exception, or the value
						// couldn't be parsed to an integer print the runtime
						// error message
						try {
							index = Integer.parseInt(matcher.group(2));
							words.remove(index);

						} catch (NumberFormatException | IndexOutOfBoundsException e) {
							System.out.println(RUNTIME_ERROR_MESSAGE);
							continue;

						}
						final String word = matcher.group(3);

						words.add(index, word);

					} else if (command.equals(REMOVE_FIRST_COMMAND)) {
						final String word = matcher.group(2);
						words.remove(word);

					} else if (command.equals(REMOVE_ALL_COMMAND)) {
						final String word = matcher.group(2);

						while (words.contains(word)) {
							words.remove(word);

						}

					} else if (command.equals(PRINT_COMMAND)) {
						System.out.print("::");

						for (final String mWord : words) {
							System.out.print(" " + mWord);

						}
						System.out.println();

					} else if (command.equals(SORT_COMMAND)) {
						Collections.sort(words);

					} else if (command.equals(REVERSE_COMMAND)) {
						Collections.reverse(words);

					} else {
						System.out.println(ERROR_MESSAGE);

					}

					// user input was no command, thus print error message.
				} else {
					System.out.println(ERROR_MESSAGE);
				}

			}

		}

	}

}
