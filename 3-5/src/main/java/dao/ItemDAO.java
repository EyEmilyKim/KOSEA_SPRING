package dao;

import java.util.List;
import model.Item;

public interface ItemDAO {
	List<Item> findAll();
	Item findById(Integer id);
}
