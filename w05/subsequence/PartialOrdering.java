package subsequence;

/**
 * Enum to specify the relation of strings subsequences.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public enum PartialOrdering {

	/**
	 * Indicates that the first String is a subsequence to the second String.
	 */
	LESS,

	/**
	 * Indicates that both Strings are equal.
	 */
	EQUAL,

	/**
	 * Indicates that the second String is a subsequence to the first String.
	 */
	GREATER,

	/**
	 * Indicates that neither of the two Strings are subsequences to each other,
	 * due to being incomparable.
	 */
	INCOMPARABLE

}
