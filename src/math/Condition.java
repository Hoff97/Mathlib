package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

public interface Condition {
	public boolean condition(ArrayList<Tuple<Variable,Countable>> binds);
}
