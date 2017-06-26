package loopinterpreter;

/**
 * A {@link Statement} which assigns a name to an expression. If run the
 * statement then will evaluate the expression and map the name to a concrete
 * value.
 * 
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class AssignStatement implements Statement {

	/**
	 * The name of the variable which gets assigned.
	 */
	private final String name;

	/**
	 * The expression, which describes the value of the variable with name.
	 */
	private final Expression exp;

	/**
	 * Creates a new {@link Statement} which assigns the given variable name to
	 * the given Expression. If {@link run} gets called it the will assign the
	 * given variable to the explicit value described by mExp.
	 * 
	 * @param mName
	 *            The name of the variable which gets assigned.
	 * 
	 * @param mExp
	 *            The expression, which describes the value of the variable
	 *            given.
	 */
	public AssignStatement(final String mName, final Expression mExp) {
		this.name = mName;
		this.exp = mExp;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see loopinterpreter.Statement#run(loopinterpreter.State)
	 */
	@Override
	public State run(State mInitial) {
		mInitial.put(this.name, Integer.valueOf(this.exp.eval(mInitial)));

		return mInitial;

	}
}
