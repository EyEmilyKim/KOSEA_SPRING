package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Bbs {
	private Integer seqno;
	@NotEmpty(message="제목을 입력하세요.")
	private String title;
	private String writer;
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	private String reg_date;
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
