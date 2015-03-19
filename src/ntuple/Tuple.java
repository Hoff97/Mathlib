package ntuple;

public class Tuple<A,B> extends Single<A> {
	
	public B b;
	
	public Tuple(A _a, B _b) {
		super(_a);
		b = _b;
	}
	
	public String str() {
		return super.str() + "," + b.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}
