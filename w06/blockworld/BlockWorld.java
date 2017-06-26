package blockworld;

import java.util.LinkedList;
import java.util.List;

/**
 * A BlockWorld which holds blocks in its world. BlockWorlds are alive as long
 * as no block hit the ground. By executing a {@link BlockWorld#step()} the
 * blocks will fall by their given speed to the ground.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class BlockWorld {

	/**
	 * The width of this world.
	 */
	private final int width;

	/**
	 * The height of this world.
	 */
	private final int height;

	/**
	 * The blocks this world contains.
	 */
	private final List<Block> blocks;

	/**
	 * The identifier of empty spaces in this world
	 */
	private final char empty;

	/**
	 * A BlockWorld which holds blocks in its world. BlockWorlds are alive as
	 * long as no block hit the ground. By executing a {@link BlockWorld#step()}
	 * the blocks will fall by their given speed to the ground.
	 * 
	 * @param mWidth
	 *            The width of this world.
	 * @param mHeight
	 *            The height of this world.
	 * @param mBlocks
	 *            The blocks this world contains.
	 * @param mEmpty
	 *            The token symbolizing empty spaces in this world.
	 */
	public BlockWorld(final int mWidth, final int mHeight, final List<Block> mBlocks, final char mEmpty) {

		// make sure to check whether all blocks are in the given world bounds.
		for (final Block block : mBlocks) {
			if ((block.getX() > (mWidth - 1)) || block.getY() > (mHeight - 1)) {
				throw new IllegalArgumentException("Block wasn't in the given world bounds.");

			}
		}
		this.width = mWidth;
		this.height = mHeight;
		this.empty = mEmpty;
		this.blocks = new LinkedList<>();

		for (final Block block : mBlocks) {
			this.blocks.add(block.clone());

		}
	}

	/**
	 * Gets the width of this world.
	 * 
	 * @return The width mentioned.
	 */
	public int getWidth() {
		return this.width;

	}

	/**
	 * Gets the height of this world.
	 * 
	 * @return The height mentioned.
	 */
	public int getHeight() {
		return this.height;

	}

	/**
	 * Returns a representation of this 2D-World with its blocks by setting each
	 * blocks shape at this arrays position, or else this worlds empty token.
	 * 
	 * @return The array resembling this world.
	 */
	public char[][] observe() {
		char[][] world = new char[this.width][this.height];

		// first traverse columns, then rows.
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				char greatestShape = 0;

				// this is a very inefficient approach
				for (final Block block : this.blocks) {

					// if the block is the one in the current scope
					if (block.getX() == i && block.getY() == j) {

						// check if the shape is greater than the last shape,
						// since we want to display the greatest shape on top of
						// the lesser shapes with blocks overlap.
						if (block.getShape() > greatestShape) {
							greatestShape = block.getShape();

						}
					}
				}

				// make sure to set the shape to the worlds empty shape if we
				// didn't find a block.
				if (greatestShape <= 0) {
					greatestShape = this.empty;

				}
				world[i][j] = greatestShape;

			}
		}
		return world;

	}

	/**
	 * Executes a step on all the blocks in this world.
	 * 
	 * @see Block#fall(int)
	 */
	public void step() {
		for (final Block block : this.blocks) {
			block.fall(this.height);
		}

	}

	/**
	 * Returns whether the world is dead or not. A world is considered dead if
	 * no more blocks move if {@link BlockWorld#step()} is called.
	 * 
	 * @return Whether the world is dead or not.
	 */
	public boolean isDead() {
		for (final Block block : this.blocks) {
			// if theres one block which is not dead, make sure to return false
			// since one block not being dead results in the world to not be
			// dead.
			if (!block.isDead(this.height)) {
				return false;

			}
		}
		// if there every block was dead return true.
		return true;

	}
}
