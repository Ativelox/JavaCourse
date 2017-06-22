package lineintersection;

import org.junit.runner.JUnitCore;

import static lineintersection.Util.printMessages;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		JUnitCore.runClasses(Class.forName("lineintersection.GeometryTest"));
		System.out.println("Messages:");
		printMessages();
	}
}
