package loopinterpreter;

/**
 * A {@link Statement} used to run conditional statements.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class ConditionalStatement implements Statement {

	private final Expression exp;

	private final Statement firstStatement;

	private final Statement secondStatement;

	/**
	 * Creates a new {@link Statement} used to run conditional statements. mS1
	 * gets run if the evaluation of the given expression on the current state
	 * is not 0. If its 0 then mS2 gets run.
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
	 */
	public ConditionalStatement(final Expression mExp, final Statement mS1, final Statement mS2) {
		this.exp = mExp;
		this.firstStatement = mS1;
		this.secondStatement = mS2;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see loopinterpreter.Statement#run(loopinterpreter.State)
	 */
	@Override
	public State run(State mInitial) {
		if (this.exp.eval(mInitial) != 0) {
			this.firstStatement.run(mInitial);

		} else {
			this.secondStatement.run(mInitial);

		}
		return mInitial;

	}
}
