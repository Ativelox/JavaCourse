package loopinterpreter;

/**
 * A factory class used to create {@link Expression}s.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Expressions {

	/**
	 * Creates
	 * {@link BinaryExpression#BinaryExpression(Expression, Binary, Expression)}
	 * .
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
	 * @return The created Expression.
	 */
	public static Expression binop(final Expression mFirstOperator, final Binary mOperation,
			final Expression mSecondOperator) {

		return new BinaryExpression(mFirstOperator, mOperation, mSecondOperator);

	}

	/**
	 * Creates {@link VariableExpression#VariableExpression(String)}.
	 * 
	 * @param mVariable
	 *            The name of the variable for this expression.
	 * 
	 * @return The created Expression.
	 */
	public static Expression var(final String mVariable) {
		return new VariableExpression(mVariable);

	}

	/**
	 * Creates {@link ConstantExpression#ConstantExpression(int)}.
	 * 
	 * @param mConstant
	 *            The value of this expression.
	 * 
	 * @return The created Expression.
	 */
	public static Expression constant(final int mConstant) {
		return new ConstantExpression(mConstant);

	}

}
