package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

public class PreReqRule extends StructedRule {
	
	ArrayList<Tuple<Variable,Countable>> prereqs;
	
	public PreReqRule(Countable s1, Countable s2, ArrayList<Tuple<Variable,Countable>> prereq) {
		super(s1, s2);
		prereqs = prereq;
	}
	
	public Countable apply(Countable countable) throws NotApplyable {
		try {
			ArrayList<Tuple<Variable,Countable>> binds = side1.match(countable);
			if(binds.containsAll(prereqs)) {
				Countable ret = side2.clone();
				for(Tuple<Variable,Countable> x : binds) {
					ret = ret.substitute(new Equation(x.a,x.b));
				}
				return ret;
			} else 
				throw new NotApplyable();
		} catch (Exception e) {
			throw new NotApplyable();
		}
	}

}
