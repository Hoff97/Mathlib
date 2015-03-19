package ntuple;

public class Octuple<A, B, C, D, E, F, G, H> extends Septuple<A, B, C, D, E, F, G> {
	
	public H h;
	
	public Octuple(A _a, B _b, C _c, D _d, E _e, F _f, G _g, H _h) {
		super(_a,_b,_c,_d,_e,_f,_g);
		h = _h;
	}
	
	public String str() {
		return super.str() + "," + h.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 8;
	}
}
