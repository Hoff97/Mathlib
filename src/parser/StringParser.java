package parser;

/**
 * Ein Parser, der einen String parst(z.B. Variablen)
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:59
 */
public class StringParser extends Leaf<String> {

	/**
	 * Der reguläre Ausdruck, der definiert, welche Therme geparst werden können.
	 */
	public String re;
	public int minLength = 0;
	public int maxLength = Integer.MAX_VALUE;

	public StringParser(String r){
		re = r;
	}
	
	public StringParser(String r, int min){
		re = r;
		minLength = min;
	}
	
	public StringParser(String r, int min, int max){
		re = r;
		minLength = min;
		maxLength = max;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param in
	 */
	public String convert(String in){
		return in;
	}
	
	public String back(String b) {
		return b;
	}

	/**
	 * 
	 * @param str
	 */
	public boolean matches(String str){
		return str.matches(re);
	}

	@Override
	public int minLength() {
		return minLength;
	}

	@Override
	public int maxLength() {
		return maxLength;
	}
}//end StringParser