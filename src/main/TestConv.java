package main;

import parser.*;
import java.util.ArrayList;

public class TestConv extends ConvertParser<String, ArrayList<String>> {
	public TestConv(Parser<String> p) {
		super(p);
	}
	
	public ArrayList<String> UToV(String in) {
		String[] spl = in.split("");
		ArrayList<String> t = new ArrayList<String>();
		for(String s : spl) {
			t.add(s);
		}
		return t;
	}
	
	public String VToU(ArrayList<String> t) {
		String[] a = {};
		String res = "";
		for(String s : t.toArray(a)) {
			res += s;
		}
		return res;
	}
}
