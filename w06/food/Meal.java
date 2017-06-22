package food;

import java.util.Map;

/**
 * A meal which has its own name and contains a collection of food associated
 * with its weight in grams. Provides a method {@link Meal#getCalorificValue()}
 * to get the Value of the calories of this meal in kJ.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public final class Meal {

	/**
	 * The name of this meal.
	 */
	private final String name;

	/**
	 * The ingredients of this meal, every food is associated with its gram
	 * weight.
	 */
	private final Map<Food, Double> ingredients;

	/**
	 * A meal which has its own name and contains a collection of food
	 * associated with its weight in grams.
	 * 
	 * @param mName
	 *            The name of this meal
	 * 
	 * @param mIngredients
	 *            The ingredients of this meal, every food is associated with
	 *            its weight in grams.
	 * 
	 * @throws IllegalArgumentException
	 *             if either name or ingredients was <tt>null</tt>.
	 */
	public Meal(final String mName, final Map<Food, Double> mIngredients) {
		if (mName == null || mIngredients == null) {
			throw new IllegalArgumentException();

		}

		this.name = mName;
		this.ingredients = mIngredients;

	}

	/**
	 * Gets the name of this meal.
	 * 
	 * @return The name
	 */
	public String getName() {
		return this.name;

	}

	/**
	 * Returns the ingredients of this meal, every food is associated with its
	 * weight in grams, which are the ingredients.
	 * 
	 * @return The ingredients mentioned.
	 */
	public Map<Food, Double> getIngredients() {
		return this.ingredients;

	}

	/**
	 * Gets the calorific value of this meal. Does so by adding up all the
	 * energy densities of every food contained in this meal and its respective
	 * weight.
	 * 
	 * @return The calorific value mentioned.
	 */
	public double getCalorificValue() {

		double calorificValue = 0;
		
		for (final Food food : this.ingredients.keySet()) {
			calorificValue += food.relativeEnergyDensity() * this.ingredients.get(food).doubleValue();

		}
		return calorificValue;

	}
}
