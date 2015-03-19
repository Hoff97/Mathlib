package math;

/**
 * Strukturen, die keine weiteren Substrukturen enthalten, also atomar sind.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
abstract public class Leaf implements Countable {

	public Leaf(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * Dupliziert das Objekt.
	 */
	public Countable clone(){
		return null;
	}

	/**
	 * Gibt an, ob ein Subtherm in diesem Therm enthalten ist.
	 * 
	 * @param countable    Der Subtherm, nach dem gesucht wird.
	 */
	public boolean contains(Countable countable){
		return false;
	}

	/**
	 * Substituiert alle Subtherme gleich der linken Seite der Gleichung durch die
	 * Rechte.
	 * 
	 * @param equation    Die Gleichung, die angibt welcher Therm durch welchen zu
	 * substituieren ist.
	 */
	public Countable substitute(Equation equation){
		return null;
	}
}//end Leaf