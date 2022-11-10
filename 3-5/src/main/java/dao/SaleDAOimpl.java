package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Sale;

@Repository
public class SaleDAOimpl implements SaleDAO {
	@Autowired
	private SqlSession session;
	
	public Integer findMaxSaleId() {
		Integer max = session.selectOne("mapper.sale.getMaxSaleId");
		if(max == null) max = 0;
		return max;
	}

	public void create(Sale sale) {
		session.insert("mapper.sale.putSale", sale);
	}

}
