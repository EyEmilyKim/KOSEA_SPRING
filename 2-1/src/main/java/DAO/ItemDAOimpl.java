package DAO;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import model.Item;

public class ItemDAOimpl implements ItemDAO {
	private SqlSession ss;

	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	
	public List<Item> getItemList(){
		return ss.selectList("mapper.home.getItems");
	}
}
