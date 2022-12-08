package dao;

import java.util.List;

import model.Notice;

public interface NoticeDao {
	Integer getMaxNoticeNo();
	void putNotice(Notice notice);
	List<Notice> getAllNotice(Integer pageNo);
	Integer getNoticeCount();
	Notice getDetail(Integer seqno); //글번호로 공지글 조회
	void deleteNotice(Integer seqno); //글번호로 공지글 삭제
	void updateNotice(Notice notice); //DTO로 공지글 수정
}
