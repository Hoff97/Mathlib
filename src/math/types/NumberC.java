package math.types;
import java.util.ArrayList;

import ntuple.Tuple;
import math.Countable;
import math.Leaf;
import math.Equation;
import math.NotMatchable;

/**
 * Eine Nummer, im Normalfall durch Float repräsentiert.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public class NumberC extends Leaf {

	public float value = 0f;

	public NumberC(float v){
		value = v;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public Countable clone(){
		return new NumberC(this.value);
	}

	/**
	 * 
	 * @param countable
	 */
	public boolean contains(Countable countable){
		if(countable instanceof Number)
		{
			if(((NumberC)countable).value==this.value)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param equation
	 */
	public Countable substitute(Equation equation){
		return this.clone();
	}
	
	public ArrayList<Tuple<Variable,Countable>> match(Countable oth)  throws NotMatchable {
		if(oth instanceof NumberC && ((NumberC)oth).value==value) {
			return new ArrayList<Tuple<Variable,Countable>>();
		}
		throw new NotMatchable();
	}
	
	public String toString() {
		return value + "";
	}
	
	public boolean equals(Countable oth) {
		return oth instanceof NumberC && ((NumberC)oth).value==value;
	}
}//end Number