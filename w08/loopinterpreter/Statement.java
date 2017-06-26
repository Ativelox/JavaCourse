package loopinterpreter;

/**
 * A statement models commands from the programming language LOOP. For example
 * conditional-statements or loops.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public interface Statement {

	/**
	 * Runs this statement on the given state. Note that the given state gets
	 * modified in-line, meaning that the given state can change every run-call.
	 * Also returns the given state explicitly to allow fast access to elements.
	 * 
	 * @param mInitial
	 *            The state on which to run the statement.
	 * 
	 * @return The state given.
	 */
	public State run(final State mInitial);

}
