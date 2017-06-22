package unittestsw04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uniquechars.Main;

/**
 *
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class UniqueCharsTest {

	@SuppressWarnings("static-method")
	@Test
	public void testUniqueChars() {
		Map<String, Integer> m = new HashMap<>();
		Assert.assertEquals(5, Main.uniqueChars(m, "Hhelloo"));
		
		Map<String, Integer> m1 = new HashMap<>();
		m1.put("hhelloo", Integer.valueOf(5));
		
		Assert.assertEquals(5, Main.uniqueChars(m1, "hhelloo"));
		
	}
	
	@SuppressWarnings("static-method")
	@Test
	public void testAllUniqueChars() {
		List<Integer> result = new LinkedList<>();
		result.add(Integer.valueOf(4));
		result.add(Integer.valueOf(5));
		
		List<String> l = new LinkedList<>();
		l.add("hhelloo");
		l.add("wwoorrld");
		Map<String, Integer> m = new HashMap<>();
		
		Assert.assertEquals(result, Main.allUniqueChars(m, l));
		
		Assert.assertEquals(result, Main.allUniqueChars(l));
		
	}

}
