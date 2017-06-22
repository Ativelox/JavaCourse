package onedgame;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Main {

	public static boolean isWinnable(final int m, final boolean[] mGame) {
		if (mGame.length <= 0 || mGame[0] == true || m <= 0) {
			throw new IllegalArgumentException();

		}

		final int n = mGame.length;

		int currentPosition = 0;
		
		boolean wentBack = false;

		while (currentPosition < n) {
			
			// the game is already won if the current position is the last entry
			// of the array since it's a valid turn and we can just walk one
			// step forward and our current position would be exactly n.
			if (currentPosition >= n - 1) {
				return true;

			}

			// if our position would be the last entry in the array or even
			// greater, then we can just finish the game.
			if (currentPosition + m >= n - 1) {
				currentPosition += m;
				continue;

			}
			
			if(currentPosition > 0 && mGame[currentPosition + 1] == true && mGame[currentPosition + m] == true && mGame[currentPosition - 1] == false){
				wentBack = true;
				currentPosition--;
				continue;
					
			}
			
			if (mGame[currentPosition + m] == false) {
				if(m == 1 && wentBack){
					return false;
					
				}
				wentBack = false;
				
				currentPosition += m;

			}else if (mGame[currentPosition + 1] == false) {
				if(wentBack){
					return false;
					
				}
				
				currentPosition++;

			}else{
				return false;
				
			}
		}
		return true;
	}
}
