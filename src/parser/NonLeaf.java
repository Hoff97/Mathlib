package parser;

/**
 * Alle Parser, die aus Subparsern bestehen. Sie rufen diese beim Parsen auf.
 * Dadurch können rekursive Strukturen geparst werden.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
abstract public class NonLeaf<V> implements Parser<V> {

	public NonLeaf(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * Gibt an, ob ein Objekt vom angegebenen Parser geparst werden kann.
	 * 
	 * @param str    The String wich is analyzed.
	 */
	public boolean matches(String str){
		return false;
	}
}//end NonLeaf