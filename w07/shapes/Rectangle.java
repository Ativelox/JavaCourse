package shapes;

/**
 * Represents a rectangle shape by utilizing two 2D-Vectors.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Rectangle implements Shape {

	/**
	 * The upper left corner of this rectangle.
	 */
	private final V2 upperLeftCorner;

	/**
	 * The dimensions of this box, where the x coordinate represents the width,
	 * and the y coordinate represents the height.
	 */
	private final V2 dimension;

	/**
	 * Creates a new rectangle shape with the given bounds.
	 * 
	 * @param mUpperLeftCorner
	 *            The upper left corner of this rectangle.
	 *            
	 * @param mDimension
	 *            The dimensions of this rectangle.
	 */
	public Rectangle(final V2 mUpperLeftCorner, final V2 mDimension) {
		if (mDimension.getX() <= 0 || mDimension.getY() <= 0) {
			throw new IllegalArgumentException();

		}

		this.upperLeftCorner = mUpperLeftCorner;
		this.dimension = mDimension;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#contains(shapes.V2)
	 */
	@Override
	public boolean contains(V2 mPoint) {
		final boolean isInXBounds = (this.upperLeftCorner.getX() <= mPoint.getX())
				&& (mPoint.getX() <= this.upperLeftCorner.getX() + this.dimension.getX());

		final boolean isInYBounds = (this.upperLeftCorner.getY() >= mPoint.getY())
				&& (mPoint.getY() >= this.upperLeftCorner.getY() - this.dimension.getY());

		if (isInXBounds && isInYBounds) {
			return true;

		}

		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#move(shapes.V2)
	 */
	@Override
	public Shape move(V2 mDisplacement) {
		return new Rectangle(new V2(this.upperLeftCorner.getX() + mDisplacement.getX(),
				this.upperLeftCorner.getY() + mDisplacement.getY()), this.dimension);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#boundingBox()
	 */
	@Override
	public Box boundingBox() {
		return new Box(this.upperLeftCorner, this.dimension);

	}

}
