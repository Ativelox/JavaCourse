package shapes;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a picture shape, which itself consists of shapes.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Picture implements Shape {

	/**
	 * All the shapes featured in this picture.
	 */
	private final List<Shape> shapes;

	/**
	 * Creates a new picture shape with the given shapes.
	 * 
	 * @param mShapes
	 *            The shapes featured in this picture.
	 */
	public Picture(final List<Shape> mShapes) {
		this.shapes = mShapes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#contains(shapes.V2)
	 */
	@Override
	public boolean contains(V2 mPoint) {
		for (final Shape shape : this.shapes) {
			// the given point only has to be contained in one of the shapes
			// contained in the picture per definition.
			if (shape.contains(mPoint)) {
				return true;

			}
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
		final LinkedList<Shape> movedShapes = new LinkedList<>();

		for (final Shape shape : this.shapes) {
			movedShapes.add(shape.move(mDisplacement));

		}

		return new Picture(movedShapes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#boundingBox()
	 */
	@Override
	public Box boundingBox() {
		double leftMostX = Double.MIN_VALUE;
		double topMostY = Double.MIN_VALUE;
		double dimensionX = Double.MIN_VALUE;
		double dimensionY = Double.MIN_VALUE;

		// make sure to determine the max values for each vector and set it
		// accordingly.
		for (final Shape shape : this.shapes) {
			final Box shapeBox = shape.boundingBox();

			if (shapeBox.getUpperLeftCorner().getX() > leftMostX) {
				leftMostX = shapeBox.getUpperLeftCorner().getX();

			}

			if (shapeBox.getUpperLeftCorner().getY() > topMostY) {
				topMostY = shapeBox.getUpperLeftCorner().getY();

			}

			if (shapeBox.getDimensions().getX() > dimensionX) {
				dimensionX = shapeBox.getDimensions().getX();

			}

			if (shapeBox.getDimensions().getY() > dimensionY) {
				dimensionY = shapeBox.getDimensions().getY();

			}
		}
		return new Box(new V2(leftMostX, topMostY), new V2(dimensionX, dimensionY));
	}

}
