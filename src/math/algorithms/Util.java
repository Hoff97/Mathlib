package math.algorithms;

import math.Countable;
import math.NonLeaf;

public class Util {
	public static int count(Countable t, Counter x) {
		int c = 0;
		if(x.is(t))
			c++;
		if(t instanceof NonLeaf) {
			NonLeaf tn = (NonLeaf)t;
			for(Countable sub : tn.subTherms) {
				c += count(sub,x);
			}
		}
		return c;
	}
}
