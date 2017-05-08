package unittest;

import org.junit.Assert;

import org.junit.Test;

import maximumhourglass.Main;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class MaximumHourglassTest {

	@SuppressWarnings("static-method")
	@Test
	public void testMaxHourglass() {
		final int[][] array = new int[Main.MATRIX_SIZE][Main.MATRIX_SIZE];
		
		/* 
		 * 0 1 1 0 1 1
		 * 1 0 1 1 0 1
		 * 0 0 1 0 0 1
		 * 0 1 1 0 1 1
		 * 1 0 1 1 0 1
		 * 0 0 1 0 0 1
		 */
		
		array[0][0] = 0;
		array[0][1] = 1;
		array[0][2] = 0;
		
		array[1][0] = 1;
		array[1][1] = 0;
		array[1][2] = 0;
		
		array[2][0] = 1;
		array[2][1] = 1;
		array[2][2] = 1;
		
		array[3][0] = 0;
		array[3][1] = 1;
		array[3][2] = 0;
		
		array[4][0] = 1;
		array[4][1] = 0;
		array[4][2] = 0;
		
		array[5][0] = 1;
		array[5][1] = 1;
		array[5][2] = 1;
		
		array[0][3] = 0;
		array[0][4] = 1;
		array[0][5] = 0;
		
		array[1][3] = 1;
		array[1][4] = 0;
		array[1][5] = 0;
		
		array[2][3] = 1;
		array[2][4] = 1;
		array[2][5] = 1;
		
		array[3][3] = 0;
		array[3][4] = 1;
		array[3][5] = 0;
		
		array[4][3] = 1;
		array[4][4] = 0;
		array[4][5] = 0;
		
		array[5][3] = 1;
		array[5][4] = 1;
		array[5][5] = 1;
		
		Assert.assertEquals(5, Main.maxHourglass(array));
	}

}
