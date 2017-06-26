package loopinterpreter;

/**
 * A {@link Expression} which is just a constant integer value.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class ConstantExpression implements Expression {

	/**
	 * The constant value of this expression.
	 */
	private final int constant;

	/**
	 * Creates a new {@link Expression} with the constant value given.
	 * 
	 * @param mConstant
	 *            The value of this expression.
	 */
	public ConstantExpression(final int mConstant) {
		this.constant = mConstant;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see loopinterpreter.Expression#eval(loopinterpreter.State)
	 */
	@Override
	public int eval(State mState) {
		return this.constant;

	}
}
