package searchtree;

/**
 * This class represents binary vortexes and edges alike. An edge would be
 * represented by setting the left and right TreeEntry to <tt>null</tt>. These
 * Entries are immutable, meaning changes to this object will return a new
 * object.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class SortedTreeEntry {

	/**
	 * The left entry of this entry, where left.value <= this.value.
	 */
	private final SortedTreeEntry left;

	/**
	 * The right entry of this entry, where right.value >= this.value.
	 */
	private final SortedTreeEntry right;

	/**
	 * The value of this entry.
	 */
	private final int value;

	/**
	 * Constructs a new sorted tree entry with the given values.
	 * 
	 * @param mValue
	 *            The value of this entry.
	 * 
	 * @param mLeft
	 *            The left entry of this entry.
	 * 
	 * @param mRight
	 *            The right entry of this entry.
	 * 
	 */
	public SortedTreeEntry(final int mValue, final SortedTreeEntry mLeft, final SortedTreeEntry mRight) {
		this.value = mValue;
		this.left = mLeft;
		this.right = mRight;

	}

	/**
	 * Adds the given value to this entry recursively. Also does so in a sorted
	 * manner.
	 * 
	 * @param mI
	 *            The value to add to this entry.
	 * 
	 * @return A new entry representing the old entry with the added value.
	 */
	public SortedTreeEntry add(final int mI) {

		if (mI < this.getValue()) {
			if (this.getLeftChild() == null) {
				return new SortedTreeEntry(this.getValue(), new SortedTreeEntry(mI, null, null), this.getRightChild());

			}
			return new SortedTreeEntry(this.getValue(), this.getLeftChild().add(mI), this.getRightChild());

		} else if (mI > this.getValue()) {
			if (this.getRightChild() == null) {
				return new SortedTreeEntry(this.getValue(), this.getLeftChild(), new SortedTreeEntry(mI, null, null));

			}
			return new SortedTreeEntry(this.getValue(), this.getLeftChild(), this.getRightChild().add(mI));

		} else {
			return new SortedTreeEntry(this.getValue(), this.getLeftChild(), this.getRightChild());

		}

	}

	/**
	 * Checks whether the given value is currently present in this entry.
	 * 
	 * @param mI
	 *            The value to check whether it's contained in this entry.
	 * 
	 * @return <tt>true</tt> if the value is present in the tree, <tt>false</tt>
	 *         otherwise.
	 */
	public boolean contains(final int mI) {
		if (mI < this.getValue()) {
			if (this.getLeftChild() == null) {
				return false;

			}
			return this.getLeftChild().contains(mI);

		} else if (mI > this.getValue()) {
			if (this.getRightChild() == null) {
				return false;

			}
			return this.getRightChild().contains(mI);

		} else {
			return true;
		}

	}

	/**
	 * Gets the left child of this entry.
	 * 
	 * @return The left child.
	 */
	public SortedTreeEntry getLeftChild() {
		return this.left;

	}

	/**
	 * Gets the right child of this entry.
	 * 
	 * @return The right child.
	 */
	public SortedTreeEntry getRightChild() {
		return this.right;

	}

	/**
	 * Gets the value of this entry.
	 * 
	 * @return The value.
	 */
	public int getValue() {
		return this.value;

	}

	/**
	 * Returns an in order representation of this entry. An in order traversal
	 * is equivalent to the natural sorting of this tree.
	 * 
	 * @return The mentioned string.
	 */
	public String toInOrder() {
		String repr = "";

		if (this.getLeftChild() != null) {
			repr += this.getLeftChild().toInOrder() + ", ";

		}
		repr += this.value + ", ";

		if (this.getRightChild() != null) {
			repr += this.getRightChild().toInOrder() + ", ";
		}

		return repr.substring(0, repr.length() - 2);
	}

}
