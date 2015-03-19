package parser;

/**
 * Grundlegendes Interface zur Parsererstellung. Es wird sowohl die möglichkeit
 * des Parsens, als auch der Rückkonvertierung der Daten zum String
 * gegeben(deshalb die doppelte Implementierung des Converter-Interfaces)
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public interface Parser<V> extends Converter<String,V> {

	/**
	 * Gibt an, ob ein Objekt vom angegebenen Parser geparst werden kann.
	 * 
	 * @param str    The String wich is analyzed.
	 */
	public boolean matches(String str);
	
	public String back(V b) throws NotConvertable;
	
	public int minLength();
	public int maxLength();
}