package ntuple;

public class Quintuple<A, B, C, D, E> extends Quadruple<A, B, C, D> {
	
	public E e;
	
	public Quintuple(A _a, B _b, C _c, D _d, E _e) {
		super(_a,_b,_c,_d);
		e = _e;
	}
	
	public String str() {
		return super.str() + "," + e.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 5;
	}
}
