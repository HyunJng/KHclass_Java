package collection;
import java.util.Vector;

class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}


public class VectorEx {
	public static void main(String[] args) {
		Vector<Point> v = new Vector<Point>();
		
		v.add(new Point(1, 2));
		v.add(new Point(5, -20));
		v.add(new Point(30, -8));
		
		v.remove(2);
		
		for(int i= 0 ;i<v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
}
