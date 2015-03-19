package math.types;
import java.util.ArrayList;

import math.Countable;
import math.NonLeaf;

/**
 * Ein x-Dimensionaler Vektor.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:46:00
 */
public class Vector extends NonLeaf {

	public Vector(ArrayList<Countable> s){
		super(s);
		tpe = "vector";
	}
	
	public Vector(Countable... s){
		this(convert(s));
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public NonLeaf create(ArrayList<Countable> s) {
		return new Vector(s);
	}
	
	static ArrayList<Countable> convert(Countable[] s){
		ArrayList<Countable> ret = new ArrayList<Countable>();
		for(Countable add : s)
			ret.add(add);
		return ret;
	}
}//end Vector