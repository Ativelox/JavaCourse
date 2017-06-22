package food;

/**
 * A class representing food in a simple way. Every food has a carbohydrate-,
 * fat- and protein share. Furthermore is every food associated uniquely by its
 * name. Thus {@link Food#equals(Object)} returns true when the names of each
 * food are the same.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Food {

	/**
	 * The energy density of carbohydrate (in kJ/g).
	 */
	private static final int CARBOHYDRATE_ENERGY_DENSITY = 17;

	/**
	 * The energy density of protein (in kJ/g).
	 */
	private static final int PROTEIN_ENERGY_DENSITY = 17;

	/**
	 * The energy density of fat (in kJ/g).
	 */
	private static final int FAT_ENERGY_DENSITY = 37;

	/**
	 * The name of this food.
	 */
	private final String name;

	/**
	 * The carbohydrate share of this food.
	 */
	private final double carbohydrateShare;

	/**
	 * The fat share of this food.
	 */
	private final double fatShare;

	/**
	 * The protein share of this food.
	 */
	private final double proteinShare;

	/**
	 * A class representing food in a simple way. Every food has a
	 * carbohydrate-, fat- and protein share. Furthermore is every food
	 * associated uniquely by its name.
	 * 
	 * @param mName
	 *            The name of this food.
	 * 
	 * @param mCarbohydrateShare
	 *            The carbohydrate share of this food, ranging from 0 - 1
	 *            (percentage)
	 * 
	 * @param mFatShare
	 *            The fat share of this food, ranging from 0 - 1 (percentage)
	 * 
	 * @param mProteinShare
	 *            The protein share of this food, ranging from 0 - 1
	 *            (percentage)
	 * 
	 * @throws IllegalArgumentException
	 *             if the shares are negative or are greater than 1 combined,
	 *             since there can't be more than 100% of the shares combined.
	 * 
	 */
	public Food(final String mName, final double mCarbohydrateShare, final double mFatShare,
			final double mProteinShare) {

		this.name = mName;
		this.carbohydrateShare = mCarbohydrateShare;
		this.fatShare = mFatShare;
		this.proteinShare = mProteinShare;

		if (this.carbohydrateShare < 0 || this.fatShare < 0 || this.proteinShare < 0) {
			throw new IllegalArgumentException();

		}

		if ((this.carbohydrateShare + this.fatShare + this.proteinShare) > 1) {
			throw new IllegalArgumentException();

		}

	}

	/**
	 * Gets this foods name.
	 * 
	 * @return The name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Calculates the relative energy density of this food. In other words
	 * calculates the energy densities of the given nutrients multiplied by
	 * their respective factos.
	 * 
	 * @return The mentioned relative energy density.
	 */
	public double relativeEnergyDensity() {
		return (this.carbohydrateShare * CARBOHYDRATE_ENERGY_DENSITY + this.proteinShare * PROTEIN_ENERGY_DENSITY
				+ this.fatShare * FAT_ENERGY_DENSITY);

	}

	@Override
	public String toString() {
		return ("\"" + this.name + "\"" + ", CarbohydrateShare: " + this.carbohydrateShare + ", FatShare: "
				+ this.fatShare + ", ProteinShare: " + this.proteinShare);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

}
