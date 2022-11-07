package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDAOimpl implements UserDAO {
	private SqlSession session;
	   
	public void setSession(SqlSession session) {
	this.session = session;
	}
	   
	public void create(User user) {
		session.selectOne("mapper.home.putUser", user);
	}
	
	public User getUser(User user) {
		return session.selectOne("mapper.home.getUser", user);
	}


}
