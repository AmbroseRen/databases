package AmbroseRen.bean;

import AmbroseRen.bean.Waiter;

public class Restaurant {
	private Waiter wt;
	/**
	 * 容器会调用构造器将Waiter对象传递进来
	 */
	public Restaurant(Waiter wt) {
		System.out.println("Restaurant()");
		this.wt = wt;
	}
	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
}
