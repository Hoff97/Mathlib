package ntuple;

public class Triple<A,B,C> extends Tuple<A, B> {
	
	public C c;
	
	public Triple(A _a, B _b, C _c) {
		super(_a,_b);
		c = _c;
	}
	
	public String str() {
		return super.str() + "," + c.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
