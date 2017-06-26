package loopinterpreter;

import java.util.HashMap;

/**
 * A State represents mappings from (Variables -> Values). It just assigns every
 * variable given a value. Uses a {@link HashMap}{@literal<String, Integer>}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class State extends HashMap<String, Integer> {

	/**
	 * The serial version UID used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Calls {@link HashMap#HashMap()}.
	 */
	public State() {
		super();

	}
}
