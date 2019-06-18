package AmbroseRen.dao.impl;

import org.springframework.stereotype.Repository;

import AmbroseRen.entity.User;

/**
 * 持久层接口
 *
 */
@Repository("userDAO")
public interface UserDAO {
	public User findByUsername(String uname);
}
