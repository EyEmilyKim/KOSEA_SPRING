package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.BBS;
import model.FromTo;

@Repository
public class BbsDaoImpl implements BbsDao {
	@Autowired
	private SqlSession session;
	@Autowired
	private FromTo ft;
	
	public List<BBS> readBBS(Integer pageNo) {
		//pageNo 로 FromTo 에 담을 start, end 계산
		//FromTo ft = new FromTo(); //자동주입 1. @Autowired 2. bean 선언
		if(pageNo == null) pageNo = 0;
		int start = (pageNo - 1) * 5;
		int end = ((pageNo - 1) * 5) + 6;
		ft.setStart(start);
		ft.setEnd(end);
		return session.selectList("mapper.home.getBBS", ft);
	}

	public Integer getBBSCount() {
		return session.selectOne("mapper.home.getBBSCount");
	}

	public BBS getBBSDetail(Integer seqno) {
		return session.selectOne("mapper.home.getBBSDetail", seqno);
	}

}
