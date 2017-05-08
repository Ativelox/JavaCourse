package simplefunctions;

/**
 * This class offers utility methods.<br>
 * 
 * @see Main#distanceOrigin(double, double)
 * @see Main#cubeVolume(double)
 * @see Main#cubeSurface(double)
 * @see Main#stringInsert(String, int)
 * @see Main#capacitance(double, double, double)
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Main {

	/**
	 * A double constant holding the value of the magnetic permeability in a
	 * classical vacuum.
	 */
	private static final double VACUUM_PERMEABILITY = 4 * Math.PI * Math.pow(10, -7);

	/**
	 * A double constant holding the value of the speed of light.
	 * 
	 */
	private static final double SPEED_OF_LIGHT = 299_792_458;

	/**
	 * A double constant holding the value of the absolute dielectric
	 * permittivity of classical vacuum.
	 */
	private static final double VACUUM_PERMITTIVITY = 1 / (VACUUM_PERMEABILITY * Math.pow(SPEED_OF_LIGHT, 2));

	/**
	 * Somehow needs main method, dummy can't be created for it, so here it is
	 * 
	 * @param args
	 * 			The command-line arguments.
	 */
	public static void main(String[] args){
		// Dummy that is not used
		
	}

	/**
	 * Calculates the distance between the point (x, y) and the Cartesian origin
	 * (0, 0).
	 * 
	 * @param x
	 *            The x value of the point.
	 * @param y
	 *            The y value of the point.
	 * 
	 * @return The distance mentioned
	 */
	public static double distanceOrigin(final double x, final double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * Calculates the volume of a cube with the given length.
	 * 
	 * @param x
	 *            The length of the cube.
	 * 
	 * @return The volume of the cube
	 */
	public static double cubeVolume(final double x) {
		return Math.pow(x, 3);
	}

	/**
	 * Calculates the surface of the cube with the given length.
	 * 
	 * @param x
	 *            The length of the cube.
	 * 
	 * @return The surface of the cube
	 */
	public static double cubeSurface(final double x) {
		return 6 * Math.pow(x, 2);
	}

	/**
	 * Inserts the character "_" at the given position in the given string.
	 * 
	 * @param str
	 *            The string to be modified.
	 * @param pos
	 *            The position where to modify the string.
	 * 
	 * @return The modified string.
	 */
	public static String stringInsert(final String str, final int pos) {
		return str.substring(0, pos) + "_" + str.substring(pos);
	}

	/**
	 * Calculates the capacity of a plate capacitor.
	 * 
	 * @param epsilonR
	 *            The relative permittivity of the material.
	 * @param A
	 *            The surface of the plate.
	 * @param d
	 *            The distance of the plates.
	 *
	 * @return The capacity of the plate capacitor.
	 */
	public static double capacitance(final double epsilonR, final double A, final double d) {
		return VACUUM_PERMITTIVITY * epsilonR * (A / d);
	}
}
