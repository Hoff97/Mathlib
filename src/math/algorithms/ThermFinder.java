package math.algorithms;

import math.Countable;
import math.NotApplyable;
import pathfinding.Node;
import pathfinding.PathNode;
import math.Rule;
import pathfinding.Astar;
import math.NonLeaf;

import java.util.ArrayList;

/**
 * Der Pfadfindungsalgorithmus, angewandt auf mathematische Strukturen.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:46:00
 */
abstract public class ThermFinder extends Astar<Countable>{
//TODO Vervollständigen
	/**
	 * Alle für die Regelanwendung zur Verfügung stehenden Regeln.
	 */
	public ArrayList<Rule> rules;

	public ThermFinder(ArrayList<Rule> r){
		rules = r;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param countable Der Starttherm von dem aus gesucht wird.
	 */
	public Countable apply(Countable countable){
		return findPath(countable).value;
	}

	/**
	 * 
	 * @param to	Der Term der durch eine Regel erzeugt wurde
	 * @param from    Der Term von dem ausgegangen wird
	 */
	public double getChange(PathNode<Countable> to, PathNode<Countable> from){
		return 1;
	}

	/**
	 * 
	 * @param node Der Therm dessen Heuristik gefragt ist
	 */
	public double getHeuristic(Countable node){
		return 1;
	}

	/**
	 * 
	 * @param node	Der Therm, von dem aus alle nächsten durch Regelanwendung gesucht werden
	 */
	public ArrayList<PathNode<Countable>> getNext(PathNode<Countable> node){
		Countable val = node.value;		
		ArrayList<PathNode<Countable>> ret = new ArrayList<PathNode<Countable>>();
		for(Rule rule : rules) {
			try {
				Countable nval = rule.apply(val);
				ret.add(new Node<Countable>(nval,node.heuristic+getChange(nval,val),node));
			} catch (NotApplyable e) {}
		}
		return ret;
	}
}//end ThermFinder