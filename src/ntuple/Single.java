package ntuple;

public class Single<A> extends NTuple {

	public A a;
	
	public Single(A _a) {
		a = _a;
	}
	
	public String str() {
		return a.toString();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}

}
