package shapes;

/**
 * An interface which provides basic methods which every shape has to have.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public interface Shape {

	/**
	 * Checks whether a point is inside this shape.
	 * 
	 * @param mPoint
	 *            The point of which to check whether its contained in this
	 *            shape.
	 * 
	 * @return <tt>true</tt> if the point is contained in this shape,
	 *         <tt>false</tt> otherwise.
	 */
	public boolean contains(final V2 mPoint);

	/**
	 * Constructs a new shape with the same features as this shape, but moved
	 * according to the displacement.
	 * 
	 * @param mDisplacement
	 *            The vector according to which this shape should be moved.
	 * 
	 * @return the moved shaped.
	 */
	public Shape move(final V2 mDisplacement);

	/**
	 * Constructs the smallest vox such that this shape fits fully insade the
	 * box.
	 * 
	 * @return a box such that this shape is inside.
	 */
	public Box boundingBox();

}
