package blockworld_revised;

/**
 * A block is an element in a world which has its own (x, y) coordinate pair and
 * its velocity, e.g. the speed at which this block falls. Also has its own
 * shape to be able to be identified.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Block {

	/**
	 * The x coordinate of this block.
	 */
	private int x;

	/**
	 * The y coordinate of this block.
	 */
	private int y;

	/**
	 * The velocity of this block.
	 */
	private final int velocity;

	/**
	 * The shape of this block.
	 */
	private final char shape;

	/**
	 * A block is an element in a world which has its own (x, y) coordinate pair
	 * and its velocity, e.g. the speed at which this block falls. Also has its
	 * own shape to be able to be identified.
	 * 
	 * @param mX
	 *            The x coordinate of this block.
	 * @param mY
	 *            The y coordinate of this block.
	 * @param mVelocity
	 *            The velocity of this block.
	 * @param mShape
	 *            The shape of this block.
	 */
	public Block(final int mX, final int mY, final int mVelocity, final char mShape) {

		// make sure to only accept valid values for block properties.
		if (mX < 0 || mY < 0 || mVelocity < 0) {
			throw new IllegalArgumentException();

		}
		this.x = mX;
		this.y = mY;
		this.velocity = mVelocity;
		this.shape = mShape;

	}

	/**
	 * Gets this blocks x coordinate.
	 * 
	 * @return The x coordinate.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets this blocks y coordinate.
	 * 
	 * @return The y coordinate.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Gets this blocks shape.
	 * 
	 * @return The shape.
	 */
	public char getShape() {
		return this.shape;
	}

	public boolean isDead(final int mHeight) {
		if (this.velocity <= 0 || this.y >= mHeight - 1) {
			return true;

		}
		return false;

	}

	/**
	 * Makes this block fall by its velocity.
	 * 
	 * @param mHeight
	 *            The ground of the world, e.g. the first y-coordinate at which
	 *            blocks cannot be.
	 */
	public void fall(final int mHeight) {
		if (this.y + this.velocity > mHeight - 1) {
			this.y = mHeight - 1;
			return;
		}
		this.y += this.velocity;

	}
}
