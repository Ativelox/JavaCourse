package shapes;

/**
 * Represenets a box shape by utilizing two 2D-Vectors.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Box {

	/**
	 * The upper left corner of this box.
	 */
	private final V2 upperLeftCorner;

	/**
	 * The dimensions of this box, where the x coordinate represents the width,
	 * and the y coordinate represents the height.
	 */
	private final V2 dimensions;

	/**
	 * Creates a new Box object with the given bounds.
	 * 
	 * @param mUpperLeftCorner
	 *            The upper left corner.
	 * @param mDimensions
	 *            The dimension.
	 */
	public Box(final V2 mUpperLeftCorner, final V2 mDimensions) {
		if (mDimensions.getX() <= 0 || mDimensions.getY() <= 0) {
			throw new IllegalArgumentException();

		}

		this.upperLeftCorner = mUpperLeftCorner;
		this.dimensions = mDimensions;

	}

	/**
	 * Get the upper left corner of this box.
	 * 
	 * @return The upper left corner.
	 */
	public V2 getUpperLeftCorner() {
		return this.upperLeftCorner;

	}

	/**
	 * Get the dimensions of this box.
	 * 
	 * @return the dimensions.
	 */
	public V2 getDimensions() {
		return this.dimensions;

	}
}
