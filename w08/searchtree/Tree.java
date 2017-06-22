package searchtree;

/**
 * An interface for trees, providing the basic methods every tree should have.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public interface Tree {

	/**
	 * Adds the value given to the tree, but doesn't change it. Instead returns
	 * a new Tree which represents the old tree with the given value added to
	 * it.
	 * 
	 * @param mI
	 *            The value to add to the tree.
	 * 
	 * @return The tree with the new value.
	 */
	public Tree add(int mI);

	/**
	 * Checks whether the given value is currently present in the tree.
	 * 
	 * @param mI
	 *            The value, which should be checked if it's currently present
	 *            in the tree.
	 * 
	 * @return <tt>true</tt> if the value is currently present in the tree,
	 *         <tt>false</tt> otherwise.
	 */
	public boolean contains(int mI);

	/**
	 * Returns the current size of the tree, e.g. how many elements are
	 * currently present in the tree.
	 * 
	 * @return The number of elements in the tree.
	 */
	public int size();

	/**
	 * Returns a String representation of this tree, where every value is
	 * present in the String in a sorted way, so that e1 <= e2 <= e3 <= e4 <=
	 * ... <= en., where ei are values of the entries of this tree.
	 * 
	 * @return The string mentioned.
	 */
	public String elementsAsString();

}
