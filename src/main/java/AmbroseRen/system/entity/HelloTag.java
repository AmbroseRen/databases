package AmbroseRen.system.entity;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	private String msg;
	private int qty;
	
	public HelloTag() {
		System.out.println("HelloTag()");
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		System.out.println("setMsg()"+msg);
		this.msg = msg;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		System.out.println("setQty()"+qty);
		this.qty = qty;
	}
	
	//需要	extends SimpleTagSupport
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag()");
		/**
		 * 可以通过继承自SimpleTagSupport类提供的方法来获得pageContext
		 * pageContext提供了获得其他所有隐含对象的方法
		 */
		PageContext pc =(PageContext)getJspContext();
		JspWriter out =pc.getOut();
		for(int i=0;i<qty;i++){
			out.println(msg + "<br/>");
		}
	}
	
}
