package parser;

/**
 * Alle Parser, die elementar, also atomar sind. Sie stoppen den Parsvorgang, wenn
 * sie aufgerufen werden.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
abstract public class Leaf<V> implements Parser<V> {
	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Leaf