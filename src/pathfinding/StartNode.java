package pathfinding;

import java.util.ArrayList;

/**
 * Ein Knotenpunkt von dem aus gesucht wird. Dieser hat keínen Vorgänger.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:59
 */
public class StartNode<T> extends PathNode<T> {

	public StartNode(T val){
		value = val;
		heuristic = 0.0;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public ArrayList<PathNode<T>> getPath(){
		ArrayList<PathNode<T>> ret = new ArrayList<PathNode<T>>();
		ret.add(this);
		return ret;
	}
}//end StartNode