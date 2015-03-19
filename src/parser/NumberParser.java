package parser;

/**
 * Ein Parser der Gleitkommazahlen parst.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public class NumberParser extends Leaf<Double> {

	public NumberParser(){
		
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param in
	 */
	public Double convert(String in){
		return new Double(in);
	}

	/**
	 * 
	 * @param in
	 */
	public String back(Double in){
		return in + "";
	}

	/**
	 * 
	 * @param str
	 */
	public boolean matches(String str){
		try {
			new Double(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public int minLength() {
		return 1;
	}

	@Override
	public int maxLength() {
		return 20;
	}
}//end NumberParser