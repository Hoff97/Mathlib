package ntuple;

public class Sextuple<A, B, C, D, E, F> extends Quintuple<A, B, C, D, E> {

	public F f;
	
	public Sextuple(A _a, B _b, C _c, D _d, E _e, F _f) {
		super(_a,_b,_c,_d,_e);
		f = _f;
	}
	
	public String str() {
		return super.str() + "," + f.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 6;
	}
}
