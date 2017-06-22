package shapes;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Contains JUnit4-Test cases for this exercise.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class ShapesTest {

	/**
	 * Test method for {@link shapes.Shapes#makeEllipse(shapes.V2, shapes.V2)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMakeEllipse() {
		final Shape e = Shapes.makeEllipse(new V2(0, 0), new V2(1, 2));
		final V2 p1 = new V2(0.5, 1);
		final V2 p2 = new V2(1, 1);

		Assert.assertTrue(e.contains(p1));
		Assert.assertFalse(e.contains(p2));

		Assert.assertFalse(e.move(new V2(-2, 0)).contains(p1));
	}

	/**
	 * Test method for {@link shapes.Shapes#makeRectangle(shapes.V2, shapes.V2)}
	 * .
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMakeRectangle() {
		final Shape r = Shapes.makeRectangle(new V2(0, 2), new V2(2, 2));
		final V2 p1 = new V2(1, 1);
		final V2 p2 = new V2(2.5, 2);

		Assert.assertTrue(r.contains(p1));
		Assert.assertFalse(r.contains(p2));

		Assert.assertTrue(r.move(new V2(1, 0)).contains(p2));

	}

	/**
	 * Test method for {@link shapes.Shapes#makePicture(java.util.List)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMakePicture() {
		final Shape e = Shapes.makeEllipse(new V2(0, 0), new V2(2, 1));
		final Shape r = Shapes.makeRectangle(new V2(0, 2), new V2(1, 2));
		final V2 p1 = new V2(0.5, 1);
		final V2 p2 = new V2(1, 1);

		final Shape pict = Shapes.makePicture(Arrays.asList(e, r));

		Assert.assertTrue(pict.contains(p1));
		Assert.assertTrue(pict.contains(p2));
		Assert.assertFalse(pict.contains(new V2(3, 0.5)));

	}

}
