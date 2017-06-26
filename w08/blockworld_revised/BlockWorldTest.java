package blockworld_revised;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import blockworld.Block;
import blockworld.BlockWorld;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class BlockWorldTest {

	/**
	 * Test method for {@link blockworld.BlockWorld#isDead()},
	 * {@link blockworld.BlockWorld#step()},
	 * {@link blockworld.BlockWorld#observe()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMinimalWorld() {
		final List<Block> bs = Collections.singletonList(new Block(0, 0, 1, 'x'));
		final BlockWorld w = new BlockWorld(1, 2, bs, '.');
		Assert.assertFalse(w.isDead());
		Assert.assertArrayEquals(new char[][] { new char[] { 'x', '.' } }, w.observe());
		w.step();
		Assert.assertTrue(w.isDead());
		Assert.assertArrayEquals(new char[][] { new char[] { '.', 'x' } }, w.observe());

		final List<Block> bw = new LinkedList<>();
		bw.add(new Block(0, 0, 2, 'x'));
		bw.add(new Block(0, 0, 0, 'o'));

		final BlockWorld w2 = new BlockWorld(2, 6, bw, '.');
		w2.step();
		w2.step();
		w2.step();
		Assert.assertTrue(w2.isDead());

	}

	/**
	 * Test method for {@link blockworld.BlockWorld#getWidth()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testGetWidth() {
		BlockWorld w = new BlockWorld(1, 2, new LinkedList<Block>(), '.');
		Assert.assertEquals(1, w.getWidth());

		w = new BlockWorld(0, 2, new LinkedList<Block>(), '.');
		Assert.assertEquals(0, w.getWidth());
	}

	/**
	 * Test method for {@link blockworld.BlockWorld#getHeight()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testGetHeight() {
		BlockWorld w = new BlockWorld(1, 2, new LinkedList<Block>(), '.');
		Assert.assertEquals(2, w.getHeight());

		w = new BlockWorld(2, 0, new LinkedList<Block>(), '.');
		Assert.assertEquals(0, w.getHeight());
	}

}
