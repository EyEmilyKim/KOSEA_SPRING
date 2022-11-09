package model;

public class SaleDetail {
	private Integer saleId; //매출번호
	private Integer saleDetailId; //매출상세번호
	private Integer itemId; //상품번호
	private Integer quantity; //수량
	private Item item; //상품 객체
	private Sale sale; //매출 객체
	
	public SaleDetail(Sale sale, Integer saleDetailId, ItemSet itemSet) {
		this.sale = sale;
		this.saleDetailId = saleDetailId;
		this.item = itemSet.getItem();
		this.quantity = itemSet.getQuantity();
	} //생성자

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getSaleDetailId() {
		return saleDetailId;
	}

	public void setSaleDetailId(Integer saleDetailId) {
		this.saleDetailId = saleDetailId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
}
