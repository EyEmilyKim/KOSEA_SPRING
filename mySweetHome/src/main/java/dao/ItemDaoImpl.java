package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.FromTo;
import model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession session;
	
	public Integer checkItemCode(String code) {
		return session.selectOne("mapper.home.checkItemCode", code);
	}

	public void putItem(Item item) {
		session.insert("mapper.home.putItem", item);
	}

	public List<Item> getAllItems(FromTo ft) {
		return session.selectList("mapper.home.getAllItems", ft);
	}

	public Integer getItemsCount() {
		return session.selectOne("mapper.home.getItemsCount");
	}

	public Item getItemByCode(String code) {
		Item item = session.selectOne("mapper.home.getItemByCode", code);
		return item;
	}

	public void deleteItem(String code) {
		session.delete("mapper.home.deleteItem", code);
	}

	public void updateItem(Item item) {
		session.update("mapper.home.updateItem", item);
	}

}
