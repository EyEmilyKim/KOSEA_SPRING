package dao;

import model.Member;

public interface UserDao {
	public String getId(String id); //ID중복 검사용 메서드
	public void entryUser(Member user); //가입자 등록용 메서드
}
