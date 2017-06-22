package shapes;

/**
 * Provides a wrapper for a basic 2D-Vector by having an x and a y coordinate.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class V2 {

	/**
	 * The x coordinate of this vector.
	 */
	private final double x;

	/**
	 * The y coordinate of this vector.
	 */
	private final double y;

	/**
	 * Creates a new Vector with the given (x, y) coordinate pair.
	 * 
	 * @param mX
	 *            The x value of this vector.
	 * 
	 * @param mY
	 *            The y value of this vector.
	 */
	public V2(final double mX, final double mY) {
		this.x = mX;
		this.y = mY;

	}

	/**
	 * Gets the x value of this vector.
	 * 
	 * @return The x value.
	 */
	public double getX() {
		return this.x;

	}

	/**
	 * Gets the y value of this vector.
	 * 
	 * @return The y value.
	 */
	public double getY() {
		return this.y;
	}

}
