package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.FromTo;
import model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSession session;
	
	public Integer getMaxNoticeNo() {
		Integer max = session.selectOne("mapper.home.getMaxNoticeNo");
		if(max == null) return 0;
		else return max;
	}

	public void putNotice(Notice notice) {
		notice.setSeqno(getMaxNoticeNo()+1);
		session.insert("mapper.home.putNotice", notice);
	}

	public List<Notice> getAllNotice(Integer pageNo) {
		if(pageNo == null) pageNo = 1;
		int start = (pageNo - 1) * 5;
		int end = ((pageNo - 1) * 5) + 6;
		FromTo ft = new FromTo();
		ft.setStart(start);
		ft.setEnd(end);
		List<Notice> list = session.selectList("mapper.home.getAllNotice", ft);
		return list;
	}

	public Integer getNoticeCount() {
		Integer count = session.selectOne("mapper.home.getNoticeCount");
		if(count == null) count = 0;
		return count;
	}

	public Notice getDetail(Integer seqno) {
		Notice notice = session.selectOne("mapper.home.getNoticeDetail", seqno);
		return notice;
	}

	public void deleteNotice(Integer seqno) {
		session.delete("mapper.home.deleteNotice", seqno);
	}

	public void updateNotice(Notice notice) {
		session.delete("mapper.home.updateNotice", notice);
	}

}
