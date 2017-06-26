package loopinterpreter;

/**
 * A {@link Expression} where its value is a variable given. The value is
 * unknown until evaluated with a given initial State.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class VariableExpression implements Expression {

	/**
	 * The variable of this expression (the value).
	 */
	private final String variable;

	/**
	 * Creates a new {@link Expression} where the value is a given variable.
	 * 
	 * @param mVariable
	 *            The name of the variable for this expression.
	 */
	public VariableExpression(final String mVariable) {
		this.variable = mVariable;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see loopinterpreter.Expression#eval(loopinterpreter.State)
	 */
	@Override
	public int eval(State mState) {
		return mState.get(this.variable).intValue();
	}

}
