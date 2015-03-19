package parser;

public class SimpleString implements Parser<String> {

	public String str;
	
	public SimpleString(String s) {
		str = s;
	}
	
	@Override
	public String convert(String in) throws NotConvertable {
		if(in.equals(str))
			return in;
		else
			throw new NotConvertable();
	}

	@Override
	public boolean matches(String s) {
		return s.equals(str);
	}

	@Override
	public String back(String b) throws NotConvertable {
		return b;
	}

	@Override
	public int minLength() {
		return str.length();
	}

	@Override
	public int maxLength() {
		return str.length();
	}

}
