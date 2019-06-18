package AmbroseRen.method.collection;

public class TestPosition {

	public static void main(String[] args) {
//		Position<Point> p =new Position<Point>(2 3);
		Position<Double> b =new Position<Double>(1.1,2.2);
		System.out.println(b);
		b.setX(3.3);
		System.out.println(b.getX());
		
		Position<String> s=new Position<String>("我很帅","你很乖");
		System.out.println(s);
		
		Position<Integer> i =new Position<Integer>(3,5);
		System.out.println(i);
	}

}
