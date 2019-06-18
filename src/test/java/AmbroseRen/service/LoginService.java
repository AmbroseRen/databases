package AmbroseRen.service;

import AmbroseRen.entity.User;

/**
 * 业务层接口
 */
public interface LoginService {
	
	public User checkLogin(String uname, String pwd);

}
