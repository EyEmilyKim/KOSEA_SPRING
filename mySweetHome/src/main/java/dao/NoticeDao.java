package dao;

import java.util.List;

import model.Notice;

public interface NoticeDao {
	Integer getMaxNoticeNo();
	void putNotice(Notice notice);
	List<Notice> getAllNotice(Integer pageNo);
	Integer getNoticeCount();
	Notice getDetail(Integer seqno); //글번호로 게시글 조회
}
