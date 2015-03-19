package parser;
import java.util.ArrayList;
import java.util.regex.Pattern;

//TODO: Rekursives Limit setzten

/**
 * Ein Parser, der durch seine Subparser aufgebaut ist(z.B. Therme wie x+y usw...)
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:46:00
 */
public class StructParser<T> extends NonLeaf<ArrayList<T>> {
	
	public ArrayList<Parser<T>> subs;
	
	public StructParser(ArrayList<Parser<T>> s){
		subs = s;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param in
	 */
	public ArrayList<T> convert(String str) throws NotConvertable {
		if(subs.size()==0) {
			return new ArrayList<T>();
		}
		else if(subs.size()==1) {
			ArrayList<T> back = new ArrayList<T>();
			back.add(subs.get(0).convert(str));
			return back;
		} else {
			for(Parser<T> sub: subs) {
				if(sub instanceof SimpleString) {
					SimpleString s = (SimpleString)sub;
					int index = subs.indexOf(sub);
					
					ArrayList<Parser<T>> subs1 = new ArrayList<Parser<T>>();
					ArrayList<Parser<T>> subs2 = new ArrayList<Parser<T>>();
					for(int i = 0; i<index; i++) {
						subs1.add(subs.get(i));
					}
					for(int i = index+1; i<subs.size(); i++) {
						subs2.add(subs.get(i));
					}
					
					StructParser<T> sub1 = new StructParser<T>(subs1);
					StructParser<T> sub2 = new StructParser<T>(subs2);
					
					String[] splitted = str.split(Pattern.quote(s.str));
					for(int i = 0; i<splitted.length+1; i++) {
						String first = "";
						String second = "";
						for(int j = 0; j<i; j++) {
							if(j>0)
								first += s.str;
							first += splitted[j];
						}
						for(int j = i; j<splitted.length; j++) {
							if(j>i)
								second += s.str;
							second += splitted[j];
						}
						if(sub1.matches(first) && sub2.matches(second)) { //Check matching Methods
							try {
								ArrayList<T> ret = new ArrayList<T>();
								for(T add : sub1.convert(first)) {
									ret.add(add);
								}
								ret.add((T) s.str);
								for(T add : sub2.convert(second)) {
									ret.add(add);
								}
								return ret;
							} catch(Exception e) {
								
							}
						}
					}
					//throw new NotConvertable(); ?????
				}
			}
			
			
			
			for(int i = 0; i<=str.length(); i++) {
				String str1 = str.substring(0,i);
				if(subs.get(0).matches(str1)) {
					ArrayList<Parser<T>> newSubs = new ArrayList<Parser<T>>();
					for(int j = 1; j<subs.size(); j++) {
						newSubs.add(subs.get(j));
					}
					
					StructParser<T> newStruct = new StructParser<T>(newSubs);
					String str2 = str.substring(i,str.length());
					if(newStruct.matches(str2)) {
						T c1 = subs.get(0).convert(str1);
						ArrayList<T> c2 = newStruct.convert(str2);
						c2.add(0,c1);
						return c2;
					}
				}
			}
		}
		throw new NotConvertable();
	}

	/**
	 * 
	 * @param in
	 */
	public String back(ArrayList<T> in) throws NotConvertable {
		String ret = "";
		for(int i = 0; i<in.size(); i++) {
			ret += subs.get(i).back(in.get(i));
		}
		return ret;
	}

	/**
	 * 
	 * @param str
	 */
	public boolean matches(String str){
		if(subs.size()==0) {
			return true;
		}
		else if(subs.size()==1) {
			return subs.get(0).matches(str);
		} else {
			for(int i = 0; i<=str.length(); i++) {
				String str1 = str.substring(0,i);
				if(subs.get(0).matches(str1)) {
					ArrayList<Parser<T>> newSubs = new ArrayList<Parser<T>>();
					for(int j = 1; j<subs.size(); j++) {
						newSubs.add(subs.get(j));
					}
					
					StructParser<T> newStruct = new StructParser<T>(newSubs);
					if(newStruct.matches(str.substring(i,str.length())))
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public int minLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxLength() {
		// TODO Auto-generated method stub
		return 0;
	}
}//end StructParser