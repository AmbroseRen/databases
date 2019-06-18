package AmbroseRen.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("config")
public class Config {
	
	private Waiter wt;
	
	@Value("西门")
	private String name;
	
	@Value("#{config.emailName}")
	private int emailName;
	
	@Value("#{config.emailPassword}")
	private int emailPassword;

	public Waiter getWt() {
		return wt;
	}

	@Resource(name="wt")
	public void setWt(Waiter wt) {
		System.out.println("setWt()"+wt);
		this.wt = wt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmailName() {
		return emailName;
	}

	public void setEmailName(int emailName) {
		this.emailName = emailName;
	}

	public int getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(int emailPassword) {
		this.emailPassword = emailPassword;
	}

	@Override
	public String toString() {
		return "Config [wt=" + wt + ", name=" + name + ", emailName=" + emailName + ", emailPassword=" + emailPassword
				+ "]";
	}
	
	
}
