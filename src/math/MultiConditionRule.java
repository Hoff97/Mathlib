package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

public class MultiConditionRule extends ConditionedRule {
	public MultiConditionRule(StructedRule r, final Condition[] conditions) {
		super(r,new Condition() {
			@Override
			public boolean condition(ArrayList<Tuple<Variable, Countable>> binds) {
				for(Condition c : conditions)
					if(!c.condition(binds))
						return false;
				return true;
			}
		});
	}
}
