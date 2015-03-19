package math;

/**
 * Eine mathematische Gleichung vom Typ a=b
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
public class Equation extends Relation {

	public Equation(Countable s1, Countable s2){
		site1 = s1;
		site2 = s2;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Equation