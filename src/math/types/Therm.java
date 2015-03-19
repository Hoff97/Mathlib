package math.types;
import java.util.ArrayList;

import math.Countable;
import math.NonLeaf;

/**
 * Eine Verbindung von Subtherms durch Operatoren
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:46:00
 */
public class Therm extends NonLeaf {

	public String type;

	public Therm(ArrayList<Countable> s, String t){
		super(s);
		type = t;
		tpe = "therm:" + type;
	}
	
	public Therm(String t, Countable... s){
		this(convert(s),t);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public NonLeaf create(ArrayList<Countable> s) {
		return new Therm(s,type);
	}
	
	static ArrayList<Countable> convert(Countable[] s){
		ArrayList<Countable> ret = new ArrayList<Countable>();
		for(Countable add : s)
			ret.add(add);
		return ret;
	}
	
	public String toString() {
		String ret = "";
		for(int i = 0; i<subTherms.size(); i++) {
			if(i!=0)
				ret += type;
			if(subTherms.get(i) instanceof Therm)
				ret += "(" + subTherms.get(i).toString() + ")";
			else
				ret += subTherms.get(i).toString();
		}
		return ret;
	}
}//end Therm