package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

public abstract class ProgramRule extends Rule {

	public Countable side1;
	
	public ProgramRule(Countable s1) {
		side1 = s1;
	}
	
	@Override
	public Countable applySingle(Countable countable) throws NotApplyable {
		try {
			ArrayList<Tuple<Variable,Countable>> binds = side1.match(countable);
			
			return generateConsequence(binds);
		} catch (NotMatchable e) {
			throw new NotApplyable();
		}
	}
	
	public abstract Countable generateConsequence(ArrayList<Tuple<Variable,Countable>> binds) throws NotApplyable;

}
