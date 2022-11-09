package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return itemList;
	}
	
	//장바구니 비었는지 여부 확인하는 메서드
	public boolean isEmpty() {
		if(itemList == null || itemList.isEmpty())
			return true;
		return false;
	}
	
	//장바구니 비우는 메서드
	public void clearAll() {
		itemList = new ArrayList<ItemSet>();
	}

	//상품을 장바구니에 담는 메서드
	public void push(ItemSet pushedItemSet) {
		//itemList에 동일한 상품이 있는 경우, 갯수만 증가
		boolean itemExistInCart = false; //이미 있는 상품인지 여부 변수
		for(ItemSet cartItemSet: this.itemList) {
			Item cartItem = cartItemSet.getItem();
			if(cartItem.getItemId() == pushedItemSet.getItem().getItemId()) {
				cartItemSet.addQuantity(
						pushedItemSet.getQuantity()); //갯수 증가
				itemExistInCart = true;
				break; //반복 종료
			}
		}
		if(! itemExistInCart) 
			this.itemList.add(pushedItemSet);
	}
	
}
