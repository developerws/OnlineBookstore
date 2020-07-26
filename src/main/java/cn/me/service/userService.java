/**
 * 
 */
package cn.me.service;

import cn.me.bean.User;
import cn.me.dao.userDao;

/**
 * @author WS
 *
 */
public class userService {
	public boolean addUserService(User user) {
		return userDao.insertUser(user);
	}
	public User queryUser(String id) {
		return userDao.queryUser(id);
	}
	public String verifyUserService(String username,String psw) {
		return userDao.verifyUser(username, psw);
	}
	public boolean updatepswService(String id,String oldpsw,String newpsw) {
		User user = userDao.queryUser(id);
		if(user.getPsw().equals(oldpsw)) {
			return userDao.updatepsw(id, newpsw);
		}
		else {
			return false;
		}
	}
	
	public boolean updateinfoService(User user) {
		return userDao.updateinfo(user);
	}
}
