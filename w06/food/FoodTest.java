package food;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class FoodTest {

	private static final double ACCURACY = 1e-2;

	@SuppressWarnings("static-method")
	@Test
	public void testMeal() {
		Map<Food, Double> ingredients = new HashMap<>();
		ingredients.put(new Food("Water", 0.0, 0.0, 0.0), Double.valueOf(1000.0));
		ingredients.put(new Food("Sugar", 1.0, 0.0, 0.0), Double.valueOf(100.0));
		ingredients.put(new Food("Protein", 0.0, 0.0, 1.0), Double.valueOf(100.0));

		Meal shake = new Meal("Fitness-Shake", ingredients);
		Assert.assertEquals(3400.0, shake.getCalorificValue(), ACCURACY);

		Map<Food, Double> ingredients2 = new HashMap<>();
		ingredients2.put(new Food("G", 0.1, 0.41, 0.14), Double.valueOf(159.2));
		ingredients2.put(new Food("O", 0.83, 0.06, 0.08), Double.valueOf(765.4));
		ingredients2.put(new Food("P", 0.49, 0.35, 0.1), Double.valueOf(273.6));

		Meal ggp = new Meal("o", ingredients2);
		Assert.assertEquals(22891.854, ggp.getCalorificValue(), ACCURACY);

	}

	@SuppressWarnings({ "unused", "static-method" })
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalFood() {
		new Food("Burger", 1, 1, 1);
	}

}
