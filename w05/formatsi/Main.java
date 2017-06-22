package formatsi;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static formatsi.Util.printMessages;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Result res = JUnitCore.runClasses(Class.forName("formatsi.FormatTest"));
		for (Failure fail : res.getFailures()) {
			System.out.println(String.format("Test failed: %s", fail.getTestHeader()));
		}

		System.out.println("Messages:");
		printMessages();
	}
}
