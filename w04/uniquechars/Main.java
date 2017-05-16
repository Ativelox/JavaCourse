package uniquechars;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Utility class providing methods to count the unique character occurences. For
 * example "hheellloo" has 4 unique character occurences.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Main {

	/**
	 * Counts the unique character occurences. Also checks if the input is
	 * contained in the cache, so it doesn't have to recalculate.
	 * 
	 * @param mCache
	 *            The cache to use for words -> occurences
	 * @param mInput
	 *            The input of which to count the unique word occurences
	 * 
	 * @return The unique word occurences in the given word.
	 */
	public static final int uniqueChars(final Map<String, Integer> mCache, final String mInput) {

		// don't calculate anything if the cache already contains the input
		// string
		if (mCache != null && mCache.containsKey(mInput)) {
			return mCache.get(mInput).intValue();

		}

		int uniqueCharCounter = 0;

		// holds every element already counted
		final List<Character> lookUpTable = new LinkedList<>();

		// iterate over every character in the given string
		for (final char inputChar : mInput.toCharArray()) {

			// only add to the counter if the element is not contained in the
			// look up table
			if (!lookUpTable.contains(Character.valueOf(inputChar))) {
				uniqueCharCounter += 1;
				lookUpTable.add(Character.valueOf(inputChar));
			}
		}

		return uniqueCharCounter;
	}

	/**
	 * Counts the unique character occurences for every element in the given
	 * list. Also checks if the input is contained in the cache, so it doesn't
	 * have to recalculate.
	 * 
	 * @param mCache
	 *            The cache to use for words -> occurences
	 * @param mInput
	 *            The input of whichs elements to count the unique word
	 *            occurences
	 * 
	 * @return A list containing the word occurences of every element in the
	 *         input list in the given order.
	 * 
	 * @see Main#uniqueChars(Map, String)
	 */
	public static final List<Integer> allUniqueChars(final Map<String, Integer> mCache, final List<String> mInput) {

		final List<Integer> result = new LinkedList<>();

		// iterate over the inputs in the given list
		for (final String input : mInput) {

			// pass the strings to the given method, which handles the rest
			result.add(Integer.valueOf(Main.uniqueChars(mCache, input)));

		}
		return result;
	}

	/**
	 * Counts the unique character occurences for every element in the given
	 * list. Creates its own cache for read input and passes it to
	 * {@link Main#allUniqueChars(Map, List)}.
	 * 
	 * @param mInput
	 *            The input of whichs elements to count the unique word
	 *            occurences
	 * 
	 * @return A list containing the word occurences of every element in the
	 *         input list in the given order.
	 * 
	 * @see Main#allUniqueChars(Map, List)
	 */
	public static final List<Integer> allUniqueChars(final List<String> mInput) {

		// the new cache created for this method
		final Map<String, Integer> cache = new HashMap<>();

		// iterate over the inputs in the given list
		for (final String input : mInput) {

			// pass the calculation to the given method.
			cache.put(input, Integer.valueOf(Main.uniqueChars(cache, input)));

		}

		// pass the created cache to the given method which handles further
		// calculation.
		return Main.allUniqueChars(cache, mInput);

	}
}