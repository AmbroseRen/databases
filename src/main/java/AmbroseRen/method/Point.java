package AmbroseRen.method;

/**
 * 该类的每个实例用于表示直角坐标系中的一个点
 * @author 天大java
 *
 */
public class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * toString被使用，需要被重写。
	 * toString返回的字符串没有格式要求，按实际开发而定。
	 * 原则上返回的字符串中应当包含给定对象属性信息
	 */
	public String toString(){
		return "（"+x+","+y+")";
	}
	
	/**
	 * 通常使用一个类的equals方法需要重写它。
	 * java API提供的类基本重写了。自己定义的类自己重写。
	 * equals方法的作用是比较两个对象像不像，即：内容是否一致。
	 */
	public boolean equals(Object o){
		if(o==null){
			return false;
		}
		if(o==this){
			return true;
		}
		if(o instanceof Point){
			Point p =(Point)o;
			p.equals(o);
			return p.x==this.x && p.y==this.y;
		}
		return false;
	}
	
}
