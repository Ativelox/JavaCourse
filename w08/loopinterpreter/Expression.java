package loopinterpreter;

/**
 * An interface used to model expressions. For example an expression could look
 * as follows:<br>
 * a + 1<br>
 * c + d<br>
 * 2 + 1<br>
 * ...<br>
 * 
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public interface Expression {

	/**
	 * Evaluates this expression with the given state. The state holds the
	 * values for the variables which are not known to the expression. It then
	 * returns exactly the value which the expression describes with the given
	 * values for the variables in state. Note that the state is not used if the
	 * expression is a constant value.
	 * 
	 * @param mState
	 *            The state used to evaluate the expression.
	 * 
	 * @return The value described by the expression.
	 */
	public int eval(final State mState);

}
