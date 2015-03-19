package math.types;
import java.util.ArrayList;

import ntuple.Tuple;
import math.Countable;
import math.Leaf;
import math.Equation;
import math.NotMatchable;

/**
 * Eine Variable, deren Wert unbekannt ist.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:46:00
 */
public class Variable extends Leaf {

	/**
	 * Der Name der Variable.
	 */
	public String name = "x";

	public Variable(){

	}
	
	public Variable(String n) {
		this.name = n;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * Clones the Variable.
	 */
	public Countable clone(){
		return new Variable(this.name);
	}

	/**
	 * 
	 * @param countable
	 */
	public boolean contains(Countable countable){
		return this.equals(countable);
	}

	/**
	 * 
	 * @param equation
	 */
	public Countable substitute(Equation equation){
		Countable ret = this.clone();
		if(equation.site1 instanceof Variable)
		{
			if(((Variable)equation.site1).name.equals(this.name))
			{
				ret = equation.site2.clone();
			}
		}
		return ret;
	}
	
	public ArrayList<Tuple<Variable,Countable>> match(Countable oth) throws NotMatchable{
		ArrayList<Tuple<Variable,Countable>> ret = new ArrayList<Tuple<Variable,Countable>>();
		ret.add(new Tuple<Variable,Countable>(this,oth));
		return ret;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Countable oth) {
		return oth instanceof Variable && ((Variable)oth).name.equals(name);
	}
}//end Variable