package dao;

import java.util.List;

import model.CartItem;

public interface CartDao {
	CartItem getCartItem(String code);
}
