package unittests;

import org.junit.runner.JUnitCore;

import static unittests.Util.printMessages;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		JUnitCore.runClasses(Class.forName("unittests.FunctionsTest"));
		System.out.println("Messages:");
		printMessages();
	}
}
