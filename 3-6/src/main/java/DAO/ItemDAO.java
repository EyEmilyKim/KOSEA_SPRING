package dao;

import java.util.List;
import model.Item;

public interface ItemDAO {
	List<Item> findAll();
	Item findById(Integer id);
	/////3-6에서 추가된 기능/////
	void create(Item item); //상품 등록
	void delete(Integer id); //상품 삭제
	void update(Item item); //상품 변경
	List<Item> findByName(String name); //이름으로 상품 조회
}
