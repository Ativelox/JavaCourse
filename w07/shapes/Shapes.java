package shapes;

import java.util.List;

/**
 * Utility class which provides methods to create shapes.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Shapes {

	/**
	 * Creates a new {@link Ellipse}.
	 * 
	 * @param mCenter
	 *            The center of the ellipse.
	 * 
	 * @param mRadii
	 *            The radii of the ellipse.
	 * 
	 * @return The ellipse with the given values.
	 */
	public static Shape makeEllipse(final V2 mCenter, final V2 mRadii) {
		return new Ellipse(mCenter, mRadii);

	}

	/**
	 * Creates a new {@link Rectangle}.
	 * 
	 * @param mUpperLeftCorner
	 *            The upper left corner of the rectangle.
	 * 
	 * @param mDimensions
	 *            The dimensions of the rectangle.
	 * 
	 * @return The rectangle with the given values.
	 */
	public static Shape makeRectangle(final V2 mUpperLeftCorner, final V2 mDimensions) {
		return new Rectangle(mUpperLeftCorner, mDimensions);

	}

	/**
	 * Creates a new {@link Picture}.
	 * 
	 * @param mShapes
	 *            The shapes featured in this picture.
	 * 
	 * @return The picture with the given values.
	 */
	public static Shape makePicture(final List<Shape> mShapes) {
		return new Picture(mShapes);

	}

}
