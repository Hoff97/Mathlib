package pathfinding;

import java.util.ArrayList;
import java.util.*;

/**
 * Implementiert den A* Algorithmus auf einem Abstrakten Level.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
public abstract class Astar<T> {
	//TODO: Add Start to find definition
	/**
	 * Alle Knotenpunkte, die im Suchverlauf entdeckt wurden, deren nachfolgende
	 * Knotenpunkte aber noch nicht untersucht wurden.
	 */
	public ArrayList<PathNode<T>> seenNotes;
	/**
	 * Alle Knotenpunkte, die genauso wie ihre Nachfolger schon entdeckt wurden.
	 */
	public ArrayList<PathNode<T>> knownNodes;

	public Astar(){
	}

	public void finalize() throws Throwable {

	}
	/**
	 * Fügt eine bekannten Knotenpunkt zur Liste aller bekannten Knotenpunkte hinzu.
	 * 
	 * @param seenNotes    Der zu hinzufügende Knotenpunkt.
	 */
	public void addKnownNote(PathNode<T> seenNote){
		knownNodes.add(seenNote);
	}

	/**
	 * Fügt mehrere Knotenpunkte zur Liste aller gesehenen Knotenpunkte hinzu.
	 * 
	 * @param seenNotes    Die zu hinzuzufügenden Knotenpunkte.
	 */
	public void addSeenNotes(ArrayList<PathNode<T>> _seenNotes){
		seenNotes.addAll(_seenNotes);
		Collections.sort(seenNotes, new Comparator<PathNode<T>>() {
		    public int compare(PathNode<T> a, PathNode<T> b) {
		        return new Integer((int)Math.round(getHeuristic(a.value)+a.heuristic-b.heuristic-getHeuristic(b.value)));
		    }
		});
	}

	/**
	 * Der Pfadfindungsalgorithmus
	 * 
	 * @param start    Der Startknotenpunkt
	 */
	public PathNode<T> findPath(T val){
		seenNotes = new ArrayList<PathNode<T>>();
		knownNodes = new ArrayList<PathNode<T>>();
		seenNotes.add(new StartNode<T>(val));
		return doFindPath();
	}

	/**
	 * Die Differenz der Heuristik von einem zum anderen Knotenpunkt
	 * 
	 * @param to    Endknotenpunkt
	 * @param from    Startknotenpunkt
	 */
	public abstract double getChange(T to, T from);

	/**
	 * Gibt die geschätzte Heuristik zum Zielknotenpunkt an
	 * 
	 * @param node    Startknotenpunkt
	 */
	public abstract double getHeuristic(T node);

	/**
	 * Alle Folgeknotenpunkte vom aktuellen Knotenpunkt
	 * 
	 * @param node    Aktueller Knotenpunkt
	 */
	public abstract ArrayList<PathNode<T>> getNext(PathNode<T> node);

	/**
	 * Gibt an, ob ein Knotenpunkt der Zielpunkt ist oder nicht.
	 * 
	 * @param node    Der zu testende Knotenpunkt
	 */
	public abstract boolean isAim(PathNode<T> node);

	/**
	 * Entfernt einen Knotenpunkt von der Liste aller gesehenen Knotenpunkte.
	 * 
	 * @param node    Der zu entfernende Knotenpunkt
	 */
	public void removeSeenNote(PathNode<T> node){
		seenNotes.remove(node);
	}
	/* Begin - EA generated code for  Activities and Interactions */
	public PathNode<T> doFindPath()
	{
		// behavior is a Activity
		PathNode<T> end = null;
		boolean found = false;
		do
		{
			/*Warning: Sort - Associated behavior not found within the package!!*/
			if (isAim(seenNotes.get(0)))
			{
				end = (PathNode<T>)this.seenNotes.get(0);
				found = true;
			}
			else
			{
				addSeenNotes(this.getNext(this.seenNotes.get(0)));
				addKnownNote(this.seenNotes.get(0));
				removeSeenNote(this.seenNotes.get(0));
			}
		}while (seenNotes.size()>0 && !found);
		
		if(end==null) {
			ArrayList<PathNode<T>> r = new ArrayList<PathNode<T>>();
			r.addAll(knownNodes);
			r.addAll(seenNotes);
			return new FailNode<T>(r);
		}
		return end;
	}

	/* End - EA generated code for  Activities and Interactions */
}//end Astar