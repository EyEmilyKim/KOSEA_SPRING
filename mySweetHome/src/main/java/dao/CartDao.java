package dao;

import java.util.List;

import model.CartItem;

public interface CartDao {
	CartItem getCartItem(String code);
	Integer getMaxSeqno(); //가장 큰 장바구니 테이블 번호 검색
	void putCart(CartItem ci); //장바구니 테이블에 insert
	void updateCart(CartItem ci); //수량변경 update
}
