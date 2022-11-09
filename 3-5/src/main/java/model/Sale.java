package model;

import java.util.ArrayList;

public class Sale {
	private User user;
	private Integer saleId; //매출번호
	private String userId; //구매자
	private String buy_date; //구매일
	
	private ArrayList<SaleDetail> saleDetailList = new ArrayList<SaleDetail>();
	
	//매출상세정보 추가 메서드
	public void addSaleDetail(SaleDetail detail) {
		this.saleDetailList.add(detail);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public ArrayList<SaleDetail> getSaleDetailList() {
		return saleDetailList;
	}

	public void setSaleDetailList(ArrayList<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}
	
}
