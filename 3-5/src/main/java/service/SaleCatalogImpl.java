package service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.SaleDAO;
import dao.SaleDetailDAO;
import model.Cart;
import model.ItemSet;
import model.Sale;
import model.SaleDetail;
import model.User;

@Service
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private SaleDAO saleDao;
	@Autowired
	private SaleDetailDAO saleDetailDao;
	
	public void checkout(User user, Cart cart) {
		Sale sale = createSale(user, cart);
		entrySale(sale);
	}
	
	private void entrySale(Sale sale) {
		this.saleDao.create(sale); //DAO를 이용해서 매출 테이블에 삽입
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for(SaleDetail saleDetail : saleDetailList) {
			this.saleDetailDao.create(saleDetail);
		} //매출 상세 테이블에 삽입
	}
	private Sale createSale(User user, Cart cart) {
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId()); //매출번호 설정
		System.out.println("매출번호2:"+sale.getSaleId());
		sale.setUser(user);
		sale.setUserId(user.getUserId());
		List<ItemSet> itemList = cart.getItemList();
		for(int i=0; i<itemList.size(); i++) {
			ItemSet itemSet = (ItemSet)itemList.get(i);
			int saleDetailId = i + 1; //매출상세번호 설정
			SaleDetail saleDetail = createSaleDetail(sale, saleDetailId, itemSet);
			sale.addSaleDetail(saleDetail);
		}
		return sale;
	}
	private SaleDetail createSaleDetail(Sale sale, Integer saleDetailId, ItemSet itemSet) {
		return new SaleDetail(sale, saleDetailId, itemSet);
	}
	private Integer getNewSaleId() {
		int newSaleId = this.saleDao.findMaxSaleId()+1;
		System.out.println("매출번호1:"+newSaleId);
		return newSaleId;
	} //매출번호를 생성하는 메서드

	public Integer findMaxSaleId() {
		return this.saleDao.findMaxSaleId();
	}

	public void create(Sale sale) {
		this.saleDao.create(sale);

	}

	public void create(SaleDetail detail) {
		this.saleDetailDao.create(detail);
	}

	public Integer sumTotal(ArrayList<ItemSet> itemList) {
		int totalAmount = 0; //총액을 위한 변수 선언
		for(ItemSet itemSet : itemList) {
			int price = itemSet.getItem().getPrice();
			int quantity = itemSet.getQuantity();
			totalAmount = totalAmount + (price * quantity);
		}
		return totalAmount;
	}

}
