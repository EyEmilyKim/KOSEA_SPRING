package dao;

import java.util.List;

import javax.crypto.Cipher;

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
	
	public Integer getMaxSeqno() { //가장 큰 장바구니 테이블 번호 검색
		Integer seqno = session.selectOne("mapper.home.getMaxSeqno");;
		if(seqno == null) seqno = 0;
		return seqno;
	}

	public void putCart(CartItem ci) {
		ci.setSeqno(getMaxSeqno() + 1); //일련번호 증가
		session.insert("mapper.home.putCart", ci);
	}
	
	public void updateCart(CartItem ci); { //수량변경 update
		session.update("mapper.home.updateCart", ci);
	}
	
}
