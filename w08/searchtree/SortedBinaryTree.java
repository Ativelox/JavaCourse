package searchtree;

/**
 * A sorted binary tree which operates on integer values. This tree is
 * immutable.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class SortedBinaryTree implements Tree {

	/**
	 * The root of this tree, e.g. the first entry of this tree.
	 */
	private final SortedTreeEntry root;

	/**
	 * The current size of this tree. Take note that this value will never
	 * change since a tree is immutable.
	 */
	private final int size;

	/**
	 * Constructs a new sorted binary tree where the root has the value 0.
	 */
	public SortedBinaryTree() {
		this(null, 0);

	}

	/**
	 * Constructs a new sorted binary tree where the root has the value given.
	 * 
	 * @param mInitialValue
	 *            The initial value of the root.
	 */
	public SortedBinaryTree(final int mInitialValue) {
		this(new SortedTreeEntry(mInitialValue, null, null));

	}

	/**
	 * Constructs a new sorted binary tree with the given root.
	 * 
	 * @param mEntry
	 *            The root of this tree.
	 */
	public SortedBinaryTree(final SortedTreeEntry mEntry) {
		this(mEntry, 1);

	}

	/**
	 * Constructs a new sorted binary tree with the given root and the given
	 * size.
	 * 
	 * @param mEntry
	 *            The root of this tree.
	 * 
	 * @param mSize
	 *            The size of this tree.
	 */
	private SortedBinaryTree(final SortedTreeEntry mEntry, final int mSize) {
		this.root = mEntry;
		this.size = mSize;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see searchtree.Tree#add(int)
	 */
	@Override
	public Tree add(int mI) {
		if (this.root == null) {
			return new SortedBinaryTree(new SortedTreeEntry(mI, null, null), this.size + 1);

		}

		if (!this.contains(mI)) {
			return new SortedBinaryTree(this.root.add(mI), this.size + 1);

		}
		return new SortedBinaryTree(this.root.add(mI), this.size);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see searchtree.Tree#contains(int)
	 */
	@Override
	public boolean contains(int mI) {
		if (this.root == null) {
			return false;

		}

		return this.root.contains(mI);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see searchtree.Tree#elementsAsString()
	 */
	@Override
	public String elementsAsString() {
		if (this.root == null) {
			return "";

		}

		return this.root.toInOrder();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see searchtree.Tree#size()
	 */
	@Override
	public int size() {
		return this.size;

	}
}
