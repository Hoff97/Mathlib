package parser;

/**
 * Ein Parser, der die Struktur nach dem Parsen in eine andere Repräsentation
 * umwandelt.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
abstract public class ConvertParser<U,V> extends NonLeaf<V> {

	/**
	 * Der Parser, der den Ausdruck parst.
	 */
	public Parser<U> parser;

	public ConvertParser(Parser<U> p){
		parser = p;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * Konvertiert ein Objekt in einen anderen Datentyp.
	 * 
	 * @param in    Das zu konvertierende Objekt.
	 */
	public V convert(String in) throws NotConvertable {
		return UToV(parser.convert(in));
	}
	
	public String back(V in) throws NotConvertable {
		return parser.back(VToU(in));
	}
	
	public abstract V UToV(U o) throws NotConvertable;
	public abstract U VToU(V o) throws NotConvertable;

	/**
	 * Gibt an, ob ein String durch einen Parser geparst werden kann.
	 * 
	 * @param str    Der zu analysierende String.
	 */
	public boolean matches(String str){
		return parser.matches(str);
	}
	
	public int minLength() {
		return parser.minLength();
	}
	public int maxLength() {
		return parser.maxLength();
	}
}//end ConvertParser