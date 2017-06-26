package loopinterpreter;

/**
 * A factory class used to create {@link Statement}s. Provides the 4 commands
 * featured in the LOOP programming language, which would be
 * {@link Statements#assign(String, Expression)},
 * {@link Statements#seq(Statement, Statement)},
 * {@link Statements#cond(Expression, Statement, Statement)},
 * {@link Statements#loop(Expression, Statement)}.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class Statements {

	/**
	 * Creates {@link AssignStatement#AssignStatement(String, Expression)}.
	 * 
	 * @param mName
	 *            The name of the variable which gets assigned.
	 *
	 * @param mExp
	 *            The expression, which describes the value of the variable
	 *            given.
	 * 
	 * @return The created Statement.
	 */
	public static Statement assign(final String mName, final Expression mExp) {
		return new AssignStatement(mName, mExp);

	}

	/**
	 * Creates
	 * {@link SequentialStatement#SequentialStatement(Statement, Statement)}.
	 * 
	 * 
	 * @param mS1
	 *            The first statement to be run.
	 * 
	 * @param mS2
	 *            The second statement to be run.
	 *
	 * @return The created Statement.
	 */
	public static Statement seq(final Statement mS1, final Statement mS2) {
		return new SequentialStatement(mS1, mS2);

	}

	/**
	 * Creates
	 * {@link ConditionalStatement#ConditionalStatement(Expression, Statement, Statement)}
	 * .
	 * 
	 * @param mExp
	 *            The expression used to determine whether to run mS1 or mS2.
	 * 
	 * @param mS1
	 *            The first statement of this statement.
	 * 
	 * @param mS2
	 *            The second statement of this statement.
	 * 
	 * @return The created Statement.
	 */
	public static Statement cond(final Expression mExp, final Statement mS1, final Statement mS2) {
		return new ConditionalStatement(mExp, mS1, mS2);

	}

	/**
	 * Creates {@link LoopStatement#LoopStatement(Expression, Statement)}.
	 * 
	 * @param mExp
	 *            The expression used to identify whether the loop should
	 *            continue or not.
	 * 
	 * @param mS
	 *            The statement which gets looped.
	 * 
	 * @return The created Statement.
	 */
	public static Statement loop(final Expression mExp, final Statement mS) {
		return new LoopStatement(mExp, mS);

	}
}
