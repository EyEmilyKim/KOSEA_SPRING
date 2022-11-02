package DAO;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import model.Item;

public class ItemDAOimpl implements ItemDAO {
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<Item> findAll() {
		return session.selectList("mapper.home.getItems"); //매퍼이름.쿼리이름
	}

	public Item findById(Integer id) {
		return session.selectOne("mapper.home.getItem", id);
	}

}
