package main;

import pathfinding.*;
import util.Vector;

import java.util.ArrayList;

public class AStarTest extends Astar<Vector> {
	public ArrayList<Vector> not;
	public Vector aim;
	
	public AStarTest(ArrayList<Vector> n,Vector a) {
		not = n;
		aim = a;
	}
	
	public ArrayList<PathNode<Vector>> find(Vector start) {		
		return findPath(start).getPath();
	}
	
	public boolean isAim(PathNode<Vector> node) {
		return node.value.equals(aim);
	}
	
	public double getChange(Vector a, Vector b) {
		return getHeuristic(b)-getHeuristic(a);
	}
	
	public double getHeuristic(Vector a) {
		return a.substract(aim).length();
	}
	
	public ArrayList<PathNode<Vector>> getNext(PathNode<Vector> node) {
		Vector v1 = node.value.substract(new Vector(1,0));
		Vector v2 = node.value.substract(new Vector(-1,0));
		Vector v3 = node.value.substract(new Vector(0,1));
		Vector v4 = node.value.substract(new Vector(0,-1));
		
		PathNode<Vector> p1 = new Node<Vector>(v1, node.heuristic+v1.substract(node.value).length(),node);
		PathNode<Vector> p2 = new Node<Vector>(v2, node.heuristic+v2.substract(node.value).length(),node);
		PathNode<Vector> p3 = new Node<Vector>(v3, node.heuristic+v3.substract(node.value).length(),node);
		PathNode<Vector> p4 = new Node<Vector>(v4, node.heuristic+v4.substract(node.value).length(),node);
		
		ArrayList<PathNode<Vector>> ret = new ArrayList<PathNode<Vector>>();
		
		if(!not.contains(v1)) {
			ret.add(p1);
		}
		if(!not.contains(v2)) {
			ret.add(p2);
		}
		if(!not.contains(v3)) {
			ret.add(p3);
		}
		if(!not.contains(v4)) {
			ret.add(p4);
		}
		
		return ret;
	}
}
