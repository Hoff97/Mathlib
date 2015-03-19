package pathfinding;

import java.util.ArrayList;


/*
 * Diese Klasse repr�sentiert R�ckgaben des Suchalgorithmus beim Scheitern des Findens eines Zielknotens.
 * So wird es erm�glicht, Informationen �ber alle versuchten Suchschritte auszugeben.
 */
public class FailNode<T> extends PathNode<T> {
	
	public double heuristic = Double.MAX_VALUE;
	
	public T value = null;
	
	public ArrayList<PathNode<T>> nodes;
	
	public FailNode(ArrayList<PathNode<T>> n){
		nodes = n;
	}
	
	@Override
	public ArrayList<PathNode<T>> getPath() {
		return nodes;
	}
}
