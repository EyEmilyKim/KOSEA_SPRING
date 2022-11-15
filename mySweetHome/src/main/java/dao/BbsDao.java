package dao;

import java.util.List;

import model.BBS;

public interface BbsDao {
	List<BBS> readBBS(Integer pageNo); //게시글 목록 검색
	Integer getBBSCount(); //전체 게시글의 갯수를 검색
	BBS getBBSDetail(Integer seqno); //글번호로 상세 게시글 검색
}
