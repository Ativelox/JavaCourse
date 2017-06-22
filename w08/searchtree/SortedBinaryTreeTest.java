package searchtree;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit-4 Test cases for this project.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class SortedBinaryTreeTest {

	/**
	 * Test method for {@link searchtree.SortedBinaryTree#add(int)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testAdd() {
		final Tree startingTree = Trees.makeTree(new int[] { 1, 2 });
		final Tree tree = startingTree.add(7).add(8).add(9).add(-1);

		Assert.assertTrue(startingTree.contains(1));
		Assert.assertFalse(startingTree.contains(7));

		Assert.assertTrue(tree.contains(-1));
		Assert.assertTrue(tree.contains(7));
		Assert.assertFalse(tree.contains(-2));

	}

	/**
	 * Test method for {@link searchtree.SortedBinaryTree#contains(int)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testContains() {
		final Tree tree = Trees.makeTree(new int[] { 2, 3, 4, 4, 1 });

		Assert.assertTrue(tree.contains(4));
		Assert.assertTrue(tree.contains(2));
		Assert.assertTrue(tree.contains(1));
		Assert.assertTrue(tree.contains(3));
		Assert.assertFalse(tree.contains(6));
		Assert.assertFalse(tree.contains(0));
	}

	/**
	 * Test method for {@link searchtree.SortedBinaryTree#size()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testSize() {
		final Tree tree = Trees.makeTree(new int[] { 2, 3, 4, 4, 1 });

		Assert.assertEquals(4, tree.size());

		Assert.assertEquals(5, tree.add(6).size());

		Assert.assertEquals(1, Trees.makeTree(new int[] { 0 }).size());
	}

	/**
	 * Test method for {@link searchtree.SortedBinaryTree#elementsAsString()}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testElementsAsString() {
		final Tree tree = Trees.makeTree(new int[] { 2, 3, 4, 4, 1 });

		Assert.assertEquals("1, 2, 3, 4", tree.elementsAsString());

		final Tree addedTree = tree.add(-1);

		Assert.assertEquals("-1, 1, 2, 3, 4", addedTree.elementsAsString());

		final Tree testTree = Trees.makeTree(new int[] { 4, 3, 2, 6, 7, 1 });

		Assert.assertEquals("1, 2, 3, 4, 6, 7", testTree.elementsAsString());

	}

}
