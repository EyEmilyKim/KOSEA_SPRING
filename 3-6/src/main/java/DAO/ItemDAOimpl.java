package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Item;

@Repository
public class ItemDAOimpl implements ItemDAO {
	@Autowired
	private SqlSession session;
	
	public List<Item> findAll() {
		return session.selectList("mapper.home.getItems"); //매퍼이름.쿼리이름
	}

	public Item findById(Integer id) {
		return session.selectOne("mapper.home.getItem", id);
	}

	public void create(Item item) {
		session.insert("mapper.home.putItem", item);
	}

	public void delete(Integer id) {
		session.delete("mapper.home.deleteItem", id);
		
	}

	public void update(Item item) {
		session.update("mapper.home.updateItem", item);
		
	}

	public List<Item> findByName(String name) {
		return session.selectList("mapper.home.findItem", name);
	}

}
