package parser;

import java.util.ArrayList;

/**
 * Ein Parser, der mehrere Möglichkeiten bietet.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:58
 */
public class MPParser<V> extends NonLeaf<V> {

	public ArrayList<Parser<V>> subs;
	
	public MPParser(){
		this(new ArrayList<Parser<V>>());
	}
	
	public MPParser(ArrayList<Parser<V>> s){
		subs = s;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public V convert(String in) throws NotConvertable {
		if(depth>maxdepth)
			throw new NotConvertable();
		depth++;
		for(Parser<V> t : subs) {
			if(t.matches(in)) {
				depth--;
				return t.convert(in);
			}
		}
		depth--;
		throw new NotConvertable();
	}

	/**
	 * 
	 * @param in
	 */
	public String back(V in) throws NotConvertable {
		for(Parser<V> t : subs) {
			try {
				return t.back(in);
			}catch(Exception e) {}
		}
		throw new NotConvertable();
	}

	public boolean matches(String str){
		if(depth>maxdepth)
			return false;
		depth++;
		for(Parser<V> t : subs) {
			if(t.matches(str)) {
				depth--;
				return true;
			}
		}
		depth--;
		return false;
	}
	
	public static int depth = 0;
	public static int maxdepth = 10;

	@Override
	public int minLength() {
		int l = Integer.MAX_VALUE;
		for(Parser<V> sub: subs)
			if(!Util.recursive(sub)) {
				int min = sub.minLength();
				if(min<l)
					l=min;
			}
		return l;
	}

	@Override
	public int maxLength() {
		int l = Integer.MAX_VALUE;
		for(Parser<V> sub: subs)
			if(!Util.recursive(sub)) {
				int min = sub.minLength();
				if(min<l)
					l=min;
			}
		return l;
	}
}//end MPParser