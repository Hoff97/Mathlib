package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

/**
 * Strukturen, die durch Substrukturen aufgebaut sind.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
abstract public class NonLeaf implements Countable {

	/**
	 * Substrukturen, durch die die Struktur definiert ist.
	 */
	public ArrayList<Countable> subTherms;
	
	public String tpe;

	public NonLeaf(ArrayList<Countable> s){
		subTherms = s;
	}

	public void finalize() throws Throwable {

	}
	
	/**
	 * Dupliziert das Objekt.
	 */
	public Countable clone(){
		ArrayList<Countable> n = new ArrayList<Countable>();
		for(Countable x : subTherms)
			n.add(x.clone());
		return create(n);
	}

	/**
	 * Gibt an, ob ein Subtherm in diesem Therm enthalten ist.
	 * 
	 * @param countable    Der Subtherm, nach dem gesucht wird.
	 */
	public boolean contains(Countable countable){
		for(Countable x : subTherms) {
			if(x.equals(countable) || x.contains(countable))
				return true;
		}
		return false;
	}

	/**
	 * Substituiert alle Subtherme gleich der linken Seite der Gleichung durch die
	 * Rechte.
	 * 
	 * @param equation    Die Gleichung, die angibt welcher Therm durch welchen zu
	 * substituieren ist.
	 */
	public Countable substitute(Equation equation){
		if(this.equals(equation.site1))
			return equation.site2;
		
		ArrayList<Countable> n = new ArrayList<Countable>();
		for(Countable x : subTherms)
			n.add(x.substitute(equation));
		return create(n);
	}
	
	abstract public NonLeaf create(ArrayList<Countable> s);
	
	//TODO:Check equality of results, remove redundant results
	public ArrayList<Tuple<Variable,Countable>> match(Countable oth) throws NotMatchable {
		if(oth instanceof NonLeaf && ((NonLeaf)oth).subTherms.size()==subTherms.size() && ((NonLeaf)oth).tpe.equals(tpe)) {
			NonLeaf othn = (NonLeaf)oth;
			ArrayList<Tuple<Variable,Countable>> all = new ArrayList<Tuple<Variable,Countable>>();
			
			for(int i = 0; i<subTherms.size(); i++) {
				all.addAll(subTherms.get(i).match(othn.subTherms.get(i)));
			}
			
			if(right(all)) {
				return removeDuplicates(all);	
			}
			throw new NotMatchable();
		}
		throw new NotMatchable();
	}
	
	static public ArrayList<Tuple<Variable,Countable>> removeDuplicates(ArrayList<Tuple<Variable,Countable>> l) {
		ArrayList<Tuple<Variable,Countable>> res = new ArrayList<Tuple<Variable,Countable>>();
		for(Tuple<Variable,Countable> x : l) {
			boolean contained = false;
			for(Tuple<Variable,Countable> y : res) {
				if(x.a.equals(y.a)) {
					contained = true;
					break;
				}
			}
			if(!contained) {
				res.add(x);
			}
		}
		return res;
	}
	
	static public boolean right(ArrayList<Tuple<Variable,Countable>> l) {
		for(Tuple<Variable,Countable> x : l) {
			for(Tuple<Variable,Countable> y : l) {
				if(x.a.equals(y.a) && !x.b.equals(y.b)) 
					return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String ret = tpe;
		ret += subTherms.toString();
		return ret;
	}
	
	public boolean equals(Countable oth) {
		if(oth instanceof NonLeaf && ((NonLeaf)oth).subTherms.size()==subTherms.size() && ((NonLeaf)oth).tpe.equals(tpe)) {
			NonLeaf othn = (NonLeaf)oth;
			for(int i = 0; i<subTherms.size(); i++) {
				if(!subTherms.get(i).equals(othn.subTherms.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}//end NonLeaf