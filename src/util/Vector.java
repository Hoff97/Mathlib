package util;

public class Vector {
	public int x;
	public int y;
	
	public Vector(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public Vector substract(Vector a) {
		return new Vector(x-a.x,y-a.y);
	}
	
	public double length() {
		return Math.sqrt(x*x+y*y);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Vector) {
			return x == ((Vector)o).x && y == ((Vector)o).y;
		}
		return false;
	}
	
	public String toString() {
		return "{" + x + ", " + y + "}";
	}
}
