package loopinterpreter;

/**
 * A BinaryExpression resembles one of the following:<br>
 * variable +- constant<br>
 * constant +- variable<br>
 * variable +- variable<br>
 * constant +- constant<br>
 * Where +- are identified by {@link Binary} and variable is
 * {@link VariableExpression} and constant is {@link ConstantExpression}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class BinaryExpression implements Expression {

	/**
	 * The first expression of this expression.
	 */
	private final Expression firstOperator;

	/**
	 * The second expression of this expression.
	 */
	private final Expression secondOperator;

	/**
	 * The operation used, either + or -.
	 */
	private final Binary operation;

	/**
	 * Creates a new {@link Expression} with the given parameters.
	 * 
	 * @param mFirstOperator
	 *            The first expression for this expression.
	 * 
	 * @param mOperation
	 *            The operation used, either + or -.
	 * 
	 * @param mSecondOperator
	 *            The second expression for this expression.
	 * 
	 */
	public BinaryExpression(final Expression mFirstOperator, final Binary mOperation,
			final Expression mSecondOperator) {

		this.firstOperator = mFirstOperator;
		this.secondOperator = mSecondOperator;
		this.operation = mOperation;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see loopinterpreter.Expression#eval(loopinterpreter.State)
	 */
	@Override
	public int eval(State mState) {
		int leftSideValue = this.firstOperator.eval(mState);
		int rightSideValue = this.secondOperator.eval(mState);
		int result = 0;

		if (this.operation.equals(Binary.ADD)) {
			result = leftSideValue + rightSideValue;

		} else if (this.operation.equals(Binary.SUB)) {
			result = leftSideValue - rightSideValue;

		}
		return result;

	}
}
