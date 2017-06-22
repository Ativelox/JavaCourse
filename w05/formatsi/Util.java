package formatsi;

import java.util.Set;
import java.util.TreeSet;

public class Util {

	private static Set<String> messages = new TreeSet<>();

	public static void log(String message) {
		messages.add(message);
	}

	public static void printMessages() {
		for (String msg : messages) {
			System.out.println(msg);
		}
	}

}
