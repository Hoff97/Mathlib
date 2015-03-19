package pathfinding;

import java.util.ArrayList;

/**
 * Ein beliebiger Knotenpunkt.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public abstract class PathNode<T> {

	/**
	 * Die Heuristik gibt an, wie viele Schritte nötig sind, um zu diesem Knotenpunkt
	 * zu gelangen.
	 */
	public double heuristic;
	/**
	 * Der durch den Knotenpunkt enthaltene Datenwert.
	 */
	public T value;
	
	public PathNode() {
	}

	public void finalize() throws Throwable {

	}
	public abstract ArrayList<PathNode<T>> getPath();
	
	public String toString() {
		return value.toString();
	}
}//end PathNode