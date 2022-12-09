package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartItem;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SqlSession session;
	
	public CartItem getCartItem(String code) {
		return session.selectOne("mapper.home.getCartItem", code);
	}

}
