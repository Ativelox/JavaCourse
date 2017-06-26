package loopinterpreter;

/**
 * A {@link Statement} which loops a given statement based on the results of a
 * given expression.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class LoopStatement implements Statement {

	/**
	 * The expression used to identify whether the loop should continue or not.
	 */
	private final Expression exp;

	/**
	 * The statement which gets looped.
	 */
	private final Statement s;

	/**
	 * Creates a new {@link Statement} which loops the given statement based on
	 * the results of the given expression. If the expression evaluates to 0
	 * then the loop gets cancelled, otherwise the loop continues.
	 * 
	 * @param mExp
	 *            The expression used to identify whether the loop should
	 *            continue or not.
	 * 
	 * @param mS
	 *            The statement which gets looped.
	 */
	public LoopStatement(final Expression mExp, final Statement mS) {
		this.exp = mExp;
		this.s = mS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see loopinterpreter.Statement#run(loopinterpreter.State)
	 */
	@Override
	public State run(State mInitial) {
		while (this.exp.eval(mInitial) != 0) {
			this.s.run(mInitial);

		}
		return mInitial;

	}
}
