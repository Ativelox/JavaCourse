package shapes;

/**
 * Represents an ellipse shape by utilizing two 2D-Vectors.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Ellipse implements Shape {

	/**
	 * The center of the ellipse.
	 */
	private final V2 center;

	/**
	 * The radii of the ellipse, where the x coordinate represents the x-aligned
	 * radius and the y coordinate represents the y-aligned radius of this
	 * ellipse.
	 */
	private final V2 radii;

	/**
	 * Creates a new ellipse shape with the given bounds.
	 * 
	 * @param mCenter
	 *            The center of this ellipse.
	 * @param mRadii
	 *            The radii of this ellipse.
	 */
	public Ellipse(final V2 mCenter, final V2 mRadii) {
		this.center = mCenter;
		this.radii = mRadii;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#contains(shapes.V2)
	 */
	@Override
	public boolean contains(final V2 mPoint) {
		final boolean isContained = ((Math.pow((mPoint.getX() - this.center.getX()), 2)
				/ Math.pow(this.radii.getX(), 2))
				+ (Math.pow(mPoint.getY() - this.center.getY(), 2) / Math.pow(this.radii.getY(), 2))) <= 1;

		return isContained;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#move(shapes.V2)
	 */
	@Override
	public Shape move(final V2 mDisplacement) {
		return new Ellipse(new V2(this.center.getX() + mDisplacement.getX(), this.center.getY() + mDisplacement.getY()),
				this.radii);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#boundingBox()
	 */
	@Override
	public Box boundingBox() {
		return new Box(new V2(this.center.getX() - this.radii.getX(), this.center.getY() + this.radii.getY()),
				new V2(this.radii.getX() * 2, this.radii.getY() * 2));

	}
}
