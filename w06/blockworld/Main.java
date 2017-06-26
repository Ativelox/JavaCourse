package blockworld;

import java.awt.Container;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * A GUI-Client which visualizes the logic implemented in {@link BlockWorld}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		BlockWorld w = new BlockWorld(10, 20, Arrays.asList(new Block(0, 0, 1, 'x'), new Block(2, 2, 2, 'o')), '.');
		runBlockWorld(w);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	static void createAndShowGUI(JLabel worldLabel, JLabel statusLabel) {
		// Create and set up the window.
		JFrame frame = new JFrame("Blockworld");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// add both labels in a vertical layout
		Container content = frame.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(worldLabel);
		content.add(statusLabel);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}

	public static void runBlockWorld(BlockWorld w) throws InterruptedException {
		JLabel worldLabel = new JLabel();
		JLabel statusLabel = new JLabel();
		renderWorld(worldLabel, statusLabel, w);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI(worldLabel, statusLabel);
			}
		});

		do {
			w.step();
			renderWorld(worldLabel, statusLabel, w);
			Thread.sleep(1000);
		} while (!w.isDead());
	}

	static void renderWorld(JLabel worldLabel, JLabel statusLabel, BlockWorld w) {
		StringBuilder result = new StringBuilder("<html>");
		char[][] grid = w.observe();
		for (int j = 0; j < w.getHeight(); j++) {
			result.append(String.format("<p><font face=\"%s\">", Font.MONOSPACED));
			for (int i = 0; i < w.getWidth(); i++) {
				result.append(grid[i][j]);
			}
			result.append("</font></p>");
		}
		result.append("</html>");
		worldLabel.setText(result.toString());
		statusLabel.setText(w.isDead() ? "DEAD" : "ALIVE");
	}

}
