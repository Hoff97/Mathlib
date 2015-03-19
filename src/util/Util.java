package util;

import java.util.ArrayList;

public class Util {
	public static ArrayList flatten(ArrayList x) {
		if(x.size() == 1) {
			if(x.get(0) instanceof ArrayList)
				return flatten((ArrayList) x.get(0));
			else
				return x;
		} else {
			ArrayList ret = new ArrayList();
			for(int i = 0; i<x.size(); i++) {
				if(x.get(i) instanceof ArrayList) {
					ret.addAll(flatten((ArrayList) x.get(i)));
				} else 
					ret.add(x.get(i));
			}
			return ret;
		}
	}
}
