package ntuple;

public class Septuple<A, B, C, D, E, F, G> extends Sextuple<A, B, C, D, E, F> {
	
	public G g;
	
	public Septuple(A _a, B _b, C _c, D _d, E _e, F _f, G _g) {
		super(_a,_b,_c,_d,_e,_f);
		g = _g;
	}
	
	public String str() {
		return super.str() + "," + g.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 7;
	}
}
