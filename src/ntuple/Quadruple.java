package ntuple;

public class Quadruple<A,B,C,D> extends Triple<A, B, C> {
	
	public D d;
	
	public Quadruple(A _a, B _b, C _c, D _d) {
		super(_a,_b,_c);
		d = _d;
	}
	
	public String str() {
		return super.str() + "," + d.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 4;
	}
}
