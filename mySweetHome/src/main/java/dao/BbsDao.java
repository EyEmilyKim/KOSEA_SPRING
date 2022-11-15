package dao;

import java.util.List;

import model.Bbs;

public interface BbsDao {
	List<Bbs> readBBS(Integer pageNo); //게시글 목록 검색
	Integer getBBSCount(); //전체 게시글의 갯수를 검색
	Bbs getBBSDetail(Integer seqno); //글번호로 상세 게시글 검색
	
	Integer getMaxSeqno(); //가장 큰 글번호 검색
	void putBBS(Bbs bbs); //게시글 삽입
}
