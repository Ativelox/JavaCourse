package anagrams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads two words from stdin and checks if the words are anagrams to each other
 * or not. A word is an anagram to another word, if the first word is a
 * permutation of the second word.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Main {

	/**
	 * The used Regex to determine if the input is in the given format or not.
	 */
	private static final String INPUT_PATTERN = "^([a-zA-Z]+)\\s([a-zA-Z]+)$";

	/**
	 * A specified string holding the message needed to be printed if the given
	 * words are anagrams
	 */
	private static final String ANAGRAMS_MESSAGE = "Anagrams";

	/**
	 * A specified string holding the message needed to be printed if the given
	 * words aren't anagrams
	 */
	private static final String NOT_ANAGRAMS_MESSAGE = "Not anagrams";

	/**
	 * The message printed if the input wasn't in the wanted format.
	 */
	private static final String ERROR_MESSAGE = "Not in given format.";

	/**
	 * This classes main class.
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public final static void main(final String[] args) {

		// the pattern used to check if the input is in the given pattern or not
		final Pattern pattern = Pattern.compile(INPUT_PATTERN);

		// a boolean changing on whether the given words are anagrams or not
		boolean isAnagram = true;

		try (final Scanner scan = new Scanner(System.in)) {

			// the user given input
			final String input = scan.nextLine();

			// the matcher used to identify the groups of input by the given
			// regex
			final Matcher matcher = pattern.matcher(input);

			// only start checking for anagrams if the message is in the wanted
			// format.
			if (matcher.matches()) {

				// the string of the first word
				final String firstWord = matcher.group(1).toLowerCase();

				// the string of the second word
				final String secondWord = matcher.group(2).toLowerCase();

				// the word is definitely no anagram if the length is different
				if (firstWord.length() != secondWord.length()) {
					isAnagram = false;

				}

				// iterate over every character in the first word and break if
				// the isAnagram was set to false, no more need to continue
				// iterating, already determined.
				for (final char firstWordChar : firstWord.toCharArray()) {
					int counter = 0;
					
					if (!isAnagram) {
						break;

					}

					// iterate over every character in the second word and break
					// if the first word is equal to the current second word,
					// thus not setting the isAnagram flag to false.
					for (final char secondWordChar : secondWord.toCharArray()) {
						if (firstWordChar == secondWordChar) {
							break;
						}

						if (counter == secondWord.length() - 1) {
							isAnagram = false;
						}
						counter++;
					}
				}

				if (isAnagram) {
					System.out.println(ANAGRAMS_MESSAGE);
					return;

				}
				System.out.println(NOT_ANAGRAMS_MESSAGE);

			} else {
				System.out.println(ERROR_MESSAGE);

			}
		}
	}
}
