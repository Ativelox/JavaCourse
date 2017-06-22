package searchtree;

/**
 * Utility class used to create new trees.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Trees {

	/**
	 * Creates a new Tree with the given Elements.
	 * 
	 * @param mElements
	 *            The elements which this tree should contain.
	 * 
	 * @return The tree with the given elements.
	 */
	public static Tree makeTree(final int[] mElements) {
		Tree currentTree = new SortedBinaryTree(mElements[0]);

		for (int i = 1; i < mElements.length; i++) {
			currentTree = currentTree.add(mElements[i]);

		}
		return currentTree;

	}
}
