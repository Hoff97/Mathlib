package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

/**
 * Eine Regel definiert durch eine Gleichung(z.B. x+y=y+x)
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:46:00
 */
public class StructedRule extends Rule {
	
	public Countable side1;
	public Countable side2;
	
	public StructedRule(Countable s1, Countable s2){
		side1 = s1;
		side2 = s2;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Wendet die Regel auf die Struktur an.
	 * 
	 * @param countable    Die Struktur, auf die die Regel angewendet wird.
	 */
	public Countable applySingle(Countable countable) throws NotApplyable {
			try {
				ArrayList<Tuple<Variable, Countable>> binds = side1.match(countable);
				Countable ret = side2.clone();
				for(Tuple<Variable,Countable> x : binds) {
					ret = ret.substitute(new Equation(x.a,x.b));
				}
				return ret;
			} catch (NotMatchable e) {
				throw new NotApplyable();
			}
	}
	/* End - EA generated code for  Activities and Interactions */
	
	public String toString() {
		return side1+"="+side2;
	}
}//end StructedRule