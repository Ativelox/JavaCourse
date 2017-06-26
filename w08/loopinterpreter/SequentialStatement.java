package loopinterpreter;

/**
 * A {@link Statement} used to execute two statements sequentially after each
 * other.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class SequentialStatement implements Statement {

	/**
	 * The statement which gets executed first.
	 */
	private final Statement firstStatement;

	/**
	 * The statement which gets executed second.
	 */
	private final Statement secondStatement;

	/**
	 * Creates a new {@link Statement} used to run two given statements
	 * sequentially after each other.
	 * 
	 * @param mS1
	 *            The first statement to be run.
	 * 
	 * @param mS2
	 *            The second statement to be run.
	 */
	public SequentialStatement(final Statement mS1, final Statement mS2) {
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
		this.firstStatement.run(mInitial);
		this.secondStatement.run(mInitial);

		return mInitial;
	}

}
