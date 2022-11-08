package model;

public class ItemSet {
	private Item item; //상품 객체
	private Integer quantity; //상품 갯수
	
	public ItemSet(Item item, Integer quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	//동일한 상품인 경우 갯수 증가 메서드
	public void addQuantity(Integer addQuantity) {
		this.quantity = this.quantity + addQuantity;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
