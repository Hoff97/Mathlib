package pathfinding;

import java.util.ArrayList;

/**
 * Ein Knotenpunkt mit einem Vorgänger.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public class Node<T> extends PathNode<T> {

	/**
	 * Der Vorgänger des Knotenpunkts.
	 */
	public PathNode<T> previousNode;

	public Node(T val, double heur, PathNode<T> prev){
		super();
		value = val;
		heuristic = heur;
		previousNode = prev;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public ArrayList<PathNode<T>> getPath(){
		ArrayList<PathNode<T>> ret = previousNode.getPath();
		ret.add(this);
		return ret;
	}
}//end Node