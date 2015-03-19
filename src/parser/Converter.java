package parser;

/**
 * Interface zur Konvertierung von Objekten.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
public interface Converter<U, V> {

	/**
	 * Konvertiert ein Objekt des Typs U in eines des Typs V.
	 * 
	 * @param in    Das zu konvertierrende Objekt.
	 */
	public V convert(U in) throws NotConvertable;

}