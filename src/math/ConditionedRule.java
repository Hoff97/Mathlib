package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

public class ConditionedRule extends StructedRule {
	private Condition c;
	
	public ConditionedRule(StructedRule r, Condition con) {
		super(r.side1,r.side2);
		c = con;
	}
	
	public Countable applySingle(Countable countable) throws NotApplyable {
		try {
			ArrayList<Tuple<Variable,Countable>> binds = side1.match(countable);
			if(c.condition(binds)) {
				Countable ret = side2.clone();
				for(Tuple<Variable,Countable> x : binds) {
					ret = ret.substitute(new Equation(x.a,x.b));
				}
				return ret;
			} else {
				throw new NotApplyable();
			}
		} catch (Exception e) {
			throw new NotApplyable();
		}
	}
}
