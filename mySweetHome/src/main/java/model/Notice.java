package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Notice { //공지사항용 DTO
	private Integer seqno; //공지글번호
	@NotEmpty(message="제목을 입력하세요.")
	private String title; //공지글 제목
	private String writer; //작성자
	private String reg_date; //작성일
	@NotEmpty(message="내용을 입력하세요.")
	private String content; //내용
	
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
