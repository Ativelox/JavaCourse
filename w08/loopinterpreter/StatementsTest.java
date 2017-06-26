package loopinterpreter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Provides JUnit 4 Test cases for loop-interpreter.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 */
public class StatementsTest {

	/**
	 * Test method for
	 * {@link loopinterpreter.Statements#assign(java.lang.String, loopinterpreter.Expression)}
	 * .
	 * 
	 * y := x + 1;
	 * 
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testAssign() {
		final State state = new State();
		state.put("X", Integer.valueOf(42));

		final Statement stmt = Statements.assign("Y",
				Statements.binop(Statements.var("X"), Binary.ADD, Statements.constant(1)));

		stmt.run(state);
		Assert.assertEquals(Integer.valueOf(42), state.get("X"));
		Assert.assertEquals(Integer.valueOf(43), state.get("Y"));

	}

	/**
	 * Test method for
	 * {@link loopinterpreter.Statements#seq(loopinterpreter.Statement, loopinterpreter.Statement)}
	 * .
	 * 
	 * y := x + 1; x := y;
	 * 
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testSeq() {
		final State state = new State();
		state.put("X", Integer.valueOf(42));

		final Statement stmt = Statements.seq(
				Statements.assign("Y", Statements.binop(Statements.var("X"), Binary.ADD, Statements.constant(1))),
				Statements.assign("X", Statements.var("Y")));

		stmt.run(state);
		Assert.assertEquals(Integer.valueOf(43), state.get("X"));
		Assert.assertEquals(Integer.valueOf(43), state.get("Y"));
	}

	/**
	 * Test method for
	 * {@link loopinterpreter.Statements#cond(loopinterpreter.Expression, loopinterpreter.Statement, loopinterpreter.Statement)}
	 * .
	 * 
	 * cond(x) { x := x + 1; } else { x : = x; }
	 * 
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testCond() {
		final State state = new State();
		state.put("X", Integer.valueOf(42));

		final Statement stmt = Statements.cond(Statements.var("X"),
				Statements.assign("X", Statements.binop(Statements.var("X"), Binary.ADD, Statements.constant(1))),
				Statements.assign("X", Statements.var("X")));

		stmt.run(state);
		Assert.assertEquals(Integer.valueOf(43), state.get("X"));

		final State state2 = new State();
		state2.put("X", Integer.valueOf(42));

		Assert.assertEquals(0, Statements.binop(Statements.var("X"), Binary.SUB, Statements.var("X")).eval(state2));

		final Statement stmt2 = Statements.cond(Statements.binop(Statements.var("X"), Binary.SUB, Statements.var("X")),
				Statements.assign("X", Statements.binop(Statements.var("X"), Binary.ADD, Statements.constant(1))),
				Statements.assign("X", Statements.var("X")));

		stmt2.run(state2);
		Assert.assertEquals(Integer.valueOf(42), state2.get("X"));

	}

	/**
	 * Test method for
	 * {@link loopinterpreter.Statements#loop(loopinterpreter.Expression, loopinterpreter.Statement)}
	 * .
	 * 
	 * loop(x) { x := x-1; y := y+2; }
	 * 
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testLoop() {
		final State state = new State();
		state.put("X", Integer.valueOf(42));
		state.put("Y", Integer.valueOf(0));

		final Statement stmt = Statements.loop(Statements.var("X"), Statements.seq(
				Statements.assign("X", Statements.binop(Statements.var("X"), Binary.SUB, Statements.constant(1))),
				Statements.assign("Y", Statements.binop(Statements.var("Y"), Binary.ADD, Statements.constant(2)))));

		stmt.run(state);
		Assert.assertEquals(Integer.valueOf(0), state.get("X"));
		Assert.assertEquals(Integer.valueOf(84), state.get("Y"));

	}

}
