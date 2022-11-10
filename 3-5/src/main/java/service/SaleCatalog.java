package service;

import java.util.ArrayList;
import model.Cart;
import model.ItemSet;
import model.Sale;
import model.SaleDetail;
import model.User;

public interface SaleCatalog {
	void checkout(User user, Cart cart);
	Integer findMaxSaleId();
	void create(Sale sale);
	void create(SaleDetail detail);
	//장바구니 상품의 총합 계산 메서드
	Integer sumTotal(ArrayList<ItemSet> itemList);
}
