package math;

/**
 * Eine Relation zwischen 2 Thermen(z.B. 2=x oder 5>y)
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:59
 */
public abstract class Relation {

	public String type = "=";
	/**
	 * Die beiden Seiten der Gleichung.
	 * Gleichungen mit mehr als 2 Seiten müssen in mehr Gleichungen unterteilt
	 * werden(z.B. x=y=z zu x=y & y=z)
	 */
	public Countable site1;
	public Countable site2;

	public Relation(){

	}

	public void finalize() throws Throwable {

	}
}//end Relation