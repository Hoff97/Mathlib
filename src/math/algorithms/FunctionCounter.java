package math.algorithms;

import math.Countable;
import math.types.Function;

public class FunctionCounter implements Counter {

	String name;
	
	public FunctionCounter(String n) {
		name = n;
	}
	
	@Override
	public boolean is(Countable e) {
		if(e instanceof Function) {
			return ((Function)e).name.equals(name);
		}
		return false;
	}

}
