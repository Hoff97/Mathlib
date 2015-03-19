package parser;

import java.util.ArrayList;

public class Util {
	public static boolean recursive(Parser<?> p) {
		return rec(p, new ArrayList<Parser<?>>());
	}
	
	public static boolean rec(Parser<?> p, ArrayList<Parser<?>> already) {
		if(p instanceof SimpleString)
			return recursive((SimpleString)p, already);
		else if(p instanceof StringParser)
			return recursive((StringParser)p,already);
		else if(p instanceof NumberParser)
			return recursive((NumberParser)p,already);
		else if(p instanceof StructParser)
			return recursive((StructParser)p,already);
		else if(p instanceof MPParser)
			return recursive((MPParser)p,already);
		
		return false;
	}
	
	public static boolean recursive(SimpleString p, ArrayList<Parser<?>> already) {
		return false;
	}
	public static boolean recursive(StringParser p, ArrayList<Parser<?>> already) {
		return false;
	}
	public static boolean recursive(NumberParser p, ArrayList<Parser<?>> already) {
		return false;
	}
	public static boolean recursive(StructParser<?> p, ArrayList<Parser<?>> already) {
		if(already.contains(p))
			return true;
		ArrayList<Parser<?>> l = (ArrayList<Parser<?>>) already.clone();
		l.add(p);
		for(Parser<?> x : p.subs)
			if(rec(x, l))
				return true;
		return false;
	}
	public static boolean recursive(MPParser<?> p, ArrayList<Parser<?>> already) {
		if(already.contains(p))
			return true;
		ArrayList<Parser<?>> l = (ArrayList<Parser<?>>) already.clone();
		l.add(p);
		for(Parser<?> x : p.subs)
			if(rec(x, l))
				return true;
		return false;
	}
}
