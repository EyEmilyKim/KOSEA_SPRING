package dao;

import java.util.List;

import model.FromTo;
import model.Item;

public interface ItemDao {
	Integer checkItemCode(String code);
	void putItem(Item item);
	List<Item> getAllItems(FromTo ft);
	Integer getItemsCount();
	Item getItemByCode(String code);
}
