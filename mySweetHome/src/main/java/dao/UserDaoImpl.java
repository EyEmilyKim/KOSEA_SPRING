package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Member;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	
	public String getId(String id) {
		return session.selectOne("mapper.home.getId", id);
	}

	public void entryUser(Member user) {
		session.insert("mapper.home.putUser", user);
	}
	
}
