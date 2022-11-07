package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.User;

@Repository
public class UserDAOimpl implements UserDAO {
	@Autowired
	private SqlSession session;
	   
	public void create(User user) {
		session.selectOne("mapper.home.putUser", user);
	}
	
	public User getUser(User user) {
		return session.selectOne("mapper.home.getUser", user);
	}

}
