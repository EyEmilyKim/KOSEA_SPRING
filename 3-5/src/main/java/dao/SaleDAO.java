package dao;

import model.Sale;

public interface SaleDAO {
	Integer findMaxSaleId();
	void create(Sale sale);
}
