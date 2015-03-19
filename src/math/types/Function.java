package math.types;

import java.util.ArrayList;

import math.Countable;
import math.NonLeaf;

public class Function extends NonLeaf {

	public String name;
	
	public Function(ArrayList<Countable> subs) {
		super(subs);
		tpe = "func";
		name = "x";
		if(subs.get(0) instanceof Variable) {
			name = ((Variable)subs.get(0)).name;
		}
	}
	
	public static Function create(String n, ArrayList<Countable> subs) {
		ArrayList<Countable> allSubs = new ArrayList<Countable>();
		allSubs.add(new Variable(n));
		allSubs.addAll(subs);
		return new Function(allSubs);
	}
	
	public static Function create(String n, Countable s1) {
		ArrayList<Countable> allSubs = new ArrayList<Countable>();
		allSubs.add(new Variable(n));
		allSubs.add(s1);
		return new Function(allSubs);
	}
	
	public static Function create(String n, Countable s1, Countable s2) {
		ArrayList<Countable> allSubs = new ArrayList<Countable>();
		allSubs.add(new Variable(n));
		allSubs.add(s1);
		allSubs.add(s2);
		return new Function(allSubs);
	}

	@Override
	public NonLeaf create(ArrayList<Countable> s) {
		return new Function(s);
	}
	
	public String toString() {
		String ret = "";
		ret += subTherms.get(0) + "(";
		for(int i = 1; i<subTherms.size(); i++) {
			if(i!=1)
				ret += ",";
			ret += subTherms.get(i).toString();
		}
		return ret + ")";
	}

}
