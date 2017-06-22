package subsequence;

/**
 * Provides a method {@link Main#subsequenceCompare(String, String)} which is
 * able to identify whether the given strings are subsequences of each other and
 * also returns their respective relation.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Main {

	/**
	 * This method is able to identify whether the given strings are
	 * subsequences of each other and also returns their respective relation.
	 * 
	 * @param mFirstString
	 *            The first string to compare to the second string.
	 * @param mSecondString
	 *            The second string to compare to the first string.
	 * 
	 * @return The subsequence relation of the two strings.
	 * 
	 * 
	 * @see PartialOrdering#EQUAL
	 * @see PartialOrdering#LESS
	 * @see PartialOrdering#GREATER
	 * @see PartialOrdering#INCOMPARABLE
	 * 
	 */
	public static PartialOrdering subsequenceCompare(final String mFirstString, final String mSecondString) {
		if (mFirstString.equals(mSecondString)) {
			return PartialOrdering.EQUAL;

		} else if (mFirstString.length() == mSecondString.length()) {
			return PartialOrdering.INCOMPARABLE;
		}

		if (mFirstString.length() <= 0) {
			return PartialOrdering.LESS;

		} else if (mSecondString.length() <= 0) {
			return PartialOrdering.GREATER;

		}

		// 1 stands for string1 > string2, -1 stands for string1 < string2.
		int order = 1;

		// determines whether we can stop iterating over the strings since we
		// already determined the relation between the two strings.
		boolean finished = false;

		// update the order flag if necessary.
		if (mFirstString.length() <= mSecondString.length()) {
			order = -1;

		}

		// the char arrays of the respective strings
		final char[] chars1 = mFirstString.toCharArray();
		final char[] chars2 = mSecondString.toCharArray();

		// the individual loop counters.
		int i = 0;
		int j = 0;

		for (i = 0; i < chars1.length; i++) {
			for (j = 0; j < chars2.length; j++) {

				// we need atleast one similarity so we can start checking
				// whether the string is a subsequence.
				if (chars1[i] == chars2[j]) {

					// start incrementing the respective indexes so we can check
					// if its a subsequence. break if one index is at the end of
					// a string.
					while (i < chars1.length && j < chars2.length) {

						// if chars are the same we move the pointer to the next
						// index in both strings.
						if (chars1[i] == chars2[j]) {
							i++;
							j++;

							// if there were no similarities we have to
							// increment the correct counter to check for
							// subsequences.
						} else {
							// string1 (i) > string2 (j), thus we have to
							// advance the pointer of the first string.
							if (order >= 1) {
								i++;

								// string1 (i) =< string2 (j), thus we have to
								// advane the pointer of the second string.
							} else {
								j++;

							}
						}

					}
					// the while loop finished, so we definitely have a result
					// now, setting the finished flag so we can indicate the
					// while loop got executed, and the for loop above can break
					// aswell.
					finished = true;
					break;

				}

			}

			if (finished) {
				break;
			}

		}

		// if we didn't even enter the main logic, e.g. the while loop the
		// strings were definitely incomparable (no char was contained in either
		// string).
		if (!finished) {
			return PartialOrdering.INCOMPARABLE;

		}

		// from here on apply the correct logic to determine what kind of
		// subsequence relation there is. first splitting them by the order
		// flag, and then by the index position, e.g. the pointer on the strings
		// char.
		if (order >= 1 && j >= mSecondString.length() - 1) {
			return PartialOrdering.GREATER;

		} else if (order <= -1 && i >= mFirstString.length() - 1) {
			return PartialOrdering.LESS;

		}

		// if nothing applied up until now the strings weren't comparable.
		return PartialOrdering.INCOMPARABLE;

	}
}
