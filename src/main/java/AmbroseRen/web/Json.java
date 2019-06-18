package AmbroseRen.web;

/**
 * JSON模型用户后台向前台返回的JSON对象
 */
@SuppressWarnings("serial")
public class Json implements java.io.Serializable {
	
	private boolean success = false;
	private String msg = "";
	private Object result = null;
	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Json [success=" + success + ", msg=" + msg + ", result=" + result + ", obj=" + obj + "]";
	}

}
