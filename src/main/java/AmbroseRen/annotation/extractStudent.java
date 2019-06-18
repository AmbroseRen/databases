package AmbroseRen.annotation;

public class extractStudent {
	private String name;
	private String interest;
	private double score;
	private String pageSize;
	
	public extractStudent() {
		System.out.println("extractStudent()");
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "extractStudent [name=" + name + ", interest=" + interest + ", score=" + score + ", pageSize=" + pageSize
				+ "]";
	}
	
}

