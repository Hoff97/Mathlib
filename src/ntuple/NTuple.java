package ntuple;

/**
 * Klasse für x-Dimensionale Tupel zum Halten verschiedener Datentypen
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public abstract class NTuple {
	public abstract int size();
	
	public abstract String str();
	
	public String toString() {
		return "(" + str() + ")";
	}
}
