package AmbroseRen.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import AmbroseRen.annotation.Waiter;

@Component("mg")
public class Manager {
	private Waiter wt;
	
	@Value("西门")
	private String name;
	
	@Value("#{config.pagesize}")
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public Manager() {
		System.out.println("Manager()");
	}
	
	@Resource(name="wt")
	public void setWt(Waiter wt) {
		System.out.println("setWt()"+wt);
		this.wt = wt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Manager [wt=" + wt + ", name=" + name + ", pageSize=" + pageSize + "]";
	}
	
}

